CREATE TABLE `module_paid` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `order_no` varchar(256) NOT NULL,
    `client_tin` varchar(256) UNIQUE NOT NULL,
    `device_no` varchar(256) NOT NULL,
    `link` varchar(1000) NULL DEFAULT NULL,
    `status` varchar(100),
    `date` varchar(100),
    `created_by` varchar(255) COLLATE utf8mb4_unicode_ci default null,
    `created_date` datetime default CURRENT_TIMESTAMP null,
    `last_modified_by` varchar(255) COLLATE utf8mb4_unicode_ci default null,
    `last_modified_date` datetime default CURRENT_TIMESTAMP null,
    PRIMARY KEY (`id`)
);