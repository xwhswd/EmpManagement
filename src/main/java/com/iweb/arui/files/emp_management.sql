/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50018 (5.0.18-nt)
 Source Host           : localhost:3306
 Source Schema         : emp_management

 Target Server Type    : MySQL
 Target Server Version : 50018 (5.0.18-nt)
 File Encoding         : 65001

 Date: 13/06/2023 12:25:36
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '部门名称',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '这是部门表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (0, '未分配');
INSERT INTO `department` VALUES (1, 'java部');
INSERT INTO `department` VALUES (3, 'pp部');
INSERT INTO `department` VALUES (4, 'pthon部1');
INSERT INTO `department` VALUES (5, 'pthon部1');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `emp_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '员工名',
  `identity_card` char(11) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '身份证号',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '电话号码',
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '男' COMMENT '性别',
  `pid` bigint(20) UNSIGNED NOT NULL DEFAULT 1 COMMENT '职位id',
  `dept_id` bigint(20) UNSIGNED NOT NULL DEFAULT '' COMMENT '部门id',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '这是员工表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (2, '张三2', '123', '345', '男', 1, 1);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `position_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '职位名',
  `position_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '职位介绍',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '这是职位表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (0, '未分配', '未分配');
INSERT INTO `post` VALUES (1, '经理', '这是一个经理职位');
INSERT INTO `post` VALUES (2, '会计', '这是会计');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `report_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '公告名',
  `report_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '公告信息',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '这是公告表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES (1, '公告1', '公告1');
INSERT INTO `report` VALUES (3, 'sadsadasa', 'asda');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户密码',
  `role` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '普通用户' COMMENT '用户角色',
  `status` char(3) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未登录' COMMENT '用户状态',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '这是用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0, 'root', '123456', '管理员', '未登录');
INSERT INTO `user` VALUES (1, 'user1', '123456', '普通用户', '未登录');
INSERT INTO `user` VALUES (3, 'user2', '123456', '普通用户', '未登录');

SET FOREIGN_KEY_CHECKS = 1;
