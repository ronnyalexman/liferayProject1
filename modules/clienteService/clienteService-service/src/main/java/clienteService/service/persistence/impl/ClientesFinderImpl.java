package clienteService.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.suggest.SuggesterResult.Entry;

import java.util.List;

import clienteService.model.Clientes;
import clienteService.service.ClientesLocalServiceUtil;
import clienteService.service.persistence.ClientesFinder;

public class ClientesFinderImpl extends ClientesFinderBaseImpl implements ClientesFinder {

	private static Log LOG = LogFactoryUtil.getLog(ClientesFinderImpl.class);

	public Clientes findByEmail(String email) {
		Session session = null;
		try {
			session = openSession();
			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery clienteQuery = DynamicQueryFactoryUtil.forClass(Clientes.class, classLoader)
					.add(RestrictionsFactoryUtil.eq("email", email));

			clienteQuery.setLimit(0, 1);
			List<Clientes> result = ClientesLocalServiceUtil.getService().dynamicQuery(clienteQuery);

			if (result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			LOG.error("Problema con la conexion a base de datos", e);
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Clientes findByNif(String nif) {
		Session session = null;
		try {
			session = openSession();
			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery clienteQuery = DynamicQueryFactoryUtil.forClass(Clientes.class, classLoader)
					.add(RestrictionsFactoryUtil.eq("nif", nif));

			clienteQuery.setLimit(0, 1);
			List<Clientes> result = ClientesLocalServiceUtil.getService().dynamicQuery(clienteQuery);

			if (result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			LOG.error("Problema con la conexion a base de datos", e);
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<Clientes> findExactByField(String field, String value, int limit) {
		Session session = null;
		try {
			session = openSession();
			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery clienteQuery = DynamicQueryFactoryUtil.forClass(Clientes.class, classLoader)
					.add(RestrictionsFactoryUtil.like(field, value));

			clienteQuery.setLimit(0, limit);
			List<Clientes> result = ClientesLocalServiceUtil.getService().dynamicQuery(clienteQuery);

			return result;
		} catch (Exception e) {
			LOG.error("Problema con la conexion a base de datos", e);
		} finally {
			closeSession(session);
		}
		return null;
	}
}
