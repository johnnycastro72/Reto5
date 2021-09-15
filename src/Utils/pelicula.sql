DROP TABLE IF EXISTS pelicula;
CREATE TABLE pelicula(
pel_id INT NOT NULL PRIMARY KEY,
pel_con_id INT NOT NULL REFERENCES contenidos(con_id), 
pel_resumen TEXT NOT NULL, 
pel_anio VARCHAR(4) NOT NULL,
pel_dir_id INT NOT NULL REFERENCES director(dir_id)
);
INSERT INTO pelicula (pel_id, pel_con_id, pel_resumen, pel_anio, pel_dir_id) values (1, 1, 
'Pelicula de superheroes basada en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, Steve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, hermano de Thor, se apodere de la tierra', '1990', 2);
INSERT INTO pelicula (pel_id, pel_con_id, pel_resumen, pel_anio, pel_dir_id) values (2, 2, 
'Pelicula de ciencia fición, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia de un grupo de astronautas que viajana traves de un agujero de gusano en busca de un nuevo hogar. ', '2014', 3);
INSERT INTO pelicula (pel_id, pel_con_id, pel_resumen, pel_anio, pel_dir_id) values (3, 3, 
'Pelicula de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un mundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.', '2001', 1);
INSERT INTO pelicula (pel_id, pel_con_id, pel_resumen, pel_anio, pel_dir_id) values (4, 4, 
'Pelicula de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu humano', '2019', 4);
INSERT INTO pelicula (pel_id, pel_con_id, pel_resumen, pel_anio, pel_dir_id) values (5, 5, 
'Pelicula de drama, narra una historia trágica de una familia, donde el padre va en busca de sus esposa al mas allá para recuperarla.', '1998', 5);
