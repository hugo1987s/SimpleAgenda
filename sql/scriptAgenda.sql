DROP DATABASE IF EXISTS `agenda`;
CREATE DATABASE `agenda`;
USE `agenda`;

DROP TABLE IF EXISTS `localidades`;
DROP TABLE IF EXISTS `tipoContacto`;
DROP TABLE IF EXISTS `personas`;

CREATE TABLE `localidades` 
(
  `CodigoPostal` int(5) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`CodigoPostal`)
);

CREATE TABLE `tipoContacto`
(
  `IdTipoContacto` int NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`IdTipoContacto`)
);

CREATE TABLE `personas` 
(
  IdPersona int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(45) NOT NULL,
  Apellido varchar(45) NOT NULL,
  Telefono varchar(20) NOT NULL,
  Calle varchar(50),
  Altura int,
  Piso int,
  Departamento varchar(10),
  CodigoPostal int(5),
  Email varchar(100),
  FechaNacimiento date,
  IdTipoContacto int,
  PRIMARY KEY (IdPersona),
  FOREIGN KEY (`CodigoPostal`) REFERENCES `localidades`(`CodigoPostal`),
  FOREIGN KEY (`IdTipoContacto`) REFERENCES `tipoContacto`(`IdTipoContacto`)
);