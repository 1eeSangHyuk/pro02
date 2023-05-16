SELECT * FROM PROD_ORDER;
desc prod_order;

alter table prod_order modify deliver_company null;
alter table prod_order modify deliver_state null;

select * from product;
SELECT * FROM PRODUCT ORDER BY CATNO;

select a.*, b.p_name, b.pic1 from prod_order a, product b where a.p_code = b.p_code order by a.order_date;
select * from prod_order;
select a.*, b.p_name, b.pic1 from prod_order a, product b where a.p_code = b.p_code and order_no=1 order by a.order_no desc;

select a.*, b.p_name, b.pic1 from prod_order a, product b where a.p_code = b.p_code order by a.order_no desc;
commit;


