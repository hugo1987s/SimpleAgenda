USE `agenda`;

SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE table `localidades`; 
TRUNCATE table `tipoContacto`; 
TRUNCATE table `personas`; 
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `localidades` VALUES
	(1613,'Los Polvorines'),
	(1617,'General Pacheco'),
	(1621,'Benavídez'),
	(1648,'Tigre'),
	(1663,'San Miguel'),
	(1665,'Jose C. Paz'),
	(1900,'La Plata'),
	(7165,'Villa Gesell');

INSERT INTO `tipoContacto` VALUES
	(1,'UNGS'),
	(2,'Simpons');

INSERT INTO `personas` VALUES
	(1,'Carlos','Almiron','(11)1234-1234','Tucumán',1823,0,'',1621,'carlos@almiron.com','1987-05-03',1),
	(2,'Julio','Rojas','(11)1234-1111','Fatone',444,0,'',1663,'julio@rojas.com','1994-02-01',1),
	(3,'Lautaro','Tomas','(11)1234-2222','Pringles',768,0,'',1663,'lautaro@tomas.com','1994-02-01',1),
	(4,'Hugo','Schreiber','(11)1234-4321','Calle 1',98,0,'',1665,'hugo@schreiber.com','1987-02-01',1),
	(5,'Maximiliano','Lucero Correa','(11)1234-4321','Calle 2',880,0,'',1663,'maxi@lucero.com','1994-02-01',1),
	(6,'Belén','Devito','(11)2222-1234','Calle 3',108,0,'',1663,'belen@devito.com','1993-02-01',1),
	(7,'Vanesa','Mayorga','(11)2222-3333','Calle 4',5900,3,'A',1663,'vanesa@mayorga.com','1993-02-01',1),
	(8,'Marjorie','Bouvier','(11)4321-5555','Calle 5',452,0,'',1900,'marjorie@simpsons.com','1980-11-11',2),
	(9,'Apu','Nahasapeemapetilon','(22)3222-5555','Calle 6',450,3,'D',1900,'apu@simpsons.com','1980-10-11',2);
