/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : cloud-vue

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-08-29 22:17:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_admin_access`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_access`;
CREATE TABLE `sys_admin_access` (
  `user_id` int(11) NOT NULL DEFAULT '0',
  `group_id` int(11) DEFAULT NULL,
  `group_ids` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin_access
-- ----------------------------
INSERT INTO `sys_admin_access` VALUES ('1', null, '15,24');
INSERT INTO `sys_admin_access` VALUES ('3', null, '29,27');
INSERT INTO `sys_admin_access` VALUES ('7', null, '15');
INSERT INTO `sys_admin_access` VALUES ('8', null, '24');
INSERT INTO `sys_admin_access` VALUES ('12', null, '32');
INSERT INTO `sys_admin_access` VALUES ('15', null, '33');
INSERT INTO `sys_admin_access` VALUES ('16', null, '15');
INSERT INTO `sys_admin_access` VALUES ('17', null, '15');

-- ----------------------------
-- Table structure for `sys_admin_group`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_group`;
CREATE TABLE `sys_admin_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `rules` varchar(4000) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `status` tinyint(3) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin_group
-- ----------------------------
INSERT INTO `sys_admin_group` VALUES ('15', '一级会员', '10,11,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,59,61,62,63,66', '0', '权限不受限制', '1');
INSERT INTO `sys_admin_group` VALUES ('24', '二级会员', '13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,59,61,62,63,66', '15', '只拥有账户权限', '1');
INSERT INTO `sys_admin_group` VALUES ('29', '一线员工', '21,22,31,32,33,61', '24', '一线员工', '1');
INSERT INTO `sys_admin_group` VALUES ('30', '二线员工', '54,55,56,57', '29', '二线员工', '1');
INSERT INTO `sys_admin_group` VALUES ('31', '系统配置', '28,29', '0', '系统配置', '1');
INSERT INTO `sys_admin_group` VALUES ('33', 'bom员工', '64,74,77,78,79,80,81,82,83,84,86,87,91,92', '0', 'bom系统所有权限', '1');

-- ----------------------------
-- Table structure for `sys_admin_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_menu`;
CREATE TABLE `sys_admin_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `pid` int(11) unsigned DEFAULT '0' COMMENT '上级菜单ID',
  `title` varchar(32) DEFAULT '' COMMENT '菜单名称',
  `url` varchar(127) DEFAULT '' COMMENT '链接地址',
  `icon` varchar(64) DEFAULT '' COMMENT '图标',
  `menu_type` tinyint(4) DEFAULT NULL COMMENT '菜单类型',
  `sort` tinyint(4) unsigned DEFAULT '0' COMMENT '排序（同级有效）',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态',
  `rule_id` int(11) DEFAULT NULL COMMENT '权限id',
  `module` varchar(50) DEFAULT NULL,
  `menu` varchar(50) DEFAULT NULL COMMENT '三级菜单吗',
  `rule_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COMMENT='【配置】后台菜单表';

-- ----------------------------
-- Records of sys_admin_menu
-- ----------------------------
INSERT INTO `sys_admin_menu` VALUES ('52', '0', '管理', '', '', '1', '0', '1', '59', 'Administrative', '', '管理菜单');
INSERT INTO `sys_admin_menu` VALUES ('53', '52', '系统配置', '', '', '1', '0', '1', '61', 'Administrative', '', '系统管理二级菜单');
INSERT INTO `sys_admin_menu` VALUES ('54', '53', '菜单管理', '/home/menu/list', '', '1', '0', '1', '21', 'Administrative', 'menu', '菜单列表');
INSERT INTO `sys_admin_menu` VALUES ('55', '53', '系统参数', '/home/config/add', '', '1', '0', '1', '29', 'Administrative', 'systemConfig', '修改系统配置');
INSERT INTO `sys_admin_menu` VALUES ('56', '53', '权限规则', '/home/rule/list', '', '1', '0', '1', '13', 'Administrative', 'rule', '规则列表');
INSERT INTO `sys_admin_menu` VALUES ('57', '52', '组织架构', '', '', '1', '0', '1', '63', 'Administrative', '', '组织架构二级菜单');
INSERT INTO `sys_admin_menu` VALUES ('58', '57', '岗位管理', '/home/position/list', '', '1', '0', '1', '31', 'Administrative', 'position', '岗位列表');
INSERT INTO `sys_admin_menu` VALUES ('59', '57', '部门管理', '/home/structures/list', '', '1', '0', '1', '39', 'Administrative', 'structures', '部门列表');
INSERT INTO `sys_admin_menu` VALUES ('60', '57', '用户组管理', '/home/groups/list', '', '1', '0', '1', '47', 'Administrative', 'groups', '用户组列表');
INSERT INTO `sys_admin_menu` VALUES ('61', '52', '账户管理', '', '', '1', '0', '1', '62', 'Administrative', '', '账户管理二级菜单');
INSERT INTO `sys_admin_menu` VALUES ('62', '61', '账户列表', '/home/users/list', '', '1', '0', '1', '55', 'Administrative', 'users', '成员列表');
INSERT INTO `sys_admin_menu` VALUES ('64', '0', 'stbom系统', '', '', '1', '0', '1', '74', 'stbom', null, 'stbom管理菜单');
INSERT INTO `sys_admin_menu` VALUES ('89', '52', 'xs管理', '', '', '1', '0', '1', '89', 'xxx', null, '  │      └─xx管理');
INSERT INTO `sys_admin_menu` VALUES ('90', '89', 'xs列表', '/home/xx/list', '', '1', '0', '1', '90', 'Adminstrative', 'xx', '  │      └─xx列表');
INSERT INTO `sys_admin_menu` VALUES ('91', '64', 'xx应收管理', '', '', '1', '0', '1', '86', 'stbom', null, '    └─st菜单管理');
INSERT INTO `sys_admin_menu` VALUES ('92', '91', 'xx会计日', '/home/accounting/list', '', '1', '0', '1', '92', 'stbom', 'accounting', '      └─xx会计日');

-- ----------------------------
-- Table structure for `sys_admin_menu_copy`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_menu_copy`;
CREATE TABLE `sys_admin_menu_copy` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `pid` int(11) unsigned DEFAULT '0' COMMENT '上级菜单ID',
  `title` varchar(32) DEFAULT '' COMMENT '菜单名称',
  `url` varchar(127) DEFAULT '' COMMENT '链接地址',
  `icon` varchar(64) DEFAULT '' COMMENT '图标',
  `menu_type` tinyint(4) DEFAULT NULL COMMENT '菜单类型',
  `sort` tinyint(4) unsigned DEFAULT '0' COMMENT '排序（同级有效）',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态',
  `rule_id` int(11) DEFAULT NULL COMMENT '权限id',
  `module` varchar(50) DEFAULT NULL,
  `menu` varchar(50) DEFAULT NULL COMMENT '三级菜单吗',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='【配置】后台菜单表';

-- ----------------------------
-- Records of sys_admin_menu_copy
-- ----------------------------
INSERT INTO `sys_admin_menu_copy` VALUES ('52', '0', '管理', '', '', '1', '0', '1', '59', 'Administrative', '');
INSERT INTO `sys_admin_menu_copy` VALUES ('53', '52', '系统配置', '', '', '1', '0', '1', '61', 'Administrative', '');
INSERT INTO `sys_admin_menu_copy` VALUES ('54', '53', '菜单管理', '/home/menu/list', '', '1', '0', '1', '21', 'Administrative', 'menu');
INSERT INTO `sys_admin_menu_copy` VALUES ('55', '53', '系统参数', '/home/config/add', '', '1', '0', '1', '29', 'Administrative', 'systemConfig');
INSERT INTO `sys_admin_menu_copy` VALUES ('56', '53', '权限规则', '/home/rule/list', '', '1', '0', '1', '13', 'Administrative', 'rule');
INSERT INTO `sys_admin_menu_copy` VALUES ('57', '52', '组织架构', '', '', '1', '0', '1', '63', 'Administrative', '');
INSERT INTO `sys_admin_menu_copy` VALUES ('58', '57', '岗位管理', '/home/position/list', '', '1', '0', '1', '31', 'Administrative', 'position');
INSERT INTO `sys_admin_menu_copy` VALUES ('59', '57', '部门管理', '/home/structures/list', '', '1', '0', '1', '39', 'Administrative', 'structures');
INSERT INTO `sys_admin_menu_copy` VALUES ('60', '57', '用户组管理', '/home/groups/list', '', '1', '0', '1', '47', 'Administrative', 'groups');
INSERT INTO `sys_admin_menu_copy` VALUES ('61', '52', '账户管理', '', '', '1', '0', '1', '62', 'Administrative', '');
INSERT INTO `sys_admin_menu_copy` VALUES ('62', '61', '账户列表', '/home/users/list', '', '1', '0', '1', '55', 'Administrative', 'users');

-- ----------------------------
-- Table structure for `sys_admin_post`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_post`;
CREATE TABLE `sys_admin_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '岗位名称',
  `remark` varchar(200) DEFAULT NULL COMMENT '岗位备注',
  `create_time` int(11) DEFAULT NULL COMMENT '数据创建时间',
  `status` tinyint(5) DEFAULT '1' COMMENT '状态1启用,0禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='岗位表';

-- ----------------------------
-- Records of sys_admin_post
-- ----------------------------
INSERT INTO `sys_admin_post` VALUES ('5', '后端开发工程师', '', '1484706862', '1');
INSERT INTO `sys_admin_post` VALUES ('6', '前端开发工程师', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('7', '设计师', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('11', '文案策划', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('12', '产品助理', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('15', '总经理', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('20', '项目经理', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('25', '职能', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('26', '项目助理', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('27', '测试工程师', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('28', '人事经理', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('29', 'CEO', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('30', '品牌策划', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('31', '前端研发工程师', '', '1484706863', '1');
INSERT INTO `sys_admin_post` VALUES ('32', '后端研发工程师', '', '1484706863', '1');

-- ----------------------------
-- Table structure for `sys_admin_rule`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_rule`;
CREATE TABLE `sys_admin_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT '' COMMENT '名称',
  `name` varchar(100) DEFAULT '' COMMENT '定义',
  `level` tinyint(5) DEFAULT NULL COMMENT '级别。1模块,2控制器,3操作',
  `pid` int(11) DEFAULT '0' COMMENT '父id，默认0',
  `status` tinyint(3) DEFAULT '1' COMMENT '状态，1启用，0禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin_rule
-- ----------------------------
INSERT INTO `sys_admin_rule` VALUES ('10', '系统基础功能', 'admin', '1', '0', '1');
INSERT INTO `sys_admin_rule` VALUES ('11', '权限规则', 'rules', '2', '10', '1');
INSERT INTO `sys_admin_rule` VALUES ('13', '规则列表', 'index', '3', '11', '1');
INSERT INTO `sys_admin_rule` VALUES ('14', '权限详情', 'read', '3', '11', '1');
INSERT INTO `sys_admin_rule` VALUES ('15', '编辑权限', 'update', '3', '11', '1');
INSERT INTO `sys_admin_rule` VALUES ('16', '删除权限', 'delete', '3', '11', '1');
INSERT INTO `sys_admin_rule` VALUES ('17', '添加权限', 'save', '3', '11', '1');
INSERT INTO `sys_admin_rule` VALUES ('18', '批量删除权限', 'deletes', '3', '11', '1');
INSERT INTO `sys_admin_rule` VALUES ('19', '批量启用/禁用权限', 'enables', '3', '11', '1');
INSERT INTO `sys_admin_rule` VALUES ('20', '菜单管理', 'menus', '2', '10', '1');
INSERT INTO `sys_admin_rule` VALUES ('21', '菜单列表', 'index', '3', '20', '1');
INSERT INTO `sys_admin_rule` VALUES ('22', '添加菜单', 'save', '3', '20', '1');
INSERT INTO `sys_admin_rule` VALUES ('23', '菜单详情', 'read', '3', '20', '1');
INSERT INTO `sys_admin_rule` VALUES ('24', '编辑菜单', 'update', '3', '20', '1');
INSERT INTO `sys_admin_rule` VALUES ('25', '删除菜单', 'delete', '3', '20', '1');
INSERT INTO `sys_admin_rule` VALUES ('26', '批量删除菜单', 'deletes', '3', '20', '1');
INSERT INTO `sys_admin_rule` VALUES ('27', '批量启用/禁用菜单', 'enables', '3', '20', '1');
INSERT INTO `sys_admin_rule` VALUES ('28', '系统管理', 'systemConfigs', '2', '10', '1');
INSERT INTO `sys_admin_rule` VALUES ('29', '修改系统配置', 'save', '3', '28', '1');
INSERT INTO `sys_admin_rule` VALUES ('30', '岗位管理', 'posts', '2', '10', '1');
INSERT INTO `sys_admin_rule` VALUES ('31', '岗位列表', 'index', '3', '30', '1');
INSERT INTO `sys_admin_rule` VALUES ('32', '岗位详情', 'read', '3', '30', '1');
INSERT INTO `sys_admin_rule` VALUES ('33', '编辑岗位', 'update', '3', '30', '1');
INSERT INTO `sys_admin_rule` VALUES ('34', '删除岗位', 'delete', '3', '30', '1');
INSERT INTO `sys_admin_rule` VALUES ('35', '添加岗位', 'save', '3', '30', '1');
INSERT INTO `sys_admin_rule` VALUES ('36', '批量删除岗位', 'deletes', '3', '30', '1');
INSERT INTO `sys_admin_rule` VALUES ('37', '批量启用/禁用岗位', 'enables', '3', '30', '1');
INSERT INTO `sys_admin_rule` VALUES ('38', '部门管理', 'structures', '2', '10', '1');
INSERT INTO `sys_admin_rule` VALUES ('39', '部门列表', 'index', '3', '38', '1');
INSERT INTO `sys_admin_rule` VALUES ('40', '部门详情', 'read', '3', '38', '1');
INSERT INTO `sys_admin_rule` VALUES ('41', '编辑部门', 'update', '3', '38', '1');
INSERT INTO `sys_admin_rule` VALUES ('42', '删除部门', 'delete', '3', '38', '1');
INSERT INTO `sys_admin_rule` VALUES ('43', '添加部门', 'save', '3', '38', '1');
INSERT INTO `sys_admin_rule` VALUES ('44', '批量删除部门', 'deletes', '3', '38', '1');
INSERT INTO `sys_admin_rule` VALUES ('45', '批量启用/禁用部门', 'enables', '3', '38', '1');
INSERT INTO `sys_admin_rule` VALUES ('46', '用户组管理', 'groups', '2', '10', '1');
INSERT INTO `sys_admin_rule` VALUES ('47', '用户组列表', 'index', '3', '46', '1');
INSERT INTO `sys_admin_rule` VALUES ('48', '用户组详情', 'read', '3', '46', '1');
INSERT INTO `sys_admin_rule` VALUES ('49', '编辑用户组', 'update', '3', '46', '1');
INSERT INTO `sys_admin_rule` VALUES ('50', '删除用户组', 'delete', '3', '46', '1');
INSERT INTO `sys_admin_rule` VALUES ('51', '添加用户组', 'save', '3', '46', '1');
INSERT INTO `sys_admin_rule` VALUES ('52', '批量删除用户组', 'deletes', '3', '46', '1');
INSERT INTO `sys_admin_rule` VALUES ('53', '批量启用/禁用用户组', 'enables', '3', '46', '1');
INSERT INTO `sys_admin_rule` VALUES ('54', '成员管理', 'users', '2', '10', '1');
INSERT INTO `sys_admin_rule` VALUES ('55', '成员列表', 'index', '3', '54', '1');
INSERT INTO `sys_admin_rule` VALUES ('56', '成员详情', 'read', '3', '54', '1');
INSERT INTO `sys_admin_rule` VALUES ('57', '删除成员', 'delete', '3', '54', '1');
INSERT INTO `sys_admin_rule` VALUES ('59', '管理菜单', 'Adminstrative', '2', '10', '1');
INSERT INTO `sys_admin_rule` VALUES ('61', '系统管理二级菜单', 'systemConfig', '1', '59', '1');
INSERT INTO `sys_admin_rule` VALUES ('62', '账户管理二级菜单', 'personnel', '3', '59', '1');
INSERT INTO `sys_admin_rule` VALUES ('63', '组织架构二级菜单', 'structures', '3', '59', '1');
INSERT INTO `sys_admin_rule` VALUES ('64', 'st基础能力', 'admin', '1', '0', '1');
INSERT INTO `sys_admin_rule` VALUES ('74', 'st管理菜单', 'stbom', '2', '64', '1');
INSERT INTO `sys_admin_rule` VALUES ('77', 'st账户管理2级菜单', 'personnel', '3', '74', '1');
INSERT INTO `sys_admin_rule` VALUES ('78', 'st组织架构2级菜单', 'structures', '3', '74', '1');
INSERT INTO `sys_admin_rule` VALUES ('79', 'st系统管理2级菜单', 'systemConfig', '1', '74', '1');
INSERT INTO `sys_admin_rule` VALUES ('80', 'st成员管理', 'users', '2', '64', '1');
INSERT INTO `sys_admin_rule` VALUES ('81', 'st成员列表', 'index', '3', '80', '1');
INSERT INTO `sys_admin_rule` VALUES ('82', 'st用户组管理', 'groups', '2', '64', '1');
INSERT INTO `sys_admin_rule` VALUES ('83', 'st用户组列表', 'index', '3', '82', '1');
INSERT INTO `sys_admin_rule` VALUES ('84', 'st系统管理', 'systemConfigs', '2', '64', '1');
INSERT INTO `sys_admin_rule` VALUES ('86', 'st菜单管理', 'menus', '2', '64', '1');
INSERT INTO `sys_admin_rule` VALUES ('87', 'st菜单列表', 'index', '3', '86', '1');
INSERT INTO `sys_admin_rule` VALUES ('89', 'xx管理', 'xxx', '1', '59', '1');
INSERT INTO `sys_admin_rule` VALUES ('90', 'xx列表', 'xx', '3', '59', '1');
INSERT INTO `sys_admin_rule` VALUES ('91', 'xx应收管理', 'receivable', '2', '64', '1');
INSERT INTO `sys_admin_rule` VALUES ('92', 'xx会计日', 'index', '3', '91', '1');

-- ----------------------------
-- Table structure for `sys_admin_structure`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_structure`;
CREATE TABLE `sys_admin_structure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT '',
  `pid` int(11) DEFAULT '0',
  `status` tinyint(3) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin_structure
-- ----------------------------
INSERT INTO `sys_admin_structure` VALUES ('1', 'xxxxx科技有限公司', '0', '1');
INSERT INTO `sys_admin_structure` VALUES ('5', '设计部', '1', '1');
INSERT INTO `sys_admin_structure` VALUES ('6', '职能部', '1', '1');
INSERT INTO `sys_admin_structure` VALUES ('37', '总经办', '1', '1');
INSERT INTO `sys_admin_structure` VALUES ('52', '项目部', '1', '1');
INSERT INTO `sys_admin_structure` VALUES ('53', '测试部', '1', '1');
INSERT INTO `sys_admin_structure` VALUES ('54', '开发部', '1', '1');
INSERT INTO `sys_admin_structure` VALUES ('55', '市场部', '1', '1');
INSERT INTO `sys_admin_structure` VALUES ('56', '研发部', '1', '1');
INSERT INTO `sys_admin_structure` VALUES ('57', '企业微信', '0', '1');
INSERT INTO `sys_admin_structure` VALUES ('58', 'st公司', '0', '1');
INSERT INTO `sys_admin_structure` VALUES ('59', 'st架构部', '58', '1');
INSERT INTO `sys_admin_structure` VALUES ('60', 'st开发部', '58', '1');

-- ----------------------------
-- Table structure for `sys_admin_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_user`;
CREATE TABLE `sys_admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) DEFAULT NULL COMMENT '管理后台账号',
  `password` varchar(100) DEFAULT NULL COMMENT '管理后台密码',
  `realname` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `structure_id` int(11) DEFAULT NULL COMMENT '部门',
  `post_id` int(11) DEFAULT NULL COMMENT '岗位',
  `status` tinyint(3) DEFAULT NULL COMMENT '状态,1启用0禁用',
  `remark` varchar(100) DEFAULT NULL COMMENT '用户备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin_user
