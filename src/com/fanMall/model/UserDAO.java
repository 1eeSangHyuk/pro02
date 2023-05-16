package com.fanMall.model;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;





import com.crypto.util.AES256;
import com.fanMall.dto.User;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String key = "%03x";
	String pw2 = "";
	
	public int loginTest(String id, String pw) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException{
		int i=0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pw2 = AES256.decryptAES256(rs.getString("USER_PW"), key);
				if (pw.equals(pw2)){
					i = 1;
				} else {
					i = 0;
				}
			} else {
				i = 2;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		
		return i;
	}
	
	public int idCheck(String id){
		int i=0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				i = 1;
			} else {
				i = 0;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			Oracle11.close(conn, pstmt, rs);
		}
		return i;
	}
	
	public int insertUser(User user){
		int i = 0, j = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_INSERT);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_pw());		
			pstmt.setString(3, user.getUser_name());
			pstmt.setString(4, user.getUser_phone());
			pstmt.setString(5, user.getUser_addr());
			pstmt.setString(6, user.getUser_email());
			j = pstmt.executeUpdate();
			if(j >= 1){
				i = 1;
			} else {
				i = 0;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			Oracle11.close(conn, pstmt, rs);
		}
		return i;
	}
	
	public int updateUser(User user){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_UPDATE);
			pstmt.setString(1, user.getUser_pw());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_phone());
			pstmt.setString(4, user.getUser_addr());
			pstmt.setString(5, user.getUser_email());
			pstmt.setString(6, user.getUser_id());
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int deleteUser(String user_id){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_DELETE);
			pstmt.setString(1, user_id);
			i = pstmt.executeUpdate();		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt);
		}
		return i;
	}
	
	public User getUserById(String user_id){
		User user = new User();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_GET);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setUser_id(rs.getString("user_id"));
				try {
					pw2 = AES256.decryptAES256(rs.getString("user_pw"), key);
				} catch (InvalidKeyException | NoSuchPaddingException
						| NoSuchAlgorithmException | InvalidKeySpecException
						| InvalidAlgorithmParameterException
						| BadPaddingException | IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int i = pw2.length();
				int k = 2;
				String p1 = pw2.substring(0, k);
				String p2 = "";
				for (int j=k;j<i;j++){
					p2 += "*";
				}
				user.setUser_pw(p1+p2);
				user.setUser_name(rs.getString("user_name"));
				user.setUser_addr(rs.getString("user_addr"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_addr(rs.getString("user_addr"));
				user.setUser_regdate(rs.getString("user_regdate"));
				user.setUser_point(rs.getInt("user_point"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
