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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Clientes. This utility wraps
 * {@link clienteService.service.impl.ClientesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClientesLocalService
 * @see clienteService.service.base.ClientesLocalServiceBaseImpl
 * @see clienteService.service.impl.ClientesLocalServiceImpl
 * @generated
 */
@ProviderType
public class ClientesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link clienteService.service.impl.ClientesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the clientes to the database. Also notifies the appropriate model listeners.
	*
	* @param clientes the clientes
	* @return the clientes that was added
	*/
	public static clienteService.model.Clientes addClientes(
		clienteService.model.Clientes clientes) {
		return getService().addClientes(clientes);
	}

	/**
	* Creates a new clientes with the primary key. Does not add the clientes to the database.
	*
	* @param clienteId the primary key for the new clientes
	* @return the new clientes
	*/
	public static clienteService.model.Clientes createClientes(long clienteId) {
		return getService().createClientes(clienteId);
	}

	/**
	* Deletes the clientes from the database. Also notifies the appropriate model listeners.
	*
	* @param clientes the clientes
	* @return the clientes that was removed
	*/
	public static clienteService.model.Clientes deleteClientes(
		clienteService.model.Clientes clientes) {
		return getService().deleteClientes(clientes);
	}

	/**
	* Deletes the clientes with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clienteId the primary key of the clientes
	* @return the clientes that was removed
	* @throws PortalException if a clientes with the primary key could not be found
	*/
	public static clienteService.model.Clientes deleteClientes(long clienteId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteClientes(clienteId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link clienteService.model.impl.ClientesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link clienteService.model.impl.ClientesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static clienteService.model.Clientes fetchClientes(long clienteId) {
		return getService().fetchClientes(clienteId);
	}

	public static clienteService.model.Clientes findByEmail(String email) {
		return getService().findByEmail(email);
	}

	public static clienteService.model.Clientes findByNif(String nif) {
		return getService().findByNif(nif);
	}

	public static java.util.List<clienteService.model.Clientes> findExactByField(
		String field, String value, int limit) {
		return getService().findExactByField(field, value, limit);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the clientes with the primary key.
	*
	* @param clienteId the primary key of the clientes
	* @return the clientes
	* @throws PortalException if a clientes with the primary key could not be found
	*/
	public static clienteService.model.Clientes getClientes(long clienteId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getClientes(clienteId);
	}

	/**
	* Returns a range of all the clienteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link clienteService.model.impl.ClientesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clienteses
	* @param end the upper bound of the range of clienteses (not inclusive)
	* @return the range of clienteses
	*/
	public static java.util.List<clienteService.model.Clientes> getClienteses(
		int start, int end) {
		return getService().getClienteses(start, end);
	}

	/**
	* Returns the number of clienteses.
	*
	* @return the number of clienteses
	*/
	public static int getClientesesCount() {
		return getService().getClientesesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the clientes in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param clientes the clientes
	* @return the clientes that was updated
	*/
	public static clienteService.model.Clientes updateClientes(
		clienteService.model.Clientes clientes) {
		return getService().updateClientes(clientes);
	}

	public static ClientesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClientesLocalService, ClientesLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClientesLocalService.class);

		ServiceTracker<ClientesLocalService, ClientesLocalService> serviceTracker =
			new ServiceTracker<ClientesLocalService, ClientesLocalService>(bundle.getBundleContext(),
				ClientesLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}