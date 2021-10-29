
CREATE DATABASE IF NOT EXISTS projectdb ;
USE projectdb;

CREATE TABLE if not exists labor_service_unit_info (
  `labor_service_unit_id` int(32) NOT NULL AUTO_INCREMENT,
  `legal_person` varchar(15) DEFAULT NULL,
  `company_type` int(1) NOT NULL,
  `company` varchar(32) DEFAULT NULL,
  `share_proportion` float DEFAULT NULL,
  `contract_number` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`labor_service_unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;





CREATE TABLE if not exists mechanical_unit_info (
  `mechanical_unit_id` int(32) NOT NULL AUTO_INCREMENT,
  `legal_person` varchar(15) DEFAULT NULL,
  `company` varchar(32) DEFAULT NULL,
  `share_proportion` float DEFAULT NULL,
  `contract_number` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`mechanical_unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE if not exists  sys_permission (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `permission_code` varchar(32) DEFAULT NULL COMMENT '权限code',
  `permission_name` varchar(32) DEFAULT NULL COMMENT '权限名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限表';







CREATE TABLE if not exists sys_request_path (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `url` varchar(64) NOT NULL COMMENT '请求路径',
  `description` varchar(128) DEFAULT NULL COMMENT '路径描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='请求路径';





CREATE TABLE if not exists sys_request_path_permission_relation (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `url_id` int(11) DEFAULT NULL COMMENT '请求路径id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='路径权限关联表';





CREATE TABLE if not exists sys_role (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名',
  `role_description` varchar(64) DEFAULT NULL COMMENT '角色说明',
  `role_code` varchar(64) DEFAULT NULL COMMENT '角色码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色表';





CREATE TABLE if not exists sys_role_permission_relation (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联关系表';




CREATE TABLE if not exists sys_user (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) NOT NULL COMMENT '账号',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `last_login_time` datetime DEFAULT NULL COMMENT '上一次登录时间',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '账号是否可用。默认为1（可用）',
  `not_expired` tinyint(1) DEFAULT '1' COMMENT '是否过期。默认为1（没有过期）',
  `account_not_locked` tinyint(1) DEFAULT '1' COMMENT '账号是否锁定。默认为1（没有锁定）',
  `credentials_not_expired` tinyint(1) DEFAULT '1' COMMENT '证书（密码）是否过期。默认为1（没有过期）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';






CREATE TABLE if not exists sys_user_role_relation (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色关联关系表';

