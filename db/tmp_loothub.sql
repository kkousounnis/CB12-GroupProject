DROP DATABASE `loothub`;
CREATE DATABASE `loothub`;
USE `loothub`;

CREATE TABLE `users` (
    `id` BIGINT NOT NULL AUTO_INCREMENT NOT NULL,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL, 
    PRIMARY KEY (`id`)
);

CREATE TABLE `roles` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `users_roles`(
	`user_id` BIGINT,
    `role_id` BIGINT,
    PRIMARY KEY(`user_id`,`role_id`),
    CONSTRAINT `fk_user_roles_user_id_users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `fk_user_roles_role_id_roles_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
);
DROP TABLE `users_contact_numbers`;
DROP TABLE `contact_numbers`;

USE `loothub`;

CREATE TABLE `contact_numbers` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`tel_number` BIGINT,
    PRIMARY KEY (`id`)
);

CREATE TABLE `users_contact_numbers`(
	`user_id` BIGINT,
    `contact_number_id` BIGINT,
    PRIMARY KEY(`user_id`,`contact_number_id`),
    CONSTRAINT `fk_users_contact_numbers_user_id_users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `fk_users_contact_numbers_contact_number_id_contact_numbers_id` FOREIGN KEY (`contact_number_id`) REFERENCES `contact_numbers` (`id`)
);


