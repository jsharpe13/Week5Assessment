-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: cis175.ckz4xz9v37ul.us-east-2.rds.amazonaws.com    Database: reading
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(35) NOT NULL,
  `AUTHOR` varchar(35) NOT NULL,
  `YEAR` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (5,'it','king',1986),(6,'a christmas carol','dickens',1843),(13,'The Hobbit','Tolkien',1937),(14,'The two towers','Tolkien',1954),(15,'chamber of secrets','rowling',1998),(16,'chamber of secrets','rowling',1998),(17,'The two towers','Tolkien',1954),(18,'it','king',1986);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_on_list`
--

DROP TABLE IF EXISTS `books_on_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books_on_list` (
  `BOOK_ID` int(11) NOT NULL,
  `LIST_ID` int(11) NOT NULL,
  KEY `LIST_ID` (`LIST_ID`),
  KEY `BOOK_ID` (`BOOK_ID`),
  CONSTRAINT `books_on_list_ibfk_1` FOREIGN KEY (`LIST_ID`) REFERENCES `check_out_list` (`LIST_ID`),
  CONSTRAINT `books_on_list_ibfk_2` FOREIGN KEY (`BOOK_ID`) REFERENCES `book` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_on_list`
--

LOCK TABLES `books_on_list` WRITE;
/*!40000 ALTER TABLE `books_on_list` DISABLE KEYS */;
INSERT INTO `books_on_list` VALUES (13,2),(14,2),(15,4),(16,5),(17,5),(13,4);
/*!40000 ALTER TABLE `books_on_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `check_out_list`
--

DROP TABLE IF EXISTS `check_out_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `check_out_list` (
  `LIST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LIST_NAME` varchar(30) DEFAULT NULL,
  `CARD_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LIST_ID`),
  KEY `CARD_ID` (`CARD_ID`),
  CONSTRAINT `check_out_list_ibfk_1` FOREIGN KEY (`CARD_ID`) REFERENCES `person` (`CARD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `check_out_list`
--

LOCK TABLES `check_out_list` WRITE;
/*!40000 ALTER TABLE `check_out_list` DISABLE KEYS */;
INSERT INTO `check_out_list` VALUES (2,'Mara\'s List',5),(4,'Leia\'s List',7),(5,'Jon List',10);
/*!40000 ALTER TABLE `check_out_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `CARD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`CARD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Luke'),(2,'Luke'),(3,'Ben'),(4,'Sam'),(5,'Mara'),(6,''),(7,'Leia'),(8,'John'),(9,'Else'),(10,'Jon');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-27 12:32:06
