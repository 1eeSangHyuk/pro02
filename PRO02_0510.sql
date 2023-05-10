DROP TABLE CATEGORY;

create table category(
    catNo VARCHAR2(10) primary key,
    catGroup varchar2(100),
    catName varchar2(100)
);

insert into category values('0101', 'fan', '써큘레이터'); --써큘레이터 데스크팬 핸디팬
insert into category values('0102', 'fan', '데스크팬');
insert into category values('0103', 'fan', '핸디팬');

insert into category values('0201', 'light', '테이블 램프'); --테이블 램프, 멀티 랜턴, 아웃도어 캠핑 랜턴
insert into category values('0202', 'light', '멀티 랜턴');
insert into category values('0203', 'light', '아웃도어 캠핑 랜턴');

insert into category values('0301', 'air', '공기청정기'); -- 공기청정기 온풍기 가습기
insert into category values('0302', 'air', '온풍기');
insert into category values('0303', 'air', '가습기');

insert into category values('0401', 'life', '휴대용 배터리'); -- 휴대용 배터리 무선 충전기 모기채
insert into category values('0402', 'life', '무선 충전기');
insert into category values('0403', 'life', '모기채');

alter table product add cate varchar2(10);

update product set cate='0101' where p_code='347';
update product set cate='0101' where p_code='288';
update product set cate='0102' where p_code='358';
update product set cate='0102' where p_code='346';
update product set cate='0103' where p_code='356';

alter table product rename column cate to catno;

alter table product add pic1 varchar2(200);
alter table product add pic2 varchar2(200);
alter table product add pic3 varchar2(200);


update product 
set pic1='./img/prod_img/fan/lumena_fan_classic_rev3_1.png',
    pic2='./img/prod_img/fan/lumena_fan_classic_rev3_2.png'
where p_code='347';

update product 
set pic1='./img/prod_img/fan/lumena_fan_boost_1.jpg',
    pic2='./img/prod_img/fan/lumena_fan_boost_2.jpg'
where p_code='288';

update product 
set pic1='./img/prod_img/fan/lumena_fan_plug_1.png',
    pic2='./img/prod_img/fan/lumena_fan_plug_2.png'
where p_code='358';

update product 
set pic1='./img/prod_img/fan/lumena_fan_stand_3z_1.png',
    pic2='./img/prod_img/fan/lumena_fan_stand_3z_2.png',
    pic3='./img/prod_img/fan/lumena_fan_stand_3z_3.png'
where p_code='346';

update product 
set pic1='./img/prod_img/fan/lumena_fan_pro_4_1.png',
    pic2='./img/prod_img/fan/lumena_fan_pro_4_2.png',
    pic3='./img/prod_img/fan/lumena_fan_pro_4_3.png'
where p_code='356';

commit;