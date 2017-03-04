-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: tigair
-- ------------------------------------------------------
-- Server version	5.7.13-0ubuntu0.16.04.2

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
-- Table structure for table `flight_history`
--

DROP TABLE IF EXISTS `flight_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aircraft_id` int(11) DEFAULT NULL,
  `flight_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_history`
--

LOCK TABLES `flight_history` WRITE;
/*!40000 ALTER TABLE `flight_history` DISABLE KEYS */;
INSERT INTO `flight_history` VALUES (82,1,'1:36','2016-06-18 00:00:00'),(83,1,'0:24','2016-06-18 00:00:00'),(84,1,'2:06','2016-06-18 00:00:00'),(85,1,'3:24','2016-06-24 00:00:00'),(86,1,'01:00','2016-06-24 00:00:00'),(87,1,'1:42','2016-06-25 00:00:00'),(88,1,'1:30','2016-06-26 00:00:00'),(89,2,'0:57','2016-07-16 00:00:00'),(90,2,'00:45','2016-07-17 00:00:00'),(91,1,'01:00','2016-06-30 00:00:00'),(92,1,'01:06','2016-07-19 00:00:00'),(93,1,'00:54','2016-07-21 00:00:00'),(94,1,'03:00','2016-08-01 00:00:00'),(95,1,'01:12','2016-08-05 00:00:00'),(96,1,'01:12','2016-08-07 00:00:00'),(97,1,'03:30','2016-08-10 00:00:00'),(98,2,'11:18','2016-08-11 00:00:00'),(99,1,'04:24','2016-08-11 00:00:00'),(100,1,'2:48','2016-08-13 00:00:00'),(101,1,'03:00','2016-08-16 00:00:00'),(102,2,'03:51','2016-08-20 00:00:00'),(103,1,'01:30','2016-09-03 00:00:00'),(104,1,'01:36','2016-09-04 00:00:00'),(105,2,'05:41','2016-09-08 00:00:00'),(106,1,'02:06','2016-09-09 00:00:00'),(107,1,'02:00','2016-09-10 00:00:00'),(108,1,'03:24','2016-09-28 00:00:00'),(109,1,'01:00','2016-09-24 00:00:00'),(110,1,'00:30','2016-09-29 00:00:00'),(111,1,'03:12','2016-10-01 00:00:00'),(112,2,'14:03','2016-10-02 00:00:00'),(113,3,'10:40','2017-02-27 00:00:00'),(114,1,'00:42','2017-02-25 00:00:00'),(115,3,'00:28','2017-03-01 00:00:00'),(116,1,'00:48','2017-02-27 00:00:00'),(117,3,'00:40','2017-03-03 00:00:00');
/*!40000 ALTER TABLE `flight_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-04 14:16:40
