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

package clienteService.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import clienteService.exception.NoSuchClientesException;

import clienteService.model.Clientes;

import clienteService.model.impl.ClientesImpl;
import clienteService.model.impl.ClientesModelImpl;

import clienteService.service.persistence.ClientesPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the clientes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientesPersistence
 * @see clienteService.service.persistence.ClientesUtil
 * @generated
 */
@ProviderType
public class ClientesPersistenceImpl extends BasePersistenceImpl<Clientes>
	implements ClientesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ClientesUtil} to access the clientes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ClientesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ClientesModelImpl.ENTITY_CACHE_ENABLED,
			ClientesModelImpl.FINDER_CACHE_ENABLED, ClientesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ClientesModelImpl.ENTITY_CACHE_ENABLED,
			ClientesModelImpl.FINDER_CACHE_ENABLED, ClientesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ClientesModelImpl.ENTITY_CACHE_ENABLED,
			ClientesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ClientesModelImpl.ENTITY_CACHE_ENABLED,
			ClientesModelImpl.FINDER_CACHE_ENABLED, ClientesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ClientesModelImpl.ENTITY_CACHE_ENABLED,
			ClientesModelImpl.FINDER_CACHE_ENABLED, ClientesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ClientesModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ClientesModelImpl.ENTITY_CACHE_ENABLED,
			ClientesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the clienteses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching clienteses
	 */
	@Override
	public List<Clientes> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Clientes> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Clientes> findByUuid(String uuid, int start, int end,
		OrderByComparator<Clientes> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Clientes> findByUuid(String uuid, int start, int end,
		OrderByComparator<Clientes> orderByComparator, boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Clientes> list = null;

		if (retrieveFromCache) {
			list = (List<Clientes>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Clientes clientes : list) {
					if (!uuid.equals(clientes.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CLIENTES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ClientesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Clientes>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Clientes>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first clientes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clientes
	 * @throws NoSuchClientesException if a matching clientes could not be found
	 */
	@Override
	public Clientes findByUuid_First(String uuid,
		OrderByComparator<Clientes> orderByComparator)
		throws NoSuchClientesException {
		Clientes clientes = fetchByUuid_First(uuid, orderByComparator);

		if (clientes != null) {
			return clientes;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchClientesException(msg.toString());
	}

	/**
	 * Returns the first clientes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clientes, or <code>null</code> if a matching clientes could not be found
	 */
	@Override
	public Clientes fetchByUuid_First(String uuid,
		OrderByComparator<Clientes> orderByComparator) {
		List<Clientes> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last clientes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clientes
	 * @throws NoSuchClientesException if a matching clientes could not be found
	 */
	@Override
	public Clientes findByUuid_Last(String uuid,
		OrderByComparator<Clientes> orderByComparator)
		throws NoSuchClientesException {
		Clientes clientes = fetchByUuid_Last(uuid, orderByComparator);

		if (clientes != null) {
			return clientes;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchClientesException(msg.toString());
	}

	/**
	 * Returns the last clientes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clientes, or <code>null</code> if a matching clientes could not be found
	 */
	@Override
	public Clientes fetchByUuid_Last(String uuid,
		OrderByComparator<Clientes> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Clientes> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Clientes[] findByUuid_PrevAndNext(long clienteId, String uuid,
		OrderByComparator<Clientes> orderByComparator)
		throws NoSuchClientesException {
		uuid = Objects.toString(uuid, "");

		Clientes clientes = findByPrimaryKey(clienteId);

		Session session = null;

		try {
			session = openSession();

			Clientes[] array = new ClientesImpl[3];

			array[0] = getByUuid_PrevAndNext(session, clientes, uuid,
					orderByComparator, true);

			array[1] = clientes;

			array[2] = getByUuid_PrevAndNext(session, clientes, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Clientes getByUuid_PrevAndNext(Session session,
		Clientes clientes, String uuid,
		OrderByComparator<Clientes> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLIENTES_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ClientesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(clientes);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Clientes> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clienteses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Clientes clientes : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(clientes);
		}
	}

	/**
	 * Returns the number of clienteses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching clienteses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLIENTES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "clientes.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "clientes.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(clientes.uuid IS NULL OR clientes.uuid = '')";

	public ClientesPersistenceImpl() {
		setModelClass(Clientes.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the clientes in the entity cache if it is enabled.
	 *
	 * @param clientes the clientes
	 */
	@Override
	public void cacheResult(Clientes clientes) {
		entityCache.putResult(ClientesModelImpl.ENTITY_CACHE_ENABLED,
			ClientesImpl.class, clientes.getPrimaryKey(), clientes);

		clientes.resetOriginalValues();
	}

	/**
	 * Caches the clienteses in the entity cache if it is enabled.
	 *
	 * @param clienteses the clienteses
	 */
	@Override
	public void cacheResult(List<Clientes> clienteses) {
		for (Clientes clientes : clienteses) {
			if (entityCache.getResult(ClientesModelImpl.ENTITY_CACHE_ENABLED,
						ClientesImpl.class, clientes.getPrimaryKey()) == null) {
				cacheResult(clientes);
			}
			else {
				clientes.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all clienteses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClientesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the clientes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Clientes clientes) {
		entityCache.removeResult(ClientesModelImpl.ENTITY_CACHE_ENABLED,
			ClientesImpl.class, clientes.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Clientes> clienteses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Clientes clientes : clienteses) {
			entityCache.removeResult(ClientesModelImpl.ENTITY_CACHE_ENABLED,
				ClientesImpl.class, clientes.getPrimaryKey());
		}
	}

	/**
	 * Creates a new clientes with the primary key. Does not add the clientes to the database.
	 *
	 * @param clienteId the primary key for the new clientes
	 * @return the new clientes
	 */
	@Override
	public Clientes create(long clienteId) {
		Clientes clientes = new ClientesImpl();

		clientes.setNew(true);
		clientes.setPrimaryKey(clienteId);

		String uuid = PortalUUIDUtil.generate();

		clientes.setUuid(uuid);

		return clientes;
	}

	/**
	 * Removes the clientes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteId the primary key of the clientes
	 * @return the clientes that was removed
	 * @throws NoSuchClientesException if a clientes with the primary key could not be found
	 */
	@Override
	public Clientes remove(long clienteId) throws NoSuchClientesException {
		return remove((Serializable)clienteId);
	}

	/**
	 * Removes the clientes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the clientes
	 * @return the clientes that was removed
	 * @throws NoSuchClientesException if a clientes with the primary key could not be found
	 */
	@Override
	public Clientes remove(Serializable primaryKey)
		throws NoSuchClientesException {
		Session session = null;

		try {
			session = openSession();

			Clientes clientes = (Clientes)session.get(ClientesImpl.class,
					primaryKey);

			if (clientes == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClientesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(clientes);
		}
		catch (NoSuchClientesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Clientes removeImpl(Clientes clientes) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clientes)) {
				clientes = (Clientes)session.get(ClientesImpl.class,
						clientes.getPrimaryKeyObj());
			}

			if (clientes != null) {
				session.delete(clientes);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (clientes != null) {
			clearCache(clientes);
		}

		return clientes;
	}

	@Override
	public Clientes updateImpl(Clientes clientes) {
		boolean isNew = clientes.isNew();

		if (!(clientes instanceof ClientesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(clientes.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(clientes);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in clientes proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Clientes implementation " +
				clientes.getClass());
		}

		ClientesModelImpl clientesModelImpl = (ClientesModelImpl)clientes;

		if (Validator.isNull(clientes.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			clientes.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (clientes.isNew()) {
				session.save(clientes);

				clientes.setNew(false);
			}
			else {
				clientes = (Clientes)session.merge(clientes);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ClientesModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { clientesModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((clientesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { clientesModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { clientesModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(ClientesModelImpl.ENTITY_CACHE_ENABLED,
			ClientesImpl.class, clientes.getPrimaryKey(), clientes, false);

		clientes.resetOriginalValues();

		return clientes;
	}

	/**
	 * Returns the clientes with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the clientes
	 * @return the clientes
	 * @throws NoSuchClientesException if a clientes with the primary key could not be found
	 */
	@Override
	public Clientes findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClientesException {
		Clientes clientes = fetchByPrimaryKey(primaryKey);

		if (clientes == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClientesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return clientes;
	}

	/**
	 * Returns the clientes with the primary key or throws a {@link NoSuchClientesException} if it could not be found.
	 *
	 * @param clienteId the primary key of the clientes
	 * @return the clientes
	 * @throws NoSuchClientesException if a clientes with the primary key could not be found
	 */
	@Override
	public Clientes findByPrimaryKey(long clienteId)
		throws NoSuchClientesException {
		return findByPrimaryKey((Serializable)clienteId);
	}

	/**
	 * Returns the clientes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the clientes
	 * @return the clientes, or <code>null</code> if a clientes with the primary key could not be found
	 */
	@Override
	public Clientes fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ClientesModelImpl.ENTITY_CACHE_ENABLED,
				ClientesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Clientes clientes = (Clientes)serializable;

		if (clientes == null) {
			Session session = null;

			try {
				session = openSession();

				clientes = (Clientes)session.get(ClientesImpl.class, primaryKey);

				if (clientes != null) {
					cacheResult(clientes);
				}
				else {
					entityCache.putResult(ClientesModelImpl.ENTITY_CACHE_ENABLED,
						ClientesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ClientesModelImpl.ENTITY_CACHE_ENABLED,
					ClientesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return clientes;
	}

	/**
	 * Returns the clientes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clienteId the primary key of the clientes
	 * @return the clientes, or <code>null</code> if a clientes with the primary key could not be found
	 */
	@Override
	public Clientes fetchByPrimaryKey(long clienteId) {
		return fetchByPrimaryKey((Serializable)clienteId);
	}

	@Override
	public Map<Serializable, Clientes> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Clientes> map = new HashMap<Serializable, Clientes>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Clientes clientes = fetchByPrimaryKey(primaryKey);

			if (clientes != null) {
				map.put(primaryKey, clientes);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ClientesModelImpl.ENTITY_CACHE_ENABLED,
					ClientesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Clientes)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CLIENTES_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Clientes clientes : (List<Clientes>)q.list()) {
				map.put(clientes.getPrimaryKeyObj(), clientes);

				cacheResult(clientes);

				uncachedPrimaryKeys.remove(clientes.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ClientesModelImpl.ENTITY_CACHE_ENABLED,
					ClientesImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the clienteses.
	 *
	 * @return the clienteses
	 */
	@Override
	public List<Clientes> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Clientes> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Clientes> findAll(int start, int end,
		OrderByComparator<Clientes> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Clientes> findAll(int start, int end,
		OrderByComparator<Clientes> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Clientes> list = null;

		if (retrieveFromCache) {
			list = (List<Clientes>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CLIENTES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTES;

				if (pagination) {
					sql = sql.concat(ClientesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Clientes>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Clientes>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the clienteses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Clientes clientes : findAll()) {
			remove(clientes);
		}
	}

	/**
	 * Returns the number of clienteses.
	 *
	 * @return the number of clienteses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CLIENTES);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClientesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the clientes persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ClientesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CLIENTES = "SELECT clientes FROM Clientes clientes";
	private static final String _SQL_SELECT_CLIENTES_WHERE_PKS_IN = "SELECT clientes FROM Clientes clientes WHERE clienteId IN (";
	private static final String _SQL_SELECT_CLIENTES_WHERE = "SELECT clientes FROM Clientes clientes WHERE ";
	private static final String _SQL_COUNT_CLIENTES = "SELECT COUNT(clientes) FROM Clientes clientes";
	private static final String _SQL_COUNT_CLIENTES_WHERE = "SELECT COUNT(clientes) FROM Clientes clientes WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "clientes.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Clientes exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Clientes exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ClientesPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}