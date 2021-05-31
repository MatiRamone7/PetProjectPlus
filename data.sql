DROP TABLE IF EXISTS ong;
DROP TABLE IF EXISTS usuario;

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
	CONSTRAINT FK_ONG FOREIGN KEY (OngId) REFERENCES ONG(id)
)

INSERT INTO usuario (nombre, password, apellido, fechaDeNacimiento, tipoDocumento, numeroDocumento, ongId) VALUES
  ('Commander', 'Pass1', 'Shepard', GetDate(), 'DNI', 38789348, 1),
  ('Garrus', 'Pass2', 'Vakarian', GetDate(), 'DNI', 44344242, 2),
  ('Urdnot', 'Pass3', 'Wrex', GetDate(), 'DNI', 23344444, 3),
  ('Mordin', 'Pass4', 'Solus', GetDate(), 'DNI', 34379899, 1);
  
 select * from ong;
 select * from usuario;