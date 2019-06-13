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

package clienteService.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Clientes}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Clientes
 * @generated
 */
@ProviderType
public class ClientesWrapper implements Clientes, ModelWrapper<Clientes> {
	public ClientesWrapper(Clientes clientes) {
		_clientes = clientes;
	}

	@Override
	public Class<?> getModelClass() {
		return Clientes.class;
	}

	@Override
	public String getModelClassName() {
		return Clientes.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("clienteId", getClienteId());
		attributes.put("nombre", getNombre());
		attributes.put("apellidos", getApellidos());
		attributes.put("nif", getNif());
		attributes.put("email", getEmail());
		attributes.put("descripcion", getDescripcion());
		attributes.put("imagen", getImagen());
		attributes.put("imagenId", getImagenId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long clienteId = (Long)attributes.get("clienteId");

		if (clienteId != null) {
			setClienteId(clienteId);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String apellidos = (String)attributes.get("apellidos");

		if (apellidos != null) {
			setApellidos(apellidos);
		}

		String nif = (String)attributes.get("nif");

		if (nif != null) {
			setNif(nif);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String descripcion = (String)attributes.get("descripcion");

		if (descripcion != null) {
			setDescripcion(descripcion);
		}

		String imagen = (String)attributes.get("imagen");

		if (imagen != null) {
			setImagen(imagen);
		}

		Long imagenId = (Long)attributes.get("imagenId");

		if (imagenId != null) {
			setImagenId(imagenId);
		}
	}

	@Override
	public Object clone() {
		return new ClientesWrapper((Clientes)_clientes.clone());
	}

	@Override
	public int compareTo(Clientes clientes) {
		return _clientes.compareTo(clientes);
	}

	/**
	* Returns the apellidos of this clientes.
	*
	* @return the apellidos of this clientes
	*/
	@Override
	public String getApellidos() {
		return _clientes.getApellidos();
	}

	/**
	* Returns the cliente ID of this clientes.
	*
	* @return the cliente ID of this clientes
	*/
	@Override
	public long getClienteId() {
		return _clientes.getClienteId();
	}

	/**
	* Returns the descripcion of this clientes.
	*
	* @return the descripcion of this clientes
	*/
	@Override
	public String getDescripcion() {
		return _clientes.getDescripcion();
	}

	/**
	* Returns the email of this clientes.
	*
	* @return the email of this clientes
	*/
	@Override
	public String getEmail() {
		return _clientes.getEmail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _clientes.getExpandoBridge();
	}

	/**
	* Returns the imagen of this clientes.
	*
	* @return the imagen of this clientes
	*/
	@Override
	public String getImagen() {
		return _clientes.getImagen();
	}

	/**
	* Returns the imagen ID of this clientes.
	*
	* @return the imagen ID of this clientes
	*/
	@Override
	public long getImagenId() {
		return _clientes.getImagenId();
	}

	/**
	* Returns the nif of this clientes.
	*
	* @return the nif of this clientes
	*/
	@Override
	public String getNif() {
		return _clientes.getNif();
	}

	/**
	* Returns the nombre of this clientes.
	*
	* @return the nombre of this clientes
	*/
	@Override
	public String getNombre() {
		return _clientes.getNombre();
	}

	/**
	* Returns the primary key of this clientes.
	*
	* @return the primary key of this clientes
	*/
	@Override
	public long getPrimaryKey() {
		return _clientes.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _clientes.getPrimaryKeyObj();
	}

	/**
	* Returns the uuid of this clientes.
	*
	* @return the uuid of this clientes
	*/
	@Override
	public String getUuid() {
		return _clientes.getUuid();
	}

	@Override
	public int hashCode() {
		return _clientes.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _clientes.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _clientes.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _clientes.isNew();
	}

	@Override
	public void persist() {
		_clientes.persist();
	}

	/**
	* Sets the apellidos of this clientes.
	*
	* @param apellidos the apellidos of this clientes
	*/
	@Override
	public void setApellidos(String apellidos) {
		_clientes.setApellidos(apellidos);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_clientes.setCachedModel(cachedModel);
	}

	/**
	* Sets the cliente ID of this clientes.
	*
	* @param clienteId the cliente ID of this clientes
	*/
	@Override
	public void setClienteId(long clienteId) {
		_clientes.setClienteId(clienteId);
	}

	/**
	* Sets the descripcion of this clientes.
	*
	* @param descripcion the descripcion of this clientes
	*/
	@Override
	public void setDescripcion(String descripcion) {
		_clientes.setDescripcion(descripcion);
	}

	/**
	* Sets the email of this clientes.
	*
	* @param email the email of this clientes
	*/
	@Override
	public void setEmail(String email) {
		_clientes.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_clientes.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_clientes.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_clientes.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the imagen of this clientes.
	*
	* @param imagen the imagen of this clientes
	*/
	@Override
	public void setImagen(String imagen) {
		_clientes.setImagen(imagen);
	}

	/**
	* Sets the imagen ID of this clientes.
	*
	* @param imagenId the imagen ID of this clientes
	*/
	@Override
	public void setImagenId(long imagenId) {
		_clientes.setImagenId(imagenId);
	}

	@Override
	public void setNew(boolean n) {
		_clientes.setNew(n);
	}

	/**
	* Sets the nif of this clientes.
	*
	* @param nif the nif of this clientes
	*/
	@Override
	public void setNif(String nif) {
		_clientes.setNif(nif);
	}

	/**
	* Sets the nombre of this clientes.
	*
	* @param nombre the nombre of this clientes
	*/
	@Override
	public void setNombre(String nombre) {
		_clientes.setNombre(nombre);
	}

	/**
	* Sets the primary key of this clientes.
	*
	* @param primaryKey the primary key of this clientes
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_clientes.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_clientes.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this clientes.
	*
	* @param uuid the uuid of this clientes
	*/
	@Override
	public void setUuid(String uuid) {
		_clientes.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Clientes> toCacheModel() {
		return _clientes.toCacheModel();
	}

	@Override
	public Clientes toEscapedModel() {
		return new ClientesWrapper(_clientes.toEscapedModel());
	}

	@Override
	public String toString() {
		return _clientes.toString();
	}

	@Override
	public Clientes toUnescapedModel() {
		return new ClientesWrapper(_clientes.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _clientes.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientesWrapper)) {
			return false;
		}

		ClientesWrapper clientesWrapper = (ClientesWrapper)obj;

		if (Objects.equals(_clientes, clientesWrapper._clientes)) {
			return true;
		}

		return false;
	}

	@Override
	public Clientes getWrappedModel() {
		return _clientes;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _clientes.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _clientes.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_clientes.resetOriginalValues();
	}

	private final Clientes _clientes;
}