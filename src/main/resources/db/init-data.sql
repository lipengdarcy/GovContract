INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (1, '', '流程管理', NULL, 1);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (2, '', '功能模块', NULL, 2);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (3, '', '配置管理', NULL, 3);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (4, '', '系统管理', NULL, 4);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (11, '', '待办任务', 1, 1);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (12, '', '流程实例', 1, 2);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (13, '', '历史任务', 1, 3);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (14, '', '流程定义', 1, 4);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (15, '', '委托授权', 1, 5);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (31, '', '数据字典', 3, 1);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (32, '', '表单管理', 3, 2);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (41, '', '用户管理', 4, 1);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (42, '', '部门管理', 4, 2);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (43, '', '角色管理', 4, 3);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (44, '', '权限管理', 4, 4);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (45, '', '资源管理', 4, 5);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU, ORDERBY) VALUES (46, '', '菜单管理', 4, 6);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (101, '待办任务', '/snaker/task/active', 11);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (102, '流程实例', '/snaker/flow/order', 12);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (103, '历史任务', '/snaker/task/history', 13);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (104, '流程定义', '/snaker/process/list', 14);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (105, '流程部署', '/snaker/process/deploy/**;/snaker/process/add/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (106, '委托授权', '/snaker/surrogate/list', 15);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (301, '字典查询', '/config/dictionary', 31);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (302, '字典查看', '/config/dictionary/view/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (303, '字典编辑', '/config/dictionary/update/**;/config/dictionary/save/**;/config/dictionary/add/**;/config/dictionary/edit/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (304, '字典删除', '/config/dictionary/delete/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (311, '表单查询', '/config/form', 32);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (312, '表单查看', '/config/form/view/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (313, '表单编辑', '/config/form/update/**;/config/form/save/**;/config/form/add/**;/config/form/edit/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (314, '表单删除', '/config/form/delete/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (401, '用户查询', '/security/user', 41);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (402, '部门查询', '/security/org', 42);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (403, '角色查询', '/security/role', 43);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (404, '权限查询', '/security/authority', 44);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (405, '资源查询', '/security/resource', 45);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (406, '菜单查询', '/security/menu', 46);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (411, '用户查看', '/security/user/view/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (412, '部门查看', '/security/org/view/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (413, '角色查看', '/security/role/view/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (414, '权限查看', '/security/authority/view/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (415, '资源查看', '/security/resource/view/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (416, '菜单查看', '/security/menu/view/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (421, '用户删除', '/security/user/delete/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (422, '部门删除', '/security/org/delete/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (423, '角色删除', '/security/role/delete/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (424, '权限删除', '/security/authority/delete/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (425, '资源删除', '/security/resource/delete/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (426, '菜单删除', '/security/menu/delete/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (431, '用户编辑', '/security/user/update/**;/security/user/save/**;/security/user/add/**;/security/user/edit/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (432, '部门编辑', '/security/org/update/**;/security/org/save/**;/security/org/add/**;/security/org/edit/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (433, '角色编辑', '/security/role/update/**;/security/role/save/**;/security/role/add/**;/security/role/edit/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (434, '权限编辑', '/security/authority/update/**;/security/authority/save/**;/security/authority/add/**;/security/authority/edit/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (435, '资源编辑', '/security/resource/update/**;/security/resource/save/**;/security/resource/add/**;/security/resource/edit/**', NULL);
INSERT INTO sec_resource (ID, NAME, SOURCE, MENU) VALUES (436, '菜单编辑', '/security/menu/update/**;/security/menu/save/**;/security/menu/add/**;/security/menu/edit/**', NULL);





INSERT INTO sec_role (ID, DESCRIPTION, NAME) VALUES (1, '系统管理员', 'Admin');
INSERT INTO sec_role (ID, DESCRIPTION, NAME) VALUES (2, '普通用户', 'General');




INSERT INTO sec_org (ID, ACTIVE, DESCRIPTION, FULLNAME, NAME, TYPE, PARENT_ORG) VALUES(200, NULL, NULL, NULL, 'XXX有限公司', NULL, NULL);

INSERT INTO sec_org (ID, ACTIVE, DESCRIPTION, FULLNAME, NAME, TYPE, PARENT_ORG) VALUES(2000, NULL, NULL, NULL, '行政部', NULL, 200);
INSERT INTO sec_org (ID, ACTIVE, DESCRIPTION, FULLNAME, NAME, TYPE, PARENT_ORG) VALUES(2001, NULL, NULL, NULL, '市场部', NULL, 200);
INSERT INTO sec_org (ID, ACTIVE, DESCRIPTION, FULLNAME, NAME, TYPE, PARENT_ORG) VALUES(2002, NULL, NULL, NULL, '研发部', NULL, 200);
INSERT INTO sec_org (ID, ACTIVE, DESCRIPTION, FULLNAME, NAME, TYPE, PARENT_ORG) VALUES(2003, NULL, NULL, NULL, '客服部', NULL, 200);

INSERT INTO sec_org (ID, ACTIVE, DESCRIPTION, FULLNAME, NAME, TYPE, PARENT_ORG) VALUES(200200, NULL, NULL, NULL, '测试组', NULL, 2002);
INSERT INTO sec_org (ID, ACTIVE, DESCRIPTION, FULLNAME, NAME, TYPE, PARENT_ORG) VALUES(200201, NULL, NULL, NULL, '质量组', NULL, 2002);
INSERT INTO sec_org (ID, ACTIVE, DESCRIPTION, FULLNAME, NAME, TYPE, PARENT_ORG) VALUES(200202, NULL, NULL, NULL, '研发组', NULL, 2002);
INSERT INTO sec_org (ID, ACTIVE, DESCRIPTION, FULLNAME, NAME, TYPE, PARENT_ORG) VALUES(200203, NULL, NULL, NULL, '需求组', NULL, 2002);
INSERT INTO sec_org (ID, ACTIVE, DESCRIPTION, FULLNAME, NAME, TYPE, PARENT_ORG) VALUES(200204, NULL, NULL, NULL, 'UI组', NULL, 2002);

INSERT INTO sec_user (ID, ADDRESS, AGE, EMAIL, ENABLED, FULLNAME, PASSWORD, SEX, TYPE, USERNAME, ORG, SALT)
VALUES (1, '', NULL, '', '1', '系统管理员', 'f9e1a0299c2570eb5942fbbda0b2a8ceb2ef9769', '1', NULL, 'admin', 200, 'e97e0cea2389225f');
INSERT INTO sec_user (ID, ADDRESS, AGE, EMAIL, ENABLED, FULLNAME, PASSWORD, SEX, TYPE, USERNAME, ORG, SALT)
VALUES (2, '', NULL, '', '1', 'test', 'f9e1a0299c2570eb5942fbbda0b2a8ceb2ef9769', '1', NULL, 'test', 200200, 'e97e0cea2389225f');
INSERT INTO sec_user (ID, ADDRESS, AGE, EMAIL, ENABLED, FULLNAME, PASSWORD, SEX, TYPE, USERNAME, ORG, SALT)
VALUES (3, '', NULL, '', '1', 'snaker', 'f9e1a0299c2570eb5942fbbda0b2a8ceb2ef9769', '1', NULL, 'snaker', 200202, 'e97e0cea2389225f');




-- SELECT * FROM witsafe.sec_resource;
SET FOREIGN_KEY_CHECKS = 0; 
delete from sec_resource;
delete from sec_permission;
delete from sec_rolepermission;

SET FOREIGN_KEY_CHECKS = 1; 

-- 资源初始化
insert into sec_resource(ID, pid, resourceCode, resourceName, link) values
(100, NULL, 'PROCESSMANAGE', '工作流管理', NULL),
(101, 100, 'WF_ACTIVETASK', '待办任务', '/snaker/task/active'),
(102, 100, 'WF_ORDER', '流程实例', '/snaker/flow/order'),
(103, 100, 'WF_HISTORYTASK', '历史任务', '/snaker/task/history'),
(104, 100, 'WF_PROCESSLIST', '流程定义', '/snaker/process/list'),
(105, 100, 'WF_PROCESSDEPLOY', '流程部署', '/snaker/process/deploy/**'),
(107, 100, 'WF_PROCESSADD', '流程增加', '/snaker/process/add/**'),
(106, 100, 'WF_SURROGATE', '委托授权', '/snaker/surrogate/list');

-- 权限初始化
insert into sec_permission(ID, code, name, resourceId) values
(100,  'PROCESSMANAGE', '工作流管理', 100),
(101,  'WF_ACTIVETASK', '待办任务', 101),
(102,  'WF_ORDER', '流程实例', 102),
(103,  'WF_HISTORYTASK', '历史任务', 103),
(104,  'WF_PROCESSLIST', '流程定义', 104),
(105,  'WF_PROCESSDEPLOY', '流程部署', 105),
(106,  'WF_SURROGATE', '委托授权', 106),
(107,  'WF_PROCESSADD', '流程增加', 107);

-- 角色权限初始化
insert into sec_rolepermission(ID, rid, permissionId) values
(101, 1,  101),
(102, 1,  102),
(103, 1,  103),
(104, 1,  104),
(105, 1,  105),
(106, 1,  106),
(107, 1,  107);


insert into sec_userpermission(ID, uid, permissionId) values(1, 2, 101)