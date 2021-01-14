
INSERT INTO `loothub`.`users`
(`id`,`email`,`password`,`first_name`,`last_name`)
VALUES(3,'kwstas654321@gmail.com','$2a$10$d0zPW8KdDNoCAL48HkFjxukz2o9BK/GbcEqNWtHXWWIyEKyan7RRW','Konstantinos','Kousounnis');

INSERT INTO `loothub`.`roles`(`id`,`role`)VALUES(3,'ROLE_USER');
INSERT INTO `loothub`.`users_roles`(`user_id`,`role_id`)VALUES (3,3);

INSERT INTO `loothub`.`contact_numbers`
(`id`,`tel_number`)
VALUES
(4,6986783675);

INSERT INTO `loothub`.`users_contact_numbers`
(`user_id`,`contact_number_id`)
VALUES
(3,4);



INSERT INTO `loothub`.`products`
(`id`,`name`,`price`,`description`,`category`)
VALUES
(1,'Painting',5000.000000000,'RARE HAMPTON & Sons Pall Mall Mahogany','Collectables');

INSERT INTO `loothub`.`product_images`
(`id`,`image_path`,`user_id`,`product_id`)
VALUES
(1,'/tmp/images/3',3,1);

INSERT INTO `loothub`.`users`
(`id`,`email`,`password`,`first_name`,`last_name`)
VALUES(5,'nikoleta1995@gmail.com','$2a$10$0HSD5.iATSipntjzbplIoO6qT.xLtC4HMzV97oo1z7BMGhPSqOiIG','Nikoleta','Ralidou');

INSERT INTO `loothub`.`roles`(`id`,`role`)VALUES(5,'ROLE_USER');
INSERT INTO `loothub`.`users_roles`(`user_id`,`role_id`)VALUES (5,5);

INSERT INTO `loothub`.`contact_numbers`
(`id`,`tel_number`)
VALUES
(6,6974634764);

INSERT INTO `loothub`.`users_contact_numbers`
(`user_id`,`contact_number_id`)
VALUES
(5,6);

INSERT INTO `loothub`.`products`
(`id`,`name`,`price`,`description`,`category`)
VALUES
(2,'Laptop',6099.000000000,'Dell Alienware Area-51m R2','Electronics');
INSERT INTO `loothub`.`product_images`
(`id`,`image_path`,`user_id`,`product_id`)
VALUES
(2,'/tmp/images/5',5,2);