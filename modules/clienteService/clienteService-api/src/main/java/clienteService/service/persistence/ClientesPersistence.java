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

import clienteService.exception.NoSuchClientesException;

import clienteService.model.Clientes;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the clientes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see clienteService.service.persistence.impl.ClientesPersistenceImpl
 * @see ClientesUtil
 * @generated
 */
@ProviderType
public interface ClientesPersistence extends BasePersistence<Clientes> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClientesUtil} to access the clientes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the clienteses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching clienteses
	*/
	public java.util.List<Clientes> findByUuid(String uuid);

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
	public java.util.List<Clientes> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Clientes> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Clientes> orderByComparator);

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
	public java.util.List<Clientes> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Clientes> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first clientes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clientes
	* @throws NoSuchClientesException if a matching clientes could not be found
	*/
	public Clientes findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Clientes> orderByComparator)
		throws NoSuchClientesException;

	/**
	* Returns the first clientes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clientes, or <code>null</code> if a matching clientes could not be found
	*/
	public Clientes fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Clientes> orderByComparator);

	/**
	* Returns the last clientes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clientes
	* @throws NoSuchClientesException if a matching clientes could not be found
	*/
	public Clientes findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Clientes> orderByComparator)
		throws NoSuchClientesException;

	/**
	* Returns the last clientes in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clientes, or <code>null</code> if a matching clientes could not be found
	*/
	public Clientes fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Clientes> orderByComparator);

	/**
	* Returns the clienteses before and after the current clientes in the ordered set where uuid = &#63;.
	*
	* @param clienteId the primary key of the current clientes
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next clientes
	* @throws NoSuchClientesException if a clientes with the primary key could not be found
	*/
	public Clientes[] findByUuid_PrevAndNext(long clienteId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Clientes> orderByComparator)
		throws NoSuchClientesException;

	/**
	* Removes all the clienteses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of clienteses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching clienteses
	*/
	public int countByUuid(String uuid);

	/**
	* Caches the clientes in the entity cache if it is enabled.
	*
	* @param clientes the clientes
	*/
	public void cacheResult(Clientes clientes);

	/**
	* Caches the clienteses in the entity cache if it is enabled.
	*
	* @param clienteses the clienteses
	*/
	public void cacheResult(java.util.List<Clientes> clienteses);

	/**
	* Creates a new clientes with the primary key. Does not add the clientes to the database.
	*
	* @param clienteId the primary key for the new clientes
	* @return the new clientes
	*/
	public Clientes create(long clienteId);

	/**
	* Removes the clientes with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clienteId the primary key of the clientes
	* @return the clientes that was removed
	* @throws NoSuchClientesException if a clientes with the primary key could not be found
	*/
	public Clientes remove(long clienteId) throws NoSuchClientesException;

	public Clientes updateImpl(Clientes clientes);

	/**
	* Returns the clientes with the primary key or throws a {@link NoSuchClientesException} if it could not be found.
	*
	* @param clienteId the primary key of the clientes
	* @return the clientes
	* @throws NoSuchClientesException if a clientes with the primary key could not be found
	*/
	public Clientes findByPrimaryKey(long clienteId)
		throws NoSuchClientesException;

	/**
	* Returns the clientes with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clienteId the primary key of the clientes
	* @return the clientes, or <code>null</code> if a clientes with the primary key could not be found
	*/
	public Clientes fetchByPrimaryKey(long clienteId);

	@Override
	public java.util.Map<java.io.Serializable, Clientes> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the clienteses.
	*
	* @return the clienteses
	*/
	public java.util.List<Clientes> findAll();

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
	public java.util.List<Clientes> findAll(int start, int end);

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
	public java.util.List<Clientes> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Clientes> orderByComparator);

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
	public java.util.List<Clientes> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Clientes> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the clienteses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of clienteses.
	*
	* @return the number of clienteses
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}