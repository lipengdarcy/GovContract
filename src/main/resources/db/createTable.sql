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

