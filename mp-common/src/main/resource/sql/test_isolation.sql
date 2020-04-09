/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-04-03 17:09:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test_isolation
-- ----------------------------
DROP TABLE IF EXISTS `test_isolation`;
CREATE TABLE `test_isolation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `num` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of test_isolation
-- ----------------------------
INSERT INTO `test_isolation` VALUES ('1', '1');
INSERT INTO `test_isolation` VALUES ('2', '2');
INSERT INTO `test_isolation` VALUES ('3', '3');

/*
set SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
set SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
set SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
set SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
*/

/*读未提交*/
set SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
select @@tx_ISOLATION;

start TRANSACTION ;
select * from test_isolation;
update test_isolation set num = 10 where id = 1;
select * from test_isolation;
select * from test_isolation;
ROLLBACK;
/*读已提交*/
set SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
start TRANSACTION ;
select * from test_isolation;
update test_isolation set num = 10 where id = 1;
select * from test_isolation;
select * from test_isolation;
commit;
select * from test_isolation;
/*可重复读*/
set SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
start TRANSACTION ;
select * from test_isolation;
update test_isolation set num = 10 where id = 1;
select * from test_isolation;
select * from test_isolation;
commit;
select * from test_isolation;
INSERT INTO `test_isolation`(num) VALUES (4);
select * from test_isolation;
select * from test_isolation;
commit;
select * from test_isolation;
/*序列化*/
set SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
start TRANSACTION ;
select * from test_isolation;
select * from test_isolation;
commit;
select * from test_isolation;
INSERT INTO `test_isolation`(num) VALUES (5);

