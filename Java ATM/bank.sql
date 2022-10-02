-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: bank1
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `accno` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `accounttype` varchar(20) DEFAULT NULL,
  `balance` float DEFAULT NULL,
  `pin` varchar(6) DEFAULT NULL,
  `ph_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`accno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (100000000,'Suraj','Savings',45000,'100000','9876543210'),(111111111,'Manthan','Savings',9900,'111111','9876543211'),(123456789,'Bharati','Savings',10000,'123456','9029759071'),(222222222,'Muthuraj','Current',101000,'222222','9876543212'),(333333333,'Kaushik','Current',44500,'333333','9876543213'),(444444444,'Rutuja','Savings',40000,'444444','9876543214'),(555555555,'Zaid','Savings',491936,'555555','9876543215'),(666666666,'Jyoti','Current',45000,'666666','9876543216'),(777777777,'Chirag','Savings',44500,'777777','9876543217'),(888888888,'Rahila','Current',49960.5,'888888','9876543218'),(999999999,'Pankaj','Savings',44500,'999999','9876543219');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions` (
  `accno` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `balance` float DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `counter` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`counter`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (111111111,'Deposit',10000,55000,'2022-10-02',1),(111111111,'Withdrawl',81,55081,'2022-10-02',2),(111111111,'Withdrawl',100,10100,'2022-10-02',3),(111111111,'Withdrawl',100,10000,'2022-10-02',4),(111111111,'Withdrawl',100,9900,'2022-10-02',5),(222222222,'Deposit',56000,101000,'2022-10-03',6),(333333333,'Withdrawl',500,44500,'2022-10-03',7),(444444444,'Withdrawl',5000,40000,'2022-10-03',8),(555555555,'Deposit',5000,50000,'2022-10-03',9),(999999999,'Deposit',500,44500,'2022-10-03',10),(888888888,'Deposit',4960.48,49960.5,'2022-10-03',11),(777777777,'Withdrawl',500,44500,'2022-10-03',12),(555555555,'Deposit',441936,491936,'2022-10-03',13);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-03  1:13:34
