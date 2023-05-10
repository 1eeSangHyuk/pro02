package com.fanMall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fanMall.dto.Product;

public class ProductDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<Product> prodListAll(){
		ArrayList<Product> prodList = new ArrayList<Product>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PROD_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product prod = new Product();
				prod.setP_code(rs.getString("p_code"));
				prod.setP_name(rs.getString("p_name"));
				prod.setP_price(rs.getInt("p_price"));
				prod.setP_about(rs.getString("p_about"));
				prod.setP_amount(rs.getInt("p_amount"));
				prod.setCatno(rs.getString("catno"));
				prod.setPic1(rs.getString("pic1"));
				prod.setPic2(rs.getString("pic2"));
				prod.setPic3(rs.getString("pic3"));
				prodList.add(prod);
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
		} finally {Oracle11.close(conn, pstmt, rs);}
		return prodList;
	}
	
	public Product prodList(String p_code){
		Product prod = new Product();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PROD_SELECT_ONE);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();
			if(rs.next()){
				prod.setP_code(rs.getString("p_code"));
				prod.setP_name(rs.getString("p_name"));
				prod.setP_price(rs.getInt("p_price"));
				prod.setP_about(rs.getString("p_about"));
				prod.setP_amount(rs.getInt("p_amount"));
				prod.setCatno(rs.getString("catno"));
				prod.setPic1(rs.getString("pic1"));
				prod.setPic2(rs.getString("pic2"));
				prod.setPic3(rs.getString("pic3"));
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
		} finally {Oracle11.close(conn, pstmt, rs);}
		return prod;
	}
	
	public ArrayList<Product> prodCatListAll(String catno){
		ArrayList<Product> prodCatListAll = new ArrayList<Product>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PROD_SELECT_CAT_ALL);
			pstmt.setString(1, catno.substring(0,2));
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product prod = new Product();
				prod.setP_code(rs.getString("p_code"));
				prod.setP_name(rs.getString("p_name"));
				prod.setP_price(rs.getInt("p_price"));
				prod.setP_about(rs.getString("p_about"));
				prod.setP_amount(rs.getInt("p_amount"));
				prod.setCatno(rs.getString("catno"));
				prod.setPic1(rs.getString("pic1"));
				prod.setPic2(rs.getString("pic2"));
				prod.setPic3(rs.getString("pic3"));
				prodCatListAll.add(prod);
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
		} finally {Oracle11.close(conn, pstmt, rs);}
		return prodCatListAll;
	}
	
	public ArrayList<Product> prodCatList(String catno){
		ArrayList<Product> prodCatList = new ArrayList<Product>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PROD_SELECT_CAT);
			pstmt.setString(1, catno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product prod = new Product();
				prod.setP_code(rs.getString("p_code"));
				prod.setP_name(rs.getString("p_name"));
				prod.setP_price(rs.getInt("p_price"));
				prod.setP_about(rs.getString("p_about"));
				prod.setP_amount(rs.getInt("p_amount"));
				prod.setCatno(rs.getString("catno"));
				prod.setPic1(rs.getString("pic1"));
				prod.setPic2(rs.getString("pic2"));
				prod.setPic3(rs.getString("pic3"));
				prodCatList.add(prod);
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
		} finally {Oracle11.close(conn, pstmt, rs);}
		return prodCatList;
	}
	
	public HashMap<String, String> catMap(String catno){
		HashMap<String, String> catMap = new HashMap<String, String>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.CAT_SELECT);
			pstmt.setString(1, catno);
			rs = pstmt.executeQuery();
			if(rs.next()){
//				Category cat = new Category();
//				cat.setCatno(rs.getString("catno"));
//				cat.setCatgroup(rs.getString("catgroup"));
//				cat.setCatname(rs.getString("catname"));
				catMap.put("catno", rs.getString("catno"));
				catMap.put("catgroup", rs.getString("catgroup"));
				catMap.put("catname", rs.getString("catname"));
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
		} finally {Oracle11.close(conn, pstmt, rs);}
		
		return catMap;
	}
	
	public int deleteProduct(String p_code){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PROD_DELETE);
			pstmt.setString(1, p_code);
			i = pstmt.executeUpdate();
			if (i>1){
				i = 1;
			} else {
				i = 0;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt);
		}
		return i;
	}
	
	public int insertProduct(Product prod){
		int i = 0;
		return i;
	}
}
