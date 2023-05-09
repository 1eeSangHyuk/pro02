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
	
	final static String NOTICE_SELECT_ALL = "select * from notice ORDER BY NOTICE_NO DESC";
	final static String NOTICE_SELECT_ONE = "SELECT * FROM NOTICE WHERE NOTICE_NO=?";
	final static String NOTICE_READCOUNT_UPDATE = "UPDATE NOTICE SET READCNT = READCNT+1 WHERE NOTICE_NO=?";
	final static String NOTICE_INSERT = "INSERT INTO NOTICE VALUES(notice_no_seq.nextval, ?, DEFAULT, ?, ?, ?, DEFAULT)";
	final static String NOTICE_UPDATE = "UPDATE NOTICE SET NOTICE_TITLE=?, NOTICE_TEXT=?, NOTICE_FILE=?, NOTICE_DATE=SYSDATE WHERE NOTICE_NO=?";
	final static String NOTICE_DELETE = "DELETE FROM NOTICE WHERE NOTICE_NO=?";
	
	final static String USER_LOGIN = "select * from user1 where USER_ID=?";
	final static String USER_INSERT = "insert into user1 values(?, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)";
										
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static void close(Connection conn, PreparedStatement pstmt){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
