package com.fanMall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fanMall.dto.Pay;
import com.fanMall.dto.Prod_order;
import com.fanMall.vo.OrderVO;

public class OrderDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int orderNoGenerator(){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.ORDER_NO_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				i = Integer.parseInt(rs.getString("order_no"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		return i+1;
	}
	
	public int payNoGenerator(){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PAY_NO_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				i = Integer.parseInt(rs.getString("pay_no"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		return i+1;
	}
	
	public String deliverNumGenerator(){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.DELIVER_NUM_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				i = Integer.parseInt(rs.getString("deliver_num"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		i += 1;
		String j =  i + "";
		for (int a=20-j.length();a>0;a--){
			j = "0" + j;
		}
		return j;
	}
	
	public int addOrder(Prod_order order, Pay pay, int basket_no ){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(Oracle11.ADD_ORDER);
			pstmt.setInt(1, order.getOrder_no());
			pstmt.setString(2, order.getUser_id());
			pstmt.setString(3, order.getP_code());
			pstmt.setInt(4, order.getOrder_count());
			pstmt.setInt(5, order.getOrder_price());
			pstmt.setString(6, order.getUser_phone());
			pstmt.setString(7, order.getOrder_addr());
			if (order.getDeliver_company() != null){
				pstmt.setString(8, order.getDeliver_company());
			} else {
				pstmt.setString(8, "우체국택배");
			}
			pstmt.setString(9, order.getDeliver_num());
			i += pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(Oracle11.ADD_PAY);
			pstmt.setInt(1, pay.getPay_no());
			pstmt.setInt(2, pay.getPay_no());
			pstmt.setString(3, pay.getPay_type());
			pstmt.setInt(4, pay.getPay_price());
			i += pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(Oracle11.REMOVE_PRODUCT);
			pstmt.setInt(1, order.getOrder_count());
			pstmt.setString(2, order.getP_code());
			i += pstmt.executeUpdate();
			
			if(basket_no != 0){
				pstmt = conn.prepareStatement(Oracle11.DELETE_BASKET);
				pstmt.setInt(1, basket_no);
				i += pstmt.executeUpdate();
			}
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt);
		}
		return i;
	}
	
	public ArrayList<OrderVO> myOrder(String user_id){
		ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>();
		OrderVO orderVO = new OrderVO();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.MY_ORDER);
			pstmt.setString(1, user_id);;
			rs = pstmt.executeQuery();
			while (rs.next()){
				orderVO.setOrder_no(rs.getInt("order_no"));
				orderVO.setUser_id(rs.getString("user_id"));
				orderVO.setP_code(rs.getString("p_code"));
				orderVO.setOrder_count(rs.getInt("order_count"));
				orderVO.setOrder_price(rs.getInt("order_price"));
				orderVO.setOrder_date(rs.getString("order_date"));
				orderVO.setUser_phone(rs.getString("user_phone"));
				orderVO.setOrder_addr(rs.getString("order_addr"));
				orderVO.setDeliver_company(rs.getString("deliver_company"));
				orderVO.setDeliver_num(rs.getInt("deliver_num"));
				orderVO.setDeliver_state(rs.getString("deliver_state"));
				orderVO.setP_name(rs.getString("p_name"));
				orderVO.setPic1(rs.getString("pic1"));
				orderVOList.add(orderVO);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		return orderVOList;
	}
}
