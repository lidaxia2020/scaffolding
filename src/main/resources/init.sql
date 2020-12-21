CREATE TABLE sys_user (
	id BIGINT (20) NOT NULL auto_increment COMMENT '用户ID',
	dept_id BIGINT (20) DEFAULT NULL COMMENT '部门ID',
	user_name VARCHAR (30) NOT NULL COMMENT '用户账号',
	nick_name VARCHAR (30) NOT NULL COMMENT '用户昵称',
	user_type VARCHAR (2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
	email VARCHAR (50) DEFAULT '' COMMENT '用户邮箱',
	phone VARCHAR (20) DEFAULT '' COMMENT '手机号码',
	sex CHAR (1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
	avatar VARCHAR (100) DEFAULT '' COMMENT '头像地址',
	password VARCHAR (100) DEFAULT '' COMMENT '密码',
	status CHAR (1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
	del_flag CHAR (1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
	login_ip VARCHAR (50) DEFAULT '' COMMENT '最后登陆IP',
	login_date datetime COMMENT '最后登陆时间',
	create_by VARCHAR (64) DEFAULT '' COMMENT '创建者',
	create_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_by VARCHAR (64) DEFAULT '' COMMENT '更新者',
	update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	remark VARCHAR (500) DEFAULT NULL COMMENT '备注',
	PRIMARY KEY (id)
) ENGINE = INNODB auto_increment = 1 COMMENT = '用户信息表';

INSERT INTO sys_user (user_name,nick_name,email,phone,`password`,login_date)
	VALUE
("1","admin","123@qq.com","13122221111","$2a$10$XDw9GvU5x8jBbCtiwxnwjekb3bW/un6L5n41Mbc.WqdtH28WYLKPe",NOW()),
("1","admin1","123@qq.com","13122221111","$2a$10$XDw9GvU5x8jBbCtiwxnwjekb3bW/un6L5n41Mbc.WqdtH28WYLKPe",NOW());

CREATE TABLE sys_user_role (
	user_id BIGINT (20) NOT NULL COMMENT '用户ID',
	role_id BIGINT (20) NOT NULL COMMENT '角色ID',
	PRIMARY KEY (user_id, role_id)
) ENGINE = INNODB COMMENT = '用户和角色关联表';

CREATE TABLE sys_role (
	id BIGINT (20) NOT NULL auto_increment COMMENT '角色ID',
	role_name VARCHAR (30) NOT NULL COMMENT '角色名称',
	role_sort INT (4) NOT NULL COMMENT '显示顺序',
	status CHAR (1) NOT NULL COMMENT '角色状态（0正常 1停用）',
	del_flag CHAR (1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
	create_by VARCHAR (64) DEFAULT '' COMMENT '创建者',
	create_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_by VARCHAR (64) DEFAULT '' COMMENT '更新者',
	update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	remark VARCHAR (500) DEFAULT NULL COMMENT '备注',
	PRIMARY KEY (id)
) ENGINE = INNODB auto_increment = 1 COMMENT = '角色信息表';

insert into sys_role(id,role_name,status,del_flag)
value

CREATE TABLE sys_menu (
	id BIGINT (20) NOT NULL auto_increment COMMENT '菜单ID',
	menu_name VARCHAR (50) NOT NULL COMMENT '菜单名称',
	parent_id BIGINT (20) DEFAULT 0 COMMENT '父菜单ID',
	order_num INT (4) DEFAULT 0 COMMENT '显示顺序',
	path VARCHAR (200) DEFAULT '' COMMENT '路由地址',
	component VARCHAR (255) DEFAULT NULL COMMENT '组件路径',
	is_frame INT (1) DEFAULT 1 COMMENT '是否为外链（0是 1否）',
	menu_type CHAR (1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
	visible CHAR (1) DEFAULT 0 COMMENT '菜单状态（0显示 1隐藏）',
	icon VARCHAR (100) DEFAULT '#' COMMENT '菜单图标',
	create_by VARCHAR (64) DEFAULT '' COMMENT '创建者',
	create_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_by VARCHAR (64) DEFAULT '' COMMENT '更新者',
	update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	remark VARCHAR (500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (id)
) ENGINE = INNODB auto_increment = 1 COMMENT = '菜单权限表';

insert into sys_menu(id,menu_name, parent_id, path,is_frame,menu_type,visible,icon,create_by)
value (1,"管理员管理",0,"",0,"M","0","&#xe726;",1),
(2,"管理员列表",1,"/sysUser/admin-list",0,"M","0","&#xe6a7;",1),
(3,"角色管理",1,"/sysRole/admin-role",0,"M","0","&#xe6a7;",1),
(4,"菜单管理管理",1,"/sysMenu/admin-menu",0,"M","0","&#xe6a7;",1);

CREATE TABLE sys_role_menu (
	role_id BIGINT (20) NOT NULL COMMENT '角色ID',
	menu_id BIGINT (20) NOT NULL COMMENT '菜单ID',
	PRIMARY KEY (role_id, menu_id)
) ENGINE = INNODB COMMENT = '角色和菜单关联表';