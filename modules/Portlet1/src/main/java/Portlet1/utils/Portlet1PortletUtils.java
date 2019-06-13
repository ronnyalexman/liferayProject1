package Portlet1.utils;

import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.model.DLFileShortcut;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;

import Portlet1.constants.Portlet1PortletKeys;

public class Portlet1PortletUtils {
	public static Log LOG = LogFactoryUtil.getLog(Portlet1PortletUtils.class);

	public static void setAttrs(RenderRequest request, Map<String, Object> attrs) {
		for (Map.Entry<String, Object> entry : attrs.entrySet()) {
			request.setAttribute(entry.getKey(), entry.getValue());
		}
	}

	public static boolean hasPermission(ThemeDisplay theme, RenderRequest renderRequest, String permission) {
		LOG.debug("hasPermission(" + permission + "):INI");
		boolean ableTo = false;
		try {
			if (theme != null)
				ableTo = PortletPermissionUtil.contains(theme.getPermissionChecker(), theme.getPlid(),
						PortalUtil.getPortletId(renderRequest), permission);
		} catch (Exception e) {
			LOG.error("Fallo al intentar verificar el permiso: " + permission, e);
		}
		LOG.debug("hasPermission():FIN");
		return ableTo;
	}

	public static String getPreference(PortletPreferences pp, Locale locale, String preference) {
		LOG.debug("getPreference(" + locale + ", " + preference + "):INI");

		String pref = "";
		try {
			if (pp != null) {
				pref = pp.getValue(preference, pref);
			}
		} catch (Exception ex) {
			LOG.error("No ha sido posible leer la preferencia del portlet", ex);
			pref = LanguageUtil.get(locale, Portlet1PortletKeys.PREFERENCE_NOTFOUND) + "\"" + preference + "\"";
		}

		LOG.debug("getPreference():FIN");
		return pref;
	}

	/**
	 * Almacena ficheros en la carpeta del usuario, si se da un fileEntryId, lo
	 * actualiza actualiza
	 * 
	 * @param actionRequest
	 * @param imageFileName
	 * @param fileEntryId   si llega informado, actualiza dicho fichero
	 * @return
	 */
	public static Object[] storageImage(ActionRequest actionRequest, String imageFileName, Long fileEntryId) {
		String userImageName = Portlet1PortletKeys.ALIES_IMG.concat(imageFileName);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		// Verifica si la carpeta del portlet existe, si no la crea
		if (uploadPortletRequest.getParameterMap().containsKey(Portlet1PortletKeys.FORM_IMAGEN)) {
			try (InputStream inputStream = uploadPortletRequest.getFileAsStream(Portlet1PortletKeys.FORM_IMAGEN)) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileShortcut.class.getName(),
						actionRequest);
				Object portletFolder = checkFolder(actionRequest, themeDisplay, serviceContext,
						Portlet1PortletKeys.Portlet1, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

				if (portletFolder != null) {// buscamos la carpeta del usuario
					Object userFolder = checkFolder(actionRequest, themeDisplay, serviceContext, imageFileName,
							GetterUtil.getLong(portletFolder));
					if (userFolder != null) {

						String contentType = uploadPortletRequest.getContentType(Portlet1PortletKeys.FORM_IMAGEN);
						long size = uploadPortletRequest.getSize(Portlet1PortletKeys.FORM_IMAGEN);

						FileEntry fileEntry = fileEntryId != null
								? DLAppServiceUtil.updateFileEntry(fileEntryId, "IMG_" + userImageName, contentType,
										userImageName, "description", "changeLog", true, inputStream, size,
										serviceContext)
								: DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),
										GetterUtil.getLong(userFolder), "IMG_" + userImageName, contentType,
										userImageName, "description", "changeLog", inputStream, size, serviceContext);

						String path = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, "",
								false, false);

						return new Object[] { fileEntry.getFileEntryId(), path };
					}
				}
			} catch (IOException e) {
				LOG.error("Problemas con la imagen", e);
			} catch (DuplicateFileEntryException e) {
				LOG.error("Este usuario ya existe, actualizando...", e);
			} catch (Exception e) {
				LOG.error("No se ha podido acceder a las carpetas", e);
			}
		}
		return new Object[] { DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				actionRequest.getContextPath() + Portlet1PortletKeys.DEFAULT_IMG_PICTURE };
	}

	private static Long checkFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay,
			ServiceContext serviceContext, String name, long parentFolder) {
		try {
			long siteId = themeDisplay.getSiteGroupId();
			Object folderId = existsDLFolder(name, siteId, parentFolder);

			if (folderId instanceof Boolean && !GetterUtil.getBoolean(folderId)) {
				// create Folder
				String descripcion = getPreference(actionRequest.getPreferences(), themeDisplay.getLocale(),
						Portlet1PortletKeys.PREFERENCE_FOLDER_DESCRIPCION);

				return DLAppServiceUtil.addFolder(siteId, parentFolder, name, descripcion, serviceContext)
						.getFolderId();
			} else if (folderId != null) {
				return GetterUtil.getLong(folderId);
			}
		} catch (PortalException e) {
			LOG.error("No se ha podido recuperar el id de la carpeta", e);
		}
		return null;
	}

	private static Object existsDLFolder(String folderName, Long siteId, Long parentId) {
		try {
			return DLFolderLocalServiceUtil.getFolder(siteId, parentId, folderName).getFolderId();
		} catch (Exception e) {
			LOG.error("No se ha podido recuperar el id de la carpeta, por lo tanto, no existe");
		}
		return false;
	}

	public static File getFileFromRequest(ActionRequest actionRequest, String inputName) {
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			if (uploadPortletRequest.getParameterMap().containsKey(inputName)) {
				return uploadPortletRequest.getFile(inputName);
			}
		} catch (Exception e) {
			LOG.error("Error al intentar recuperar un archivo de la request " + actionRequest.getContextPath());
		}

		return null;
	}

	/**
	 * String jsonSocrata = Jsoup
	 * .connect("https://ctti.azure-westeurope-prod.socrata.com/resource/4ef9-dsav.json?$limit=1")
	 * .ignoreContentType(true).execute().body();
	 * 
	 * renderRequest.setAttribute("json", jsonSocrata);
	 */
}
