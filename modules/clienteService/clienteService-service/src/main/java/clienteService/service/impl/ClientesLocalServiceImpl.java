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

package clienteService.service.impl;

import java.util.List;

import clienteService.model.Clientes;
import clienteService.service.base.ClientesLocalServiceBaseImpl;

/**
 * The implementation of the clientes local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link clienteService.service.ClientesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientesLocalServiceBaseImpl
 * @see clienteService.service.ClientesLocalServiceUtil
 */
public class ClientesLocalServiceImpl extends ClientesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * clienteService.service.ClientesLocalServiceUtil} to access the clientes local
	 * service.
	 */
	public Clientes findByEmail(String email) {
		return super.clientesFinder.findByEmail(email);
	}

	public Clientes findByNif(String nif) {
		return super.clientesFinder.findByNif(nif);
	}

	public List<Clientes> findExactByField(String field, String value, int limit) {
		return super.clientesFinder.findExactByField(field, value, limit);
	}
}