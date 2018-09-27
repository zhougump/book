/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.10-log : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '书名',
  `author` varchar(50) NOT NULL COMMENT '作者',
  `publish` varchar(50) NOT NULL COMMENT '出版日期',
  `publishdate` date NOT NULL COMMENT '出版日期',
  `page` int(10) NOT NULL COMMENT '页数',
  `price` int(30) NOT NULL COMMENT '价格',
  PRIMARY KEY (`id`,`name`,`author`,`publish`,`publishdate`,`page`,`price`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`author`,`publish`,`publishdate`,`page`,`price`) values (1,'白夜行','东野圭吾','东京出版社','2017-10-28',700,66),(2,'你的孤独最败犹荣','刘同','湖南出版社','2014-06-21',411,34),(3,'沉睡的深林','东野圭吾','日本仙台出版社','2019-07-30',320,55),(4,'太平天国战争','僧格林沁','北平出版社','2017-11-30',800,32),(5,'忘川茶舍','简小严','华东出版社','2017-10-27',289,25),(6,'红手指','东野圭吾','群马出版社','2018-09-29',299,28);

/*Table structure for table `picture` */

DROP TABLE IF EXISTS `picture`;

CREATE TABLE `picture` (
  `id` int(18) NOT NULL AUTO_INCREMENT,
  `pic` varchar(3000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `picture` */

insert  into `picture`(`id`,`pic`) values (1,'/image/Fate (17).jpg'),(2,'/image/战列舰.jpg'),(3,'/image/Ashe_Splash_9.jpg'),(4,'/image/Thresh_Splash_2.jpg'),(5,'/image/Fiora_Splash_4.jpg'),(6,'/image/Hecarim_Splash_3.jpg'),(7,'/image/Akali_Splash_5.jpg');

/*Table structure for table `school` */

DROP TABLE IF EXISTS `school`;

CREATE TABLE `school` (
  `name` varchar(40) NOT NULL,
  `subject` varchar(40) NOT NULL,
  `grade` int(20) NOT NULL,
  PRIMARY KEY (`name`,`subject`,`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `school` */

insert  into `school`(`name`,`subject`,`grade`) values ('石','历史',100),('石','数学',71),('石','语文',99),('陈','历史',76),('陈','数学',88),('陈','语文',73),('韩','历史',92),('韩','数学',21),('韩','语文',88);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`) values (1,'abc','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
