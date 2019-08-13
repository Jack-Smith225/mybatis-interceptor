CREATE DATABASE IF NOT EXISTS `mybatis-interceptor` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
USE `mybatis-interceptor`;

CREATE TABLE `user` (
	`user_id` INT(11) NOT NULL COMMENT '用户id',
	`user_name` VARCHAR(50) NULL DEFAULT NULL COMMENT '用户名称',
	`birthday` DATETIME NULL COMMENT '生日',
	`zh_name` VARCHAR(50) NULL COMMENT '中文名',
	`en_name` VARCHAR(50) NULL COMMENT '英文名',
	PRIMARY KEY (`user_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

insert into `user` values(1,'张三','1992-12-09','zhangsan','kevin');
insert into `user` values(2,'李四','1991-5-12','lisi','peter');
insert into `user` values(3,'李四','1991-5-12','haha','jack');

