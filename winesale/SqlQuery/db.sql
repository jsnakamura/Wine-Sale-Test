CREATE DATABASE IF NOT EXISTS winesale_db;

CREATE TABLE `clients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1

CREATE TABLE `sales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `client` varchar(100) DEFAULT NULL,
  `total_value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=latin1

CREATE TABLE `wines` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product` varchar(100) DEFAULT NULL,
  `variety` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `harvest` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sale_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sale_wine_fk_idx` (`sale_id`),
  CONSTRAINT `sale_wine_fk` FOREIGN KEY (`sale_id`) REFERENCES `sales` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=577 DEFAULT CHARSET=latin1