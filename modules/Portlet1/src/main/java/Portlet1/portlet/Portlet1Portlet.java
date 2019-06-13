package Portlet1.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.internal.StringUtil;
import org.osgi.service.component.annotations.Component;

import Portlet1.constants.Portlet1PortletKeys;
import Portlet1.utils.Portlet1PortletUtils;
import clienteService.model.Clientes;
import clienteService.service.ClientesLocalService;
import clienteService.service.ClientesLocalServiceUtil;
import clienteService.service.ClientesServiceUtil;
import clienteService.service.persistence.ClientesFinder;
import clienteService.service.persistence.ClientesUtil;

/**
 * @author rmedina
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=VASS",
		"com.liferay.portlet.instanceable=false", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + Portlet1PortletKeys.Portlet1,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.friendly-url-mapping=vass" }, service = Portlet.class)
public class Portlet1Portlet extends MVCPortlet {
	private static Log LOG = LogFactoryUtil.getLog(Portlet1Portlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// INI global vars
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences pp = renderRequest.getPreferences();

		// Attrs
		HashMap<String, Object> attrs = new HashMap<>();
		String jsp = ParamUtil.get(renderRequest, Portlet1PortletKeys.JSP_PAGE, Portlet1PortletKeys.JSP_PAGE_VIEW);
		switch (jsp) {
		case Portlet1PortletKeys.JSP_PAGE_ALTA:
			System.out.println(jsp);
			break;
		default:
			attrs.put("userName", themeDisplay.getUser().getFullName());
			attrs.put("altaPermission",
					Portlet1PortletUtils.hasPermission(themeDisplay, renderRequest, Portlet1PortletKeys.ALTA_CLIENTE));
			break;
		}

		attrs.put("pie",
				Portlet1PortletUtils.getPreference(pp, themeDisplay.getLocale(), Portlet1PortletKeys.PREFERENCE_PIE));
		Portlet1PortletUtils.setAttrs(renderRequest, attrs);
		// super obligatorio y al final del todo
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		String action = ParamUtil.get(resourceRequest, "action", "exportJSON");
		if (action.equals("exportJSON")) {

			JSONArray arr = JSONFactoryUtil.createJSONArray();
			List<Clientes> clientes = ClientesLocalServiceUtil.getService().getClienteses(-1, -1);

			for (Clientes cli : clientes) {
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("nombre", cli.getNombre());
				json.put("apellidos", cli.getApellidos());
				json.put("nif", cli.getNif());
				arr.put(json);
			}

			resourceResponse.setContentType("application/json");
			resourceResponse.getPortletOutputStream().write(arr.toJSONString().getBytes());
		}
		ClientesServiceUtil.getService().testService();
		super.serveResource(resourceRequest, resourceResponse);
	}

	/***************** CRUD ************************/

	@ProcessAction(name = "create")
	public void create(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		LOG.info("create():INI");

		String nombre = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_NOMBRE);
		String nif = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_NIF);

		if (!StringUtil.isBlank(nif) && !StringUtil.isBlank(nombre)) {
			String email = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_EMAIL);
			String descripcion = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_DESCRIPCION, "");
			String apellidos = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_APELLIDOS, "");

			Clientes cliente = ClientesLocalServiceUtil
					.createClientes(CounterLocalServiceUtil.increment(Clientes.class.getName()));

			cliente.setNombre(nombre);
			cliente.setApellidos(apellidos);
			cliente.setNif(nif);
			cliente.setEmail(email);
			cliente.setDescripcion(descripcion);

			Object[] picture = Portlet1PortletUtils.storageImage(actionRequest, nif, null);
			cliente.setImagenId(GetterUtil.getLong(picture[0]));
			cliente.setImagen(String.valueOf(picture[1]));

			LOG.debug("Creando cliente: " + cliente);
			ClientesLocalServiceUtil.addClientes(cliente);
		} else {
			// TODO control de errores, display a popUp
		}

		actionResponse.setRenderParameter(Portlet1PortletKeys.JSP_PAGE, Portlet1PortletKeys.JSP_PAGE_VIEW);
		LOG.info("create():FIN");
	}

	@ProcessAction(name = "update")
	public void update(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		LOG.info("update():INI");

		String nif = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_NIF);

		if (!StringUtil.isBlank(nif)) {
			Clientes cliente = ClientesLocalServiceUtil.findByNif(nif);

			String email = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_EMAIL, cliente.getEmail());
			String descripcion = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_DESCRIPCION,
					cliente.getDescripcion());
			String apellidos = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_APELLIDOS,
					cliente.getApellidos());
			String nombre = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_NOMBRE, cliente.getNombre());

			cliente.setNombre(nombre);
			cliente.setApellidos(apellidos);
			cliente.setEmail(email);
			cliente.setDescripcion(descripcion);

			if (ParamUtil.getBoolean(actionRequest, Portlet1PortletKeys.FORM_UPDATE_IMG, false)) {
				Object[] picture = Portlet1PortletUtils.storageImage(actionRequest, nif, null);
				cliente.setImagenId(GetterUtil.getLong(picture[0]));
				cliente.setImagen(String.valueOf(picture[1]));
			}

			LOG.debug("Actualizando cliente: " + cliente);
			cliente = ClientesLocalServiceUtil.getService().updateClientes(cliente);
			actionRequest.setAttribute("cliente", cliente);
		} else {
			// TODO control de errores, display a popUp
		}

		actionResponse.setRenderParameter(Portlet1PortletKeys.JSP_PAGE, Portlet1PortletKeys.JSP_PAGE_PERFIL);
		LOG.info("update():FIN");
	}

	/***************** REDIRECT ********************/

	@ProcessAction(name = "homeRedirect")
	public void homeRedirect(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		LOG.debug("homeRedirect():INI");
		ThemeDisplay theme = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Object userId = theme.getUser().getUserId();

		LOG.debug("El usuario con ID " + userId + " vuelve a la home");
		actionResponse.setRenderParameter(Portlet1PortletKeys.JSP_PAGE, Portlet1PortletKeys.JSP_PAGE_VIEW);
		LOG.debug("homeRedirect():END");
	}

	@ProcessAction(name = "createRedirect")
	public void createRedirect(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		LOG.debug("createRedirect():INI");
		ThemeDisplay theme = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Object userId = theme.getUser().getUserId();

		LOG.debug("El usuario con ID " + userId + " procede a realizar una alta");
		actionResponse.setRenderParameter(Portlet1PortletKeys.JSP_PAGE, Portlet1PortletKeys.JSP_PAGE_ALTA);
		LOG.debug("createRedirect():END");
	}

	@ProcessAction(name = "readRedirect")
	public void readRedirect(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		LOG.debug("read():INI");
		ThemeDisplay theme = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Object userId = theme.getUser().getUserId();

		LOG.debug("El usuario con ID " + userId + " procede a realizar una lectura");
		actionRequest.setAttribute("clientes", ClientesLocalServiceUtil.getService().getClienteses(-1, -1));
		actionResponse.setRenderParameter(Portlet1PortletKeys.JSP_PAGE, Portlet1PortletKeys.JSP_PAGE_LLISTA);

		LOG.debug("read():END");
	}

	@ProcessAction(name = "actionRedirect")
	public void actionRedirect(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		LOG.debug("actionRedirect():INI");

		ThemeDisplay theme = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Object userId = theme.getUser().getUserId();
		String email = ParamUtil.getString(actionRequest, Portlet1PortletKeys.FORM_EMAIL);
		boolean update = ParamUtil.getBoolean(actionRequest, Portlet1PortletKeys.FORM_UPDATE);

		Clientes cliente = ClientesLocalServiceUtil.getService().findByEmail(email);

		if (update) {
			LOG.debug("El usuario con ID " + userId + " procede a modificar al usuario con email" + email);
			actionRequest.setAttribute("cliente", cliente);

			actionResponse.setRenderParameter(Portlet1PortletKeys.JSP_PAGE, Portlet1PortletKeys.JSP_PAGE_PERFIL);
		} else {
			LOG.debug("El usuario con ID " + userId + " procede a eliminar al usuario con email" + email);
		}

		LOG.debug("actionRedirect():END");
	}

	/***************** email ************/
	@ProcessAction(name = "sendEmail")
	public void sendEmail(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		LOG.debug("sendEmail():INI");
		int responseCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		String to = ParamUtil.getString(actionRequest, Portlet1PortletKeys.EMAIL_TO);
		String from = ParamUtil.getString(actionRequest, Portlet1PortletKeys.EMAIL_FROM);

		if (!StringUtil.isBlank(to) && !StringUtil.isBlank(from)) {
			String body = ParamUtil.getString(actionRequest, Portlet1PortletKeys.EMAIL_BODY);
			String[] cc = ParamUtil.getParameterValues(actionRequest, Portlet1PortletKeys.EMAIL_CC);
			String nombre = ParamUtil.getString(actionRequest, Portlet1PortletKeys.EMAIL_NOMBRE);

			try {
				MailMessage mailMessage = new MailMessage();
				mailMessage.setHTMLFormat(true);
				mailMessage.setBody(body);

				mailMessage.setFrom(new InternetAddress(from, nombre));
				mailMessage.setTo(new InternetAddress(to));
				for (String ccEmail : cc) {
					mailMessage.setCC(new InternetAddress(ccEmail));
				}

				File attachedFile = Portlet1PortletUtils.getFileFromRequest(actionRequest,
						Portlet1PortletKeys.EMAIL_FILE);
				if (attachedFile != null) {
					mailMessage.addFileAttachment(attachedFile);
				}

				mailMessage.setSubject(Portlet1PortletUtils.getPreference(actionRequest.getPreferences(),
						actionRequest.getLocale(), Portlet1PortletKeys.PREFERENCE_EMAIL_SUBJEC));

				MailServiceUtil.sendEmail(mailMessage);
				responseCode = HttpServletResponse.SC_OK;
			} catch (Exception e) {
				LOG.error("No se pudo enviar el Email", e);
			}
		}
		actionResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, Integer.toString(responseCode));
	}
}