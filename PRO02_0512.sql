DESC BASKET;
select * from basket;
select * from product;
select * from user1;
desc user1;
desc category;
desc prod_order;
desc pay;
--USER_ID      NOT NULL VARCHAR2(30)

alter table prod_order drop column order_type;
alter table prod_order drop column order_fee;
alter table prod_order drop column order_company;
alter table prod_order drop column order_num;

alter table prod_order add user_phone varchar2(20);
alter table prod_order add dname varchar2(30);
alter table prod_order add dcode varchar2(20);

desc product;
desc user1;
desc pay;
alter table pay add user_id VARCHAR2(30);
alter table pay add pay_price number;
alter table pay add pay_DATE VARCHAR2(300) DEFAULT TO_CHAR(SYSDATE, 'yyyy/MM/dd hh24:mi:ss') NOT NULL;
alter table pay add constraint pay_fk2 foreign key(user_id) references user1(user_id);
alter table pay drop column order_no;
commit;