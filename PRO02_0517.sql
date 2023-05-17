select a.*, b.p_name, b.pic1 from prod_order a, product b where a.p_code=288 and a.p_code = b.p_code order by a.order_no desc;

select * from product;
desc product;

desc prod_order;

alter table prod_order modify deliver_num null;

select * from review;
desc review;

select a.*, b.order_date, c.p_name, c.catno, c.pic1
  from review a, prod_order b, product c
 where a.order_no = b.order_no
   and b.p_code = c.p_code
   and a.order_no = ?;

commit;