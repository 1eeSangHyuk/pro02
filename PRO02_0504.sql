CREATE TABLE "USER1" (
	"USER_ID"    VARCHAR2(30)   PRIMARY KEY,
	"USER_PW"	VARCHAR2(300)		NOT NULL,
	"USER_NAME"	VARCHAR2(30)		NOT NULL,
	"USER_PHONE"	VARCHAR2(20)		NOT NULL,
	"USER_ADDR"	VARCHAR2(100)		NOT NULL,
    "USER_EMAIL"     VARCHAR2(100)   NOT NULL,
    "USER_REGDATE"  VARCHAR2(300)   DEFAULT TO_CHAR(SYSDATE, 'yyyy/MM/dd hh24:mi:ss') NOT NULL,
    "USER_POINT"     NUMBER  DEFAULT 0 NOT NULL
);

--상품
CREATE TABLE "PRODUCT" (
	"P_CODE"	VARCHAR2(6)		PRIMARY KEY,
	"P_NAME"	VARCHAR2(100)		NOT NULL,
	"P_PRICE"	NUMBER		NOT NULL,
	"P_ABOUT"	VARCHAR2(500),
	"P_AMOUNT"	NUMBER		NOT NULL
);

--주문내역
create sequence order_no_seq;

CREATE TABLE "PROD_ORDER" (
    "ORDER_NO" NUMBER PRIMARY KEY,
    "USER_ID" VARCHAR2(30)  NOT NULL,
    "P_CODE" VARCHAR2(6) NOT NULL,
    "ORDER_COUNT" NUMBER NOT NULL,
    "ORDER_TYPE" VARCHAR2(30) DEFAULT '택배' NOT NULL,
    "ORDER_FEE" NUMBER DEFAULT 3000 NOT NULL,
    "ORDER_PRICE" NUMBER NOT NULL,
    "ORDER_DATE" VARCHAR2(300) DEFAULT TO_CHAR(SYSDATE, 'yyyy/MM/dd hh24:mi:ss') NOT NULL,
    "ORDER_ADDR" VARCHAR2(100) NOT NULL,
    "ORDER_COMPANY" VARCHAR2(50) DEFAULT '우체국 택배' NOT NULL,
    "ORDER_NUM" VARCHAR2(25) NOT NULL UNIQUE,
    "ORDER_STATE" VARCHAR2(30) DEFAULT '배송 전' NOT NULL,
    CONSTRAINT PROD_ORDER_FK1 FOREIGN KEY(USER_ID) REFERENCES USER1(USER_ID),
    CONSTRAINT PROD_ORDER_FK2 FOREIGN KEY(P_CODE) REFERENCES PRODUCT(P_CODE)
);

--장바구니
create sequence basket_no_seq;

CREATE TABLE "BASKET" (
	"BASKET_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR2(30)		NOT NULL,
	"P_CODE"	VARCHAR2(6)		NOT NULL,
	"BASKET_COUNT"	NUMBER		DEFAULT 0,
    CONSTRAINT BASKET_FK1 FOREIGN KEY(USER_ID) REFERENCES USER1(USER_ID),
    CONSTRAINT BASKET_FK2 FOREIGN KEY(P_CODE) REFERENCES PRODUCT(P_CODE)
);

--결제
create sequence pay_no_seq;

CREATE TABLE "PAY" (
	"PAY_NO"	NUMBER		PRIMARY KEY,
	"ORDER_NO"	NUMBER		NOT NULL,
    "PAY_TYPE"  VARCHAR2(50)    NOT NULL,
    CONSTRAINT PAY_FK FOREIGN KEY(ORDER_NO) REFERENCES PROD_ORDER(ORDER_NO)
);

--리뷰
create sequence review_no_seq;

CREATE TABLE "REVIEW" (
	"REVIEW_NO"	NUMBER		PRIMARY KEY,
	"USER_ID"	VARCHAR2(30)		NOT NULL,
	"ORDER_NO"	NUMBER		NOT NULL,
	"REVIEW_DATE"	VARCHAR2(300)   DEFAULT TO_CHAR(SYSDATE, 'yyyy/MM/dd hh24:mi:ss') NOT NULL,
    "REVIEW_TITLE"  VARCHAR2(100)   NOT NULL,
	"REVIEW_TEXT"	VARCHAR2(1000)		NOT NULL,
	"REVIEW_STAR"	NUMBER		DEFAULT '5',
    CONSTRAINT REVIEW_FK1 FOREIGN KEY(USER_ID) REFERENCES USER1(USER_ID),
    CONSTRAINT REVIEW_FK2 FOREIGN KEY(ORDER_NO) REFERENCES PROD_ORDER(ORDER_NO)
);


