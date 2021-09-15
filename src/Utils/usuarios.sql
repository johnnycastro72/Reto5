DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios(
usu_alias VARCHAR(10) NOT NULL PRIMARY KEY,
usu_nombre VARCHAR(45) NOT NULL, 
usu_apellido VARCHAR(45) NOT NULL, 
usu_email VARCHAR(45), 
usu_celular VARCHAR(45),
usu_password VARCHAR(45), 
usu_nacimiento DATE
);
INSERT INTO usuarios (usu_alias, usu_nombre, usu_apellido) values ('lucky', 'Pedro', 'Perez');
INSERT INTO usuarios (usu_alias, usu_nombre, usu_apellido) values ('malopez', 'Maria', 'Lopez');
INSERT INTO usuarios (usu_alias, usu_nombre, usu_apellido) values ('diva', 'Ana', 'Diaz');
INSERT INTO usuarios (usu_alias, usu_nombre, usu_apellido) values ('dreamer', 'Luis', 'Rojas');
INSERT INTO usuarios (usu_alias, usu_nombre, usu_apellido) values ('ninja', 'Andres', 'Cruz');
INSERT INTO usuarios (usu_alias, usu_nombre, usu_apellido) values ('neon', 'Nelson', 'Ruiz');
INSERT INTO usuarios (usu_alias, usu_nombre, usu_apellido) values ('rose', 'Claudia', 'Mendez');
INSERT INTO usuarios (usu_alias, usu_nombre, usu_apellido) values ('green', 'Jorge', 'Rodriguez');