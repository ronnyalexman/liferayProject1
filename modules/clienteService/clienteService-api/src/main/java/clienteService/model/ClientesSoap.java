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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link clienteService.service.http.ClientesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see clienteService.service.http.ClientesServiceSoap
 * @generated
 */
@ProviderType
public class ClientesSoap implements Serializable {
	public static ClientesSoap toSoapModel(Clientes model) {
		ClientesSoap soapModel = new ClientesSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setClienteId(model.getClienteId());
		soapModel.setNombre(model.getNombre());
		soapModel.setApellidos(model.getApellidos());
		soapModel.setNif(model.getNif());
		soapModel.setEmail(model.getEmail());
		soapModel.setDescripcion(model.getDescripcion());
		soapModel.setImagen(model.getImagen());
		soapModel.setImagenId(model.getImagenId());

		return soapModel;
	}

	public static ClientesSoap[] toSoapModels(Clientes[] models) {
		ClientesSoap[] soapModels = new ClientesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClientesSoap[][] toSoapModels(Clientes[][] models) {
		ClientesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClientesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClientesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClientesSoap[] toSoapModels(List<Clientes> models) {
		List<ClientesSoap> soapModels = new ArrayList<ClientesSoap>(models.size());

		for (Clientes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClientesSoap[soapModels.size()]);
	}

	public ClientesSoap() {
	}

	public long getPrimaryKey() {
		return _clienteId;
	}

	public void setPrimaryKey(long pk) {
		setClienteId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getClienteId() {
		return _clienteId;
	}

	public void setClienteId(long clienteId) {
		_clienteId = clienteId;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public String getApellidos() {
		return _apellidos;
	}

	public void setApellidos(String apellidos) {
		_apellidos = apellidos;
	}

	public String getNif() {
		return _nif;
	}

	public void setNif(String nif) {
		_nif = nif;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	public String getImagen() {
		return _imagen;
	}

	public void setImagen(String imagen) {
		_imagen = imagen;
	}

	public long getImagenId() {
		return _imagenId;
	}

	public void setImagenId(long imagenId) {
		_imagenId = imagenId;
	}

	private String _uuid;
	private long _clienteId;
	private String _nombre;
	private String _apellidos;
	private String _nif;
	private String _email;
	private String _descripcion;
	private String _imagen;
	private long _imagenId;
}