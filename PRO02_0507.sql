ALTER TABLE NOTICE MODIFY NOTICE_FILE DEFAULT NULL;

update user1 set user_pw = '1R9rG2NpoxFTiDTbBa1QCQQNT/1YQYHp7tIwKVq3Ity3l6eKGi5RGGOKwOtK5b+2Zed8og==' where user_id = 'admin';
update user1 set user_pw='mNcHsZIHnDqx3zAAZeXITvgdakX4+CP37PqStq5T2zYabBp+Lu0rwPlDZErB7nGci0J71Q==' where user_id='user1';
update user1 set user_pw='aWHUdE5UZWsZLlGTF08HlHX7cILv9o5lq8wqgXlu0deJMaYaTOAYv50jtzRZMBtlPeTA5Q==' where user_id='user2';
update user1 set user_pw='QC6eAYxp9mBoNFaBe3159yRr6ONuDosLFG5rH77WNageS2U6LWSmPrEjmTICDfJ2hP9XDw==' where user_id='user3';
update user1 set user_pw='UmsoLFih4fS3epaKakdLcOhvzWTQq54p5sbXQpYWlCGmre8NtSG/rpFVQB4MXPLeIHwF+g==' where user_id='user4';
update user1 set user_pw='asUNZzVpBTYurqXEPp5kwaQErIRgNCE4Py8U+FyMCDKuFY6oyIIu2TU41VCjDrXzli5SPg==' where user_id='user5';

select * from notice;

commit;

select * from user1;