package com.fanMall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fanMall.dto.Product;

public class ProductDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<Product> prodListAll(){
		ArrayList<Product> prodList = new ArrayList<Product>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product prod = new Product();
				prod.setP_code(rs.getString("p_code"));
				prod.setP_name(rs.getString("p_name"));
				prod.setP_price(rs.getInt("p_price"));
				prod.setP_about(rs.getString("p_about"));
				prod.setP_amount(rs.getInt("p_amount"));
				prodList.add(prod);
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
		} finally {Oracle11.close(conn, pstmt, rs);}
		return prodList;
	}
	
	public Product prodList(int p_code){
		Product prod = new Product();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_SELECT_ONE);
			pstmt.setInt(1, p_code);
			rs = pstmt.executeQuery();
			if(rs.next()){
				prod.setP_code(rs.getString("p_code"));
				prod.setP_name(rs.getString("p_name"));
				prod.setP_price(rs.getInt("p_price"));
				prod.setP_about(rs.getString("p_about"));
				prod.setP_amount(rs.getInt("p_amount"));
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
		} finally {Oracle11.close(conn, pstmt, rs);}
		return prod;
	}
}
