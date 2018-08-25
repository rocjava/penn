SELECT COUNT(1) FROM ly_lawyer;
UPDATE ly_lawyer t SET t.`gender` = 'MALE' ;
UPDATE ly_lawyer t SET t.`status` = 'Y' ;

CREATE TABLE `ly_lawyer` (
  `id` BIGINT(15)  PRIMARY KEY AUTO_INCREMENT,
  `lawfirm` BIGINT(15) DEFAULT NULL,
  `name` VARCHAR(60) DEFAULT NULL,
  `mobile` VARCHAR(20) DEFAULT NULL,
  `gender` VARCHAR(10) DEFAULT NULL,
  `telephone` VARCHAR(20) DEFAULT NULL,
  `email` VARCHAR(60) DEFAULT NULL,
  `age` BIGINT(3) DEFAULT NULL,
  `level` VARCHAR(10) DEFAULT NULL,
  `working_years` BIGINT(15) DEFAULT NULL,
  `degree` VARCHAR(10) DEFAULT NULL,
  `university` VARCHAR(60) DEFAULT NULL,
  `status` VARCHAR(10) DEFAULT NULL,
  `create_date` DATE DEFAULT NULL,
  `last_modify_date` DATETIME DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8  AUTO_INCREMENT = 1000000 ;