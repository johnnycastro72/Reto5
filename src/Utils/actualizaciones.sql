SET SQL_SAFE_UPDATES=0;
UPDATE pelicula SET pel_anio="2012" WHERE pel_con_id=1;
UPDATE usuarios SET usu_celular="3115678432" WHERE usu_alias="ninja";
DELETE FROM transmisiones WHERE tra_usu_alias="green" AND tra_con_id=4;
SET SQL_SAFE_UPDATES=1;
