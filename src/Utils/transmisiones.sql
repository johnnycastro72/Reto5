DROP TABLE IF EXISTS transmisiones;
CREATE TABLE transmisiones(
tra_usu_alias VARCHAR(10) NOT NULL REFERENCES usuarios(usu_alias), 
tra_con_id INT NOT NULL REFERENCES contenidos(con_id),
tra_fechahora DATETIME NOT NULL
);
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("lucky", 1, '2017-10-25 20:00:00');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("lucky", 4, '2019-03-15 18:30:00');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("lucky", 9, '2019-05-20 20:30:00');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("malopez", 1, '2018-05-20 20:30:00');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("malopez", 9, '2020-01-20 20:30:00');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("diva", 2, '2019-05-20 20:30:00');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("diva", 3, '2018-06-22 21:30:00');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("diva", 6, '2020-03-17 15:30:20');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("dreamer", 6, '2020-03-17 15:30:20');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("dreamer", 7, '2020-04-10 18:30:20');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("ninja", 8, '2020-02-17 20:30:20');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("ninja", 9, '2020-02-20 16:30:20');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("ninja", 11, '2020-03-27 18:30:20');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("rose", 10, '2020-03-20 21:30:20');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("green", 2, '2020-01-10 17:30:20');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("green", 4, '2020-02-15 20:30:20');
INSERT INTO transmisiones (tra_usu_alias, tra_con_id, tra_fechahora) values ("green", 5, '2020-03-17 18:30:20');