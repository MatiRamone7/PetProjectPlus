DROP TABLE IF EXISTS ong;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS rescatista;
DROP TABLE IF EXISTS publicacion;

CREATE TABLE [ong] (
	id int primary Key identity(1,1),
	nombre varchar(255),
	estandarizacionDeImagen varchar(255)
)

INSERT INTO ong (nombre, estandarizacionDeImagen) VALUES
  ('Pets Corp', 'Imagen Grande'),
  ('Partners of Pets', 'Imagen Mediana'),
  ('Pets Refugee', 'Imagen Chica');
 
CREATE TABLE [usuario] (
	id int primary Key identity(1,1),
	nombre varchar(255),
	password varchar(255),
	apellido varchar(255),
	fechaDeNacimiento DateTime2,
	tipoDocumento varchar(255),
	numeroDocumento int,
	--FK
	ongId int,
	CONSTRAINT FK_ONG FOREIGN KEY (ongId) REFERENCES ONG(id)
)

INSERT INTO usuario (nombre, password, apellido, fechaDeNacimiento, tipoDocumento, numeroDocumento, ongId) VALUES
  ('Commander', 'Pass1', 'Shepard', GetDate(), 'DNI', 38789348, 1),
  ('Garrus', 'Pass2', 'Vakarian', GetDate(), 'DNI', 44344242, 2),
  ('Urdnot', 'Pass3', 'Wrex', GetDate(), 'DNI', 23344444, 3),
  ('Mordin', 'Pass4', 'Solus', GetDate(), 'DNI', 34379899, 1);

CREATE TABLE [rescatista] (
	id int primary Key identity(1,1),
	nombre varchar(255),
	apellido varchar(255),
	tipoDocumento varchar(255),
	numeroDocumento int,
	direccion varchar(255),
	contacto varchar(255),
)

INSERT INTO rescatista (nombre, apellido, tipoDocumento, numeroDocumento, direccion, contacto) VALUES
  ('Rescatador', 'De Ropes', 'DNI', 33523334, 'Elcano 3445', '11-5455-2345'),
  ('Rescatador', 'De Togas', 'DNI', 23249876, 'Av. San Martin 235', 'Rescatador@hotmail.com'),
  ('Encontré', 'Una tortuga', 'DNI', 3455234, 'Av. Corrientes 577', '4988-3244'),
  ('Encontré', 'Un puma', 'DNI', 30665190, 'Florida 201', 'Rescatador@gmail.com');
 
CREATE TABLE [publicacion] (
	id int primary Key identity(1,1),
	foto varchar(255),
	lugarEncuentro varchar(255),
	--FK
	ongId int,
	CONSTRAINT FK_ONG_FROM_PUBLICACION FOREIGN KEY (ongId) REFERENCES ONG(id),
	rescatistaId int,
	CONSTRAINT FK_RESCATISTA FOREIGN KEY (rescatistaId) REFERENCES rescatista(id)
)

INSERT INTO publicacion (foto, lugarEncuentro, ongId, rescatistaId) VALUES
  ('Foto Perro', 'Encontrado en Villa Crespo', 1, 1),
  ('Foto Gato', 'Encontrado en Plaza Miserere', 2, 2)
  
CREATE TABLE [mascota] (
	id int primary Key identity(1,1),
	nombre varchar(255),
	apodo varchar(255),
	fechaDeNacimiento DateTime2,
	sexo varchar(255),
	especie varchar(255),
	foto varchar(255),
	qr varchar(255)
)

CREATE TABLE [caracteristica] (
	id int primary Key identity(1,1),
	valor varchar(255),
	categoria varchar(255)
)

CREATE TABLE [caracteristicaxmascota] (
	id int primary Key identity(1,1),
	--FK
	caracteristicaId int,
	CONSTRAINT FK_CARACTERISTICA FOREIGN KEY (caracteristicaId) REFERENCES caracteristica(id),
	mascotaId int,
	CONSTRAINT FK_MASCOTA FOREIGN KEY (mascotaId) REFERENCES mascota(id)
)

 select * from ong;
 select * from usuario;
 select * from rescatista;
 select * from publicacion;