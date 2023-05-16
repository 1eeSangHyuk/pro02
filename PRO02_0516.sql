SELECT * FROM PROD_ORDER;
desc prod_order;

alter table prod_order modify deliver_company null;
alter table prod_order modify deliver_state null;

select * from product;
SELECT * FROM PRODUCT ORDER BY CATNO;
commit;


