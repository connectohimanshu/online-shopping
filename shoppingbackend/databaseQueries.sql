
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(225) NOT NULL,
  `image_url` varchar(50) NOT NULL,
  `is_active` tinyint(1) NOT NULL
);




CREATE TABLE category (
   id IDENTITY,
  name varchar(50),
  description varchar(225),
  image_url varchar(50),
  is_active BOOLEAN,
  
  CONSTRAINT pk_category_id	PRIMARY KEY (id)
);



INSERT INTO `Category` (`id`, `is_active`, `description`, `image_url`, `name`) VALUES (NULL, '1', 'This is Ac', 'ac_png', 'AC');



CREATE TABLE `SpringMvcTutorial`.`user_detail` ( `id` INT NOT NULL , `first_name` VARCHAR(50) NOT NULL , `last_name` VARCHAR(50) NOT NULL , `role` VARCHAR(50) NOT NULL , `enabled` BOOLEAN NOT NULL , `password` VARCHAR(50) NOT NULL , `email` VARCHAR(100) NOT NULL , `contact_number` VARCHAR(15) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;


INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `role`, `enabled`, `password`, `email`, `contact_number`) VALUES ('', 'Virat', 'Kohli', 'ADMIN', '1', 'admin', 'vk@gmail.com', '8888888888'), ('', 'Ravindra', 'Jadega', 'SUPPLIER', '1', '1234', 'rj@gmail.com', '9999999999')
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `role`, `enabled`, `password`, `email`, `contact_number`) VALUES (NULL, 'Rohit', 'Sharma', 'SUPPLIER', '1', '123456', 'rs@gmail.com', '4444444444');




CREATE TABLE `SpringMvcTutorial`.`product` ( `id` BIGINT NOT NULL AUTO_INCREMENT , `code` VARCHAR(20) NOT NULL , `name` VARCHAR(50) NOT NULL , `brand` VARCHAR(50) NOT NULL , `description` VARCHAR(255) NOT NULL , `unit_price` DECIMAL(10,2) NOT NULL , `quantity` INT NOT NULL , `is_active` BOOLEAN NOT NULL , `category_id` INT NOT NULL , `supplier_id` INT NOT NULL , `purchases` INT NOT NULL DEFAULT '0' , `views` INT NOT NULL DEFAULT '0' , PRIMARY KEY (`id`)) ENGINE = InnoDB;

INSERT INTO `product` (`id`, `code`, `name`, `brand`, `description`, `unit_price`, `quantity`, `is_active`, `category_id`, `supplier_id`, `purchases`, `views`) VALUES (NULL, 'PRDABC123DEFX', 'iphone', 'Apple', 'This one of the best smarphone', '52000', '3', '1', '1', '3', '0', '0'), (NULL, 'PRDDEFX123DEFX', 'Samsung note 5', 'Samsung', 'Smartphone with great features', '35000', '3', '1', '2', '2', '0', '0')

INSERT INTO `product` (`id`, `code`, `name`, `brand`, `description`, `unit_price`, `quantity`, `is_active`, `category_id`, `supplier_id`, `purchases`, `views`) VALUES (NULL, 'PRDABC123GHTY', 'Google pixel', 'Pixel', 'This is the phone by google', '62000', '2', '1', '3', '3', '0', '0'), (NULL, 'PRDABC123FDSS', 'MacBook Pro', 'Apple', 'This is the latest laptop in market', '120000', '6', '1', '2', '2', '0', '0')





