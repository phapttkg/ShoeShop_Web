-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for shoeshop
DROP DATABASE IF EXISTS `shoeshop`;
CREATE DATABASE IF NOT EXISTS `shoeshop` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `shoeshop`;

-- Dumping structure for table shoeshop.tbl_bill
DROP TABLE IF EXISTS `tbl_bill`;
CREATE TABLE IF NOT EXISTS `tbl_bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_product` int(11) DEFAULT NULL,
  `price_unit` double DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table shoeshop.tbl_bill: ~1 rows (approximately)
DELETE FROM `tbl_bill`;
/*!40000 ALTER TABLE `tbl_bill` DISABLE KEYS */;
INSERT INTO `tbl_bill` (`id`, `cus_name`, `id_product`, `price_unit`, `amount`, `total_price`) VALUES
	(2, 'hau', 20, 545.3, 100, 54529.99999999999);
/*!40000 ALTER TABLE `tbl_bill` ENABLE KEYS */;

-- Dumping structure for table shoeshop.tbl_brand
DROP TABLE IF EXISTS `tbl_brand`;
CREATE TABLE IF NOT EXISTS `tbl_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table shoeshop.tbl_brand: ~2 rows (approximately)
DELETE FROM `tbl_brand`;
/*!40000 ALTER TABLE `tbl_brand` DISABLE KEYS */;
INSERT INTO `tbl_brand` (`id`, `name`) VALUES
	(1, 'Adidat'),
	(2, 'Minh Phuc'),
	(3, 'TN');
/*!40000 ALTER TABLE `tbl_brand` ENABLE KEYS */;

-- Dumping structure for table shoeshop.tbl_category
DROP TABLE IF EXISTS `tbl_category`;
CREATE TABLE IF NOT EXISTS `tbl_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table shoeshop.tbl_category: ~2 rows (approximately)
DELETE FROM `tbl_category`;
/*!40000 ALTER TABLE `tbl_category` DISABLE KEYS */;
INSERT INTO `tbl_category` (`id`, `name`) VALUES
	(1, 'giay'),
	(2, 'dep');
/*!40000 ALTER TABLE `tbl_category` ENABLE KEYS */;

-- Dumping structure for table shoeshop.tbl_color
DROP TABLE IF EXISTS `tbl_color`;
CREATE TABLE IF NOT EXISTS `tbl_color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table shoeshop.tbl_color: ~2 rows (approximately)
DELETE FROM `tbl_color`;
/*!40000 ALTER TABLE `tbl_color` DISABLE KEYS */;
INSERT INTO `tbl_color` (`id`, `name`) VALUES
	(1, 'red'),
	(2, 'yellow');
/*!40000 ALTER TABLE `tbl_color` ENABLE KEYS */;

-- Dumping structure for table shoeshop.tbl_product
DROP TABLE IF EXISTS `tbl_product`;
CREATE TABLE IF NOT EXISTS `tbl_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `img` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `id_color` int(11) DEFAULT NULL,
  `id_category` int(11) DEFAULT NULL,
  `id_brand` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table shoeshop.tbl_product: ~8 rows (approximately)
DELETE FROM `tbl_product`;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` (`id`, `name`, `img`, `price`, `size`, `id_color`, `id_category`, `id_brand`, `amount`) VALUES
	(15, 'hau', '/uploads/blog-img-04.jpg', 31.3, 31, 1, 1, 2, 313),
	(20, 'hau cong', '/uploads/slider-03.jpg', 545.3, 13, 1, 1, 1, 31),
	(21, 'hau', '/uploads/blog-img-01.jpg', 40, 10, 1, 1, 1, 100),
	(22, 'jang', '/uploads/img-08.jpg', 56.3, 56, 1, 1, 1, 100),
	(24, 'jang', '/uploads/slider-03.jpg', 38, 32, 1, 1, 1, 125),
	(25, 'hau', '/uploads/Untitled.png', 31, 31, 1, 1, 1, 31),
	(30, 'hau', '/uploads/blog-img-01.jpg', 40, 31, 1, 2, 1, 100),
	(31, 'hau cong', '/uploads/img-08.jpg', 45.3, 100, 1, 2, 1, 45);
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;

-- Dumping structure for table shoeshop.tbl_user
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE IF NOT EXISTS `tbl_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `passwd` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table shoeshop.tbl_user: ~4 rows (approximately)
DELETE FROM `tbl_user`;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` (`uid`, `name`, `email`, `passwd`) VALUES
	(1, 'hau', 'hau@gmail.com', 'hau'),
	(2, 'hau', 'hau1998@gmail.com', 'hau'),
	(3, 'hau', 'hau1@gmail.com', '1'),
	(4, 'jang', 'jang@gmail.com', '1');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
