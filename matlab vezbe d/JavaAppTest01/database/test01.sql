/*
SQLyog Community v12.4.3 (32 bit)
MySQL - 8.2.0 : Database - stud_sluzba
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stud_sluzba` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `stud_sluzba`;

/*Table structure for table `nastavnik` */

DROP TABLE IF EXISTS `nastavnik`;

CREATE TABLE `nastavnik` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) CHARACTER SET utf8mb4   ,
  `prezime` varchar(100) CHARACTER SET utf8mb4   ,
  `zvanje` bigint unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `zvanje` (`zvanje`),
  CONSTRAINT `nastavnik_ibfk_1` FOREIGN KEY (`zvanje`) REFERENCES `zvanje` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `nastavnik` */

insert  into `nastavnik`(`id`,`ime`,`prezime`,`zvanje`) values 
(1,'Pera','Peric',1),
(2,'Ana','Anic',2),
(3,'Jana','Janic',5),
(4,'Zika','Zikic',4);

/*Table structure for table `predmet` */

DROP TABLE IF EXISTS `predmet`;

CREATE TABLE `predmet` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) CHARACTER SET utf8mb4   ,
  `esbp` json NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `predmet` */

/*Table structure for table `zvanje` */

DROP TABLE IF EXISTS `zvanje`;

CREATE TABLE `zvanje` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) CHARACTER SET utf8mb4   ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `zvanje` */

insert  into `zvanje`(`id`,`naziv`) values 
(1,'redovni profesor'),
(2,'vanredni profesor'),
(3,'docent'),
(4,'asistent'),
(5,'saradnik u nastavi');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
