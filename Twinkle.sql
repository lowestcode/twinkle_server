/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.153.128
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 192.168.153.128:3306
 Source Schema         : Twinkle

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 02/09/2019 13:26:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for twinkle_article
-- ----------------------------
DROP TABLE IF EXISTS `twinkle_article`;
CREATE TABLE `twinkle_article`  (
  `article_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `label_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专栏ID',
  `article_tag` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签ID',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `mark_down` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'MarkDown语法',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章正文',
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章封面',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '发表日期',
  `updatetime` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  `ispublic` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否公开',
  `istop` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否置顶',
  `visits` int(20) NULL DEFAULT NULL COMMENT '浏览量',
  `thumbup` int(20) NULL DEFAULT NULL COMMENT '点赞数',
  `comment` int(20) NULL DEFAULT NULL COMMENT '评论数',
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态',
  `channelid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属频道',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL',
  `type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of twinkle_article
-- ----------------------------
INSERT INTO `twinkle_article` VALUES ('1164827396168237056', '2', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:07', '2019-08-23 17:11:07', NULL, NULL, 4, 5, 19, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827417076842496', '2', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:12', '2019-08-23 17:11:12', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827419434041344', '2', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:12', '2019-08-23 17:11:12', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827421476667392', '2', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:13', '2019-08-23 17:11:13', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827422869176320', '2', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:13', '2019-08-23 17:11:13', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827424773390336', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:14', '2019-08-23 17:11:14', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827426673410048', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:14', '2019-08-23 17:11:14', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827428284022784', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:15', '2019-08-23 17:11:15', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827429739446272', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:15', '2019-08-23 17:11:15', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827431207452672', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:15', '2019-08-23 17:11:15', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827432650293248', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:16', '2019-08-23 17:11:16', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827434646781952', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:16', '2019-08-23 17:11:16', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827436718768128', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:17', '2019-08-23 17:11:17', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827439218573312', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:17', '2019-08-23 17:11:17', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827442708234233', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:18', '2019-08-23 17:11:18', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1164827442708234240', '1', NULL, 'asdasdasdad', 'a', 'asdasdasdasdasdasdasdasdad', NULL, '2019-08-23 17:11:18', '2019-08-23 17:11:18', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1167008872590770176', '1', '2', 'asdasd', 'a', '123123123', NULL, '2019-08-29 17:39:31', '2019-08-29 17:39:31', NULL, NULL, 0, 0, 0, '0', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1167030124424495104', '1', '2', 'asdasd', 'a', '<p>123- sdafas</p>\n<ul>\n<li>asdf</li>\n<li>asdf</li>\n<li>asdf</li>\n<li>asd</li>\n<li>f</li>\n<li>asdf</li>\n</ul>\n<table>\n<thead>\n<tr>\n<th>colasdumn1</th>\n<th>column2</th>\n<th>column3</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>content1</td>\n<td>content2</td>\n<td>content3</td>\n</tr>\n</tbody>\n</table>\n', NULL, '2019-08-29 19:03:58', '2019-08-29 19:03:58', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1167033612575465472', '1', '2', 'asdasd', '|column1|column2|column3|\n|-|-|-|\n|content1|content2|content3|\n\n\n\n```java\npublic class Article implements Serializable {\n\n    @Id\n    @Column(name = \"article_id\")\n    private String articleId;\n\n    private String labelId;\n\n    private String articleTag;\n\n    private String title;\n\n    private String content;\n\n    private String image;\n\n    private String createtime;\n\n    private String updatetime;\n\n    private String ispublic;\n\n    private String istop;\n\n    private int visits;\n\n    private int thumbup;\n\n    private int comment;\n\n    private String state;\n\n    private String url;\n\n    private String type;\n\n    private String markDown;\n}\n```\n1. asdfa\n2. df\n3. asdf\n4. asd\n5. f\n6. asdf', '<table>\n<thead>\n<tr>\n<th>column1</th>\n<th>column2</th>\n<th>column3</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>content1</td>\n<td>content2</td>\n<td>content3</td>\n</tr>\n</tbody>\n</table>\n<pre><div class=\"hljs\"><code class=\"lang-java\"><span class=\"hljs-keyword\">public</span> <span class=\"hljs-class\"><span class=\"hljs-keyword\">class</span> <span class=\"hljs-title\">Article</span> <span class=\"hljs-keyword\">implements</span> <span class=\"hljs-title\">Serializable</span> </span>{\n\n    <span class=\"hljs-meta\">@Id</span>\n    <span class=\"hljs-meta\">@Column</span>(name = <span class=\"hljs-string\">\"article_id\"</span>)\n    <span class=\"hljs-keyword\">private</span> String articleId;\n\n    <span class=\"hljs-keyword\">private</span> String labelId;\n\n    <span class=\"hljs-keyword\">private</span> String articleTag;\n\n    <span class=\"hljs-keyword\">private</span> String title;\n\n    <span class=\"hljs-keyword\">private</span> String content;\n\n    <span class=\"hljs-keyword\">private</span> String image;\n\n    <span class=\"hljs-keyword\">private</span> String createtime;\n\n    <span class=\"hljs-keyword\">private</span> String updatetime;\n\n    <span class=\"hljs-keyword\">private</span> String ispublic;\n\n    <span class=\"hljs-keyword\">private</span> String istop;\n\n    <span class=\"hljs-keyword\">private</span> <span class=\"hljs-keyword\">int</span> visits;\n\n    <span class=\"hljs-keyword\">private</span> <span class=\"hljs-keyword\">int</span> thumbup;\n\n    <span class=\"hljs-keyword\">private</span> <span class=\"hljs-keyword\">int</span> comment;\n\n    <span class=\"hljs-keyword\">private</span> String state;\n\n    <span class=\"hljs-keyword\">private</span> String url;\n\n    <span class=\"hljs-keyword\">private</span> String type;\n\n    <span class=\"hljs-keyword\">private</span> String markDown;\n}\n</code></div></pre>\n<ol>\n<li>asdfa</li>\n<li>df</li>\n<li>asdf</li>\n<li>asd</li>\n<li>f</li>\n<li>asdf</li>\n</ol>\n', NULL, '2019-08-29 19:17:50', '2019-08-29 19:17:50', NULL, NULL, 0, 0, 0, '0', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1167053972918272000', '1', '2', 'asdasd', '![QQ图片20190828001010.png](http://pwtu5eoyz.bkt.clouddn.com/1167053963103600640)', '<p><img src=\"http://pwtu5eoyz.bkt.clouddn.com/1167053963103600640\" alt=\"QQ图片20190828001010.png\" /></p>\n', NULL, '2019-08-29 20:38:44', '2019-08-29 20:38:44', NULL, NULL, 0, 0, 0, '0', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1167054385428070400', '1', '2', 'asdasd', '![Cache_3ada4cbe02d00de4..jpg](http://pwtu5eoyz.bkt.clouddn.com/1167054226757550080)\n\n|column1|column2|column3|\n|-|-|-|\n|content1|content2|content3|\n\n1. asdasdasd\n2. asd\n3. asd\n4. as\n5. das\n6. dasd\n\n```java\n\n@RestController\n@RequestMapping(\"/image\")\n@CrossOrigin\npublic class ImgController {\n\n    @Autowired\n    private ImgService imgService;\n\n\n    @RequestMapping(method = RequestMethod.POST)\n    public Result saveImg(@RequestParam(\"image\") MultipartFile file){\n        System.out.println(file);\n        String s = imgService.saveImg(new Img(), file);\n        Map<String,String> map = new HashMap<>();\n        map.put(\"url\",s);\n        return new Result(true, StatusCode.SAVESUCCESS, \"保存成功\",map);\n    }\n\n    @RequestMapping(value = \"/{imageId}\",method = RequestMethod.DELETE)\n    public Result deleteImg(@PathVariable String imageId){\n        imgService.deleteImg(imageId);\n        return new Result(true, StatusCode.DELETESUCCESS, \"删除成功\");\n    }\n\n    @RequestMapping(value = \"/findAll/{page}/{size}\", method = RequestMethod.GET)\n    public Result findAll(@PathVariable(\"page\") int page, @PathVariable(\"size\") int size){\n        Page<Img> pageData = imgService.findAll(page, size);\n        return new Result(true, StatusCode.OK, \"查询图片列表成功\", new PageResult<Img>(pageData.getTotalElements(), pageData.getContent()));\n    }\n\n    @RequestMapping(method = RequestMethod.GET)\n    public Result findImg(){\n        return new Result(true, StatusCode.OK, \"查询成功\",imgService.findImg());\n    }\n}\n```\n\n\n', '<p><img src=\"http://pwtu5eoyz.bkt.clouddn.com/1167054226757550080\" alt=\"Cache_3ada4cbe02d00de4..jpg\" /></p>\n<table>\n<thead>\n<tr>\n<th>column1</th>\n<th>column2</th>\n<th>column3</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>content1</td>\n<td>content2</td>\n<td>content3</td>\n</tr>\n</tbody>\n</table>\n<ol>\n<li>asdasdasd</li>\n<li>asd</li>\n<li>asd</li>\n<li>as</li>\n<li>das</li>\n<li>dasd</li>\n</ol>\n<pre><div class=\"hljs\"><code class=\"lang-java\">\n<span class=\"hljs-meta\">@RestController</span>\n<span class=\"hljs-meta\">@RequestMapping</span>(<span class=\"hljs-string\">\"/image\"</span>)\n<span class=\"hljs-meta\">@CrossOrigin</span>\n<span class=\"hljs-keyword\">public</span> <span class=\"hljs-class\"><span class=\"hljs-keyword\">class</span> <span class=\"hljs-title\">ImgController</span> </span>{\n\n    <span class=\"hljs-meta\">@Autowired</span>\n    <span class=\"hljs-keyword\">private</span> ImgService imgService;\n\n\n    <span class=\"hljs-meta\">@RequestMapping</span>(method = RequestMethod.POST)\n    <span class=\"hljs-function\"><span class=\"hljs-keyword\">public</span> Result <span class=\"hljs-title\">saveImg</span><span class=\"hljs-params\">(@RequestParam(<span class=\"hljs-string\">\"image\"</span>)</span> MultipartFile file)</span>{\n        System.out.println(file);\n        String s = imgService.saveImg(<span class=\"hljs-keyword\">new</span> Img(), file);\n        Map&lt;String,String&gt; map = <span class=\"hljs-keyword\">new</span> HashMap&lt;&gt;();\n        map.put(<span class=\"hljs-string\">\"url\"</span>,s);\n        <span class=\"hljs-keyword\">return</span> <span class=\"hljs-keyword\">new</span> Result(<span class=\"hljs-keyword\">true</span>, StatusCode.SAVESUCCESS, <span class=\"hljs-string\">\"保存成功\"</span>,map);\n    }\n\n    <span class=\"hljs-meta\">@RequestMapping</span>(value = <span class=\"hljs-string\">\"/{imageId}\"</span>,method = RequestMethod.DELETE)\n    <span class=\"hljs-function\"><span class=\"hljs-keyword\">public</span> Result <span class=\"hljs-title\">deleteImg</span><span class=\"hljs-params\">(@PathVariable String imageId)</span></span>{\n        imgService.deleteImg(imageId);\n        <span class=\"hljs-keyword\">return</span> <span class=\"hljs-keyword\">new</span> Result(<span class=\"hljs-keyword\">true</span>, StatusCode.DELETESUCCESS, <span class=\"hljs-string\">\"删除成功\"</span>);\n    }\n\n    <span class=\"hljs-meta\">@RequestMapping</span>(value = <span class=\"hljs-string\">\"/findAll/{page}/{size}\"</span>, method = RequestMethod.GET)\n    <span class=\"hljs-function\"><span class=\"hljs-keyword\">public</span> Result <span class=\"hljs-title\">findAll</span><span class=\"hljs-params\">(@PathVariable(<span class=\"hljs-string\">\"page\"</span>)</span> <span class=\"hljs-keyword\">int</span> page, @<span class=\"hljs-title\">PathVariable</span><span class=\"hljs-params\">(<span class=\"hljs-string\">\"size\"</span>)</span> <span class=\"hljs-keyword\">int</span> size)</span>{\n        Page&lt;Img&gt; pageData = imgService.findAll(page, size);\n        <span class=\"hljs-keyword\">return</span> <span class=\"hljs-keyword\">new</span> Result(<span class=\"hljs-keyword\">true</span>, StatusCode.OK, <span class=\"hljs-string\">\"查询图片列表成功\"</span>, <span class=\"hljs-keyword\">new</span> PageResult&lt;Img&gt;(pageData.getTotalElements(), pageData.getContent()));\n    }\n\n    <span class=\"hljs-meta\">@RequestMapping</span>(method = RequestMethod.GET)\n    <span class=\"hljs-function\"><span class=\"hljs-keyword\">public</span> Result <span class=\"hljs-title\">findImg</span><span class=\"hljs-params\">()</span></span>{\n        <span class=\"hljs-keyword\">return</span> <span class=\"hljs-keyword\">new</span> Result(<span class=\"hljs-keyword\">true</span>, StatusCode.OK, <span class=\"hljs-string\">\"查询成功\"</span>,imgService.findImg());\n    }\n}\n</code></div></pre>\n', NULL, '2019-08-29 20:40:22', '2019-08-29 20:40:22', NULL, NULL, 0, 0, 0, '0', NULL, NULL, NULL);
INSERT INTO `twinkle_article` VALUES ('1167062789043290112', '1', '2', 'asdasd', '1. 12\n2. 312\n3. 31\n4. 23\n5. 12\n6. 31\n7. 23\n8. 1231\n\n|column1|column2|column3|\n|-|-|-|\n|content1|content2|content3|\n\n```java\n    @Autowired\n    private ImgDao imgDao;\n\n    @Autowired\n    private QiniuUpload qiniuUpload;\n\n    @Autowired\n    private QiniuUtil qiniuUtil;\n\n    @Autowired\n    private IdWorker idWorker;\n\n```\n\n\n![L6ML~2NHT12OQJS9B3Q4.png](http://pwtu5eoyz.bkt.clouddn.com/1167062776552652800)\n\n', '<ol>\n<li>12</li>\n<li>312</li>\n<li>31</li>\n<li>23</li>\n<li>12</li>\n<li>31</li>\n<li>23</li>\n<li>1231</li>\n</ol>\n<table>\n<thead>\n<tr>\n<th>column1</th>\n<th>column2</th>\n<th>column3</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>content1</td>\n<td>content2</td>\n<td>content3</td>\n</tr>\n</tbody>\n</table>\n<pre><div class=\"hljs\"><code class=\"lang-java\">    <span class=\"hljs-meta\">@Autowired</span>\n    <span class=\"hljs-keyword\">private</span> ImgDao imgDao;\n\n    <span class=\"hljs-meta\">@Autowired</span>\n    <span class=\"hljs-keyword\">private</span> QiniuUpload qiniuUpload;\n\n    <span class=\"hljs-meta\">@Autowired</span>\n    <span class=\"hljs-keyword\">private</span> QiniuUtil qiniuUtil;\n\n    <span class=\"hljs-meta\">@Autowired</span>\n    <span class=\"hljs-keyword\">private</span> IdWorker idWorker;\n\n</code></div></pre>\n<p><img src=\"http://pwtu5eoyz.bkt.clouddn.com/1167062776552652800\" alt=\"L6ML~2NHT12OQJS9B3Q4.png\" /></p>\n', NULL, '2019-08-29 21:13:46', '2019-08-29 21:13:46', NULL, NULL, 0, 0, 0, '1', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for twinkle_img
-- ----------------------------
DROP TABLE IF EXISTS `twinkle_img`;
CREATE TABLE `twinkle_img`  (
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id+名字',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of twinkle_img
-- ----------------------------
INSERT INTO `twinkle_img` VALUES ('1167062776552652800', 'http://pwtu5eoyz.bkt.clouddn.com/1167062776552652800');

-- ----------------------------
-- Table structure for twinkle_label
-- ----------------------------
DROP TABLE IF EXISTS `twinkle_label`;
CREATE TABLE `twinkle_label`  (
  `label_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '分类id',
  `label_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`label_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of twinkle_label
-- ----------------------------
INSERT INTO `twinkle_label` VALUES ('1164615317226307584', 'php');
INSERT INTO `twinkle_label` VALUES ('1166361343394156544', '阿萨的');
INSERT INTO `twinkle_label` VALUES ('1166361399920791552', '222');
INSERT INTO `twinkle_label` VALUES ('1166361573619503104', 'ww');
INSERT INTO `twinkle_label` VALUES ('1166361705496809472', '2222');

-- ----------------------------
-- Table structure for twinkle_user
-- ----------------------------
DROP TABLE IF EXISTS `twinkle_user`;
CREATE TABLE `twinkle_user`  (
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户密码',
  `user_hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户爱好',
  `user_create_time` datetime(0) NULL DEFAULT NULL COMMENT '用户注册成功',
  `user_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户简介',
  `user_roles` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户的权限',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of twinkle_user
-- ----------------------------
INSERT INTO `twinkle_user` VALUES ('1164754803063111680', 'admin', '$2a$10$uhCN59biI3/mX5QJRMrIi./gA11vP0t4gBUb8nHbaQfzoZF.lBhQm', '唱歌', '2019-08-23 12:22:39', '哈哈哈哈哈哈哈哈', 'admin');
INSERT INTO `twinkle_user` VALUES ('1164759277483704320', 'user', '$2a$10$VWuuggMmgk05up1cb0HtXOdvxVIPzOBd91hBTHw9/YHT2Po.CsUJu', '唱歌', '2019-08-23 12:40:26', 'asdasdasdasd', 'user');
INSERT INTO `twinkle_user` VALUES ('1164772264776847360', 'root', '$2a$10$xNm3tKCkqQ30ncvv.pcvYOFw/dcE4UWv2WL4ijBrhaycbRLAiYZrG', 'asd', '2019-08-23 13:32:03', 'fasdf', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
