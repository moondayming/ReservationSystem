/*
Navicat SQLite Data Transfer

Source Server         : UserTable
Source Server Version : 31300
Source Host           : :0

Target Server Type    : SQLite
Target Server Version : 31300
File Encoding         : 65001

Date: 2019-10-25 10:30:24
*/

PRAGMA foreign_keys = OFF;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "main"."user";
CREATE TABLE "user" (
"count"  TEXT(30) NOT NULL,
"password"  TEXT(30) NOT NULL,
PRIMARY KEY ("count")
);
PRAGMA foreign_keys = ON;
