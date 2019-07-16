-- MySQL dump 10.13  Distrib 5.5.53, for Win32 (AMD64)
--
-- Host: localhost    Database: absence
-- ------------------------------------------------------
-- Server version	5.5.53

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply` (
  `applyId` int(11) NOT NULL AUTO_INCREMENT,
  `activity` varchar(45) DEFAULT NULL COMMENT '会议活动名称',
  `job` varchar(45) DEFAULT NULL COMMENT '职位',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号码',
  `startTime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开始时间',
  `endTime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '结束时间',
  `other` varchar(45) DEFAULT 'none' COMMENT '代替人员',
  `reason` varchar(255) DEFAULT NULL COMMENT '请假原因',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `isPass` tinyint(3) unsigned DEFAULT '0' COMMENT '1通过审核，0未通过审核，-1不批准',
  `description` varchar(255) DEFAULT '' COMMENT '审批说明',
  `departmentId` int(11) DEFAULT NULL COMMENT '部门外键',
  PRIMARY KEY (`applyId`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='请假申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` VALUES (3,'值班','干事','name','123456','2019-09-09 14:12:12','2019-09-09 14:12:12','other','reason','2019-03-02 07:58:15',0,'',1),(4,'值班','干部','name','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-02 08:41:16',0,'',1),(5,'值班','干事','name','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-02 08:41:24',0,'',1),(6,'值班','干部','name','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-02 08:41:28',0,'',1),(7,'值班','干事','活动会议','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-02 08:43:17',0,'',1),(8,'值班','干部','部门','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-02 08:46:21',0,'',1),(9,'活动会议','干事','姓名','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-02 08:48:26',0,'',1),(10,'活动会议','干部','姓名','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-04 05:45:50',0,'',1),(11,'活动会议','干事','姓名','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-04 05:47:51',0,'',1),(12,'活动会议','干部','姓名','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-04 08:30:23',0,'',1),(13,'活动会议','干事','姓名','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-06 01:18:28',0,'',1),(14,'活动会议','干部','姓名','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-06 02:29:29',0,'',1),(15,'活动会议','干事','姓名','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-06 04:56:47',0,'',1),(16,'活动会议','干部','姓名','123456','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-06 06:08:26',0,'',1),(17,'活动会议','干事','姓名','15813318719','2018-09-01 14:22:22','2018-09-01 14:22:23','代替人员','请假理由','2019-03-07 12:08:21',0,'',1);
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`departmentId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'网络部');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `permissionId` int(11) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(45) DEFAULT NULL COMMENT '权限名',
  `description` varchar(255) DEFAULT NULL COMMENT '权限说明',
  PRIMARY KEY (`permissionId`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'审核干事值班请假',NULL),(2,'审核干部值班请假',NULL),(3,'审核干事会议活动请假',NULL),(4,'审核干部会议活动请假',NULL),(5,'添加管理员',NULL),(6,'删除管理员',NULL),(7,'添加审核人员',NULL),(8,'删除审核人员',NULL);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `reviewId` int(11) NOT NULL AUTO_INCREMENT,
  `applyId` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reviewId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='审核表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,2,1,'2019-03-11 05:44:39');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'干部'),(2,'干事'),(3,'秘书部部长'),(4,'站长团'),(5,'管理员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permission` (
  `roleId` int(11) DEFAULT NULL,
  `permissionId` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES (1,3),(3,1),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(1,3),(5,5),(5,6),(5,7),(5,8);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `departmentId` int(11) NOT NULL DEFAULT '0' COMMENT '用户所在部门，和申请的部门保持一致，方便审核分类',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user1','123456','15813318719',1),(2,'user2','123456','15813318718',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(1,3),(2,5),(2,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-16  9:40:58