-- ----------------------------
INSERT INTO `sys_admin_user` VALUES ('1', 'admin', '62f04a011fbb80030bb0a13701c20b41', '超级管理员', '1', '5', '1', '超级管理员', null, null);
INSERT INTO `sys_admin_user` VALUES ('3', 'aaaaa', 'e10adc3949ba59abbe56e057f20f883e', '用户A', '5', '20', '1', '用户A', null, null);
INSERT INTO `sys_admin_user` VALUES ('10', 'admin0', '62f04a011fbb80030bb0a13701c20b41', '超级管理员b', '1', '29', '1', '超级管理员', null, null);
INSERT INTO `sys_admin_user` VALUES ('12', 'zhangsan', '01d7f40760960e7bd9443513f22ab9af', 'zhangsan', '52', null, '1', 'zhangsan', null, null);
INSERT INTO `sys_admin_user` VALUES ('15', 'lisi', 'dc3a8f1670d65bea69b7b65048a0ac40', 'lisi', '60', null, '1', 'lisi', null, null);
INSERT INTO `sys_admin_user` VALUES ('16', 'zhangsan1', '75fa96bc88e1774ee4f693dcb06aefd2', 'zhangsan1', '59', null, null, 'zhangsan1', null, null);
INSERT INTO `sys_admin_user` VALUES ('17', 'gouri', '6cc9e809d4880b35b026dcd3b3c217eb', 'gouri', '60', null, null, 'gouri', null, null);

