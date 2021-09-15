DROP TABLE IF EXISTS director;
CREATE TABLE director(
dir_id INT NOT NULL PRIMARY KEY,
dir_nombre VARCHAR(45) NOT NULL, 
dir_apellido VARCHAR(45) NOT NULL, 
dir_nacionalidad VARCHAR(45) NOT NULL
);
INSERT INTO director (dir_id, dir_nombre, dir_apellido, dir_nacionalidad) values (1, 'Hayo', 'Miyazaki', 'japones');
INSERT INTO director (dir_id, dir_nombre, dir_apellido, dir_nacionalidad) values (2, 'Joss', 'Whedon', 'estadounidense');
INSERT INTO director (dir_id, dir_nombre, dir_apellido, dir_nacionalidad) values (3, 'Christopher', 'Nolan', 'estadounidense');
INSERT INTO director (dir_id, dir_nombre, dir_apellido, dir_nacionalidad) values (4, 'Bong', 'Joon-ho', 'coreano');
INSERT INTO director (dir_id, dir_nombre, dir_apellido, dir_nacionalidad) values (5, 'Vincent', 'Ward', 'neozelandes');