/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-01-19 11:03:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(40) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `borth_day` date DEFAULT NULL,
  `is_at_work` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '胡亚鹏', '26', '男', '1402477783@qq.com', '1993-12-29', '');
INSERT INTO `employee` VALUES ('2', '陈粒', '24', '女', '258852369@qq.com', '1995-04-20', '');
INSERT INTO `employee` VALUES ('3', '还不知道取什么名字', '1', '男', '123456789@qq.com', '2022-08-18', '');
INSERT INTO `employee` VALUES ('5', 'xiao胡2', '3', '男', '1234567899@qq.com', '2024-08-18', '');
INSERT INTO `employee` VALUES ('7', 'xiao胡4', '5', '男', '1234567899@qq.com', '2023-08-18', '');
INSERT INTO `employee` VALUES ('9', 'xiao胡6', '7', '男', '1234567899@qq.com', '2021-08-18', '');

-- ----------------------------
-- Table structure for `metrics_row`
-- ----------------------------
DROP TABLE IF EXISTS `metrics_row`;
CREATE TABLE `metrics_row` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `metrics_table_id` varchar(128) DEFAULT NULL,
  `period` varchar(16) DEFAULT NULL,
  `period_id` varchar(128) DEFAULT NULL,
  `period_name` varchar(255) DEFAULT NULL,
  `period_start_date` date DEFAULT NULL,
  `period_end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of metrics_row
-- ----------------------------
INSERT INTO `metrics_row` VALUES ('39', '2', '项目内', '111', '迭代1', '2019-12-04', '2019-12-26');
INSERT INTO `metrics_row` VALUES ('42', '1', '迭代内', '222', '迭代1', '2019-12-26', '2019-12-26');
INSERT INTO `metrics_row` VALUES ('43', '1', '迭代内', '333', '迭代1', '2019-12-04', '2019-12-26');
INSERT INTO `metrics_row` VALUES ('47', '1', '项目内', '444', '迭代1', '2019-12-30', '2019-12-31');

-- ----------------------------
-- Table structure for `my_info`
-- ----------------------------
DROP TABLE IF EXISTS `my_info`;
CREATE TABLE `my_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_info
-- ----------------------------
INSERT INTO `my_info` VALUES ('1', '胡亚鹏', '25');
INSERT INTO `my_info` VALUES ('2', '陈粒', '24');

