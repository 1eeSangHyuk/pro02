-- 카테고리 테이블 만들기
create table category(
    catNo number primary key,
    catGroup varchar2(100),
    catName varchar2(100)
);

insert into category values(0101, 'fan', '써큘레이터'); --써큘레이터 데스크팬 핸디팬
insert into category values(0102, 'fan', '데스크팬');
insert into category values(0103, 'fan', '핸디팬');

insert into category values(0201, 'light', '테이블 램프'); --테이블 램프, 멀티 랜턴, 아웃도어 캠핑 랜턴
insert into category values(0202, 'light', '멀티 랜턴');
insert into category values(0203, 'light', '아웃도어 캠핑 랜턴');

insert into category values(0301, 'air', '공기청정기'); -- 공기청정기 온풍기 가습기
insert into category values(0302, 'air', '온풍기');
insert into category values(0303, 'air', '가습기');

insert into category values(0401, 'life', '휴대용 배터리'); -- 휴대용 배터리 무선 충전기 모기채
insert into category values(0402, 'life', '무선 충전기');
insert into category values(0403, 'life', '모기채');

commit;