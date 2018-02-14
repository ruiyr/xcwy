﻿CREATE TABLE `order_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestart` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `timeend` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` decimal(7,2) DEFAULT NULL,
  `user_mobile` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_car` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_carnum` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `service_condition` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_id` varchar(9) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `x` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `y` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;