--
-- Table structure for table `cryptocoins`
--

DROP TABLE IF EXISTS `cryptocoins`;

CREATE TABLE `cryptocoins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `ticker_symbol` varchar(15) NOT null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;