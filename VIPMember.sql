/*
Navicat SQLite Data Transfer

Source Server         : UserTable
Source Server Version : 31300
Source Host           : :0

Target Server Type    : SQLite
Target Server Version : 31300
File Encoding         : 65001

Date: 2019-10-25 10:30:32
*/

PRAGMA foreign_keys = OFF;

-- ----------------------------
-- Table structure for VIPMember
-- ----------------------------
DROP TABLE IF EXISTS "main"."VIPMember";
CREATE TABLE "VIPMember" (
"phonenum"  TEXT(11) NOT NULL,
"score"  INTEGER NOT NULL,
"created_time"  TEXT NOT NULL,
"modified_time"  TEXT NOT NULL,
PRIMARY KEY ("phonenum" ASC)
);
PRAGMA foreign_keys = ON;