--공지사항
CREATE SEQUENCE NOTICE_NO_SEQ;

CREATE TABLE "NOTICE" (
	"NOTICE_NO"	NUMBER		PRIMARY KEY,
	"USER_ID"	VARCHAR2(30)		NOT NULL,
	"NOTICE_DATE"	VARCHAR2(300)   DEFAULT TO_CHAR(SYSDATE, 'yyyy/MM/dd hh24:mi:ss') NOT NULL,
    "NOTICE_TITLE"  VARCHAR2(100)   NOT NULL,
	"NOTICE_TEXT"	VARCHAR2(1000)	NOT NULL,
    "NOTICE_FILE"   VARCHAR2(100),    
	"READCNT"       NUMBER      DEFAULT 1,
    CONSTRAINT NOTICE_FK1 FOREIGN KEY(USER_ID) REFERENCES USER1(USER_ID)
);

-- 더미데이터입력란
--USER1
INSERT INTO user1 VALUES('admin', '1234', 'admin', '01000000000', '경기도 고양시 일산서구', 'admin@gmail.co.kr',	DEFAULT, DEFAULT);
INSERT INTO user1 VALUES('user1', '4321', '이름1', '01043214321', '경기도 고양시 일산동구', 'user1@gmail.co.kr',	DEFAULT, DEFAULT);
INSERT INTO user1 VALUES('user2', '1111', '이름2', '01011111111', '경기도 파주시 문산읍', 'user2@gmail.co.kr',	DEFAULT, DEFAULT);
INSERT INTO user1 VALUES('user3', '3333', '이름3', '01033333333', '경기도 김포시 통진읍', 'user3@gmail.co.kr',	DEFAULT, DEFAULT);
INSERT INTO user1 VALUES('user4', '2222', '이름4', '01022222222', '경기도 파주시 월릉면', 'user4@gmail.co.kr',	DEFAULT, DEFAULT);
INSERT INTO user1 VALUES('user5', '7979', '이름5', '01079797979', '경기도 고양시 일산서구', 'user5@gmail.co.kr',	DEFAULT, DEFAULT);
--PRODUCT
INSERT INTO product VALUES('347', '루메나 FAN CLASSIC 3세대 무선 써큘레이터', 199999, '서큘레이터, 무선, 13inch, 7엽 블레이드', 20);
INSERT INTO product VALUES('288', '루메나 FAN BOOST 무선 써큘레이터', 119000, '서큘레이터, 무선, 10inch, 5엽 블레이드', 15);
INSERT INTO product VALUES('358', '루메나 FAN PLUG 스탠드형 유선 선풍기', 99000, '서큘레이터, 유선, 13inch, 7엽 블레이드', 16);
INSERT INTO product VALUES('346', '루메나 FAN STAND 3Z 탁상용 무선 선풍기', 34900, '데스크팬, 무선, 6inch, 5엽 블레이드', 30);
INSERT INTO product VALUES('356', '루메나 FAN PRO 4 휴대용 무선 선풍기', 24900, '핸디팬, 무선,4inch, 4엽 블레이드', 20);
--BASKET
INSERT INTO basket VALUES(basket_no_seq.nextval, 'user2', '358', 2);
INSERT INTO basket VALUES(basket_no_seq.nextval, 'user3', '346', 3);
INSERT INTO basket VALUES(basket_no_seq.nextval, 'user4', '356', 4);
INSERT INTO basket VALUES(basket_no_seq.nextval, 'user5', '347', 4);
--NOTICE
INSERT INTO NOTICE(notice_no, user_id, notice_date, notice_title, notice_text, readcnt) VALUES(NOTICE_NO_SEQ.NEXTVAL, 'admin', default, '더미공지사항1', '더미공지사항1입니다.', default);
INSERT INTO NOTICE(notice_no, user_id, notice_date, notice_title, notice_text, readcnt) VALUES(NOTICE_NO_SEQ.NEXTVAL, 'admin', default, '더미공지사항2', '더미공지사항2입니다.', default);
-- 더미데이터입력란 끝

select * from notice;
commit;