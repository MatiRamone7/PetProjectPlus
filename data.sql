DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT PRIMARY KEY IDENTITY(1,1),
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  race VARCHAR(255) DEFAULT NULL
);

INSERT INTO users (first_name, last_name, race) VALUES
  ('Commander', 'Shepard', 'Human'),
  ('Garrus', 'Vakarian', 'Turian'),
  ('Urdnot', 'Wrex', 'Krogan');
  
 select * from users