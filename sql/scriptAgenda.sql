CREATE DATABASE Agenda;
USE agenda;
CREATE TABLE Personas
(
  IdPersona int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(45) NOT NULL,
  Telefono varchar(20) NOT NULL,
  Calle varchar(50),
  Altura int,
  Piso int,
  Departamento varchar(10),
  CodigoPostal int(5),
  Email varchar(100),
  FechaNacimiento date,
  IdTipoContacto int,
  PRIMARY KEY (IdPersona)
);


CREATE TABLE Localidades 
(
  CodigoPostal int(5) NOT NULL,
  Nombre varchar(45) NOT NULL,
  PRIMARY KEY (CodigoPostal)
);


CREATE TABLE TipoContacto
(
  IdTipoContacto int NOT NULL AUTO_INCREMENT,
  Tipo varchar(45) NOT NULL,
  PRIMARY KEY (IdTipoContacto)
);
