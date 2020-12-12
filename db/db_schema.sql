DROP DATABASE loothub;

CREATE DATABASE `loothub`;

USE `loothub`;

CREATE TABLE `user_categories` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
	`category_name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `users` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL, 
    `first_name` VARCHAR(255) NOT NULL, 
    `last_name` VARCHAR(255) NOT NULL, 
    `email` VARCHAR(255) NOT NULL, 
    `password` VARCHAR(255) NOT NULL,
    `category_id` INT NOT NULL,
      CONSTRAINT `fk_users_category_id__user_categories_id` FOREIGN KEY (`category_id`)
        REFERENCES `user_categories` (`id`),
        PRIMARY KEY (`id`)
	);
    

CREATE TABLE `contact_numbers` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
	`user_id` INT NOT NULL,
	`tel_number` VARCHAR(255),
	PRIMARY KEY(`id`),
	CONSTRAINT `fk_contact_numbers_user_id__users_id` FOREIGN KEY (`user_id`)
		REFERENCES `users` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `user_addresses` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
	`user_id` INT NOT NULL,
	`country` VARCHAR(255) NOT NULL,
	`city` VARCHAR (255) NOT NULL,
	`street_name` VARCHAR(255) NULL DEFAULT NULL,
	`street_number` VARCHAR(255) NULL DEFAULT NULL,
	`postal_code` INT NOT NULL,
	`is_shipping` BOOLEAN DEFAULT FALSE,
	`is_billing` BOOLEAN DEFAULT FALSE,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_user_addresses_user_id__users_id` FOREIGN KEY (`user_id`)
		REFERENCES `users` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `product_categories` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
    `category_name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE `products` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`description` VARCHAR(255) NULL DEFAULT NULL,
	`category_id` INT NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_products_category_id__product_categories_id` FOREIGN KEY (`category_id`)
		REFERENCES `product_categories` (`id`)
);



CREATE TABLE `product_tags` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
    `tag_name` VARCHAR(255) NOT NULL,
    `product_id` INT NOT NULL,
    PRIMARY KEY (`id`),
	CONSTRAINT `fk_product_tags_product_id__products_id` FOREIGN KEY (`product_id`)
		REFERENCES `products` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `product_images` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
    `image_path` VARCHAR(255) NOT NULL,
    `product_id` INT NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_product_images_product_id__products_id` FOREIGN KEY (`product_id`)
		REFERENCES `products` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `auction_status` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
	`status` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `auctions` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
	`product_id` INT NOT NULL,
	`user_id` INT NOT NULL,
    `starting_datetime` DATETIME NOT NULL,
    `end_datetime` DATETIME NOT NULL,
    `comments` VARCHAR(255) NULL DEFAULT NULL,
    `auction_status_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_auctions_product_id__products_id` FOREIGN KEY (`product_id`)
		REFERENCES `products` (`id`)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT `fk_auctions_user_id__users_id` FOREIGN KEY (`user_id`)
		REFERENCES `users` (`id`)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT `fk_auctions_auction_status_id__auctions_status_id` FOREIGN KEY (`auction_status_id`)
		REFERENCES `auction_status` (`id`)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

/* CREATE TABLE `auction_winners` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
    `user_id` INT NOT NULL,
    `auction_id` INT NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_auction_winners_user_id_users_id` FOREIGN KEY (`user_id`)
		REFERENCES `users` (`id`),
	CONSTRAINT `fk_auction_winners_auction_id__auctions__id` FOREIGN KEY (`auction_id`)
		REFERENCES `auctions` (`id`)        
); */


	
CREATE TABLE `bids` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
	`auction_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    `bid` DECIMAL(19,4) NOT NULL,
    `bid_datetime` DATETIME NOT NULL,
    `is_winner` BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_bids_auction_id__auctions_id` FOREIGN KEY (`auction_id`)
		REFERENCES `auctions` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_bids_user_id__users_id` FOREIGN KEY (`user_id`)
		REFERENCES `users` (`id`)
	);
	
CREATE TABLE `auction_prices` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
	`auction_id` INT NOT NULL,
	`starting_price` DECIMAL(19,4) NULL DEFAULT NULL,
	`current_price` DECIMAL(19,4) NULL DEFAULT NULL,
	`buyout_price` DECIMAL(19,4) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_auction_prices_auction_id__auctions_id` FOREIGN KEY (`auction_id`)
		REFERENCES `auctions` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE
);
    
CREATE TABLE `order_details` (
	`id` INT NOT NULL AUTO_INCREMENT NOT NULL,
	`auction_id` INT NOT NULL,
    `tracking_number` VARCHAR(255),
    `shipping_address_id` INT NOT NULL,
    `billing_address_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_order_details_auction_id__auctions_id` FOREIGN KEY (`auction_id`)
		REFERENCES `auctions` (`id`),
	CONSTRAINT `fk_order_details_shipping_address_id__user_addresses_id` FOREIGN KEY (`shipping_address_id`)
		REFERENCES `user_addresses` (`id`),
	CONSTRAINT `fk_order_details_billing_address_id__user_addresses_id` FOREIGN KEY (`billing_address_id`)
		REFERENCES `user_addresses` (`id`)
);

   