-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: 4chanvideos
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contenidos`
--

DROP TABLE IF EXISTS `contenidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contenidos` (
  `con_id` int NOT NULL,
  `titulo` varchar(45) NOT NULL,
  PRIMARY KEY (`con_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenidos`
--

LOCK TABLES `contenidos` WRITE;
/*!40000 ALTER TABLE `contenidos` DISABLE KEYS */;
INSERT INTO `contenidos` VALUES (1,'Los Vengadores'),(2,'Interestelar'),(3,'El viaje de Chihiro'),(4,'Parasitos'),(5,'Mas alla de los sueños'),(6,'The walking dead'),(7,'Viaje a las estrellas: la serie original'),(8,'Glow'),(9,'La casa de papel'),(10,'Friends'),(11,'Arrow'),(12,'The big bang theory'),(13,'Vikingos');
/*!40000 ALTER TABLE `contenidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director` (
  `dir_id` int NOT NULL,
  `dir_nombre` varchar(45) NOT NULL,
  `dir_apellido` varchar(45) NOT NULL,
  `dir_nacionalidad` varchar(45) NOT NULL,
  PRIMARY KEY (`dir_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` VALUES (1,'Hayo','Miyazaki','japones'),(2,'Joss','Whedon','estadounidense'),(3,'Christopher','Nolan','estadounidense'),(4,'Bong','Joon-ho','coreano'),(5,'Vincent','Ward','neozelandes');
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `pel_id` int NOT NULL,
  `pel_con_id` int NOT NULL,
  `pel_resumen` text NOT NULL,
  `pel_anio` varchar(4) NOT NULL,
  `pel_dir_id` int NOT NULL,
  PRIMARY KEY (`pel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,1,'Pelicula de superheroes basada en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, \nSteve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, \nhermano de Thor, se apodere de la tierra.','2012',2),(2,2,'Pelicula de ciencia ficción, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia \nde un grupo de astronautas que viajan a traves de un agujero de gusano en busca de un nuevo hogar.','2014',3),(3,3,'Pelicula de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un \nmundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.','2001',1),(4,4,'Pelicula de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu \nhumano.','2019',4),(5,5,'Pelicula de drama, narra una historia trágica de una familia, donde el padre va en busca de sus esposa al mas \nallá para recuperarla.','1998',5);
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie`
--

DROP TABLE IF EXISTS `serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serie` (
  `ser_id` int NOT NULL,
  `ser_con_id` int NOT NULL,
  `ser_temporadas` int NOT NULL,
  `ser_episodios` int NOT NULL,
  PRIMARY KEY (`ser_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie`
--

LOCK TABLES `serie` WRITE;
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
INSERT INTO `serie` VALUES (1,6,153,11),(2,7,80,3),(3,8,30,3),(4,9,31,4),(5,10,236,10),(6,11,170,8),(7,12,279,12),(8,13,79,6);
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmisiones`
--

DROP TABLE IF EXISTS `transmisiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transmisiones` (
  `tra_usu_alias` varchar(10) NOT NULL,
  `tra_con_id` int NOT NULL,
  `tra_fechahora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmisiones`
--

LOCK TABLES `transmisiones` WRITE;
/*!40000 ALTER TABLE `transmisiones` DISABLE KEYS */;
INSERT INTO `transmisiones` VALUES ('lucky',1,'2017-10-25 20:00:00'),('lucky',4,'2019-03-15 18:30:00'),('lucky',9,'2019-05-20 20:30:00'),('malopez',1,'2018-05-20 20:30:00'),('malopez',9,'2020-01-20 20:30:00'),('diva',2,'2019-05-20 20:30:00'),('diva',3,'2018-06-22 21:30:00'),('diva',6,'2020-03-17 15:30:20'),('dreamer',6,'2020-03-17 15:30:20'),('dreamer',7,'2020-04-10 18:30:20'),('ninja',8,'2020-02-17 20:30:20'),('ninja',9,'2020-02-20 16:30:20'),('ninja',11,'2020-03-27 18:30:20'),('rose',10,'2020-03-20 21:30:20'),('green',2,'2020-01-10 17:30:20'),('green',5,'2020-03-17 18:30:20');
/*!40000 ALTER TABLE `transmisiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usu_alias` varchar(10) NOT NULL,
  `usu_nombre` varchar(45) NOT NULL,
  `usu_apellido` varchar(45) NOT NULL,
  `usu_email` varchar(45) DEFAULT NULL,
  `usu_celular` varchar(45) DEFAULT NULL,
  `usu_password` varchar(45) DEFAULT NULL,
  `usu_nacimiento` date DEFAULT NULL,
  PRIMARY KEY (`usu_alias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('diva','Ana','Diaz',NULL,NULL,NULL,NULL),('dreamer','Luis','Rojas',NULL,NULL,NULL,NULL),('green','Jorge','Rodriguez',NULL,NULL,NULL,NULL),('lucky','Pedro','Perez',NULL,NULL,NULL,NULL),('malopez','Maria','Lopez',NULL,NULL,NULL,NULL),('neon','Nelson','Ruiz',NULL,NULL,NULL,NULL),('ninja','Andres','Cruz',NULL,'3115678432',NULL,NULL),('rose','Claudia','Mendez',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-07 19:31:01
