SET FOREIGN_KEY_CHECKS = 0; 


DROP TABLE IF EXISTS sys_param;
CREATE TABLE sys_param (
    id INT NOT NULL AUTO_INCREMENT,
    paramTypeCode VARCHAR(100) DEFAULT NULL COMMENT '参数类型编码',
    paramTypeName VARCHAR(100) DEFAULT NULL COMMENT '参数类型名称',
    paramFatherType VARCHAR(100) DEFAULT NULL COMMENT '参数上级类型',
    paramCode VARCHAR(100) DEFAULT NULL COMMENT '参数编码',
    paramName VARCHAR(500) DEFAULT NULL COMMENT '参数名称',
    paramValue VARCHAR(100) DEFAULT NULL COMMENT '参数值',
    publish_date DATE DEFAULT NULL COMMENT '发布日期',      
    isValid TINYINT(1) DEFAULT 1 COMMENT '是否有效，1：有效，0：无效',
    PRIMARY KEY (id)
)  ENGINE=MYISAM DEFAULT CHARACTER SET=UTF8 COMMENT '系统参数表';

INSERT INTO `witsafe`.`sys_param` (`id`, `paramTypeCode`, `paramTypeName`, `paramCode`, `paramName`, 
`paramValue`, `isValid`) VALUES ('1', 'isvalid', '是否有效', 'valid', '有效', '1', '1');

INSERT INTO `witsafe`.`sys_param` (`id`, `paramTypeCode`, `paramTypeName`, `paramCode`, `paramName`, 
`paramValue`, `isValid`) VALUES ('2', 'isvalid', '是否有效', 'notvalid', '无效', '0', '1');



DROP TABLE IF EXISTS account;
CREATE TABLE account (
    id INT NOT NULL AUTO_INCREMENT,
    orgid INT NOT NULL COMMENT '组织id',
    name VARCHAR(200) NOT NULL COMMENT '用户名',
    password VARCHAR(200) DEFAULT NULL COMMENT '密码',
    realname VARCHAR(200) DEFAULT NULL COMMENT '真实姓名',
    phone VARCHAR(20) DEFAULT NULL COMMENT '电话',
    mobile VARCHAR(11) DEFAULT NULL COMMENT '手机',
    PRIMARY KEY (id)
)  ENGINE=MYISAM DEFAULT CHARACTER SET=UTF8 COMMENT '用户账号';

DROP TABLE IF EXISTS organization;
CREATE TABLE organization (
    id INT NOT NULL AUTO_INCREMENT,
    pid INT NOT NULL COMMENT '上级id',
    name VARCHAR(200) DEFAULT NULL COMMENT '组织名称',
    PRIMARY KEY (id)
)  ENGINE=MYISAM DEFAULT CHARACTER SET=UTF8 COMMENT '组织机构';


DROP TABLE IF EXISTS nationStandard;
CREATE TABLE nationStandard (
    id INT NOT NULL AUTO_INCREMENT,
    standardNo VARCHAR(500) DEFAULT NULL COMMENT '标准号',
    name_ch VARCHAR(500) DEFAULT NULL COMMENT '中文题名',
    name_en VARCHAR(500) DEFAULT NULL COMMENT '英文题名',
    publish_date DATE DEFAULT NULL COMMENT '发布日期',
    effect_date DATE DEFAULT NULL COMMENT '实施日期',
    valid_range TEXT DEFAULT NULL COMMENT '适用范围',
    standardNo_replace TEXT DEFAULT NULL COMMENT '代替标准号',
    name_replace VARCHAR(500) DEFAULT NULL COMMENT '代替标准号名称',
    type_ch VARCHAR(500) DEFAULT NULL COMMENT '中国标准分类',
    type_iso VARCHAR(500) DEFAULT NULL COMMENT '国际标准分类',
    publisher VARCHAR(500) DEFAULT NULL COMMENT '发布部门',
    PRIMARY KEY (id)
)  ENGINE=MYISAM DEFAULT CHARACTER SET=UTF8 COMMENT '环境卫生国家标准文献';

