select * from review;
select * from prod_order;
select * from pay;
select * from product;
desc prod_order;
select a.*, b.order_date, c.p_name
from review a, prod_order b, product c 
where a.order_no = b.order_no 
and b.p_code = c.p_code 
and a.order_no = ?;

select a.*, b.order_date, c.p_name
from review a, prod_order b, product c 
where a.order_no = b.order_no 
and b.p_code = 347
and b.p_code = c.p_code ;

SELECT  * FROM REVIEW WHERE ORDER_NO=?;

select * from prod_order;

desc review;

select a.*, b.order_date, c.p_name from review a, prod_order b, product c where a.order_no = b.order_no and b.p_code = 356 and b.p_code = c.p_code order by review_date desc;