-- ----------------------------
-- Table structure for `qrtz_blob_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_calendars`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_cron_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('schedulerFactoryBean', 'trigger1', 'group1', '0 0/1 8-18 ? * 2-6', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for `qrtz_fired_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_job_details`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('schedulerFactoryBean', 'job1', 'group1', null, 'com.hyp.task.quartz.ScheduledJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000010770800000010000000007800);

-- ----------------------------
-- Table structure for `qrtz_locks`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('schedulerFactoryBean', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('schedulerFactoryBean', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for `qrtz_paused_trigger_grps`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_scheduler_state`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('schedulerFactoryBean', 'operate-server1579400690562', '1579401092920', '20000');

-- ----------------------------
-- Table structure for `qrtz_simple_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_simprop_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('schedulerFactoryBean', 'trigger1', 'group1', 'job1', 'group1', null, '1579478400000', '1579397679784', '0', 'WAITING', 'CRON', '1578363488000', '0', null, '0', '');

-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `report_config_id` int(11) NOT NULL COMMENT '关联报表ID',
  `report_type` varchar(255) NOT NULL COMMENT '报表类型：项目，人力，需求',
  `project_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('1', '1', '111项目11', '10021');
INSERT INTO `report` VALUES ('2', '2', '人员', '10021');
INSERT INTO `report` VALUES ('3', '3', '需求', '10021');
INSERT INTO `report` VALUES ('4', '23', '项目', '10021');
INSERT INTO `report` VALUES ('5', '24', '项目', '10021');
INSERT INTO `report` VALUES ('6', '33', '项目', '10021');
INSERT INTO `report` VALUES ('7', '34', '项目', '10021');
INSERT INTO `report` VALUES ('8', '35', '项目', '10021');
INSERT INTO `report` VALUES ('9', '36', '项目1', '10021');
INSERT INTO `report` VALUES ('10', '1', '项目', '10021');
INSERT INTO `report` VALUES ('11', '1', '项目', '10021');
INSERT INTO `report` VALUES ('12', '1', '项目', '10021');
INSERT INTO `report` VALUES ('13', '1', '项目', '10021');
INSERT INTO `report` VALUES ('14', '1', '项目', '10021');
INSERT INTO `report` VALUES ('15', '1', '项目', '10021');
INSERT INTO `report` VALUES ('16', '1', '项目', '10021');
INSERT INTO `report` VALUES ('17', '1', '项目', '10021');
INSERT INTO `report` VALUES ('18', '1', '项目', '10021');
INSERT INTO `report` VALUES ('19', '1', '项目', '10021');
INSERT INTO `report` VALUES ('20', '1', '项目', '10021');
INSERT INTO `report` VALUES ('21', '1', '项目', '10021');
INSERT INTO `report` VALUES ('22', '1', '项目', '10021');
INSERT INTO `report` VALUES ('23', '1', '项目', '10021');
INSERT INTO `report` VALUES ('24', '2', '人员', '10021');
INSERT INTO `report` VALUES ('25', '2', '人员', '10021');
INSERT INTO `report` VALUES ('26', '1', '项目', '10021');
INSERT INTO `report` VALUES ('27', '2', '人员', '10021');
INSERT INTO `report` VALUES ('28', '2', '人员', '10021');
INSERT INTO `report` VALUES ('29', '2', '人员', '10021');
INSERT INTO `report` VALUES ('30', '1', '项目', '10021');
INSERT INTO `report` VALUES ('31', '2', '人员', '10021');
INSERT INTO `report` VALUES ('32', '2', '人员', '10021');
INSERT INTO `report` VALUES ('33', '2', '人员', '10021');
INSERT INTO `report` VALUES ('34', '2', '人员', '10021');
INSERT INTO `report` VALUES ('35', '2', '人员', '10021');
INSERT INTO `report` VALUES ('36', '2', '人员', '10021');
INSERT INTO `report` VALUES ('37', '2', '人员', '10021');
INSERT INTO `report` VALUES ('38', '2', '人员', '10021');
INSERT INTO `report` VALUES ('39', '1', '项目', '10021');
INSERT INTO `report` VALUES ('40', '2', '人员', '10021');
INSERT INTO `report` VALUES ('41', '2', '人员', '10021');
INSERT INTO `report` VALUES ('42', '2', '人员', '10021');
INSERT INTO `report` VALUES ('43', '2', '人员', '10021');
INSERT INTO `report` VALUES ('44', '2', '人员', '10021');
INSERT INTO `report` VALUES ('45', '2', '人员', '10021');
INSERT INTO `report` VALUES ('46', '2', '人员', '10021');
INSERT INTO `report` VALUES ('47', '2', '人员', '10021');
INSERT INTO `report` VALUES ('48', '2', '人员', '10021');
INSERT INTO `report` VALUES ('49', '2', '人员', '10021');
INSERT INTO `report` VALUES ('50', '2', '人员', '10021');
INSERT INTO `report` VALUES ('51', '2', '人员', '10021');
INSERT INTO `report` VALUES ('52', '2', '人员', '10021');
INSERT INTO `report` VALUES ('53', '2', '人员', '10021');
INSERT INTO `report` VALUES ('54', '2', '人员', '10021');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '胡亚鹏', '26', '5');
INSERT INTO `student` VALUES ('2', '陈粒', '24', '2');
INSERT INTO `student` VALUES ('3', '胡小鹏', '1', '3');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `type` varchar(40) DEFAULT NULL,
  `tag` varchar(40) DEFAULT NULL,
  `src` varchar(40) DEFAULT NULL,
  `ip` varchar(40) DEFAULT NULL,
  `msg` varchar(40) DEFAULT NULL,
  `login_name` varchar(40) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `use_time` bigint(20) DEFAULT NULL,
  `params` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(255) DEFAULT NULL COMMENT '别名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role_id` int(11) DEFAULT NULL COMMENT '权限id',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `deleted` int(11) DEFAULT '0' COMMENT '是否删除(0:未删除 1:已删除)',
  `update_version` int(11) DEFAULT '0' COMMENT '乐观锁',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'hyp', '小胡', '123456', '1', '1', '2019-12-30 10:10:10', '2019-12-31 10:10:10', '哈哈哈', '1', '1', 'huyapeng', '17345748624');
INSERT INTO `sys_user` VALUES ('2', 'cl', '小陈', '321654', '1', '1', '2019-12-30 10:10:10', '2019-12-31 10:10:10', '哈哈哈', '1', '1', 'chenli', '17345748624');
INSERT INTO `sys_user` VALUES ('18', 'shen', '自豪', 'shen', null, null, '2019-12-30 11:42:16', '2019-12-30 11:42:16', null, '0', '0', null, null);
INSERT INTO `sys_user` VALUES ('19', 'shen', '祥和', 'shen', null, null, '2019-12-30 11:48:40', '2019-12-30 11:48:40', null, '0', '0', null, null);
INSERT INTO `sys_user` VALUES ('20', 'shen', '打捞', 'shen', null, null, '2019-12-30 11:48:52', '2019-12-30 11:48:52', null, '0', '0', null, null);

-- ----------------------------
-- Table structure for `tms_system_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `tms_system_user_info`;
CREATE TABLE `tms_system_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `login_no` varchar(40) DEFAULT NULL,
  `domain_account` varchar(40) DEFAULT NULL COMMENT '域账号',
  `password` varchar(40) DEFAULT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `mailbox` varchar(40) DEFAULT NULL COMMENT '邮箱',
  `business_group` enum('华为业务群','中软业务群') DEFAULT NULL COMMENT '业务群',
  `business_line` enum('IT业务线','无线网络业务线') DEFAULT NULL COMMENT '业务线',
  `business_department` enum('无线事业部','平台事业部') DEFAULT NULL COMMENT '事业部',
  `delivery_department` enum('PLG交付部','OSS交付部') DEFAULT NULL COMMENT '交付部',
  `account_expiration_time` date DEFAULT NULL COMMENT '账号失效时间',
  `password_expiration_time` date DEFAULT NULL COMMENT '密码失效时间',
  `role` enum('管理员','PO','项目经理','交付经理','领导','客户') DEFAULT NULL COMMENT '角色',
  `is_locked` bit(1) DEFAULT NULL COMMENT '锁定',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tms_system_user_info
-- ----------------------------
INSERT INTO `tms_system_user_info` VALUES ('1', null, 'zhangsan', '19931229', '张三', 'zhangsan@chinasoft.com', '华为业务群', 'IT业务线', '无线事业部', 'OSS交付部', '2020-03-01', '2020-03-01', '管理员', '');
INSERT INTO `tms_system_user_info` VALUES ('2', null, 'lisi', '19931229', '李四', 'lisi@chinasoft.com', '中软业务群', 'IT业务线', '无线事业部', 'OSS交付部', '2021-03-01', '2021-03-01', '管理员', '');

-- ----------------------------
-- Table structure for `tool`
-- ----------------------------
DROP TABLE IF EXISTS `tool`;
CREATE TABLE `tool` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `version` varchar(20) DEFAULT NULL,
  `support_process` varchar(128) DEFAULT NULL,
  `business_property` varchar(40) DEFAULT NULL,
  `manage_property` varchar(40) DEFAULT NULL,
  `provide_interface` bit(1) DEFAULT NULL,
  `prj_amount` int(11) DEFAULT NULL,
  `report_method` varchar(40) DEFAULT NULL,
  `status` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tool
-- ----------------------------
INSERT INTO `tool` VALUES ('1', 'icpci', '1.0', '静态检查', '付费', '客户提供', '', '12', '系统固化', '启用');
INSERT INTO `tool` VALUES ('2', '需求管理平台', '1.0', '需求管理', '开源', '公司提供', '', '13', '系统固化', '启用');
INSERT INTO `tool` VALUES ('3', '云龙平台', '1.0', '静态检查', '开源', '客户提供', '', '14', '系统固化', '启用');
INSERT INTO `tool` VALUES ('4', '华为云系统', '2.0', '静态检查，单元测试', '开源', '客户提供', '', '15', '系统固化', '启用');
INSERT INTO `tool` VALUES ('8', '项目管理系统', '1.0', '静态检查', '付费', '公司提供', '', '16', '系统固化', '启用');
INSERT INTO `tool` VALUES ('9', 'PMS需求管理平台', '1.0', '静态检查', '开源', '公司提供', '', '17', '系统固化', '启用');
INSERT INTO `tool` VALUES ('11', '公司度量系统', '1.0', '单元测试', '开源', '公司提供', '', '18', '系统固化', '启用');
INSERT INTO `tool` VALUES ('12', '系统1', '1.0', '静态检查，单元测试', '开源', '客户提供', '', '19', '系统固化', '启用');
INSERT INTO `tool` VALUES ('13', '系统2', '1.0', '静态检查，单元测试', '开源', '公司提供', '', '20', '系统固化', '启用');
INSERT INTO `tool` VALUES ('14', '系统3', '1.0', '静态检查，单元测试', '开源', '公司提供', '', '21', '系统固化', '启用');
INSERT INTO `tool` VALUES ('15', '系统4', '1.0', '静态检查，单元测试', '开源', '公司提供', '', '22', '系统固化', '启用');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jone', '18', 'test1@baomidou.com');
INSERT INTO `user` VALUES ('2', 'Jack', '20', 'test2@baomidou.com');
INSERT INTO `user` VALUES ('3', 'Tom', '28', 'test3@baomidou.com');
INSERT INTO `user` VALUES ('4', 'Sandy', '21', 'test4@baomidou.com');
INSERT INTO `user` VALUES ('5', 'Billie', '24', 'test5@baomidou.com');
