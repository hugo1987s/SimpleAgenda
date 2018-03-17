CREATE DATABASE `agenda`;
USE agenda;

DROP TABLE IF EXISTS `localidades`;
DROP TABLE IF EXISTS `personas`;

CREATE TABLE `localidades` 
(
  `codigoPostal` int(5) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoPostal`)
);
CREATE TABLE `personas` 
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `localidad` int(5),
  PRIMARY KEY (`idPersona`),
  FOREIGN KEY (`localidad`) REFERENCES `localidades`(`codigoPostal`)
);
