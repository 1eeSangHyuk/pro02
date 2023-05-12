SELECT * FROM CATEGORY;

SELECT SUBSTR(CATNO, 0, 2)
  FROM CATEGORY;
  
SELECT SUBSTR(CATNO, 0, 2) AS CAT1, CATGROUP FROM CATEGORY WHERE CATNO LIKE '%01';

SELECT CATNO, SUBSTR(CATNO, 0, 2) AS CAT1, SUBSTR(CATNO, 3, 4) AS CAT2, CATGROUP, CATNAME FROM CATEGORY WHERE CATNO LIKE '01%'; -- WHERE CATNO LIKE ?||'%'
SELECT CATNO, SUBSTR(CATNO, 0, 2) AS CAT1, SUBSTR(CATNO, 3, 4) AS CAT2, CATGROUP, CATNAME FROM CATEGORY WHERE CATNO LIKE '02%';
SELECT CATNO, SUBSTR(CATNO, 0, 2) AS CAT1, SUBSTR(CATNO, 3, 4) AS CAT2, CATGROUP, CATNAME FROM CATEGORY WHERE CATNO LIKE '03%';
SELECT CATNO, SUBSTR(CATNO, 0, 2) AS CAT1, SUBSTR(CATNO, 3, 4) AS CAT2, CATGROUP, CATNAME FROM CATEGORY WHERE CATNO LIKE '04%';
SELECT CATNO, SUBSTR(CATNO, 0, 2) AS CAT1, SUBSTR(CATNO, 3, 4) AS CAT2, CATGROUP, CATNAME FROM CATEGORY WHERE CATNO LIKE '%';

select * from product;
desc product;
select * from notice;
commit;

select p_code
  from (select * from product where catno like '01%' order by p_code desc)
 where rownum=1
;

select * from basket;

select user_id, sum(basket_count)
  from basket
group by user_id;

select basket_no, user_id, p_code, basket_count, sum(basket_count) over(partition by user_id) as tot_count
  from basket
order by user_id, basket_no desc;

desc basket;
select user_id from user1;
--admin user1 test1 (varchar)
select p_code from product;
--347 288 358 346 356 (varchar)

alter table basket modify basket_no number;

--truncate table basket;

insert into basket values(basket_no_seq.nextval, 'user1', '347', 3);
insert into basket values(basket_no_seq.nextval, 'user1', '288', 5);
insert into basket values(basket_no_seq.nextval, 'test1', '358', 4);
insert into basket values(basket_no_seq.nextval, 'test1', '346', 2);
insert into basket values(basket_no_seq.nextval, 'test1', '356', 6);
insert into basket values(basket_no_seq.nextval, 'user1', '358', 3);

select * from basket;

select a.basket_no, a.user_id, a.p_code, b.p_name, a.basket_count, b.p_price, b.p_amount
  from basket a, product b
 where a.p_code = b.p_code
   and a.user_id = 'user1'
; -- 사용자 장바구니 페이지 조회

commit;