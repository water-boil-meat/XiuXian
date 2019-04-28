/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xiuxian

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-04-28 12:28:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_person
-- ----------------------------
DROP TABLE IF EXISTS `tb_person`;
CREATE TABLE `tb_person` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT,
  `exp` int(32) NOT NULL DEFAULT '0',
  `state_id` int(32) NOT NULL DEFAULT '1',
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_person
-- ----------------------------
INSERT INTO `tb_person` VALUES ('1', '19', '2', '许无情', 'xuyiqing');

-- ----------------------------
-- Table structure for tb_state
-- ----------------------------
DROP TABLE IF EXISTS `tb_state`;
CREATE TABLE `tb_state` (
  `state_id` int(32) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(32) NOT NULL,
  `state_exp` int(32) NOT NULL,
  `success_rate` int(32) NOT NULL,
  `state_desc` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_state
-- ----------------------------
INSERT INTO `tb_state` VALUES ('1', '练力期', '100', '90', '初入修武一途');
INSERT INTO `tb_state` VALUES ('2', '练肉期', '300', '90', '肉体是修炼的根本');
INSERT INTO `tb_state` VALUES ('3', '练脏期', '500', '90', '修炼五脏六腑');
INSERT INTO `tb_state` VALUES ('4', '易筋期', '1000', '90', '修炼经脉');
INSERT INTO `tb_state` VALUES ('5', '锻骨期', '1500', '90', '修炼骨骼');
INSERT INTO `tb_state` VALUES ('6', '凝脉期', '2000', '80', '世俗界的强者');
