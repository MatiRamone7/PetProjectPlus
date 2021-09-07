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

CREATE TABLE [contacto] (
	id int primary Key identity(1,1),
	mail varchar(255),
	telefono varchar(255),
	medio varchar(255),
)

CREATE TABLE [foto] (
	id int primary Key identity(1,1),
	imagenByteArray BLOB(65535),
	descripcion TEXT
)

/* MASCOTA Y CARACTERISTICAS*/

CREATE TABLE [caracteristica] (
	id int primary Key identity(1,1),
	descripcion varchar(255)
)

CREATE TABLE [caracteristicaPet](
	id int primary Key identity(1,1),
	valor varchar(255),
	caracteristicaId int,
	CONSTRAINT FK_CARACTERISTICA FOREIGN KEY (caracteristicaId) REFERENCES caracteristica(id)
)

CREATE TABLE [mascota] (
	id int primary Key identity(1,1),
	nombre varchar(255),
	apodo varchar(255),
	fechaDeNacimiento DateTime2,
	sexo varchar(20),
	especie varchar(5),
	/*foto, cómo guardo una lista?*/
	qr varchar(255),
	descripcionFisica TEXT,
    duenioId int,
    CONSTRAINT FK_DUENIO FOREIGN KEY (duenioId) REFERENCES usuario(id)
	/*caracteristicas set*/
)

/*FORMULARIOS*/

CREATE TABLE [formularioIntencionDeAdoptar] (
	id int primary Key identity(1,1),
	sexo varchar(20),
	especie varchar(5),
	solicitanteId int,
	CONSTRAINT FK_SOLICITANTE FOREIGN KEY (solicitanteId) REFERENCES usuario(id)
	/*preferencias/caracteristicas */
	/*estado*/
)

CREATE TABLE [formularioDarEnAdopcion] (
	id int primary Key identity(1,1),
	duenioId int,
	CONSTRAINT FK_DUENIO FOREIGN KEY (duenioId) REFERENCES usuario(id)
	mascotaId int,
	CONSTRAINT FK_MASCOTA FOREIGN KEY (mascotaId) REFERENCES mascota(id),
	organizacionId int,
	CONSTRAINT FK_ORGANIZACION FOREIGN KEY (organizacionId) REFERENCES organizacion(id),
	/*estadoId,*/
	/*preguntaRespuestaAdoptanteId*/
)

CREATE TABLE [formularioMascotaPerdida] (
	id int primary Key identity(1,1),
	nombre varchar(255),
	apellido varchar(255),
	fechaDeNacimiento DateTime2,
	tipoDocumento varchar(5),
	nroDocumento int,
	direccionId int, 
	CONSTRAINT FK_DIRECCION FOREIGN KEY (direccionId) REFERENCES direccion(id),
	contactoId int,
	CONSTRAINT FK_CONTACTO FOREIGN KEY (contactoId) REFERENCES contacto(id),
	ongId int,
	CONSTRAINT FK_ORGANIZACION FOREIGN KEY (ongId) REFERENCES organizacion(id),
	mascota int,
	CONSTRAINT FK_MASCOTA FOREIGN KEY (mascotaId) REFERENCES mascota(id),
	/*estado*/
	tamanio varchar(12),
	sexo varchar(20),
	especie varchar(5),
	descripcion TEXT,
	/*fotos*/
	/*lugarEncuentroMascota*/
)

CREATE TABLE [formularioMascotaEncontrada] (
	id int primary Key identity(1,1),
	fechaHora TIMESTAMP,
	formularioMascotaPerdidaId int,
	CONSTRAINT FK_FORMULARIOMASCOTAPERDIDA FOREIGN KEY (formularioMascotaPerdidaId) REFERENCES formularioMascotaPerdida(id),
	usuarioId int,
	CONSTRAINT FK_USUARIO FOREIGN KEY (usuarioId) REFERENCES usuario(id)
)

CREATE TABLE [estadoFormulario] (
	id int primary Key identity(1,1),
	fechaHora TIMESTAMP,
	usuario varchar(255),
	estadoId int,
	CONSTRAINT FK_ESTADO FOREIGN KEY (estadoId) REFERENCES estado(id)
)

CREATE TABLE [estadoFormulario] (
	id int primary Key identity(1,1),
	nombre varchar(50),
)

/* ORGANIZACION */

CREATE TABLE [organizacion] (
	id int primary Key identity(1,1),
	nombre varchar(50),
	/*voluntarios*/
	direccionId int, 
	CONSTRAINT FK_DIRECCION FOREIGN KEY (direccionId) REFERENCES direccion(id),
	especificacionesFotoId int, 
	CONSTRAINT FK_ESPECIFICACIONESFOTO FOREIGN KEY (especificacionesFotoId) REFERENCES charsFoto(id),
	/*preguntasIntencioDeAdopcion*/
)

CREATE TABLE [charsFoto] (
	id int primary Key identity(1,1),
	nivelCalidad int,
	sizeFoto int
)

CREATE TABLE [preguntaAdoptante] (
	id int primary Key identity(1,1),
	pregunta varchar(255),
	tipoPregunta varchar(255),
	organizacionId int,
	CONSTRAINT FK_ORGANIZACION FOREIGN KEY (organizacionId) REFERENCES organizacion(id),
)

CREATE TABLE [preguntaRespuestaAdoptante] (
	id int primary Key identity(1,1),
	respuesta varchar(255),
	preguntaId int,
	CONSTRAINT FK_PREGUNTA FOREIGN KEY (preguntaId) REFERENCES preguntaAdoptante(id),
	formularioId int,
	CONSTRAINT FK_FORMULARIO FOREIGN KEY (formularioId) REFERENCES formularioDarEnAdopcion(id),
)

/* USUARIO, ADMIN, ROLES */