INSERT INTO provincia (nombre) VALUES
('Buenos Aires'),
('Capital Federal'),
('Catamarca'),
('Chaco'),
('Chubut'),
('C�rdoba'),
('Corrientes'),
('Entre R�os'),
('Formosa'),
('Jujuy'),
('La Pampa'),
('La Rioja'),
('Mendoza'),
('Misiones'),
('Neuqu�n'),
('R�o Negro'),
('Salta'),
('San Juan'),
('San Luis'),
('Santa Cruz'),
('Santa Fe'),
('Santiago del Estero'),
('Tierra del Fuego'),
('Tucum�n');


INSERT INTO caracteristica (descripcion) VALUES
('Raza'),
('Color Principal'),
('Color Secundario'),
('Tama�o'),
('Rabo'),
('Patr�n distintivo'),

('Esterilizado'),
('Enfermedades');


INSERT INTO [opcionesCaracteristicas] (valor, caracteristicaId) VALUES
--Raza Perro
('Beagle', 1),
('B�xer', 1),
('Bulldog', 1),
('Caniche', 1),
('Chihuahua', 1),
('Golden', 1),
('D�lmata', 1),
('Husky siberiano', 1),
('Obejero Alem�n', 1),
('Yorkshire terrier', 1),

--Raza Gato
('Angora turco', 1),
('Azul ruso', 1),
('Bengal�', 1),
('Maine Coon', 1),
('Maine Coon', 1),
('Siam�s', 1),
('Siberiano', 1),

--Color Principal
('Negro', 2),
('Blanco', 2),
('Gris', 2),
('Naranja', 2),
('Marr�n', 2),
('Rosado', 2),
('Caf� con leche', 2),

--Color Secundario
('Negro', 3),
('Blanco', 3),
('Gris', 3),
('Naranja', 3),
('Marr�n', 3),
('Rosado', 3),
('Caf� con leche', 3),

--Tama�o
('Grande', 4),
('Mediano', 4),
('Chico', 4),

--Rabo
('Si', 5),
('No', 5),

--Esterilizado
('Si', 7),
('No', 7),
(null, 7);

INSERT INTO [organizacion] (nombre) VALUES
('ONG 1'),
('ONG 2'),
('ONG 3');


INSERT INTO [preguntasAdopcion] (pregunta, organizacion_id) VALUES
('�cuanto pesa la mascota?',1),
('�Porque decisdiste darla en adopcion?',1),
('�cuanto pesa la mascota?',2),
('�Era un animal callejero antes de que lo tuvieras?',2),
('�C�mo ha sido su temperamento ulimamente?',3),
('�Porque decisdiste darla en adopcion?',3);



/*COSAS DE LOGIN Y SESION NO TOCAR POR AHORA*/

 INSERT INTO Authority (authority) VALUES ('ADMIN'), ('USER'), ('VOLUNTARIO');

 INSERT INTO sesion (enabled,password,username) VALUES 
(1,'$2a$04$N/AOZpRELtGEPeDwJoI8wuT9O1qbZbnnoLc1tnTQWEhFkmpFJ6WTG', 'administrador'),
(1,'$2a$04$N/AOZpRELtGEPeDwJoI8wuT9O1qbZbnnoLc1tnTQWEhFkmpFJ6WTG', 'usuario');

INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,1), (2,2);

