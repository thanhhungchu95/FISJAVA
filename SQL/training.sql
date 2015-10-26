/* Create Database `training` */

CREATE DATABASE  IF NOT EXISTS `training`;
USE `training`;

/* Create Table `user` */
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `idUser` int(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
);

/* Insert values for `user` */
INSERT INTO `user` VALUES 
(1,'cuongnm'),(2,'quanhq'),
(3,'hungct'),(4,'trangnt'),
(5,'khuyennt'),(6,'hiendt'),
(7,'chinhvm'),(8,'thiennhx'),
(9,'phuocbv'),(10,'tinhpt'),
(11,'phuvh'),(12,'anhtt');

/* Create Table `lover` */
DROP TABLE IF EXISTS `lover`;
CREATE TABLE `lover` (
  `idLover` int(10) NOT NULL,
  `male` int(10) DEFAULT NULL,
  `female` int(10) DEFAULT NULL,
  PRIMARY KEY (`idLover`)
);

/* Insert values for `lover` */
INSERT INTO `lover` VALUES 
(1,1,6),
(2,7,5),
(3,9,4);

/* Find who are lover */
SELECT male.name AS male, female.name AS female
FROM user AS male, user AS female, lover AS love 
WHERE male.idUser = love.male AND female.idUser = love.female;
