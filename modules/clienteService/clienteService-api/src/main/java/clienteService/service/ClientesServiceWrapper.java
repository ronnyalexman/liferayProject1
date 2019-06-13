/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package clienteService.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ClientesService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClientesService
 * @generated
 */
@ProviderType
public class ClientesServiceWrapper implements ClientesService,
	ServiceWrapper<ClientesService> {
	public ClientesServiceWrapper(ClientesService clientesService) {
		_clientesService = clientesService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _clientesService.getOSGiServiceIdentifier();
	}

	@Override
	public void testService() {
		_clientesService.testService();
	}

	@Override
	public ClientesService getWrappedService() {
		return _clientesService;
	}

	@Override
	public void setWrappedService(ClientesService clientesService) {
		_clientesService = clientesService;
	}

	private ClientesService _clientesService;
}