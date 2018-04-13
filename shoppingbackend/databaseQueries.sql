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
