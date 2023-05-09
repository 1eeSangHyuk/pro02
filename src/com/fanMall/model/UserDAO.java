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
}