-- snaker工作流相关表 开始
CREATE TABLE wf_process (
    id                VARCHAR(32) PRIMARY KEY NOT NULL comment '主键ID',
    name              VARCHAR(100) comment '流程名称',
    display_Name      VARCHAR(200) comment '流程显示名称',
    type              VARCHAR(100) comment '流程类型',
    instance_Url      VARCHAR(200) comment '实例url',
    state             TINYINT(1) comment '流程是否可用',
    content           LONGBLOB comment '流程模型定义',
    version           INT(2) comment '版本',
    create_Time       VARCHAR(50) comment '创建时间',
    creator           VARCHAR(50) comment '创建人'
)comment='流程定义表';

CREATE TABLE wf_order (
    id                VARCHAR(32) NOT NULL PRIMARY KEY comment '主键ID',
    parent_Id         VARCHAR(32) comment '父流程ID',
    process_Id        VARCHAR(32) NOT NULL comment '流程定义ID',
    creator           VARCHAR(100) comment '发起人',
    create_Time       VARCHAR(50) NOT NULL comment '发起时间',
    expire_Time       VARCHAR(50) comment '期望完成时间',
    last_Update_Time  VARCHAR(50) comment '上次更新时间',
    last_Updator      VARCHAR(100) comment '上次更新人',
    priority          TINYINT(1) comment '优先级',
    parent_Node_Name  VARCHAR(100) comment '父流程依赖的节点名称',
    order_No          VARCHAR(100) comment '流程实例编号',
    variable          VARCHAR(2000) comment '附属变量json存储',
    version           INT(3) comment '版本'
)comment='流程实例表';

CREATE TABLE wf_task (
    id                VARCHAR(32) NOT NULL PRIMARY KEY comment '主键ID',
    order_Id          VARCHAR(32) NOT NULL comment '流程实例ID',
    task_Name         VARCHAR(100) NOT NULL comment '任务名称',
    display_Name      VARCHAR(200) NOT NULL comment '任务显示名称',
    task_Type         TINYINT(1) NOT NULL comment '任务类型',
    perform_Type      TINYINT(1) comment '参与类型',
    operator          VARCHAR(100) comment '任务处理人',
    create_Time       VARCHAR(50) comment '任务创建时间',
    finish_Time       VARCHAR(50) comment '任务完成时间',
    expire_Time       VARCHAR(50) comment '任务期望完成时间',
    action_Url        VARCHAR(200) comment '任务处理的url',
    parent_Task_Id    VARCHAR(100) comment '父任务ID',
    variable          VARCHAR(2000) comment '附属变量json存储',
    version           TINYINT(1) comment '版本'
)comment='任务表';

CREATE TABLE wf_task_actor (
    task_Id           VARCHAR(32) not null comment '任务ID',
    actor_Id          VARCHAR(100) not null comment '参与者ID'
)comment='任务参与者表';

create table wf_hist_order (
    id                VARCHAR(32) not null primary key comment '主键ID',
    process_Id        VARCHAR(32) not null comment '流程定义ID',
    order_State       TINYINT(1) not null comment '状态',
    creator           VARCHAR(100) comment '发起人',
    create_Time       VARCHAR(50) not null comment '发起时间',
    end_Time          VARCHAR(50) comment '完成时间',
    expire_Time       VARCHAR(50) comment '期望完成时间',
    priority          TINYINT(1) comment '优先级',
    parent_Id         VARCHAR(32) comment '父流程ID',
    order_No          VARCHAR(100) comment '流程实例编号',
    variable          VARCHAR(2000) comment '附属变量json存储'
)comment='历史流程实例表';

