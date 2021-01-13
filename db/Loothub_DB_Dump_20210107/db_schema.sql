CREATE DATABASE IF NOT EXISTS `loothub`;

USE `loothub`;

CREATE TABLE `products` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `price` DECIMAL(14 , 9 ) NOT NULL,
    `description` VARCHAR(255) DEFAULT NULL,
    `category` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

CREATE TABLE `users` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;


CREATE TABLE `contact_numbers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `tel_number` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

CREATE TABLE `item_status` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `status` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

CREATE TABLE `product_images` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `image_path` VARCHAR(255) NOT NULL,
    `user_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_product_images_product_id__products_id` (`product_id`),
    CONSTRAINT `fk_product_images_product_id__products_id` FOREIGN KEY (`product_id`)
        REFERENCES `products` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

CREATE TABLE `product_tags` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `tag_name` VARCHAR(255) NOT NULL,
    `product_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_product_tags_product_id__products_id` (`product_id`),
    CONSTRAINT `fk_product_tags_product_id__products_id` FOREIGN KEY (`product_id`)
        REFERENCES `products` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

CREATE TABLE `roles` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `role` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

CREATE TABLE `user_addresses` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `country` VARCHAR(255) NOT NULL,
    `city` VARCHAR(255) NOT NULL,
    `street_name` VARCHAR(255) DEFAULT NULL,
    `street_number` VARCHAR(255) DEFAULT NULL,
    `postal_code` INT NOT NULL,
    `is_shipping` TINYINT(1) DEFAULT '0',
    `is_billing` TINYINT(1) DEFAULT '0',
    PRIMARY KEY (`id`),
    KEY `fk_user_addresses_user_id__users_id` (`user_id`),
    CONSTRAINT `fk_user_addresses_user_id__users_id` FOREIGN KEY (`user_id`)
        REFERENCES `users` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;



CREATE TABLE `users_contact_numbers` (
    `user_id` INT NOT NULL,
    `contact_number_id` INT NOT NULL,
    PRIMARY KEY (`user_id` , `contact_number_id`),
    KEY `fk_users_contact_numbers_contact_number_id_contact_numbers__idx` (`contact_number_id`),
    CONSTRAINT `fk_users_contact_numbers_contact_number_id_contact_numbers_id` FOREIGN KEY (`contact_number_id`)
        REFERENCES `contact_numbers` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_users_contact_numbers_user_id_users_id` FOREIGN KEY (`user_id`)
        REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

CREATE TABLE `users_roles` (
    `user_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    PRIMARY KEY (`user_id` , `role_id`),
    KEY `fk_user_roles_role_id_roles_id` (`role_id`),
    CONSTRAINT `fk_user_roles_role_id_roles_id` FOREIGN KEY (`role_id`)
        REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_user_roles_user_id_users_id` FOREIGN KEY (`user_id`)
        REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

CREATE TABLE `orders` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `product_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    `comments` VARCHAR(255) DEFAULT NULL,
    `item_status_id` INT NOT NULL,
    `tracking_number` VARCHAR(255) DEFAULT NULL,
    `shipping_address_id` INT NOT NULL,
    `billing_address_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_auctions_product_id__products_id` (`product_id`),
    KEY `fk_auctions_user_id__users_id` (`user_id`),
    KEY `fk_auctions_auction_status_id__auctions_status_id` (`item_status_id`),
    KEY `fk_order_details_billing_address_id__user_addresses_id_idx` (`billing_address_id`),
    KEY `fk_order_details_shipping_address_id__user_addresses_id_idx` (`shipping_address_id`),
    CONSTRAINT `fk_auctions_auction_status_id__auctions_status_id` FOREIGN KEY (`item_status_id`)
        REFERENCES `item_status` (`id`)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_auctions_product_id__products_id` FOREIGN KEY (`product_id`)
        REFERENCES `products` (`id`)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_auctions_user_id__users_id` FOREIGN KEY (`user_id`)
        REFERENCES `users` (`id`)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_orders_billing_address_id__user_addresses_id` FOREIGN KEY (`billing_address_id`)
        REFERENCES `user_addresses` (`id`)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_orders_shipping_address_id__user_addresses_id` FOREIGN KEY (`shipping_address_id`)
        REFERENCES `user_addresses` (`id`)
        ON DELETE RESTRICT ON UPDATE RESTRICT
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

INSERT INTO `loothub`.`users`
(`id`,`email`,`password`,`first_name`,`last_name`)
VALUES(1,'admin@gmail.com','$2a$10$.P3ERs5Kvvtm2r07AtEBtuW1HH2q2UwmgffoXImBbOvIzBeM.F9.W','admin','admin');

INSERT INTO `loothub`.`roles`(`id`,`role`)VALUES(1,'ADMIN');
INSERT INTO `loothub`.`users_roles`(`user_id`,`role_id`)VALUES (1,1);





   