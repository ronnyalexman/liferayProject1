package Portlet1.portlet;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import Portlet1.constants.Portlet1PortletKeys;

@Component(configurationPid = "NavigationPortlet.NavigationConfig", immediate = true, property = {
		"javax.portlet.name=" + Portlet1PortletKeys.Portlet1, }, service = ConfigurationAction.class)

public class Portlet1Config extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String pie = ParamUtil.getString(actionRequest, Portlet1PortletKeys.PREFERENCE_PIE);
		String multimediaDescripcion = ParamUtil.getString(actionRequest,
				Portlet1PortletKeys.PREFERENCE_FOLDER_DESCRIPCION);
		
		String subject = ParamUtil.getString(actionRequest, Portlet1PortletKeys.PREFERENCE_EMAIL_SUBJEC);

		PortletPreferences pp = actionRequest.getPreferences();

		pp.setValue(Portlet1PortletKeys.PREFERENCE_PIE, pie);
		pp.setValue(Portlet1PortletKeys.PREFERENCE_FOLDER_DESCRIPCION, multimediaDescripcion);
		pp.setValue(Portlet1PortletKeys.PREFERENCE_EMAIL_SUBJEC, subject);
		pp.store();
	}

	@Override
	public String getJspPath(HttpServletRequest request) {
		PortletRequest pr = (PortletRequest) request.getAttribute("javax.portlet.request");
		PortletPreferences pp = pr.getPreferences();

		request.setAttribute(Portlet1PortletKeys.PREFERENCE_FOLDER_DESCRIPCION,
				pp.getValue(Portlet1PortletKeys.PREFERENCE_FOLDER_DESCRIPCION, ""));

		request.setAttribute(Portlet1PortletKeys.PREFERENCE_PIE, pp.getValue(Portlet1PortletKeys.PREFERENCE_PIE, ""));
		
		request.setAttribute(Portlet1PortletKeys.PREFERENCE_EMAIL_SUBJEC, pp.getValue(Portlet1PortletKeys.PREFERENCE_EMAIL_SUBJEC, ""));

		return Portlet1PortletKeys.JSP_PAGE_CONFIG;
	}
}
