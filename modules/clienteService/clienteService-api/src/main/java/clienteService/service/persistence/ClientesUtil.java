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

package clienteService.service.persistence;

import aQute.bnd.annotation.ProviderType;

import clienteService.model.Clientes;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the clientes service. This utility wraps {@link clienteService.service.persistence.impl.ClientesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientesPersistence
 * @see clienteService.service.persistence.impl.ClientesPersistenceImpl
 * @generated
 */
@ProviderType
public class ClientesUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Clientes clientes) {
		getPersistence().clearCache(clientes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Clientes> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Clientes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Clientes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Clientes> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Clientes update(Clientes clientes) {
		return getPersistence().update(clientes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Clientes update(Clientes clientes,
		ServiceContext serviceContext) {
		return getPersistence().update(clientes, serviceContext);
	}

	/**
	* Returns all the clienteses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching clienteses
	*/
	public static List<Clientes> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the clienteses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clienteses
	* @param end the upper bound of the range of clienteses (not inclusive)
	* @return the range of matching clienteses
	*/
	public static List<Clientes> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the clienteses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clienteses
	* @param end the upper bound of the range of clienteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clienteses
	*/
	public static List<Clientes> findByUuid(String uuid, int start, int end,
		OrderByComparator<Clientes> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the clienteses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clienteses
	* @param end the upper bound of the range of clienteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching clienteses
	*/
	public static List<Clientes> findByUuid(String uuid, int start, int end,
		OrderByComparator<Clientes> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first clientes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clientes
	* @throws NoSuchClientesException if a matching clientes could not be found
	*/
	public static Clientes findByUuid_First(String uuid,
		OrderByComparator<Clientes> orderByComparator)
		throws clienteService.exception.NoSuchClientesException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first clientes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clientes, or <code>null</code> if a matching clientes could not be found
	*/
	public static Clientes fetchByUuid_First(String uuid,
		OrderByComparator<Clientes> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last clientes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clientes
	* @throws NoSuchClientesException if a matching clientes could not be found
	*/
	public static Clientes findByUuid_Last(String uuid,
		OrderByComparator<Clientes> orderByComparator)
		throws clienteService.exception.NoSuchClientesException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last clientes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clientes, or <code>null</code> if a matching clientes could not be found
	*/
	public static Clientes fetchByUuid_Last(String uuid,
		OrderByComparator<Clientes> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the clienteses before and after the current clientes in the ordered set where uuid = &#63;.
	*
	* @param clienteId the primary key of the current clientes
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next clientes
	* @throws NoSuchClientesException if a clientes with the primary key could not be found
	*/
	public static Clientes[] findByUuid_PrevAndNext(long clienteId,
		String uuid, OrderByComparator<Clientes> orderByComparator)
		throws clienteService.exception.NoSuchClientesException {
		return getPersistence()
				   .findByUuid_PrevAndNext(clienteId, uuid, orderByComparator);
	}

	/**
	* Removes all the clienteses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of clienteses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching clienteses
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the clientes in the entity cache if it is enabled.
	*
	* @param clientes the clientes
	*/
	public static void cacheResult(Clientes clientes) {
		getPersistence().cacheResult(clientes);
	}

	/**
	* Caches the clienteses in the entity cache if it is enabled.
	*
	* @param clienteses the clienteses
	*/
	public static void cacheResult(List<Clientes> clienteses) {
		getPersistence().cacheResult(clienteses);
	}

	/**
	* Creates a new clientes with the primary key. Does not add the clientes to the database.
	*
	* @param clienteId the primary key for the new clientes
	* @return the new clientes
	*/
	public static Clientes create(long clienteId) {
		return getPersistence().create(clienteId);
	}

	/**
	* Removes the clientes with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clienteId the primary key of the clientes
	* @return the clientes that was removed
	* @throws NoSuchClientesException if a clientes with the primary key could not be found
	*/
	public static Clientes remove(long clienteId)
		throws clienteService.exception.NoSuchClientesException {
		return getPersistence().remove(clienteId);
	}

	public static Clientes updateImpl(Clientes clientes) {
		return getPersistence().updateImpl(clientes);
	}

	/**
	* Returns the clientes with the primary key or throws a {@link NoSuchClientesException} if it could not be found.
	*
	* @param clienteId the primary key of the clientes
	* @return the clientes
	* @throws NoSuchClientesException if a clientes with the primary key could not be found
	*/
	public static Clientes findByPrimaryKey(long clienteId)
		throws clienteService.exception.NoSuchClientesException {
		return getPersistence().findByPrimaryKey(clienteId);
	}

	/**
	* Returns the clientes with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clienteId the primary key of the clientes
	* @return the clientes, or <code>null</code> if a clientes with the primary key could not be found
	*/
	public static Clientes fetchByPrimaryKey(long clienteId) {
		return getPersistence().fetchByPrimaryKey(clienteId);
	}

	public static java.util.Map<java.io.Serializable, Clientes> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the clienteses.
	*
	* @return the clienteses
	*/
	public static List<Clientes> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the clienteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clienteses
	* @param end the upper bound of the range of clienteses (not inclusive)
	* @return the range of clienteses
	*/
	public static List<Clientes> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the clienteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clienteses
	* @param end the upper bound of the range of clienteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of clienteses
	*/
	public static List<Clientes> findAll(int start, int end,
		OrderByComparator<Clientes> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the clienteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clienteses
	* @param end the upper bound of the range of clienteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of clienteses
	*/
	public static List<Clientes> findAll(int start, int end,
		OrderByComparator<Clientes> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the clienteses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of clienteses.
	*
	* @return the number of clienteses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ClientesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClientesPersistence, ClientesPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClientesPersistence.class);

		ServiceTracker<ClientesPersistence, ClientesPersistence> serviceTracker = new ServiceTracker<ClientesPersistence, ClientesPersistence>(bundle.getBundleContext(),
				ClientesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}