-- DDL query for creation of `user_data` Table
CREATE TABLE `user_data` (
  `id` bigint NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `encrypted_password` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_email_address_idx` (`email_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DDL query for creation of `initiator_details` Table
CREATE TABLE `initiator_details` (
  `id` bigint NOT NULL,
  `name` varchar(100) NOT NULL,
  `business_unit` varchar(100) NOT NULL,
  `contact_number` varchar(100) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- DDL query for creation of `facility_details` Table
CREATE TABLE `facility_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `category` varchar(20) NOT NULL,
  `purpose` varchar(20) NOT NULL,
  `term` bigint DEFAULT NULL,
  `ccy` varchar(5) NOT NULL,
  `amount` bigint NOT NULL,
  `is_housing_loan` int DEFAULT NULL,
  `pvs_req_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pvs_req_id` (`pvs_req_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DDL query for creation of `pvs_val_requests` Table
CREATE TABLE `pvs_val_requests` (
  `req_id` bigint NOT NULL AUTO_INCREMENT,
  `received_datetime` datetime NOT NULL,
  `created_datetime` datetime NOT NULL,
  `modified_datetime` datetime NOT NULL,
  `user_id` bigint NOT NULL,
  `is_active` int NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`req_id`),
  KEY `user_id_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- DDL query for creation of `customer_details` Table
CREATE TABLE `customer_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) NOT NULL,
  `customer_number` varchar(20) NOT NULL,
  `address` varchar(400) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- DDL query for creation of `borrower_details` Table
CREATE TABLE `borrower_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_id` bigint NOT NULL,
  `is_main_borrower` int DEFAULT NULL,
  `pvs_req_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pvs_req_id_idx` (`pvs_req_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- DDL query for creation of `document_details` Table
CREATE TABLE `document_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(80) NOT NULL,
  `filename` varchar(100) NOT NULL,
  `size` bigint NOT NULL,
  `storage_path` varchar(400) NOT NULL,
  `uploaded_by` int NOT NULL,
  `uploaded_datetime` datetime NOT NULL,
  `pvs_req_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pvs_req_id_idx` (`pvs_req_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DDL query for creation of `comments` Table
CREATE TABLE `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment_body` varchar(500) NOT NULL,
  `user_id` int NOT NULL,
  `comment_datetime` datetime NOT NULL,
  `pvs_req_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pvs_req_id_idx` (`pvs_req_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DDL query for creation of `property_val_details` Table
CREATE TABLE `property_val_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `application_datetime` datetime NOT NULL,
  `pvs_req_id` bigint NOT NULL,
  `is_fos_ref` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pvs_req_id_idx` (`pvs_req_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;