create table wf_hist_task (
    id                VARCHAR(32) not null primary key comment '主键ID',
    order_Id          VARCHAR(32) not null comment '流程实例ID',
    task_Name         VARCHAR(100) not null comment '任务名称',
    display_Name      VARCHAR(200) not null comment '任务显示名称',
    task_Type         TINYINT(1) not null comment '任务类型',
    perform_Type      TINYINT(1) comment '参与类型',
    task_State        TINYINT(1) not null comment '任务状态',
    operator          VARCHAR(100) comment '任务处理人',
    create_Time       VARCHAR(50) not null comment '任务创建时间',
    finish_Time       VARCHAR(50) comment '任务完成时间',
    expire_Time       VARCHAR(50) comment '任务期望完成时间',
    action_Url        VARCHAR(200) comment '任务处理url',
    parent_Task_Id    VARCHAR(32) comment '父任务ID',
    variable          VARCHAR(2000) comment '附属变量json存储'
)comment='历史任务表';

create table wf_hist_task_actor (
    task_Id           VARCHAR(32) not null comment '任务ID',
    actor_Id          VARCHAR(100) not null comment '参与者ID'
)comment='历史任务参与者表';

create table wf_surrogate (
    id                VARCHAR(100) PRIMARY KEY NOT NULL COMMENT '主键ID',
    process_Name       VARCHAR(100) COMMENT '流程名称',
    operator          VARCHAR(100) COMMENT '授权人',
    surrogate         VARCHAR(100) COMMENT '代理人',
    odate             VARCHAR(64) COMMENT '操作时间',
    sdate             VARCHAR(64) COMMENT '开始时间',
    edate             VARCHAR(64) COMMENT '结束时间',
    state             TINYINT(1) COMMENT '状态'
)COMMENT='委托代理表';
create index IDX_SURROGATE_OPERATOR on wf_surrogate (operator);

create table wf_cc_order (
    order_Id        varchar(32) COMMENT '流程实例ID',
    actor_Id        varchar(100) COMMENT '参与者ID',
    status          TINYINT(1)  COMMENT '状态',
    creator         varchar(50) COMMENT '发起人',
    create_Time      varchar(50) comment '创建时间',
    finish_Time      varchar(50) comment '完成时间'
)comment='抄送实例表';
create index IDX_CCORDER_ORDER on wf_cc_order (order_Id);

create index IDX_PROCESS_NAME on wf_process (name);
create index IDX_ORDER_PROCESSID on wf_order (process_Id);
create index IDX_ORDER_NO on wf_order (order_No);
create index IDX_TASK_ORDER on wf_task (order_Id);
create index IDX_TASK_TASKNAME on wf_task (task_Name);
create index IDX_TASK_PARENTTASK on wf_task (parent_Task_Id);
create index IDX_TASKACTOR_TASK on wf_task_actor (task_Id);
create index IDX_HIST_ORDER_PROCESSID on wf_hist_order (process_Id);
create index IDX_HIST_ORDER_NO on wf_hist_order (order_No);
create index IDX_HIST_TASK_ORDER on wf_hist_task (order_Id);
create index IDX_HIST_TASK_TASKNAME on wf_hist_task (task_Name);
create index IDX_HIST_TASK_PARENTTASK on wf_hist_task (parent_Task_Id);
create index IDX_HIST_TASKACTOR_TASK on wf_hist_task_actor (task_Id);

alter table wf_task_actor
  add constraint FK_TASK_ACTOR_TASKID foreign key (task_Id)
  references wf_task (id);
alter table wf_task
  add constraint FK_TASK_ORDERID foreign key (order_Id)
  references wf_order (id);
alter table wf_order
  add constraint FK_ORDER_PARENTID foreign key (parent_Id)
  references wf_order (id);
alter table wf_order
  add constraint FK_ORDER_PROCESSID foreign key (process_Id)
  references wf_process (id);
alter table wf_hist_task_actor
  add constraint FK_HIST_TASKACTOR foreign key (task_Id)
  references wf_hist_task (id);
alter table wf_hist_task
  add constraint FK_HIST_TASK_ORDERID foreign key (order_Id)
  references wf_hist_order (id);
alter table wf_hist_order
  add constraint FK_HIST_ORDER_PARENTID foreign key (parent_Id)
  references wf_hist_order (id);
alter table wf_hist_order
  add constraint FK_HIST_ORDER_PROCESSID foreign key (process_Id)
  references wf_process (id);
  
  