-- ----------------------------
-- Table structure for `sys_log_0`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_0`;
CREATE TABLE `sys_log_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` smallint(6) NOT NULL DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `service_id` varchar(32) DEFAULT NULL COMMENT '服务ID',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(500) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(10) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `time` mediumtext COMMENT '执行时间',
  `statu` smallint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `exception` longtext COMMENT '异常信息',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `t_sys_log_0_create_by` (`create_by`) USING BTREE,
  KEY `t_sys_log_0_request_uri` (`request_uri`) USING BTREE,
  KEY `t_sys_log_0_type` (`type`) USING BTREE,
  KEY `t_sys_log_0_create_date` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of sys_log_0
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_log_1`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_1`;
CREATE TABLE `sys_log_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` smallint(6) NOT NULL DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `service_id` varchar(32) DEFAULT NULL COMMENT '服务ID',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(500) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(10) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `time` mediumtext COMMENT '执行时间',
  `statu` smallint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `exception` longtext COMMENT '异常信息',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `t_sys_log_1_create_by` (`create_by`) USING BTREE,
  KEY `t_sys_log_1_request_uri` (`request_uri`) USING BTREE,
  KEY `t_sys_log_1_type` (`type`) USING BTREE,
  KEY `t_sys_log_1_create_date` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of sys_log_1
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_system_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_system_config`;
CREATE TABLE `sys_system_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '配置ID',
  `name` varchar(50) DEFAULT '',
  `value` varchar(100) DEFAULT '' COMMENT '配置值',
  `group` tinyint(4) unsigned DEFAULT '0' COMMENT '配置分组',
  `need_auth` tinyint(4) DEFAULT '1' COMMENT '1需要登录后才能获取，0不需要登录即可获取',
  PRIMARY KEY (`id`),
  UNIQUE KEY `参数名` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='【配置】系统配置表';

-- ----------------------------
-- Records of sys_system_config
-- ----------------------------
INSERT INTO `sys_system_config` VALUES ('1', 'SYSTEM_NAME', 'ST通用后台登录', '0', '1');
INSERT INTO `sys_system_config` VALUES ('2', 'SYSTEM_LOGO', 'uploads\\20170219\\d9fe7b784e1b1f406234b7b301e627e8.png', '0', '1');
INSERT INTO `sys_system_config` VALUES ('3', 'LOGIN_SESSION_VALID', '1644', '0', '1');
INSERT INTO `sys_system_config` VALUES ('4', 'IDENTIFYING_CODE', '0', '0', '1');

-- ----------------------------
-- Procedure structure for `aaaa`
-- ----------------------------
DROP PROCEDURE IF EXISTS `aaaa`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aaaa`(IN emp_id INT, OUT count_num INT )
    READS SQL DATA
