CREATE DATABASE  IF NOT EXISTS `tigair` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tigair`;
-- MySQL dump 10.13  Distrib 5.5.49, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: tigair
-- ------------------------------------------------------
-- Server version	5.5.49-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aircraft`
--

DROP TABLE IF EXISTS `aircraft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aircraft` (
  `id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `make` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `model` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `manufactured_date` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `serial_no` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type_certificate` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_cycles` int(11) DEFAULT NULL,
  `engine_model` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_serial_no` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_manufactured_year` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_type_certificate` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_total_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_time_since_overhaul` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `propeller_model` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `propeller_serial_no` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `propeller_manufactured_year` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `propeller_type_certificate` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `propeller_total_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `propeller_time_since_overhaul` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `show_deprecated` bit(1) DEFAULT b'0',
  `show_description` bit(1) DEFAULT b'0',
  `show_maintenance_reference` bit(1) DEFAULT b'0',
  `show_maintenance_instruction` bit(1) DEFAULT b'0',
  `show_source` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aircraft`
--

LOCK TABLES `aircraft` WRITE;
/*!40000 ALTER TABLE `aircraft` DISABLE KEYS */;
INSERT INTO `aircraft` VALUES (1,'SP-DTQ','Cessna 182P','182P','1972-01-01','18261034','N/A','2926:18',NULL,'Continental O-470-R','211720-72R','N/A','N/A','875:30','875:30','McCauley C2A34C201-C/90AD-S','697889','N/A','N/A','404:18','404:18','\0','','','\0','\0'),(2,'PH-USA','Cessna 172P','172P','1981-03-12','172-74718','TBD','3305:19',0,'Lycoming O-320-D2J','RL-18723-39A','1997','TBD','1305:54','1305:54','McCauley 1C160DTM','83367','2010','TBD','331:41','331:41','\0','\0','','','');
/*!40000 ALTER TABLE `aircraft` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-31 12:13:02