CREATE TABLE sec_menu (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(500) DEFAULT NULL,
  name VARCHAR(200) NOT NULL,
  parent_menu INT DEFAULT NULL,
  orderby INT DEFAULT 0
);

CREATE TABLE sec_resource (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL,
  source VARCHAR(200) DEFAULT NULL,
  menu INT DEFAULT NULL
);
ALTER TABLE SEC_RESOURCE ADD UNIQUE (NAME);
ALTER TABLE SEC_RESOURCE ADD CONSTRAINT FK_RESOURCE_MENU FOREIGN KEY (MENU) REFERENCES SEC_MENU (ID);

CREATE TABLE sec_authority (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(500) DEFAULT NULL,
  name VARCHAR(200) NOT NULL
);
ALTER TABLE SEC_AUTHORITY ADD UNIQUE (NAME);

CREATE TABLE sec_authority_resource (
  authority_id INT NOT NULL,
  resource_id INT NOT NULL
);
ALTER TABLE SEC_AUTHORITY_RESOURCE ADD CONSTRAINT FK_AUTHORITY_RESOURCE1 FOREIGN KEY (AUTHORITY_ID) REFERENCES SEC_AUTHORITY (ID);
ALTER TABLE SEC_AUTHORITY_RESOURCE ADD CONSTRAINT FK_AUTHORITY_RESOURCE2 FOREIGN KEY (RESOURCE_ID) REFERENCES SEC_RESOURCE (ID);

CREATE TABLE sec_role (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(500) DEFAULT NULL,
  name VARCHAR(200) NOT NULL
);
ALTER TABLE SEC_ROLE ADD UNIQUE (NAME);

CREATE TABLE sec_role_authority (
  role_id INT NOT NULL,
  authority_id INT NOT NULL
);
ALTER TABLE SEC_ROLE_AUTHORITY ADD CONSTRAINT FK_ROLE_AUTHORITY1 FOREIGN KEY (AUTHORITY_ID) REFERENCES SEC_AUTHORITY (ID);
ALTER TABLE SEC_ROLE_AUTHORITY ADD CONSTRAINT FK_ROLE_AUTHORITY2 FOREIGN KEY (ROLE_ID) REFERENCES SEC_ROLE (ID);

CREATE TABLE sec_org (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  active VARCHAR(255) DEFAULT NULL,
  description VARCHAR(500) DEFAULT NULL,
  fullname VARCHAR(200) DEFAULT NULL,
  name VARCHAR(200) NOT NULL,
  type VARCHAR(200) DEFAULT NULL,
  parent_org INT DEFAULT NULL
);
ALTER TABLE SEC_ORG ADD CONSTRAINT FK_ORG_PARENT FOREIGN KEY (PARENT_ORG) REFERENCES SEC_ORG (ID);

CREATE TABLE sec_user (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  address VARCHAR(200) DEFAULT NULL,
  age INT(11) DEFAULT NULL,
  email VARCHAR(100) DEFAULT NULL,
  enabled VARCHAR(255) DEFAULT NULL,
  fullname VARCHAR(100) DEFAULT NULL,
  password VARCHAR(50) DEFAULT NULL,
  plainPassword VARCHAR(50) DEFAULT NULL,
  salt VARCHAR(255) DEFAULT NULL,
  sex VARCHAR(255) DEFAULT NULL,
  type INT(11) DEFAULT NULL,
  username VARCHAR(50) NOT NULL,
  org INT DEFAULT NULL
);
ALTER TABLE SEC_USER ADD UNIQUE (USERNAME);
ALTER TABLE SEC_USER ADD CONSTRAINT FK_USER_ORG FOREIGN KEY (ORG) REFERENCES SEC_ORG (ID);

CREATE TABLE sec_role_user (
  user_id INT NOT NULL,
  role_id INT NOT NULL
);
ALTER TABLE SEC_ROLE_USER ADD CONSTRAINT FK_ROLE_USER1 FOREIGN KEY (USER_ID) REFERENCES SEC_USER (ID);
ALTER TABLE SEC_ROLE_USER ADD CONSTRAINT FK_ROLE_USER2 FOREIGN KEY (ROLE_ID) REFERENCES SEC_ROLE (ID);

