# Account
DROP SCHEMA IF EXISTS db_account ;
CREATE SCHEMA db_account ;
USE db_account ;

CREATE TABLE `account_tbl` (
                               `id` INT (11) NOT NULL AUTO_INCREMENT,
                               `user_id` VARCHAR (255) DEFAULT NULL,
                               `money` INT (11) DEFAULT 0,
                               PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 ;

INSERT INTO account_tbl (id, user_id, money) VALUES (1, '1001', 10000) ;
INSERT INTO account_tbl (id, user_id, money) VALUES (2, '1002', 10000) ;

CREATE TABLE `undo_log` (
                            `id` BIGINT (20) NOT NULL AUTO_INCREMENT,
                            `branch_id` BIGINT (20) NOT NULL,
                            `xid` VARCHAR (100) NOT NULL,
                            `context` VARCHAR (128) NOT NULL,
                            `rollback_info` LONGBLOB NOT NULL,
                            `log_status` INT (11) NOT NULL,
                            `log_created` DATETIME NOT NULL,
                            `log_modified` DATETIME NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 ;

#Order
DROP SCHEMA IF EXISTS db_order ;
CREATE SCHEMA db_order ;
USE db_order ;

CREATE TABLE `order_tbl` (
                             `id` INT (11) NOT NULL AUTO_INCREMENT,
                             `user_id` VARCHAR (255) DEFAULT NULL,
                             `commodity_code` VARCHAR (255) DEFAULT NULL,
                             `count` INT (11) DEFAULT '0',
                             `money` INT (11) DEFAULT '0',
                             PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 ;

CREATE TABLE `undo_log` (
                            `id` BIGINT (20) NOT NULL AUTO_INCREMENT,
                            `branch_id` BIGINT (20) NOT NULL,
                            `xid` VARCHAR (100) NOT NULL,
                            `context` VARCHAR (128) NOT NULL,
                            `rollback_info` LONGBLOB NOT NULL,
                            `log_status` INT (11) NOT NULL,
                            `log_created` DATETIME NOT NULL,
                            `log_modified` DATETIME NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 ;

#Stock
DROP SCHEMA IF EXISTS db_stock ;
CREATE SCHEMA db_stock ;
USE db_stock ;

CREATE TABLE `stock_tbl` (
                             `id` INT (11) NOT NULL AUTO_INCREMENT,
                             `commodity_code` VARCHAR (255) DEFAULT NULL,
                             `count` INT (11) DEFAULT '0',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `commodity_code` (`commodity_code`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 ;

INSERT INTO stock_tbl (id, commodity_code, COUNT) VALUES (1, '2001', 1000) ;

CREATE TABLE `undo_log` (
                            `id` BIGINT (20) NOT NULL AUTO_INCREMENT,
                            `branch_id` BIGINT (20) NOT NULL,
                            `xid` VARCHAR (100) NOT NULL,
                            `context` VARCHAR (128) NOT NULL,
                            `rollback_info` LONGBLOB NOT NULL,
                            `log_status` INT (11) NOT NULL,
                            `log_created` DATETIME NOT NULL,
                            `log_modified` DATETIME NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 ;

