-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: cybershield_ai
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `amenaza`
--

DROP TABLE IF EXISTS `amenaza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amenaza` (
  `idAmenaza` int NOT NULL AUTO_INCREMENT,
  `Descripcion` text NOT NULL,
  `NivelRiesgo` enum('Bajo','Medio','Alto','Crítico') NOT NULL,
  `Analisis_idAnalisis` int NOT NULL,
  PRIMARY KEY (`idAmenaza`),
  KEY `fk_Amenaza_Analisis1_idx` (`Analisis_idAnalisis`),
  CONSTRAINT `fk_Amenaza_Analisis1` FOREIGN KEY (`Analisis_idAnalisis`) REFERENCES `analisis` (`idAnalisis`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenaza`
--

LOCK TABLES `amenaza` WRITE;
/*!40000 ALTER TABLE `amenaza` DISABLE KEYS */;
INSERT INTO `amenaza` VALUES (2,'Phishing en correos electrónicos','Alto',1),(4,'Malware en el sistema','Alto',3);
/*!40000 ALTER TABLE `amenaza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analisis`
--

DROP TABLE IF EXISTS `analisis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analisis` (
  `idAnalisis` int NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Resultado` text NOT NULL,
  `Usuario_idUsuario` int NOT NULL,
  `Sistema_idSistema` int NOT NULL,
  PRIMARY KEY (`idAnalisis`),
  KEY `fk_Analisis_Usuario_idx` (`Usuario_idUsuario`),
  KEY `fk_Analisis_Sistema1_idx` (`Sistema_idSistema`),
  CONSTRAINT `fk_Analisis_Sistema1` FOREIGN KEY (`Sistema_idSistema`) REFERENCES `sistema` (`idSistema`),
  CONSTRAINT `fk_Analisis_Usuario` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis`
--

LOCK TABLES `analisis` WRITE;
/*!40000 ALTER TABLE `analisis` DISABLE KEYS */;
INSERT INTO `analisis` VALUES (1,'2022-01-26','Se detectó un intento de intrusión',6,1),(3,'2023-08-14','Vulnerabilidad identificada en el servidor',6,3);
/*!40000 ALTER TABLE `analisis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recomendacion`
--

DROP TABLE IF EXISTS `recomendacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recomendacion` (
  `idRecomendacion` int NOT NULL AUTO_INCREMENT,
  `Descripcion` text NOT NULL,
  `NivelUrgencia` enum('Bajo','Medio','Alto','Crítico') NOT NULL,
  `Amenaza_idAmenaza` int NOT NULL,
  PRIMARY KEY (`idRecomendacion`),
  KEY `fk_Recomendacion_Amenaza1_idx` (`Amenaza_idAmenaza`),
  CONSTRAINT `fk_Recomendacion_Amenaza1` FOREIGN KEY (`Amenaza_idAmenaza`) REFERENCES `amenaza` (`idAmenaza`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recomendacion`
--

LOCK TABLES `recomendacion` WRITE;
/*!40000 ALTER TABLE `recomendacion` DISABLE KEYS */;
INSERT INTO `recomendacion` VALUES (1,'Configurar firewall','Alto',4),(2,'Implementar autenticación de dos factores','Alto',2);
/*!40000 ALTER TABLE `recomendacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sistema`
--

DROP TABLE IF EXISTS `sistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sistema` (
  `idSistema` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Descripcion` text,
  PRIMARY KEY (`idSistema`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sistema`
--

LOCK TABLES `sistema` WRITE;
/*!40000 ALTER TABLE `sistema` DISABLE KEYS */;
INSERT INTO `sistema` VALUES (1,'ShieldGuard','Sistema de monitoreo de intrusiones'),(3,'CyberProtect','Herramienta de analisis de vulnerabilidades');
/*!40000 ALTER TABLE `sistema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Correo_Electronico` varchar(45) NOT NULL,
  `Contraseña` varchar(45) NOT NULL,
  `Rol` enum('Administrador','Usuario') NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `Correo_Electronico_UNIQUE` (`Correo_Electronico`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (5,'Pedro','pedro1254@gmail.com','123456','Administrador'),(6,'Jessica','jessica1254@gmail.com','123446','Usuario'),(8,'Andrea','Andrea1254@gmail.com','123446','Usuario'),(10,'Th1','thing1254@gmail.com','123446','Usuario'),(11,'Th2','thing21254@gmail.com','123446','Usuario');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-14 22:31:48
