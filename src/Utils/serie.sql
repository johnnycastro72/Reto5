DROP TABLE IF EXISTS serie;
CREATE TABLE serie(
ser_id INT NOT NULL PRIMARY KEY,
ser_con_id INT NOT NULL REFERENCES contenidos(con_id), 
ser_temporadas INT NOT NULL, 
ser_episodios INT NOT NULL
);
INSERT INTO serie (ser_id, ser_con_id, ser_temporadas, ser_episodios) values (1, 6, 153, 11);
INSERT INTO serie (ser_id, ser_con_id, ser_temporadas, ser_episodios) values (2, 7, 80, 3);
INSERT INTO serie (ser_id, ser_con_id, ser_temporadas, ser_episodios) values (3, 8, 30, 3);
INSERT INTO serie (ser_id, ser_con_id, ser_temporadas, ser_episodios) values (4, 9, 31, 4);
INSERT INTO serie (ser_id, ser_con_id, ser_temporadas, ser_episodios) values (5, 10, 236, 10);
INSERT INTO serie (ser_id, ser_con_id, ser_temporadas, ser_episodios) values (6, 11, 170, 8);
INSERT INTO serie (ser_id, ser_con_id, ser_temporadas, ser_episodios) values (7, 12, 279, 12);
INSERT INTO serie (ser_id, ser_con_id, ser_temporadas, ser_episodios) values (8, 13, 79, 6);
