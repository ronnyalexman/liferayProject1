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

package clienteService.model.impl;

import aQute.bnd.annotation.ProviderType;

import clienteService.model.Clientes;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Clientes in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Clientes
 * @generated
 */
@ProviderType
public class ClientesCacheModel implements CacheModel<Clientes>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientesCacheModel)) {
			return false;
		}

		ClientesCacheModel clientesCacheModel = (ClientesCacheModel)obj;

		if (clienteId == clientesCacheModel.clienteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clienteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", clienteId=");
		sb.append(clienteId);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", apellidos=");
		sb.append(apellidos);
		sb.append(", nif=");
		sb.append(nif);
		sb.append(", email=");
		sb.append(email);
		sb.append(", descripcion=");
		sb.append(descripcion);
		sb.append(", imagen=");
		sb.append(imagen);
		sb.append(", imagenId=");
		sb.append(imagenId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Clientes toEntityModel() {
		ClientesImpl clientesImpl = new ClientesImpl();

		if (uuid == null) {
			clientesImpl.setUuid("");
		}
		else {
			clientesImpl.setUuid(uuid);
		}

		clientesImpl.setClienteId(clienteId);

		if (nombre == null) {
			clientesImpl.setNombre("");
		}
		else {
			clientesImpl.setNombre(nombre);
		}

		if (apellidos == null) {
			clientesImpl.setApellidos("");
		}
		else {
			clientesImpl.setApellidos(apellidos);
		}

		if (nif == null) {
			clientesImpl.setNif("");
		}
		else {
			clientesImpl.setNif(nif);
		}

		if (email == null) {
			clientesImpl.setEmail("");
		}
		else {
			clientesImpl.setEmail(email);
		}

		if (descripcion == null) {
			clientesImpl.setDescripcion("");
		}
		else {
			clientesImpl.setDescripcion(descripcion);
		}

		if (imagen == null) {
			clientesImpl.setImagen("");
		}
		else {
			clientesImpl.setImagen(imagen);
		}

		clientesImpl.setImagenId(imagenId);

		clientesImpl.resetOriginalValues();

		return clientesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		clienteId = objectInput.readLong();
		nombre = objectInput.readUTF();
		apellidos = objectInput.readUTF();
		nif = objectInput.readUTF();
		email = objectInput.readUTF();
		descripcion = objectInput.readUTF();
		imagen = objectInput.readUTF();

		imagenId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(clienteId);

		if (nombre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombre);
		}

		if (apellidos == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(apellidos);
		}

		if (nif == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nif);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (descripcion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descripcion);
		}

		if (imagen == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imagen);
		}

		objectOutput.writeLong(imagenId);
	}

	public String uuid;
	public long clienteId;
	public String nombre;
	public String apellidos;
	public String nif;
	public String email;
	public String descripcion;
	public String imagen;
	public long imagenId;
}