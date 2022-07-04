CREATE DATABASE  IF NOT EXISTS `timesheet_dev` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `timesheet_dev`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: timesheet_dev
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `id_area` int NOT NULL AUTO_INCREMENT,
  `nombre_area` varchar(45) NOT NULL,
  `codigo_area` varchar(45) NOT NULL,
  `flg_activo` tinyint(1) DEFAULT '1',
  `user_reg` varchar(100) NOT NULL,
  `date_reg` datetime NOT NULL,
  `user_upd` varchar(100) DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  PRIMARY KEY (`id_area`),
  UNIQUE KEY `id_area_UNIQUE` (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'ADMINISTRACION','AMD',1,'cristian','2022-06-29 18:39:22',NULL,NULL),(2,'SISTEMAS','SIS',1,'cristian','2022-06-29 18:45:51',NULL,NULL),(3,'CONTABILIDAD','CONT',1,'cristian','2022-06-29 18:45:51',NULL,NULL),(4,'MARKETING','MARK',1,'cristian','2022-06-29 18:46:44',NULL,NULL);
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asistencia` (
  `id_asistencia` int NOT NULL AUTO_INCREMENT,
  `id_empleado` int NOT NULL,
  `id_tipo_trabajo` int NOT NULL,
  `id_sede` int NOT NULL,
  `id_dispositivo` int NOT NULL,
  `hora_entrada` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_salida` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `coord_long` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `coord_lat` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_dia_festivo` tinyint(1) DEFAULT '0',
  `flg_activo` tinyint(1) DEFAULT '1',
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  PRIMARY KEY (`id_asistencia`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencia`
--