BEGIN  
              SELECT  COUNT(*)  INTO  count_num  
              FROM  employee  
              WHERE  d_id=emp_id ;  
          END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `num_from_employee`
-- ----------------------------
DROP PROCEDURE IF EXISTS `num_from_employee`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `num_from_employee`(IN emp_id INT, OUT count_num INT )
    READS SQL DATA
BEGIN  
              SELECT  COUNT(*)  INTO  count_num  
              FROM  employee  
              WHERE  d_id=emp_id ;  
          END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sys_admin_access_pr`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sys_admin_access_pr`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_admin_access_pr`(IN emp_id INT, OUT count_num INT )
    READS SQL DATA
BEGIN  
              SELECT  COUNT(*)  INTO  count_num  
              FROM  sys_admin_access  
              WHERE  user_id=emp_id ;  
          END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `abc`
-- ----------------------------
DROP FUNCTION IF EXISTS `abc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `abc`(emp_id INT) RETURNS varchar(20) CHARSET utf8mb4
BEGIN  
              RETURN  (SELECT  name  
              FROM  sys_admin_access  
              WHERE  id=emp_id );  
          END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `abcd`
-- ----------------------------
DROP FUNCTION IF EXISTS `abcd`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `abcd`(emp_id INT) RETURNS varchar(20) CHARSET utf8mb4
BEGIN  
              RETURN  (SELECT  *  
              FROM  sys_admin_access  
              WHERE  id=emp_id );  
          END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `deleteById`
