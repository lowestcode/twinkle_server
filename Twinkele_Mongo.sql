/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.153.128
 Source Server Type    : MongoDB
 Source Server Version : 40200
 Source Host           : 192.168.153.128:27017
 Source Schema         : Twinkele_Mongo

 Target Server Type    : MongoDB
 Target Server Version : 40200
 File Encoding         : 65001

 Date: 02/09/2019 13:26:22
*/


// ----------------------------
// Collection structure for comment
// ----------------------------
db.getCollection("comment").drop();
db.createCollection("comment");
