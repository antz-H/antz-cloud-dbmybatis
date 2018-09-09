



-----t_product_type
-- Create table
create table T_PRODUCT_TYPE
(
  PRODUCT_TYPE NUMBER not null,
  TYPE_NAME    VARCHAR2(50),
  CREATETIME   DATE,
  MODIFYTIME   DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column T_PRODUCT_TYPE.PRODUCT_TYPE
  is '产品类别';
comment on column T_PRODUCT_TYPE.TYPE_NAME
  is '类别描述';
comment on column T_PRODUCT_TYPE.CREATETIME
  is '创建时间';
comment on column T_PRODUCT_TYPE.MODIFYTIME
  is '修改时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_PRODUCT_TYPE
  add constraint PRIMARTY_KEY primary key (PRODUCT_TYPE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );



insert into t_product_type t (t.product_type,t.type_name,t.createtime,t.modifytime) values(1001,'器材类',to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ));

insert into t_product_type t (t.product_type,t.type_name,t.createtime,t.modifytime) values(1002,'日用品类',to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ));

insert into t_product_type t (t.product_type,t.type_name,t.createtime,t.modifytime) values
(1003,'家电类',to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ));

insert into t_product_type t (t.product_type,t.type_name,t.createtime,t.modifytime) values
(1004,'水果类',to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual),'yyyy-MM-dd HH24:mi:ss' ));


-----t_product_region

-- Create table
create table T_PRODUCT_REGION
(
  REGION_ID   NUMBER,
  REGION_NAME VARCHAR2(50),
  CREATETIME  DATE,
  MODIFYTIME  DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column T_PRODUCT_REGION.REGION_ID
  is '地区id';
comment on column T_PRODUCT_REGION.REGION_NAME
  is '地区名称';
comment on column T_PRODUCT_REGION.CREATETIME
  is '创建时间';
comment on column T_PRODUCT_REGION.MODIFYTIME
  is '修改时间';


insert into t_product_region t (t.region_id,t.region_name,t.createtime,t.modifytime) values(101,'上海',to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ));

insert into t_product_region t (t.region_id,t.region_name,t.createtime,t.modifytime) values(102,'北京',to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ));

insert into t_product_region t (t.region_id,t.region_name,t.createtime,t.modifytime) values(103,'安徽',to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ));


-------t_product


-- Create table
create table T_PRODUCT
(
  PRODUCT_NO   NUMBER not null,
  PRODUCT_NAME VARCHAR2(100),
  PRODUCT_TYPE NUMBER,
  CREATETIME   DATE,
  MODIFYTIME   DATE,
  REGION       NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 1
    next 8
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column T_PRODUCT.PRODUCT_NO
  is '产品id';
comment on column T_PRODUCT.PRODUCT_NAME
  is '产品名称';
comment on column T_PRODUCT.PRODUCT_TYPE
  is '产品类别';
comment on column T_PRODUCT.CREATETIME
  is '创建时间';
comment on column T_PRODUCT.MODIFYTIME
  is '修改时间';
comment on column T_PRODUCT.REGION
  is '归属地';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_PRODUCT
  add constraint PRIMARTT_KEY primary key (PRODUCT_NO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );



insert into t_product t (t.PRODUCT_NO,t.PRODUCT_NAME,t.PRODUCT_TYPE,REGION,t.createtime,t.modifytime) values(100001,'苹果',1004,101,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ));


insert into t_product t (t.PRODUCT_NO,t.PRODUCT_NAME,t.PRODUCT_TYPE,REGION,t.createtime,t.modifytime) values(100002,'香蕉',1004,101,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ));


insert into t_product t (t.PRODUCT_NO,t.PRODUCT_NAME,t.PRODUCT_TYPE,REGION,t.createtime,t.modifytime) values(100003,'电视',1003,103,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ));


insert into t_product t (t.PRODUCT_NO,t.PRODUCT_NAME,t.PRODUCT_TYPE,REGION,t.createtime,t.modifytime) values(100004,'碗',1002,104,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ) ,to_date((select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual) ,'yyyy-MM-dd HH24:mi:ss' ));



--存储过程

create or replace procedure saveproduct
    (PRODUCT_NO in NUMBER ,
    PRODUCT_NAME in VARCHAR ,
    PRODUCT_TYPE in NUMBER ,
    REGION in NUMBER ,
    CREATETIME in DATE ,
    MODIFYTIME in DATE ,
    counts out NUMBER )
AS
BEGIN
INSERT INTO t_product t (t.PRODUCT_NO,t.PRODUCT_NAME,t.PRODUCT_TYPE,REGION,t.createtime,t.modifytime) values
  (PRODUCT_NO,PRODUCT_NAME,PRODUCT_TYPE,REGION,to_date( CREATETIME,'yyyy-MM-dd HH24:mi:ss' ) ,to_date(MODIFYTIME ,'yyyy-MM-dd HH24:mi:ss' ));

END ;



