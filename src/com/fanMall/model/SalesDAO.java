package com.fanMall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fanMall.dto.Basket;
import com.fanMall.vo.BasketVO;

public class SalesDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<BasketVO> getBasket(){	//관리자 전체 장바구니 현황 조회
		ArrayList<BasketVO> basketList = new ArrayList<BasketVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.BASKET_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BasketVO bvo = new BasketVO();
				bvo.setBasket_no(rs.getInt("basket_no"));
				bvo.setUser_id(rs.getString("user_id"));
				bvo.setP_code(rs.getString("p_code"));
				bvo.setP_name(rs.getString("p_name"));
				bvo.setBasket_count(rs.getInt("basket_count"));
				bvo.setP_price(rs.getInt("p_price"));
				bvo.setP_amount(rs.getInt("p_amount"));
				basketList.add(bvo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		return basketList;
	}
	
	public Basket getUserBasket(int basket_no){	//단일 상품 구매시 sales에 건내줄 Basket dto
		Basket basket = new Basket();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.BASKET_SELECT_BY_BNO);
			pstmt.setInt(1, basket_no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				basket.setBasket_no(basket_no);
				basket.setUser_id(rs.getString("user_id"));
				basket.setP_code(rs.getString("p_code"));
				basket.setBasket_count(rs.getInt("basket_count"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		return basket;
	}
	
	public ArrayList<BasketVO> getUserBasketVO(String user_id){	//사용자 장바구니 조회
		ArrayList<BasketVO> basketVOList = new ArrayList<BasketVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.BASKETVO_SELECT_BY_USER_ID);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BasketVO bvo = new BasketVO();
				bvo.setBasket_no(rs.getInt("basket_no"));
				bvo.setUser_id(rs.getString("user_id"));
				bvo.setP_code(rs.getString("p_code"));
				bvo.setP_name(rs.getString("p_name"));
				bvo.setBasket_count(rs.getInt("basket_count"));
				bvo.setP_price(rs.getInt("p_price"));
				bvo.setP_amount(rs.getInt("p_amount"));
				basketVOList.add(bvo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		return basketVOList;
	}
}
