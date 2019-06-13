package Portlet1.portlet;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import Portlet1.constants.Portlet1PortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + Portlet1PortletKeys.Portlet1,
		"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml" }, service = FriendlyURLMapper.class)
public class FriendlyUrlMapping extends DefaultFriendlyURLMapper {
	@Override
	public String getMapping() {
		return _MAPPING;
	}

	/*@Override
	public void populateParams(String friendlyURLPath, Map<String, String[]> parameterMap,
			Map<String, Object> requestContext) {
		
		System.out.println("Procesando URL" + friendlyURLPath);
		
		// TODO Auto-generated method stub
		super.populateParams(friendlyURLPath, parameterMap, requestContext);
	}

	@Override
	public String buildPath(LiferayPortletURL liferayPortletURL) {
		String jsp = liferayPortletURL.getParameter("jspPage");
		System.out.println(jsp);
		
		if(jsp  != null && jsp.isEmpty()) {
			return "/"+_MAPPING + jsp.substring(0, jsp.indexOf(".jsp"));
		}
		return null;
	}*/

	private static final String _MAPPING = "vass";

}
