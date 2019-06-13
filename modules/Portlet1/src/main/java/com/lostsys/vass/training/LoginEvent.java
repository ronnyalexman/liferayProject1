package com.lostsys.vass.training;

import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "key=" + PropsKeys.LOGIN_EVENTS_POST }, service = LifecycleAction.class)
public class LoginEvent implements LifecycleAction {
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) {
		try {
			User user = PortalUtil.getUser(lifecycleEvent.getRequest());
			System.out.println(
					"Usuario logueado: " + user.getEmailAddress() + "\nPass: " + user.getPassword());
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
