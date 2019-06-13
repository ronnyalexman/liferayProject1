create table VASS_Clientes (
	uuid_ VARCHAR(75) null,
	clienteId LONG not null primary key,
	nombre VARCHAR(75) null,
	apellidos VARCHAR(75) null,
	nif VARCHAR(75) null,
	email VARCHAR(75) null,
	descripcion VARCHAR(500) null,
	imagen VARCHAR(500) null,
	imagenId LONG
);