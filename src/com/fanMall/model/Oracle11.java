package com.fanMall.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Oracle11 {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "PRO02";
	static String pw = "1234";
	
	//공지사항
	final static String NOTICE_SELECT_ALL = "select * from notice ORDER BY NOTICE_NO DESC";
	final static String NOTICE_SELECT_ONE = "SELECT * FROM NOTICE WHERE NOTICE_NO=?";
	final static String NOTICE_READCOUNT_UPDATE = "UPDATE NOTICE SET READCNT = READCNT+1 WHERE NOTICE_NO=?";
	final static String NOTICE_INSERT = "INSERT INTO NOTICE VALUES(notice_no_seq.nextval, ?, DEFAULT, ?, ?, ?, DEFAULT)";
	final static String NOTICE_UPDATE = "UPDATE NOTICE SET NOTICE_TITLE=?, NOTICE_TEXT=?, NOTICE_FILE=?,"
			+ " NOTICE_DATE=TO_CHAR(SYSDATE, 'yyyy/MM/dd hh24:mi:ss') WHERE NOTICE_NO=?";
	final static String NOTICE_DELETE = "DELETE FROM NOTICE WHERE NOTICE_NO=?";
	
	//사용자
	final static String USER_LOGIN = "select * from user1 where USER_ID=?";
	final static String USER_INSERT = "insert into user1 values(?, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)";
	final static String USER_GET = "select * from user1 where user_id=?";
	final static String USER_DELETE = "DELETE FROM USER1 WHERE USER_ID=?";
	final static String USER_UPDATE = "UPDATE USER1 SET USER_PW=?, USER_NAME=?, USER_PHONE=?, USER_ADDR=?, USER_EMAIL=? WHERE USER_ID=?";
	
	//product
	final static String PROD_SELECT_ALL = "SELECT * FROM PRODUCT ORDER BY CATNO";
	final static String PROD_SELECT_ONE = "SELECT * FROM PRODUCT WHERE P_CODE=?";
	final static String PROD_SELECT_CAT = "SELECT * FROM PRODUCT WHERE CATNO=?";
	final static String PROD_SELECT_CAT_ALL = "SELECT * FROM PRODUCT WHERE CATNO LIKE ?||'%'";
	final static String CAT_SELECT = "SELECT * FROM CATEGORY WHERE CATNO=?";
	final static String PROD_DELETE = "DELETE FROM PRODUCT WHERE P_CODE=?";
	final static String PROD_INSERT = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	final static String CAT_SELECT_CAT1 = "SELECT SUBSTR(CATNO, 0, 2) AS CAT1, CATGROUP FROM CATEGORY WHERE CATNO LIKE '%01'";
	final static String CAT_SELECT_CAT2 = "SELECT CATNO, SUBSTR(CATNO, 0, 2) AS CAT1, SUBSTR(CATNO, 3, 4) AS CAT2, CATGROUP, CATNAME FROM CATEGORY WHERE CATNO LIKE ?||'%'";
	final static String GET_P_CODE_MAX_INCAT = "select p_code from (select * from product where catno like ?||'%' order by p_code desc) where rownum=1";
	final static String GET_P_CODE = "SELECT P_CODE FROM PRODUCT WHERE CATNO LIKE ? ORDER BY P_CODE DESC";
	
	//장바구니
	final static String BASKET_SELECT_ALL = "SELECT * FROM BASKET"; //관리자 전체 장바구니 현황 조회
	final static String BASKET_SELECT_BY_BNO = "SELECT * FROM BASKET WHERE BASKET_NO=?"; //특정 항목에 대한 장바구니 현황 조회
	final static String BASKETVO_SELECT_BY_USER_ID = "select a.basket_no, a.user_id, a.p_code, b.p_name,"
			+ " a.basket_count, b.p_price, b.p_amount from basket a, product b"
			+ " where a.p_code = b.p_code and a.user_id = ?"; //사용자가 본인 장바구니 조회
	final static String DELETE_BASKET = "delete from basket where basket_no=?";
	final static String INSERT_BASKET = "INSERT INTO BASKET VALUES(BASKET_NO_SEQ.NEXTVAL, ?, ?, 1)";
	
	//주문(order)
	final static String ORDER_NO_GENERATOR = "SELECT ORDER_NO FROM (SELECT ORDER_NO FROM PROD_ORDER ORDER BY ORDER_NO DESC) WHERE ROWNUM=1";
	final static String ADD_ORDER = "INSERT INTO PROD_ORDER VALUES(?, ?, ?, ?, ?, default, ?, ?, ?, ?, default)";
	final static String DELIVER_NUM_GENERATOR = "SELECT DELIVER_NUM FROM (SELECT DELIVER_NUM FROM PROD_ORDER ORDER BY DELIVER_NUM DESC) WHERE ROWNUM=1";
	final static String REMOVE_PRODUCT = "UPDATE PRODUCT SET P_AMOUNT=P_AMOUNT-? WHERE P_CODE=?";
	final static String MY_ORDER = "select a.*, b.p_name, b.pic1 from prod_order a, product b where a.user_id=? and a.p_code = b.p_code";
	final static String ORDER_LIST_ALL = "select a.*, b.p_name, b.pic1 from prod_order a, product b where a.p_code = b.p_code order by a.order_no desc";
	final static String ORDER_BY_NO = "select a.*, b.p_name, b.pic1 from prod_order a, product b where a.p_code = b.p_code and order_no=? order by a.order_no desc";
	final static String UPDATE_ORDER = "UPDATE PROD_ORDER SET DELIVER_COMPANY=?, DELIVER_STATE=?, DELIVER_NUM=? WHERE ORDER_NO=?";
	
	//결제
	final static String PAY_NO_GENERATOR = "SELECT PAY_NO FROM (SELECT PAY_NO FROM PAY ORDER BY PAY_NO DESC) WHERE ROWNUM=1";
	final static String ADD_PAY = "INSERT INTO PAY VALUES(?, ?, ?, ?, DEFAULT)";
			
	
	static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		return conn;
	}
	
	static void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void close(Connection conn, PreparedStatement pstmt){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
