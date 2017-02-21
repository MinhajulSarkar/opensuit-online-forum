/*
MySQL Data Transfer
Source Host: localhost
Source Database: forum
Target Host: localhost
Target Database: forum
Date: 2/21/2017 9:45:35 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role` varchar(255) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_comments
-- ----------------------------
DROP TABLE IF EXISTS `t_comments`;
CREATE TABLE `t_comments` (
  `T_USRE_EMAIL` varchar(60) default NULL,
  `T_THREAD_CODE` varchar(15) default NULL,
  `T_COMMENT_CODE` varchar(15) default NULL,
  `T_COMMENT_TEXT` varchar(5000) default NULL,
  `T_ENTRY_USER` varchar(50) default NULL,
  `T_ENTRY_DATE` datetime default NULL,
  `T_UPDATE_USER` varchar(50) default NULL,
  `T_UPDATE_DATE` datetime default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_thread_registration
-- ----------------------------
DROP TABLE IF EXISTS `t_thread_registration`;
CREATE TABLE `t_thread_registration` (
  `T_THREAD_CODE` varchar(15) default NULL,
  `T_USRE_EMAIL` varchar(60) default NULL,
  `T_TOPIC_ID` int(11) default NULL,
  `T_THREAD_TILE` varchar(200) default NULL,
  `T_THREAD_DES` varchar(1000) default NULL,
  `T_ENTRY_USER` varchar(50) default NULL,
  `T_ENTRY_DATE` datetime default NULL,
  `T_UPDATE_USER` varchar(50) default NULL,
  `T_UPDATE_DATE` datetime default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic` (
  `T_TOPIC_ID` int(11) default NULL,
  `T_TOPIC_NAME` varchar(100) default NULL,
  `T_ENTRY_USER` varchar(50) default NULL,
  `T_ENTRY_DATE` datetime default NULL,
  `T_UPDATE_USER` varchar(50) default NULL,
  `T_UPDATE_DATE` datetime default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `active` int(11) default NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY  (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ADMIN');
