package com.fanMall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fanMall.dto.Category;
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
				if (!rs.getString("pic1").equals("")){
					prod.setPic1(rs.getString("pic1").substring(2));
				}
				if (!rs.getString("pic2").equals("")){
					prod.setPic2(rs.getString("pic2").substring(2));
				}
				if (!rs.getString("pic3").equals("")){
					prod.setPic3(rs.getString("pic3").substring(2));
				}
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
				catMap.put("catno", rs.getString("catno"));
				catMap.put("cat1", rs.getString("catno").substring(0, 2));
				catMap.put("cat2", rs.getString("catno").substring(2, 4));
				catMap.put("catgroup", rs.getString("catgroup"));
				catMap.put("catname", rs.getString("catname"));
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
		} finally {Oracle11.close(conn, pstmt, rs);}
		
		return catMap;
	}
	
	public ArrayList<Category> catListCat1(){
		ArrayList<Category> catList = new ArrayList<Category>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.CAT_SELECT_CAT1);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Category cat = new Category();
				cat.setCat1(rs.getString("cat1"));
				cat.setCatgroup(rs.getString("catgroup"));
				catList.add(cat);
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
		} finally {Oracle11.close(conn, pstmt, rs);}
		return catList;
	}
	
	public ArrayList<Category> catListCat2(String cat1){
		ArrayList<Category> catList = new ArrayList<Category>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.CAT_SELECT_CAT2);
			pstmt.setString(1, cat1);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Category cat = new Category();
				cat.setCatno(rs.getString("catno"));
				cat.setCat1(rs.getString("cat1"));
				cat.setCat2(rs.getString("cat2"));
				cat.setCatgroup(rs.getString("catgroup"));
				cat.setCatname(rs.getString("catname"));
				catList.add(cat);
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
		} finally {Oracle11.close(conn, pstmt, rs);}
		return catList;
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
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PROD_INSERT);
			pstmt.setString(1, prod.getP_code());
			pstmt.setString(2, prod.getP_name());
			pstmt.setInt(3, prod.getP_price());
			pstmt.setString(4, prod.getP_about());
			pstmt.setInt(5, prod.getP_amount());
			pstmt.setString(6, prod.getCatno());
			pstmt.setString(7, prod.getPic1());
			pstmt.setString(8, prod.getPic2());
			pstmt.setString(9, prod.getPic3());
			int j = pstmt.executeUpdate();
			if (j > 0){
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
	
	public String getP_codeGenerator(String cat1){
		String p_codeMax = "0";
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.GET_P_CODE_MAX_INCAT);
			pstmt.setString(1, cat1);
			rs = pstmt.executeQuery();
			if(rs.next()){
				p_codeMax = rs.getString("p_code");
			} else {
				p_codeMax = "0";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		int p_code = Integer.parseInt(p_codeMax) + 1;
		System.out.println(p_code);
		int i = p_codeMax.length();
		
		if(i==2){
			p_codeMax = "0" + p_code;
		} else if(i==1) {
			p_codeMax = "00" + p_code;
		} else {
			p_codeMax = "" + p_code;
		}
		return p_codeMax;
	}
}
