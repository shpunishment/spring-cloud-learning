/*
 Navicat Premium Data Transfer

 Source Server         : local 5.7.26 mysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:4306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 09/10/2020 09:47:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三1', '1', 1);
INSERT INTO `user` VALUES (2, '张三2', '2', 1);
INSERT INTO `user` VALUES (3, '张三3', '1', 0);
INSERT INTO `user` VALUES (4, '张三4', '2', 0);
INSERT INTO `user` VALUES (5, '张三5', '1', 0);
INSERT INTO `user` VALUES (6, '张三6', '1', 0);
INSERT INTO `user` VALUES (7, '张三7', '1', 0);
INSERT INTO `user` VALUES (8, '张三8', '2', 0);
INSERT INTO `user` VALUES (9, '张三9', '2', 0);
INSERT INTO `user` VALUES (10, '张三10', '1', 0);
INSERT INTO `user` VALUES (11, '张三11', '2', 0);
INSERT INTO `user` VALUES (12, '张三12', '1', 0);
INSERT INTO `user` VALUES (13, '张三13', '2', 0);
INSERT INTO `user` VALUES (14, '张三14', '1', 0);
INSERT INTO `user` VALUES (15, '张三15', '2', 0);

SET FOREIGN_KEY_CHECKS = 1;