-- ----------------------------
DROP FUNCTION IF EXISTS `deleteById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `deleteById`(uid SMALLINT UNSIGNED) RETURNS varchar(20) CHARSET utf8mb4
BEGIN
DELETE FROM son WHERE id = uid;
RETURN (SELECT COUNT(id) FROM son);
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `findRole`
-- ----------------------------
DROP FUNCTION IF EXISTS `findRole`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `findRole`(targetStr varchar(2000),findStr varchar(2000)) RETURNS varchar(1000) CHARSET utf8mb4
BEGIN
	DECLARE strNum int;
	DECLARE lenIndex int DEFAULT 1;
	DECLARE cStr VARCHAR(50);
	DECLARE flag INT;  -- 标志位
	SET strNum=1+(length(targetStr) - length(replace(targetStr,',','')));
	WHILE lenIndex<=strNum   -- 从一开始循环
	DO
	set cStr=reverse(substring_index(reverse(substring_index(targetStr,',',lenIndex)),',',1));-- 这一步的含义请参考函数分解自己实一下，就明白了
	set flag=FIND_IN_SET(cStr,findStr);
	if (flag>0&&cStr!='') THEN
	RETURN flag;
	END IF;
	set lenIndex=lenIndex+1;
	END WHILE;
	RETURN 0;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `my_sum`
-- ----------------------------
DROP FUNCTION IF EXISTS `my_sum`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `my_sum`(x int) RETURNS int(11)
begin
    set @i = 1;
    set @sum = 0;
    while @i <= x do
        set @sum = @sum + @i;
        set @i = @i + 1;
    end while;
    return @sum;
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `my_sum1`
-- ----------------------------
DROP FUNCTION IF EXISTS `my_sum1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `my_sum1`(x int) RETURNS int(11)
begin
    set @i = 1;
    set @sum = 0;
    while @i <= x do
        set @sum = @sum + @i;
        set @i = @i + 1;
    end while;
    return @sum;
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `name_from_employee`
-- ----------------------------
DROP FUNCTION IF EXISTS `name_from_employee`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `name_from_employee`(emp_id INT ) RETURNS varchar(20) CHARSET utf8mb4
BEGIN  
              RETURN  (SELECT  name  
              FROM  employee  
              WHERE  num=emp_id );  
          END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `name_from_employee2`