CREATE TABLE sec_user_authority (
  user_id INT NOT NULL,
  authority_id INT NOT NULL
);
ALTER TABLE SEC_USER_AUTHORITY ADD CONSTRAINT FK_USER_AUTHORITY1 FOREIGN KEY (AUTHORITY_ID) REFERENCES SEC_AUTHORITY (ID);
ALTER TABLE SEC_USER_AUTHORITY ADD CONSTRAINT FK_USER_AUTHORITY2 FOREIGN KEY (USER_ID) REFERENCES SEC_USER (ID);

CREATE TABLE conf_dictionary (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  cn_name VARCHAR(200) NOT NULL,
  description VARCHAR(500) DEFAULT NULL,
  name VARCHAR(200) NOT NULL
);
ALTER TABLE CONF_DICTIONARY ADD UNIQUE (NAME);

CREATE TABLE conf_dictitem (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  code VARCHAR(50) DEFAULT NULL,
  description VARCHAR(500) DEFAULT NULL,
  name VARCHAR(200) NOT NULL,
  orderby INT(11) DEFAULT NULL,
  dictionary INT DEFAULT NULL
);
ALTER TABLE CONF_DICTITEM ADD UNIQUE (NAME);
ALTER TABLE CONF_DICTITEM ADD CONSTRAINT FK_DICTITEM_DICTIONARY FOREIGN KEY (DICTIONARY) REFERENCES CONF_DICTIONARY (ID);

CREATE TABLE df_form (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL,
  display_name VARCHAR(200) DEFAULT NULL,
  type VARCHAR(50) DEFAULT NULL,
  creator VARCHAR(50) DEFAULT NULL,
  create_time VARCHAR(50) DEFAULT NULL,
  original_html TEXT,
  parse_html TEXT,
  field_num INT DEFAULT 0
);
ALTER TABLE DF_FORM ADD UNIQUE (NAME);

CREATE TABLE df_field (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL,
  plugins VARCHAR(200) DEFAULT NULL,
  title VARCHAR(50) DEFAULT NULL,
  type  VARCHAR(50) DEFAULT NULL,
  flow  VARCHAR(10) DEFAULT NULL,
  table_name VARCHAR(50) DEFAULT NULL,
  form_id INT NOT NULL
);

CREATE TABLE flow_approval (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  operator VARCHAR(50) NOT NULL,
  operate_time VARCHAR(50),
  result VARCHAR(50),
  description VARCHAR(500) DEFAULT NULL,
  order_id VARCHAR(50),
  task_id VARCHAR(50),
  task_name VARCHAR(100)
);

CREATE TABLE flow_borrow (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  operator VARCHAR(50) NOT NULL,
  description VARCHAR(500) DEFAULT NULL,
  amount DOUBLE,
  operate_time VARCHAR(50),
  repayment_date VARCHAR(50),
  order_id VARCHAR(50)
);

-- snaker工作流相关表 结束

-- 删除完成后设置 
SET FOREIGN_KEY_CHECKS = 1; 


/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/11/12 10:57:42                          */
/*==============================================================*/


drop table if exists sec_Permission;

drop table if exists sec_Resource;

drop table if exists sec_Role;

drop table if exists sec_RoleGroup;

drop table if exists sec_RolePermission;

drop table if exists sec_UserPermission;

drop table if exists sec_UserPermissionJob;

drop table if exists sec_UserRole;

/*==============================================================*/
/* Table: sec_Permission                                        */
/*==============================================================*/
create table sec_Permission
(
   ID                   int not null comment 'ID',
   code                 varchar(100) comment '权限编码',
   name                 varchar(100) comment '权限名称',
   resourceId           int comment '资源id',
   description          longtext comment '权限描述',
   primary key (ID)
);

alter table sec_Permission comment '权限';

