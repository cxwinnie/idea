drop database if exists scm;

create database scm default character set utf8;

use scm;

drop table if exists supplier;


/*============================*/
/* Table: 管理员表结构 		  */
/*============================*/
create table account
(
   /* 管理员编号,自动增长 */
   acc_id                  int not null auto_increment,
   /* 管理员登录名  */
   acc_login               varchar(20),
   /* 管理员姓名  */
   acc_name                varchar(20),
   /* 管理员密码 */
   acc_pass                varchar(20),
   /* 设置编号为主键 */
   primary key (acc_id)
);

/*==============================================================*/
/* Table: 供应商表	                                        */
/*==============================================================*/

create table supplier
(
   sup_id               bigint not null auto_increment,
   sup_name             varchar(20),
   sup_linkman          varchar(20),
   sup_phone            varchar(11),
   sup_address          varchar(100),
   sup_remark           varchar(200),
   primary key (sup_id)
);
   sup_pay              decimal(12,2),
   sup_type             varchar(10),
alter table supplier add column sup_pay decimal(12,2) comment '供应商预付';
alter table supplier add column sup_type varchar(10) comment '供应商类型';

/* 添加供应商数据, */
insert into account (acc_login,acc_pass) values ('admin','admin');
insert into account (acc_login,acc_pass) values ('admin2','admin2');
/* 添加供应商数据, */
insert into supplier (sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values ('苹果供应商','小张','12388888887','广州花都','普通供应商',0,1);
insert into supplier (sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values ('三星供应商','小王','12388888888','广州增城','普通供应商',0,1);
insert into supplier (sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values ('华为供应商','小王','12388888889','广东深圳','一级供应商',0,2);
insert into supplier (sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values ('TCL供应商','小王','12388888666','广州增城','普通供应商',0,1);
insert into supplier (sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values ('Nokia供应商','小王','12388888777','广东深圳','一级供应商',0,2);

select * from account;
select * from supplier;

select t.* from supplier t where t.sup_name like '%供应商%' limit 1,2;
select count(1) from supplier t where t.sup_name like '%供应商%';
