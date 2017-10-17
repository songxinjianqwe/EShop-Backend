/*
Navicat MySQL Data Transfer

Source Server         : Conn
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : eshop

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-10-17 18:25:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `balance`
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance` (
  `user` bigint(20) NOT NULL,
  `balance` double DEFAULT NULL,
  `payment_password` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user`),
  CONSTRAINT `fk_user_balance` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of balance
-- ----------------------------
INSERT INTO `balance` VALUES ('1', '900', '$2a$10$ljrvBQUWTVhGH2YYIX3uIeZ4a3VDxdo.n9HGGBLCzgEnAMrlEBfza');
INSERT INTO `balance` VALUES ('2', '2000', '$2a$10$PkRJNfvMvBnDLzGReXvUXOyX5F.IKEkFAj0VQ6HkrJUSXnhxXnPwu');
INSERT INTO `balance` VALUES ('5', '0', null);
INSERT INTO `balance` VALUES ('6', '0', null);
INSERT INTO `balance` VALUES ('7', '0', null);

-- ----------------------------
-- Table structure for `mail`
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sender` bigint(20) NOT NULL,
  `receiver` bigint(20) NOT NULL,
  `mail_status` smallint(5) unsigned zerofill NOT NULL DEFAULT '00000',
  `text` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_mail_text` (`text`),
  KEY `fk_mail_user_sender` (`sender`),
  KEY `fk_mail_user_receiver` (`receiver`),
  CONSTRAINT `fk_mail_text` FOREIGN KEY (`text`) REFERENCES `mail_text` (`id`),
  CONSTRAINT `fk_mail_user_receiver` FOREIGN KEY (`receiver`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_mail_user_sender` FOREIGN KEY (`sender`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mail
-- ----------------------------
INSERT INTO `mail` VALUES ('1', '1', '2', '00000', '1');
INSERT INTO `mail` VALUES ('2', '1', '5', '00000', '2');
INSERT INTO `mail` VALUES ('14', '5', '1', '00001', '14');
INSERT INTO `mail` VALUES ('15', '1', '2', '00000', '14');
INSERT INTO `mail` VALUES ('16', '1', '5', '00000', '14');
INSERT INTO `mail` VALUES ('17', '5', '1', '00000', '18');
INSERT INTO `mail` VALUES ('18', '5', '1', '00000', '18');
INSERT INTO `mail` VALUES ('19', '6', '1', '00000', '19');
INSERT INTO `mail` VALUES ('20', '6', '1', '00000', '18');
INSERT INTO `mail` VALUES ('21', '2', '1', '00000', '1');
INSERT INTO `mail` VALUES ('22', '2', '1', '00001', '14');
INSERT INTO `mail` VALUES ('23', '1', '6', '00000', '21');
INSERT INTO `mail` VALUES ('24', '1', '7', '00000', '21');

-- ----------------------------
-- Table structure for `mail_text`
-- ----------------------------
DROP TABLE IF EXISTS `mail_text`;
CREATE TABLE `mail_text` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mail_text` text,
  `send_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mail_text
-- ----------------------------
INSERT INTO `mail_text` VALUES ('1', 'hehe', '2017-05-04 16:18:08');
INSERT INTO `mail_text` VALUES ('2', 'dada', '2017-05-04 16:18:15');
INSERT INTO `mail_text` VALUES ('14', 'HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1HelloWorld1', '2017-05-09 19:22:09');
INSERT INTO `mail_text` VALUES ('15', 'HelloWorld2', '2017-05-09 19:40:05');
INSERT INTO `mail_text` VALUES ('16', 'HelloWorld3', '2017-07-12 13:34:36');
INSERT INTO `mail_text` VALUES ('17', 'HelloWorld4', '2017-07-12 16:27:25');
INSERT INTO `mail_text` VALUES ('18', 'HelloWorld5', '2017-10-16 10:01:10');
INSERT INTO `mail_text` VALUES ('19', 'HelloWorld6', '2017-10-16 10:01:13');
INSERT INTO `mail_text` VALUES ('20', 'HelloWorld7', '2017-10-16 10:03:43');
INSERT INTO `mail_text` VALUES ('21', '呵呵呵', '2017-10-16 20:26:26');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `body` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '新增课程:Java程序设计', 'JavaSEJavaSEJavaSEJavaSEJavaSEJavaSEJavaSEJavaSEJavaSEJavaSEJavaSEJavaSEJavaSEJavaSE', '2017-10-06 16:32:50');
INSERT INTO `news` VALUES ('2', '新增课程:.Net程序设计', '.Net', '2017-10-06 16:33:13');
INSERT INTO `news` VALUES ('3', '课程降价:JavaSE', 'JavaSE', '2017-10-06 16:33:30');
INSERT INTO `news` VALUES ('4', 'JavaSE课程本学期结束', 'JavaSE', '2017-10-06 16:33:57');
INSERT INTO `news` VALUES ('5', '课程取消:DBA培训', 'DBA', '2017-10-06 16:34:19');
INSERT INTO `news` VALUES ('6', '新增课程:C++语法', 'C++', '2017-10-06 22:23:01');
INSERT INTO `news` VALUES ('8', '新增课程:React.js开发', 'React.js', '2017-10-07 12:48:38');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  `place_time` datetime DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `order_status` smallint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_user` (`user`),
  KEY `fk_order_product` (`product`),
  CONSTRAINT `fk_order_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '1', '1', '2017-10-06 21:27:34', '300', '3');
INSERT INTO `order` VALUES ('2', '2', '2', '1', '2017-10-06 21:27:50', '800', '1');
INSERT INTO `order` VALUES ('3', '3', '1', '1', '2017-10-06 21:28:27', '500', '2');
INSERT INTO `order` VALUES ('4', '4', '1', '1', '2017-10-06 21:29:12', '300', '2');
INSERT INTO `order` VALUES ('5', '5', '5', '1', '2017-10-06 21:30:03', '2000', '1');
INSERT INTO `order` VALUES ('16', '24', '1', '1', '2017-10-14 17:17:45', '500', '3');
INSERT INTO `order` VALUES ('17', '24', '1', '1', '2017-10-14 17:26:09', '500', '3');
INSERT INTO `order` VALUES ('18', '24', '1', '1', '2017-10-14 17:36:26', '500', '0');
INSERT INTO `order` VALUES ('20', '24', '1', '1', '2017-10-14 19:25:04', '500', '1');
INSERT INTO `order` VALUES ('21', '25', '1', '1', '2017-10-14 21:02:23', '500', '1');
INSERT INTO `order` VALUES ('22', '2', '1', '1', '2017-10-15 12:04:25', '400', '0');
INSERT INTO `order` VALUES ('23', '24', '1', '1', '2017-10-15 17:32:03', '500', '0');
INSERT INTO `order` VALUES ('24', '5', '1', '1', '2017-10-15 17:32:21', '400', '0');
INSERT INTO `order` VALUES ('25', '24', '1', '1', '2017-10-16 08:26:04', '500', '0');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` bigint(20) DEFAULT NULL,
  `type` smallint(4) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_on_promotion` tinyint(4) unsigned zerofill DEFAULT '0000',
  `image_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_product_category` (`category`),
  KEY `unique_product_name` (`name`),
  CONSTRAINT `fk_product_product_category` FOREIGN KEY (`category`) REFERENCES `product_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'JavaSE基础', '300', '1', '0', 'JavaSE基础学习视频', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/57035ff200014b8a06000338-240-135.jpg');
INSERT INTO `product` VALUES ('2', 'JavaSE进阶', '400', '1', '1', 'JavaSE提高学习视频', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/570360620001390f06000338-240-135.jpg');
INSERT INTO `product` VALUES ('3', 'JavaSE高级', '500', '1', '2', 'JavaSE高级学习视频', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/5703604a0001694406000338-240-135.jpg');
INSERT INTO `product` VALUES ('4', 'HTML+CSS', '300', '3', '0', 'Web基础课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/59030cc50001144806000338.jpg');
INSERT INTO `product` VALUES ('5', 'JavaScript', '400', '3', '1', 'Web提高课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/59ae66c5000139d906000338.jpg');
INSERT INTO `product` VALUES ('6', 'Vue.js', '500', '3', '2', 'Web高级课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/58ca659a00017c3705400300-360-202.jpg');
INSERT INTO `product` VALUES ('7', 'JQuery', '500', '3', '2', 'Web高级课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/570b05f4000194e506000338-240-135.jpg');
INSERT INTO `product` VALUES ('8', 'Spring', '500', '1', '2', 'JavaEE课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/591138710001e41305400300-360-202.jpg');
INSERT INTO `product` VALUES ('17', 'C#', '300', '2', '0', '.Net基础课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/57035f2c000106fa06000338-240-135.jpg');
INSERT INTO `product` VALUES ('18', 'ASP.Net', '300', '2', '0', '.Net基础课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/ASP.Net.png');
INSERT INTO `product` VALUES ('19', 'PHP语法', '300', '4', '0', 'PHP基础课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/572b06470001a42e06000338-240-135.jpg');
INSERT INTO `product` VALUES ('20', 'Laravel', '500', '4', '2', 'PHP高级课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/593a7a470001bcff05400300-360-202.jpg');
INSERT INTO `product` VALUES ('21', 'Android语法', '300', '9', '0', 'Android基础课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/599150070001993506000338-240-135.jpg');
INSERT INTO `product` VALUES ('22', 'Swift语法', '300', '10', '0', 'IOS基础课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/579193580001000306000338-240-135.jpg');
INSERT INTO `product` VALUES ('23', '随机算法', '300', '11', '0', 'ML基础课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/59dada7100016d9405400300-360-202.jpg');
INSERT INTO `product` VALUES ('24', 'React.js', '500', '3', '2', 'Web高级课程', '0001', 'http://eshop-1252651195.cossh.myqcloud.com/carousel/react.jpg');
INSERT INTO `product` VALUES ('25', 'Android组件化开发', '500', '9', '2', 'Android高级课程', '0001', 'http://eshop-1252651195.cossh.myqcloud.com/carousel/android.jpg');
INSERT INTO `product` VALUES ('26', '算法面试', '500', '1', '2', 'Java高级课程', '0001', 'http://eshop-1252651195.cossh.myqcloud.com/carousel/algo.jpg');
INSERT INTO `product` VALUES ('27', 'react-native', '500', '3', '2', 'Web高级课程', '0001', 'http://eshop-1252651195.cossh.myqcloud.com/carousel/react-native.jpg');
INSERT INTO `product` VALUES ('28', 'Linux基础', '300', '13', '0', '大数据基础课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/53fed63700018a9306000338-240-135.jpg');
INSERT INTO `product` VALUES ('29', '需求文档', '300', '14', '0', '产品经理基础课程', '0000', null);
INSERT INTO `product` VALUES ('30', 'Python语法', '300', '15', '0', '数据分析基础课程', '0000', null);
INSERT INTO `product` VALUES ('31', 'Photoshop教程', '300', '12', '0', 'UI基础课程', '0000', null);
INSERT INTO `product` VALUES ('33', '测试基础', '300', '16', '0', '软件测试基础课程', '0000', null);
INSERT INTO `product` VALUES ('34', 'SpringBoot实战', '500', '1', '2', 'JavaEE课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/SpringBoot.png');
INSERT INTO `product` VALUES ('35', 'SpringMVC', '500', '1', '2', 'JavaEE课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/570765d90001bf1406000338-240-135.jpg');
INSERT INTO `product` VALUES ('36', 'SpringData', '500', '1', '2', 'JavaEE数据课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/58e6081c00012ec206000338-240-135.jpg');
INSERT INTO `product` VALUES ('37', 'SpringSecurity', '500', '1', '2', 'JavaEE安全课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/591138710001e41305400300-360-202.jpg');
INSERT INTO `product` VALUES ('38', 'ElasticSearch', '500', '1', '2', 'JavaEE搜索课程', '0000', 'http://eshop-1252651195.cossh.myqcloud.com/product/Java/59b77bac0001985906000338-240-135.jpg');

-- ----------------------------
-- Table structure for `product_category`
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_on_board` tinyint(1) unsigned zerofill DEFAULT '0',
  `image_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', 'Java', '就业面最广的职业方向', '1', 'http://eshop-1252651195.cossh.myqcloud.com/category/JavaEE.png');
INSERT INTO `product_category` VALUES ('2', '.Net', '.Net', '0', 'http://eshop-1252651195.cossh.myqcloud.com/category/.Net.png');
INSERT INTO `product_category` VALUES ('3', 'Web', 'Web开发的未来趋势', '1', 'http://eshop-1252651195.cossh.myqcloud.com/category/Web.png');
INSERT INTO `product_category` VALUES ('4', 'PHP', 'PHP', '0', 'http://eshop-1252651195.cossh.myqcloud.com/category/PHP.png');
INSERT INTO `product_category` VALUES ('9', 'Android', '\r\n让你更容易追求幸福生活，享受美好生活', '1', 'http://eshop-1252651195.cossh.myqcloud.com/category/Android.png');
INSERT INTO `product_category` VALUES ('10', 'IOS', '企业必争的人才资源', '1', 'http://eshop-1252651195.cossh.myqcloud.com/category/IOS.png');
INSERT INTO `product_category` VALUES ('11', 'ML', 'ML', '0', 'http://eshop-1252651195.cossh.myqcloud.com/category/ML.png');
INSERT INTO `product_category` VALUES ('12', 'UI', '最流行用户交互设计语言', '1', 'http://eshop-1252651195.cossh.myqcloud.com/category/UI.png');
INSERT INTO `product_category` VALUES ('13', '大数据', '大数据', '0', 'http://eshop-1252651195.cossh.myqcloud.com/category/BigData.png');
INSERT INTO `product_category` VALUES ('14', '产品经理', '产品经理', '0', 'http://eshop-1252651195.cossh.myqcloud.com/category/ProductManager.png');
INSERT INTO `product_category` VALUES ('15', '数据分析', '人才需求量大，收入水平高', '1', 'http://eshop-1252651195.cossh.myqcloud.com/category/DataAnalysis.png');
INSERT INTO `product_category` VALUES ('16', '测试', '测试', '0', 'http://eshop-1252651195.cossh.myqcloud.com/category/SoftwareTest.png');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `role` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(60) NOT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `real_name` varchar(30) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `reg_time` datetime DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `user_status` smallint(6) unsigned zerofill NOT NULL DEFAULT '000000',
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$TK1o7JAlSdGU.IYnXHx4yOFoLfAxKEAl9BSxKcbjD/wni.YvRZHnm', 'orange\'s cat', 'wwwwwwwwwwwwww', 'M', '1996-12-26', '2017-04-27 19:35:29', 'songxinjianzx@163.com', '4544444444', '000001', 'http://eshop-1252651195.cossh.myqcloud.com/user/avatar/%28I%5D5WFSF21%7DU6OLL9%5D%28H%7B%289.jpg');
INSERT INTO `user` VALUES ('2', 'admin2', '$2a$10$PkRJNfvMvBnDLzGReXvUXOyX5F.IKEkFAj0VQ6HkrJUSXnhxXnPwu', 'admin2', 'hahaha', 'M', '1995-12-10', '2017-04-28 09:03:38', 'hahaha@163.com', '13088721239', '000001', 'http://eshop-1252651195.cossh.myqcloud.com/user/avatar/4A78%7D0WHV8KK1_9KX7M2D6C.jpg');
INSERT INTO `user` VALUES ('5', 'admin3', '$2a$10$zTZqrJTOM7Gs2NzBeTPa3.A/ex39v68utE4WaUPVN04dNYFGNhNdu', 'admin3', 'dadada', 'M', '1995-12-10', '2017-04-28 13:37:37', 'songxinjianzx@126.com', '13088721239', '000001', 'http://eshop-1252651195.cossh.myqcloud.com/user/avatar/MLNON%40639_88AWPRZE%28EGB5.jpg');
INSERT INTO `user` VALUES ('6', 'user1', '$2a$10$vhtyeS2t/UD6aACZ678ilemF2lYv2bq7CHlh8s8JIdqkBALyOulq2', 'user1', 'user1', 'M', '2017-10-01', '2017-10-15 17:15:03', 'songxinjianzx@126.com', '123123123123123', '000001', null);
INSERT INTO `user` VALUES ('7', 'user2', '$2a$10$n8xZeYUnoq.VhVpl4J2LIOgLm9gkuGBOaIv6733Ea20Zcpqx51yRG', 'user2', 'user2', 'M', '2017-10-01', '2017-10-16 20:22:55', 'songxinjianzx@126.com', '123123123123', '000001', null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user` bigint(20) NOT NULL,
  `role` bigint(20) NOT NULL,
  PRIMARY KEY (`user`,`role`),
  KEY `user_role_role_id` (`role`),
  CONSTRAINT `user_role_role_id` FOREIGN KEY (`role`) REFERENCES `role` (`id`),
  CONSTRAINT `user_role_user_id` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '1');
INSERT INTO `user_role` VALUES ('5', '1');
INSERT INTO `user_role` VALUES ('1', '2');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('5', '2');
INSERT INTO `user_role` VALUES ('6', '2');
INSERT INTO `user_role` VALUES ('7', '2');
