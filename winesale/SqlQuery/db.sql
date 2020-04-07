CREATE DATABASE IF NOT EXISTS winesale_db;

CREATE TABLE IF NOT EXISTS `clients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `sales` (
  `code` int NOT NULL,
  `date` DATE DEFAULT NULL,
  `client` varchar(100) DEFAULT NULL,
  `wine_id` int DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `wines` (
  `product` varchar(100) NOT NULL,
  `variety` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `harvest` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sale_id` int DEFAULT NULL,
  PRIMARY KEY (`product`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;