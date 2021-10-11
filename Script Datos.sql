INSERT INTO provincia (nombre) VALUES
('Buenos Aires'),
('Capital Federal'),
('Catamarca'),
('Chaco'),
('Chubut'),
('Córdoba'),
('Corrientes'),
('Entre Ríos'),
('Formosa'),
('Jujuy'),
('La Pampa'),
('La Rioja'),
('Mendoza'),
('Misiones'),
('Neuquén'),
('Río Negro'),
('Salta'),
('San Juan'),
('San Luis'),
('Santa Cruz'),
('Santa Fe'),
('Santiago del Estero'),
('Tierra del Fuego'),
('Tucumán');

INSERT INTO caracteristica (descripcion) VALUES
('Raza'),
('Color Principal'),
('Color Secundario'),
('Tamaño'),
('Rabo'),
('Patrón distintivo'),

('Esterilizado'),
('Enfermedades');

INSERT INTO [opcionesCaracteristicas] (valor, caracteristicaId) VALUES
--Raza Perro
('Beagle', 1),
('Bóxer', 1),
('Bulldog', 1),
('Caniche', 1),
('Chihuahua', 1),
('Golden', 1),
('Dálmata', 1),
('Husky siberiano', 1),
('Obejero Alemán', 1),
('Yorkshire terrier', 1),

--Raza Gato
('Angora turco', 1),
('Azul ruso', 1),
('Bengalí', 1),
('Maine Coon', 1),
('Maine Coon', 1),
('Siamés', 1),
('Siberiano', 1),

--Color Principal
('Negro', 2),
('Blanco', 2),
('Gris', 2),
('Naranja', 2),
('Marrón', 2),
('Rosado', 2),
('Café con leche', 2),

--Color Secundario
('Negro', 3),
('Blanco', 3),
('Gris', 3),
('Naranja', 3),
('Marrón', 3),
('Rosado', 3),
('Café con leche', 3),

--Tamaño
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

INSERT INTO Authority (authority) VALUES ('ADMIN'), ('USER'), ('VOLUNTARIO');
