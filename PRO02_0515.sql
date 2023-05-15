DESC PRODUCT;
desc prod_order;
desc basket;
desc review;
desc pay;
desc user1;
desc category;
desc notice;
select * from prod_order;
select p_code from (select * from product where catno like '01%' order by p_code desc) where rownum=1;

select * from prod_order where order_no=?;
select a.*, b.p_name, b.pic1 from prod_order a, product b where a.order_no=1 and a.p_code = b.p_code;
--update prod_order set deliver_company='우체국택배' where order_no=1;

select * from prod_order;
select * from pay;
delete from pay where pay_no=1;
delete from prod_order where order_no=1;
select * from basket order by user_id;
select * from product where p_code='358';
select * from basket order by basket_no desc;
delete from basket where basket_no=?;

alter table prod_order modify(deliver_num varchar(20));
commit; 