-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: zamowienia
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `cennik`
--

DROP TABLE IF EXISTS `cennik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cennik` (
  `idCennik` int NOT NULL AUTO_INCREMENT,
  `pizza` varchar(45) CHARACTER SET utf16 COLLATE utf16_polish_ci DEFAULT NULL,
  `dodatkiPizza` varchar(45) CHARACTER SET utf16 COLLATE utf16_polish_ci DEFAULT NULL,
  `danie` varchar(45) CHARACTER SET utf16 COLLATE utf16_polish_ci DEFAULT NULL,
  `dodatkiDanie` varchar(45) CHARACTER SET utf16 COLLATE utf16_polish_ci DEFAULT NULL,
  `zupy` varchar(45) CHARACTER SET utf16 COLLATE utf16_polish_ci DEFAULT NULL,
  `napoje` varchar(45) CHARACTER SET utf16 COLLATE utf16_polish_ci DEFAULT NULL,
  `uwagi` varchar(45) CHARACTER SET utf16 COLLATE utf16_polish_ci DEFAULT NULL,
  `koszt` varchar(45) COLLATE utf16_polish_ci NOT NULL,
  PRIMARY KEY (`idCennik`),
  UNIQUE KEY `idhistoria_UNIQUE` (`idCennik`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cennik`
--

LOCK TABLES `cennik` WRITE;
/*!40000 ALTER TABLE `cennik` DISABLE KEYS */;
/*!40000 ALTER TABLE `cennik` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-05 12:19:01