LOCK TABLES `asistencia` WRITE;
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
INSERT INTO `asistencia` VALUES (1,1,1,1,1,'08:00:00','18:00:00',NULL,NULL,0,1,'cristian ','2022-06-28 19:44:12',NULL,NULL),(2,2,1,1,2,'08:00:00','18:01:00',NULL,NULL,0,1,'cristian ','2022-06-28 19:44:25',NULL,NULL),(3,3,1,1,1,'08:00:00','18:07:00',NULL,NULL,0,1,'cristian ','2022-06-28 19:44:38',NULL,NULL),(4,5,1,2,1,'08:04:00','18:50:00',NULL,NULL,0,1,'cristian ','2022-06-28 19:45:06',NULL,NULL),(7,7,2,3,2,'08:02:00','18:15:00',NULL,NULL,0,1,'cristian ','2022-06-28 19:46:01',NULL,NULL),(8,8,1,3,2,'08:13:00','18:12:00',NULL,NULL,0,1,'cristian ','2022-06-28 19:46:24',NULL,NULL),(9,9,1,3,1,'08:01:00','18:00:00',NULL,NULL,0,1,'cristian ','2022-06-28 19:46:43',NULL,NULL),(10,10,1,1,1,'08:00:00','18:30:00',NULL,NULL,0,1,'cristian ','2022-06-28 19:46:53',NULL,NULL);
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargos` (
  `id_cargo` int NOT NULL AUTO_INCREMENT,
  `nombre_cargo` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `codigo_cargo` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `flg_activo` tinyint(1) DEFAULT '1',
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  PRIMARY KEY (`id_cargo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'programador 2','001',1,'admin','2021-12-23 22:24:00','fasto','2022-05-11 01:24:34'),(2,'Diseñador','002',1,'admin','2021-12-23 22:39:18','fasto','2022-05-11 01:24:37'),(3,'Repartidor1','002',1,'admin','2021-12-23 23:23:04','fasto','2022-05-11 01:24:32'),(4,'Contadora','003',1,'admin','2021-12-23 23:39:38','fasto','2022-05-11 01:24:29'),(5,'Asistente','004',1,'admin','2021-12-23 23:39:43','fasto','2022-05-11 01:24:27'),(6,'Administrador','005',1,'admin','2021-12-23 23:39:49','fasto','2022-05-11 01:24:20'),(7,'Abogado','006',1,'admin','2021-12-23 23:39:55','fasto','2022-05-11 01:24:13'),(8,'asdafdasf','007',1,'admin','2021-12-23 23:40:01','fasto','2022-05-11 01:24:11'),(9,'sdafsfsf','008',1,'admin','2021-12-23 23:40:10','fasto','2022-05-11 01:24:09'),(10,'asdsadasfd','009',1,'admin','2021-12-23 23:40:16','fasto','2022-05-11 01:24:17'),(11,'asfadsfsdf','010',1,'admin','2021-12-23 23:40:22','fasto','2022-05-11 01:24:15'),(12,'asfsdfsdf','011',1,'admin','2021-12-23 23:40:28','fasto','2022-05-11 01:24:24'),(13,'Secretaria','002',1,'admin','2021-12-26 22:33:41','fasto','2022-05-11 01:24:22'),(14,'Gerente','003',1,'admin','2021-12-26 22:34:28','fasto','2022-05-11 01:24:39'),(15,'Diseñadora','003',1,'admin','2022-01-11 21:55:14','admin','2022-01-11 21:55:14'),(16,'sfasfafsdfsdf','0011',1,'admin','2022-01-11 22:02:17','fasto','2022-05-11 01:24:41'),(17,'sdfsfsf','05544',1,'admin','2022-02-05 22:44:28','fasto','2022-05-11 01:24:44'),(18,'Prueba nuevo1','C-005',1,'fasto','2022-05-11 01:00:55','fasto','2022-05-11 01:01:03');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dias_festivos`
--

DROP TABLE IF EXISTS `dias_festivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dias_festivos` (
  `id_dia_festivo` int NOT NULL AUTO_INCREMENT,
  `nombre_dia_festivo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `fecha_dia_festivo` date DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT '1',
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  PRIMARY KEY (`id_dia_festivo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dias_festivos`
--

LOCK TABLES `dias_festivos` WRITE;
/*!40000 ALTER TABLE `dias_festivos` DISABLE KEYS */;
INSERT INTO `dias_festivos` VALUES (1,'Prueba de dia festivo','2022-01-11',0,'admin','2022-01-11 22:30:42','admin','2022-01-11 22:52:31'),(2,'santa rosa1','2022-08-30',1,'admin','2022-01-11 22:52:19','admin','2022-01-11 22:52:24'),(3,'San Pedro y San Pablo','2022-06-28',1,'admin','2022-01-11 22:52:19',NULL,NULL);
/*!40000 ALTER TABLE `dias_festivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispositivos`
--

DROP TABLE IF EXISTS `dispositivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dispositivos` (
  `id_dispositivo` int NOT NULL AUTO_INCREMENT,
  `nombre_dispotivo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_dispositivo` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `serie` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigo` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `modelo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `marca` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT '1',
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  PRIMARY KEY (`id_dispositivo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispositivos`
--

LOCK TABLES `dispositivos` WRITE;
/*!40000 ALTER TABLE `dispositivos` DISABLE KEYS */;
INSERT INTO `dispositivos` VALUES (1,'BEACON',NULL,NULL,NULL,NULL,NULL,1,'cristian','2022-05-12 22:09:27',NULL,NULL),(2,'SMARTPHONE',NULL,NULL,NULL,NULL,NULL,1,'cristian','2022-05-12 22:09:27',NULL,NULL),(3,'TABLET',NULL,NULL,NULL,NULL,NULL,1,'cristian','2022-05-12 22:09:27',NULL,NULL);
/*!40000 ALTER TABLE `dispositivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `id_persona` int NOT NULL,
  `id_area` int NOT NULL,
  `id_cargo` int NOT NULL,
  `id_horario` int NOT NULL,
  `codigo_empleado` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `correo` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `direccion` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `foto` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT '1',
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  PRIMARY KEY (`id_empleado`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,2,2,1,1,NULL,'931687890','franklin.asto.leon@gmail.com','dirección prueba',NULL,1,'fasto','2022-05-14 17:11:33','fasto','2022-05-14 17:11:33'),(2,3,2,1,1,NULL,'934550880','crii@gmail.com','Chincha',NULL,1,'fasto','2022-06-24 18:19:07','fasto','2022-06-24 18:19:07'),(3,4,1,6,1,NULL,'934550880','Julio@gmail.com',NULL,NULL,1,'cristian','2022-06-24 18:19:07',NULL,NULL),(5,5,1,6,1,NULL,'934550880','Josei@gmail.com',NULL,NULL,1,'cristian','2022-06-24 18:19:07',NULL,NULL),(6,6,4,2,1,NULL,'934550880','Emili@gmail.com',NULL,NULL,1,'cristian','2022-06-24 18:19:07',NULL,NULL),(7,7,3,4,2,NULL,'934550880','yanet@gmail.com',NULL,NULL,1,'cristian','2022-06-24 18:19:07',NULL,NULL),(8,8,3,4,2,NULL,'934550880','claudia@gmail.com',NULL,NULL,1,'cristian','2022-06-24 18:19:07',NULL,NULL),(9,10,1,5,1,NULL,'9098498515','eraul@gmail.com','direccion',NULL,1,'fasto','2022-06-29 22:21:06','fasto','2022-06-29 22:21:06');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horarios` (
  `id_horario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hora_inicio` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hora_fin` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT '1',
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  PRIMARY KEY (`id_horario`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,'Operador','08:00','18:00',1,'fasto','2022-05-12 22:09:27','fasto','2022-05-12 22:34:33'),(2,'Personal administrativo','08:00','18:00',1,'fasto','2022-05-12 22:10:58','fasto','2022-05-12 22:34:12');
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `id_persona` int NOT NULL AUTO_INCREMENT,
  `tipo_documento` int DEFAULT NULL,
  `numero_documento` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombres` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `apellido_paterno` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `apellido_materno` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `sexo` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_completo` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT '1',
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  PRIMARY KEY (`id_persona`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (2,1,'72669187','Franklin Ruiz','Asto','Leon','1994-07-13','1','Franklin Ruiz Asto Leon',1,'fasto','2022-05-14 17:11:33','fasto','2022-05-14 17:11:33'),(3,1,'75555647','Cristian','Mart','Faj','1994-05-17','1','Cristian Mart Faj',1,'fasto','2022-06-24 18:19:07','fasto','2022-06-24 18:19:07'),(4,1,'70510255','Julio','Gomez','Godin','1994-02-01','1','Julio Gomez Godin',1,'cristian','2022-06-28 19:52:12',NULL,NULL),(5,1,'70510255','Jose','Ramirez','Alcantara','1994-02-01','1','Jose Ramirez Alcantara',1,'cristian','2022-06-28 19:52:13',NULL,NULL),(6,1,'71110058','Emili','Cordova','Diaz','2001-01-20','2','Emili Cordova Diaz',1,'cristian','2022-06-28 19:52:13',NULL,NULL),(7,1,'70202020','Yanet','Flores','Dulan','2000-02-01','2','Yanet Flores Dulan',1,'cristian','2022-06-28 19:52:13',NULL,NULL),(8,1,'70000277','Claudia','Nuñez','Garcia','2002-10-12','2','Claudia Nuñez Garcia',1,'cristian','2022-06-28 19:52:13',NULL,NULL),(10,1,'20805681','Raul','Equivel','Sanez','1997-12-18','1','Raul Equivel Sanez',1,'fasto','2022-06-29 22:21:05','fasto','2022-06-29 22:21:05');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_rol`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN',1);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sedes`
--

DROP TABLE IF EXISTS `sedes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sedes` (
  `id_sede` int NOT NULL AUTO_INCREMENT,
  `nombre_sede` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `direccion` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `beacon` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `coord_long` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `coord_lat` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT '1',
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  PRIMARY KEY (`id_sede`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sedes`
--

LOCK TABLES `sedes` WRITE;
/*!40000 ALTER TABLE `sedes` DISABLE KEYS */;
INSERT INTO `sedes` VALUES (1,'SEDE PRINCIAL','','',NULL,NULL,NULL,1,'cristian','2022-06-28 19:52:13',NULL,NULL),(2,'SEDE NORTE',NULL,NULL,NULL,NULL,NULL,1,'cristian','2022-06-28 19:52:13',NULL,NULL),(3,'SEDE SUR',NULL,NULL,NULL,NULL,NULL,1,'cristian','2022-06-28 19:52:13',NULL,NULL);
/*!40000 ALTER TABLE `sedes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_trabajo`
--

DROP TABLE IF EXISTS `tipo_trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_trabajo` (
  `id_tipo_trabajo` int NOT NULL AUTO_INCREMENT,
  `nombre_tipo_trabajo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `abreviatura` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT '1',
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_upd` datetime DEFAULT NULL,
  PRIMARY KEY (`id_tipo_trabajo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_trabajo`
--

LOCK TABLES `tipo_trabajo` WRITE;
/*!40000 ALTER TABLE `tipo_trabajo` DISABLE KEYS */;
INSERT INTO `tipo_trabajo` VALUES (1,'Remoto','RM',1,'admin','2021-12-26 23:10:36','admin','2021-12-26 23:10:36'),(2,'Presencial','PR',1,'admin','2021-12-26 23:11:52','admin','2021-12-26 23:11:52'),(3,'Mixto','MXT',1,'admin','2022-01-11 21:54:14','admin','2022-01-11 21:54:14');
/*!40000 ALTER TABLE `tipo_trabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubicacion`
--

DROP TABLE IF EXISTS `ubicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ubicacion` (
  `id_ubicacion` int NOT NULL AUTO_INCREMENT,
  `nombre_ubicacion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `direccion` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `coord_long` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `coord_lat` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `flg_activo` tinyint(1) DEFAULT '1',
  `creado_por` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL,
  PRIMARY KEY (`id_ubicacion`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubicacion`
--

LOCK TABLES `ubicacion` WRITE;
/*!40000 ALTER TABLE `ubicacion` DISABLE KEYS */;
INSERT INTO `ubicacion` VALUES (1,'AREQUIPA',NULL,NULL,NULL,NULL,1,'cristian','2022-06-28 19:52:13',NULL,NULL),(2,'LIMA',NULL,NULL,NULL,NULL,1,'cristian','2022-06-28 19:52:13',NULL,NULL),(3,'ICA',NULL,NULL,NULL,NULL,1,'cristian','2022-06-28 19:52:13',NULL,NULL),(4,'AYACUCHO',NULL,NULL,NULL,NULL,1,'cristian','2022-06-28 19:52:13',NULL,NULL);
/*!40000 ALTER TABLE `ubicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_roles`
--

DROP TABLE IF EXISTS `usuario_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_roles` (
  `id_usuario_rol` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `id_rol` int NOT NULL,
  `estado` tinyint NOT NULL,
  PRIMARY KEY (`id_usuario_rol`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_roles`
--

LOCK TABLES `usuario_roles` WRITE;
/*!40000 ALTER TABLE `usuario_roles` DISABLE KEYS */;
INSERT INTO `usuario_roles` VALUES (1,1,1,1);
/*!40000 ALTER TABLE `usuario_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `correo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado` tinyint(1) NOT NULL,
  `creado_por` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `creado_fec` datetime NOT NULL,
  `modificado_por` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `modificado_fec` datetime DEFAULT NULL,
  PRIMARY KEY (`id_usuario`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','$2a$10$qGyDfZLBB.SgLv7GCP3uZe3oM38fVtr58T1iZ1LNOvO61loNUAAaK','rr.hh','Franklin Ruiz Asto Leon','franklin.asto.leon@gmail.com',1,'1','2021-10-17 18:14:02',NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'timesheet_dev'
--
/*!50003 DROP PROCEDURE IF EXISTS `IndDataPersonas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `IndDataPersonas`()
BEGIN
	SELECT  
		COUNT( CASE WHEN a.sexo in ( 1,2 ) AND a.flg_activo = 1 THEN 0 END) as Total, 
		COUNT( CASE WHEN a.sexo = 1 AND a.flg_activo = 1 THEN 0 END) as Hombres, 
		COUNT( CASE WHEN a.sexo = 2 AND a.flg_activo = 1 THEN 0 END) as Mujeres
	FROM timesheet_dev.personas a 
	WHERE a.flg_activo = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `IndHorasPorSede` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `IndHorasPorSede`()
BEGIN
		SELECT  
		s.nombre_sede as sede, 
		DATE_FORMAT( CAST(SUM(TIMEDIFF( a.hora_salida, a.hora_entrada)) AS TIME), 	'%T') as htrabajadas,
		DATE_FORMAT( CAST(SUM(TIMEDIFF( a.hora_salida, h.hora_fin)) AS TIME) ,	'%T')  as hextra,
		DATE_FORMAT( CAST(SUM(TIMEDIFF( a.hora_entrada,  h.hora_inicio)) AS TIME) ,	'%T' )  as htardanza
	FROM timesheet_dev.asistencia a
	INNER JOIN timesheet_dev.empleados e on  e.id_empleado =  a.id_empleado and e.flg_activo = 1
	INNER JOIN timesheet_dev.sedes s on  s.id_sede =  a.id_sede and s.flg_activo = 1
	INNER JOIN timesheet_dev.horarios h on  h.id_horario =  e.id_horario and h.flg_activo = 1
	WHERE a.flg_activo = 1 
	GROUP BY a.id_sede;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `IndPersonaPorArea` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `IndPersonaPorArea`()
BEGIN
	 SELECT  
	a.nombre_area as area,
    count(e.id_empleado) as cantidad
FROM timesheet_dev.empleados e
INNER JOIN  timesheet_dev.areas a on  e.id_area =  a.id_area
WHERE e.flg_activo = 1 GROUP BY a.id_area;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `RepGeneral` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `RepGeneral`(IdSede Int,  IdTurno Int)
BEGIN
    SELECT 
		p.nombre_completo as personal,
        a.nombre_area as area ,
        c.nombre_cargo as cargo,
		s.nombre_sede as sede,
		asis.hora_entrada as hentrada, 
        asis.hora_salida as hsalida, 
        h.nombre as turno,
		DATE_FORMAT(CAST(TIMEDIFF( asis.hora_salida, asis.hora_entrada) AS TIME), '%T') AS horatrabajada,
		DATE_FORMAT( CAST(TIMEDIFF( asis.hora_salida, h.hora_fin) AS TIME) ,	'%T')  as horaextra,
		DATE_FORMAT( CAST(TIMEDIFF( asis.hora_entrada,  h.hora_inicio) AS TIME) ,	'%T' )  as horatardanza,
        e.correo,
        e.telefono,
        (CASE WHEN e.direccion is null THEN ' - ' ELSE e.direccion END) as direccion,
		(CASE WHEN p.sexo = 1 THEN 'MASC.' ELSE 'FEM.' END) as genero,
        CAST(p.fecha_nacimiento AS char) as fecnacimiento,
        (CASE
			WHEN p.tipo_documento = 1 THEN 'DNI'
			WHEN p.tipo_documento = 2 THEN 'CE'
            WHEN p.tipo_documento = 2 THEN 'C4'
           ELSE ''
        END) AS 'tipodocumento'
        /*Agregar tipo de trabajo*/
	FROM  timesheet_dev.empleados e
		INNER JOIN timesheet_dev.personas p on p.id_persona = e.id_persona and p.flg_activo = 1
		INNER JOIN timesheet_dev.asistencia asis on e.id_empleado = asis.id_empleado  and asis.flg_activo = 1
		INNER JOIN timesheet_dev.areas a on  a.id_area =  e.id_area and a.flg_activo = 1
		INNER JOIN timesheet_dev.sedes s on  s.id_sede =  asis.id_sede and s.flg_activo = 1
		INNER JOIN timesheet_dev.horarios h on h.id_horario = e.id_horario 
		INNER JOIN timesheet_dev.cargos c on c.id_cargo = e.id_cargo and c.flg_activo= 1 
	WHERE e.flg_activo = 1  AND   h.flg_activo = 1
    AND s.id_sede = ( case when IdSede  = 0 then s.id_sede else IdSede end)
	AND e.id_horario = ( case when IdTurno  = 0 then e.id_horario else IdTurno end);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `RepHorasDeTrabajo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `RepHorasDeTrabajo`(IdSede Int, TipoHora char(50))
BEGIN
    SELECT   
        p.nombre_completo as personal,
		s.nombre_sede as sede,  
       (CASE  
		WHEN TipoHora = "HTRAB" THEN DATE_FORMAT(CAST(TIMEDIFF( asis.hora_salida, asis.hora_entrada) AS TIME), '%T')
		WHEN TipoHora = "HEXT" THEN DATE_FORMAT(CAST(TIMEDIFF( asis.hora_salida, h.hora_fin) AS TIME) ,	'%T') 
		WHEN TipoHora = "HTARD" THEN DATE_FORMAT(CAST(TIMEDIFF( asis.hora_entrada,  h.hora_inicio) AS TIME), '%T' )   
        ELSE ' - '
        END) AS 'horas'
            
	FROM  timesheet_dev.empleados e
	INNER JOIN timesheet_dev.personas p on p.id_persona = e.id_persona and p.flg_activo = 1
    INNER JOIN timesheet_dev.asistencia asis on e.id_empleado = asis.id_empleado  and asis.flg_activo = 1
    INNER JOIN timesheet_dev.sedes s on  s.id_sede =  asis.id_sede and s.flg_activo = 1
	INNER JOIN timesheet_dev.horarios h on  h.id_horario =  e.id_horario and h.flg_activo = 1
	WHERE e.flg_activo = 1 
    AND s.id_sede = ( case when IdSede  = 0 then s.id_sede else IdSede end);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `RepTurno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `RepTurno`(IdTurno Int)
BEGIN
    SELECT   
       p.nombre_completo as personal,
       h.nombre as turno,
       h.hora_inicio as hinicio,
       h.hora_fin as hfin
	FROM  timesheet_dev.empleados e
    INNER JOIN timesheet_dev.personas p on p.id_persona = e.id_persona
	INNER JOIN timesheet_dev.horarios h on h.id_horario = e.id_horario
	WHERE e.flg_activo = 1 
	AND e.id_horario = ( case when IdTurno  = 0 then e.id_horario else IdTurno end);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-04 10:17:15
