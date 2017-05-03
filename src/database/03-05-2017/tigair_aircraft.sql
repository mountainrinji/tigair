-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: 192.168.1.33    Database: tigair
-- ------------------------------------------------------
-- Server version	5.7.17

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
  `summary_date` varchar(35) COLLATE utf8_unicode_ci DEFAULT NULL,
  `summary_recipients` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aircraft`
--

LOCK TABLES `aircraft` WRITE;
/*!40000 ALTER TABLE `aircraft` DISABLE KEYS */;
INSERT INTO `aircraft` VALUES (1,'SP-DTQ','Cessna 182P','182P','1972','18261034','N/A','2974:00',NULL,'Continental O-470-R','211720-72R','N/A','N/A','923:12','923:12','McCauley C2A34C201-C/90AD-S','697889','N/A','N/A','452:00','452:00','\0','','','\0','\0',NULL,NULL),(2,'PH-USA','Cessna 172P','172P','1981-03-12','172-74718','TBD','3353:44',0,'Lycoming O-320-D2J','RL-18723-39A','1997','TBD','1354:19','1354:19','McCauley 1C160DTM','83367','2010','TBD','380:06','380:06','\0','\0','','','','16','leszczyfon@gmail.com'),(3,'SP-FYZ','Cessna','175C','1964','17557099','3A17 Rev. 46','2992:56',NULL,'Continental GO-300-E','12634-1-C','1964','E-298','804:17','804:17','McCauley 2A31C21-DE/84S','697157','1973','P-919','566:16','566:16','\0','\0','\0','\0','\0',NULL,NULL),(4,'SP-FRA','Socata','Raylle 150 TD','1976','2661','XXXX','3351:43',NULL,'Lycoming O-320-D2E','L-41500-27A','1976','XXXX','3446:38','30:16','Sensenich 74DM6-0-58','A54698','1991','XXXX','1189:58','1189:58','\0','\0','','\0','',NULL,NULL);
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

-- Dump completed on 2017-05-03 20:46:29
