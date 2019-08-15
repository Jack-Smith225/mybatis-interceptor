CREATE DATABASE IF NOT EXISTS `mybatis-interceptor` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
USE `mybatis-interceptor`;

CREATE TABLE `user` (
	`user_id` INT(11) NOT NULL COMMENT '用户id',
	`user_name` VARCHAR(50) NULL DEFAULT NULL COMMENT '用户名称',
	`birthday` VARCHAR(50) NULL DEFAULT NULL COMMENT '生日',
	`zh_name` VARCHAR(50) NULL DEFAULT NULL COMMENT '中文名',
	`en_name` VARCHAR(50) NULL DEFAULT NULL COMMENT '英文名',
	PRIMARY KEY (`user_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

INSERT INTO `user` (`user_id`, `user_name`, `birthday`, `zh_name`, `en_name`) VALUES (1, '张三', '1992-12-09', '张三', 'kevin');
INSERT INTO `user` (`user_id`, `user_name`, `birthday`, `zh_name`, `en_name`) VALUES (2, '李四', '1991-05-12', '李四', 'peter');
INSERT INTO `user` (`user_id`, `user_name`, `birthday`, `zh_name`, `en_name`) VALUES (3, '李四', '1991-05-12', '李四二', 'jack');


