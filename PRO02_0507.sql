ALTER TABLE NOTICE MODIFY NOTICE_FILE DEFAULT NULL;

INSERT INTO NOTICE VALUES(NOTICE_NO_SEQ.NEXTVAL, 'admin', default, '더미공지사항2', '더미공지사항2입니다.', default, DEFAULT);

COMMIT;

select * from user1;

update user1 set user_pw = '1R9rG2NpoxFTiDTbBa1QCQQNT/1YQYHp7tIwKVq3Ity3l6eKGi5RGGOKwOtK5b+2Zed8og==' where user_id = 'admin';
commit;