-- ----------------------------
DROP FUNCTION IF EXISTS `name_from_employee2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `name_from_employee2`(emp_id INT ) RETURNS varchar(20) CHARSET utf8mb4
BEGIN  
              RETURN  (SELECT  name  
              FROM  employee  
              WHERE  num=emp_id );  
          END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `simpleFun`
-- ----------------------------
DROP FUNCTION IF EXISTS `simpleFun`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `simpleFun`() RETURNS varchar(20) CHARSET utf8mb4
RETURN "Hello World!"
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `sys_admin_access_fun1`
-- ----------------------------
DROP FUNCTION IF EXISTS `sys_admin_access_fun1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `sys_admin_access_fun1`(emp_id INT) RETURNS varchar(20) CHARSET utf8mb4
BEGIN  
              RETURN  (SELECT  group_id  
              FROM  sys_admin_access  
              WHERE  user_id=emp_id );  
          END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `sys_admin_access_pro1`
-- ----------------------------
DROP FUNCTION IF EXISTS `sys_admin_access_pro1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `sys_admin_access_pro1`(emp_id INT) RETURNS varchar(20) CHARSET utf8mb4
BEGIN  
              RETURN  (SELECT  *  
              FROM  sys_admin_access  
              WHERE  user_id=emp_id );  
          END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `_Navicat_Temp_Stored_Proc`
-- ----------------------------
DROP FUNCTION IF EXISTS `_Navicat_Temp_Stored_Proc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `_Navicat_Temp_Stored_Proc`() RETURNS int(11)
RETURN 0;
;;
DELIMITER ;