/*==============================================================*/
/* Table: sec_Resource                                          */
/*==============================================================*/
create table sec_Resource
(
   ID                   int not null comment 'ID',
   pid                  int comment '资源上级id',
   resourceCode         varchar(100) comment '资源编码',
   resourceName         varchar(100) comment '资源名称',
   link                 varchar(200) comment '资源链接',
   description          longtext comment '资源描述',
   `order`              int comment '排序',
   isMenu               tinyint comment '是否菜单',
   menuName             varchar(100) comment '菜单名称',
   isActive             tinyint comment '是否可用',
   primary key (ID)
);

alter table sec_Resource comment '资源';

/*==============================================================*/
/* Table: sec_Role                                              */
/*==============================================================*/
create table sec_Role
(
   ID                   int not null comment 'ID',
   groupId              int comment '角色组id',
   name                 varchar(100) comment '角色名称',
   description          varchar(1000) comment '角色描述',
   isActive             tinyint comment '是否可用',
   primary key (ID)
);

alter table sec_Role comment '角色';

/*==============================================================*/
/* Table: sec_RoleGroup                                         */
/*==============================================================*/
create table sec_RoleGroup
(
   ID                   int not null comment 'ID',
   name                 varchar(100) comment '角色组名称',
   isActive             tinyint comment '是否可用',
   primary key (ID)
);

alter table sec_RoleGroup comment '角色组';

/*==============================================================*/
/* Table: sec_RolePermission                                    */
/*==============================================================*/
create table sec_RolePermission
(
   ID                   int not null comment 'ID',
   rid                  int comment '角色id',
   permissionId         int comment '权限id',
   isActive             tinyint comment '是否可用',
   primary key (ID)
);

alter table sec_RolePermission comment '角色权限';

/*==============================================================*/
/* Table: sec_UserPermission                                    */
/*==============================================================*/
create table sec_UserPermission
(
   ID                   int comment 'ID',
   uid                 int comment '用户id',
   permissionId         int comment '权限id',
   isActive             tinyint comment '是否可用'
);

alter table sec_UserPermission comment '用户权限';

/*==============================================================*/
/* Table: sec_UserPermissionJob                                 */
/*==============================================================*/
create table sec_UserPermissionJob
(
   ID                   int not null comment 'ID',
   userPermissionId     int comment '用户权限id',
   createTime           datetime comment '创建时间',
   expireTime           datetime comment '到期时间',
   updateTime           datetime comment '执行时间',
   status               tinyint comment '状态',
   primary key (ID)
);

alter table sec_UserPermissionJob comment '针对购买一定时限的企业用户，定时更新该用户的有效字段，如一个月后，该用户的状态由有效变为无效，该工作由系统job自动执行';

/*==============================================================*/
/* Table: sec_UserRole                                          */
/*==============================================================*/
create table sec_UserRole
(
   ID                   int not null comment 'ID',
   uid                  int comment '用户id',
   rid                  int comment '角色id',
   isActive             tinyint comment '是否可用',
   primary key (ID)
);

alter table sec_UserRole comment '用户角色';

alter table sec_Permission add constraint FK_R_6 foreign key (resourceId)
      references sec_Resource (ID) on delete restrict on update restrict;

alter table sec_Role add constraint FK_R_1 foreign key (groupId)
      references sec_RoleGroup (ID) on delete restrict on update restrict;

alter table sec_RolePermission add constraint FK_R_8 foreign key (rid)
      references sec_Role (ID) on delete restrict on update restrict;

alter table sec_RolePermission add constraint FK_R_9 foreign key (permissionId)
      references sec_Permission (ID) on delete restrict on update restrict;

alter table sec_UserPermission add constraint FK_R_4 foreign key (permissionId)
      references sec_Permission (ID) on delete restrict on update restrict;

alter table sec_UserPermissionJob add constraint FK_R_2 foreign key (userPermissionId)
      references sec_UserPermission (ID) on delete restrict on update restrict;

alter table sec_UserRole add constraint FK_R_3 foreign key (rid)
      references sec_Role (ID) on delete restrict on update restrict;

