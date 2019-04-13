DROP TABLE IF EXISTS `user_accounts`;
CREATE TABLE `user_accounts` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`username` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	`tenant_id` bigint(20) NOT NULL,
	`created_by` varchar(255) NOT NULL DEFAULT '0',
	`blocked_by` varchar(255) DEFAULT NULL,
	`updated_by` varchar(255) DEFAULT NULL,
	`created_date` timestamp NOT NULL DEFAULT current_timestamp(),
	`blocked_date` timestamp NULL DEFAULT NULL,
	`updated_date` timestamp NULL DEFAULT NULL,
	`description` varchar(255) DEFAULT NULL,
	`is_activated` tinyint(1) DEFAULT 0,
	`is_blocked` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tokens_management`;
CREATE TABLE `tokens_management` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`username` varchar(150) NOT NULL,
	`token` text NOT NULL,
	`status` tinyint(1) NOT NULL DEFAULT 1,
	`created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
	`id` int(3) NOT NULL AUTO_INCREMENT,
	`name` varchar(255) DEFAULT NULL,
	`created_by` varchar(255) DEFAULT NULL,
	`created_date` timestamp DEFAULT NULL DEFAULT current_timestamp(),
    `updated_by` varchar(255) DEFAULT NULL,
	`updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
	`id` int(3) NOT NULL AUTO_INCREMENT,
	`name` varchar(255) DEFAULT NULL,
	`description` text DEFAULT NULL,
	`created_by` varchar(255) DEFAULT NULL,
	`created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus`
(
	`id` int(3) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `description` text DEFAULT NULL,
    `url` text DEFAULT NULL,
    `position` int(2) NOT NULL DEFAULT 1,
    `iconclass` varchar(255) DEFAULT NULL,
    `status` int(1)  NOT NULL DEFAULT 1,
    `created_by` varchar(255) DEFAULT NULL,
	`created_date` timestamp DEFAULT current_timestamp(),
    `updated_by` varchar(255) NULL DEFAULT NULL,
	`updated_date` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `role_permission_menu`;
CREATE TABLE `role_permission_menu` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id` int(3) NOT NULL,
    `menu_id` int(3) NOT NULL,
    `permission` varchar(50) NOT NULL,
    `created_by` varchar(255) DEFAULT NULL,
	`created_date` timestamp DEFAULT current_timestamp(),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id` int(3) NOT NULL,
    `username` varchar(250) NOT NULL,
    `created_by` varchar(255) DEFAULT NULL,
	`created_date` timestamp DEFAULT current_timestamp(),
    `updated_by` varchar(255) NULL DEFAULT NULL,
	`updated_date` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;