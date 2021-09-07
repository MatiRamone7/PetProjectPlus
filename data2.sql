CREATE TABLE [provincia] (
	id int primary Key identity(1,1),
	nombre varchar(255)
)

INSERT INTO provincia(nombre) VALUES
  ('Buenos Aires'),
  ('Cordoba'),
  ('Santa Fe'),
  ('Uruguay');

CREATE TABLE [ciudad] (
	id int primary Key identity(1,1),
	nombre varchar(255),
	provinciaId int,
	CONSTRAINT FK_PROVINCIA FOREIGN KEY (provinciaId) REFERENCES provincia(id)
)

INSERT INTO ciudad(nombre, provinciaId) VALUES
  ('CABA', 1),
  ('Cordoba City', 2),
  ('Rosario', 3),
  ('Montevideo', 4);

CREATE TABLE [direccion] (
	id int primary Key identity(1,1),
	departamento varchar(255),
	ciudadId int,
	calle varchar(255),
	numero int,
	codigoPostal varchar(255),
	latitud double,
	longitud double,
	CONSTRAINT FK_CIUDAD FOREIGN KEY (ciudadId) REFERENCES ciudad(id)
)

INSERT INTO direccion(departamento, ciudadId, calle, numero, codigoPostal, latitud, longitud) VALUES
  ('Depto 1', 1, 'Calle 1', 1, 'CP 1', 1, 1),
  ('Depto 2', 2, 'Calle 2', 2, 'CP 2', 2, 2),
  ('Depto 3', 3, 'Calle 3', 3, 'CP 3', 3, 3),
  ('Depto 4', 4, 'Calle 4', 4, 'CP 4', 4, 4);

