/*
 Navicat Premium Data Transfer

 Source Server         : 陈
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : jiu

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 06/10/2022 19:27:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checkout
-- ----------------------------
DROP TABLE IF EXISTS `checkout`;
CREATE TABLE `checkout`  (
  `离开id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `入住id` int(255) NULL DEFAULT NULL,
  `离开时间` datetime NULL DEFAULT NULL,
  `总和` double(255, 0) NULL DEFAULT NULL,
  `合计` double(255, 0) NULL DEFAULT NULL,
  `注释` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`离开id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of checkout
-- ----------------------------
INSERT INTO `checkout` VALUES ('20221005092420', 1, '2022-10-05 09:24:18', 5000, 4900, '');
INSERT INTO `checkout` VALUES ('20221006064220', 234, '2022-10-06 06:42:14', 200, 100, '');
INSERT INTO `checkout` VALUES ('20221006064422', 234, '2022-10-06 06:44:19', 200, 100, '');
INSERT INTO `checkout` VALUES ('232323', 4, '2022-09-26 00:00:00', 600, -80, '');

-- ----------------------------
-- Table structure for guest
-- ----------------------------
DROP TABLE IF EXISTS `guest`;
CREATE TABLE `guest`  (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `房间号` int(255) NULL DEFAULT NULL,
  `押金` int(255) NULL DEFAULT NULL,
  `姓名` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `性别` tinyint(1) NULL DEFAULT NULL,
  `电话` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `证件类型` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `证件号` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `入住时间` date NULL DEFAULT NULL,
  `离开时间` date NULL DEFAULT NULL,
  `地址` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `操作员` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 235 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of guest
-- ----------------------------
INSERT INTO `guest` VALUES (232, 203, 200, '王先生', 1, '12323545', '身份证', '78964838', '2022-09-23', '2022-10-06', '山东泰安', 'root');
INSERT INTO `guest` VALUES (233, 201, 100, '刘', 1, '8766879873432', '居民身份证', '67868', '2022-10-06', '2022-10-06', '山东烟台', 'root');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `房间号` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `房间类型` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `人数` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `价格` int(255) NULL DEFAULT NULL,
  `能否入住` tinyint(1) NULL DEFAULT NULL COMMENT '1true,0false',
  `备注` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `楼层` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`房间号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('101', '单人间', '2', 200, 1, '', '一楼');
INSERT INTO `room` VALUES ('102', '标准间', '2', 200, 1, NULL, '1');
INSERT INTO `room` VALUES ('104', '单人间', '1', 200, 1, '', '一楼');
INSERT INTO `room` VALUES ('105', '单人间', '1', 200, 1, '', '一楼');
INSERT INTO `room` VALUES ('201', '豪华间', '1', 400, 0, '光线好', '1');
INSERT INTO `room` VALUES ('203', '三人间', '1', 600, 0, NULL, '1');
INSERT INTO `room` VALUES ('301', '套房', '1', 800, 1, '安静且视野开阔', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `账号` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `密码` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `操作员` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`账号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'r');
INSERT INTO `user` VALUES ('2', '2', '2');
INSERT INTO `user` VALUES ('678887', '678', '李');
INSERT INTO `user` VALUES ('root', '123456', '大堂经理');
INSERT INTO `user` VALUES ('rooy', '1234567', '前台1');

-- ----------------------------
-- Table structure for wen
-- ----------------------------
DROP TABLE IF EXISTS `wen`;
CREATE TABLE `wen`  (
  `用户名` varbinary(255) NULL DEFAULT NULL,
  `问题` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
