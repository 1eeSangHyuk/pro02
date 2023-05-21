package com.fanMall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fanMall.dto.Review;
import com.fanMall.vo.ReviewVO;

public class ReviewDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<ReviewVO> getReviewVO(){
		ArrayList<ReviewVO> reviewVOList = new ArrayList<ReviewVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.GET_REVIEW_VO);
			rs = pstmt.executeQuery();
			while (rs.next()){
				ReviewVO rvo = new ReviewVO();
				rvo.setReview_no(rs.getInt("review_no"));
				rvo.setUser_id(rs.getString("user_id"));
				rvo.setOrder_no(rs.getInt("order_no"));
				rvo.setReview_date(rs.getString("review_date"));
				rvo.setReview_text(rs.getString("review_text"));
				rvo.setReview_star(rs.getInt("review_star"));
				rvo.setOrder_date(rs.getString("order_date"));
				rvo.setP_name(rs.getString("p_name"));
				reviewVOList.add(rvo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		return reviewVOList;
	}
	
	public ArrayList<ReviewVO> getReviewVOByUid(String user_id){
		ArrayList<ReviewVO> reviewVOList = new ArrayList<ReviewVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.GET_REVIEW_VO_BY_UID);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while (rs.next()){
				ReviewVO rvo = new ReviewVO();
				rvo.setReview_no(rs.getInt("review_no"));
				rvo.setUser_id(rs.getString("user_id"));
				rvo.setOrder_no(rs.getInt("order_no"));
				rvo.setReview_date(rs.getString("review_date"));
				rvo.setReview_text(rs.getString("review_text"));
				rvo.setReview_star(rs.getInt("review_star"));
				rvo.setOrder_date(rs.getString("order_date"));
				rvo.setP_name(rs.getString("p_name"));
				reviewVOList.add(rvo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		return reviewVOList;
	}
	
	public ArrayList<ReviewVO> getReviewVOByPcode(String p_code){
		ArrayList<ReviewVO> reviewVOList = new ArrayList<ReviewVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.GET_REVIEW_VO_BY_P_CODE);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();
			while (rs.next()){
				ReviewVO rvo = new ReviewVO();
				rvo.setReview_no(rs.getInt("review_no"));
				rvo.setUser_id(rs.getString("user_id"));
				rvo.setOrder_no(rs.getInt("order_no"));
				rvo.setReview_date(rs.getString("review_date"));
				rvo.setReview_text(rs.getString("review_text"));
				rvo.setReview_star(rs.getInt("review_star"));
				rvo.setOrder_date(rs.getString("order_date"));
				rvo.setP_name(rs.getString("p_name"));
				reviewVOList.add(rvo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		return reviewVOList;
	}
	
	public int insertReview(Review review){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.INSERT_REVIEW);
			pstmt.setString(1, review.getUser_id());
			pstmt.setInt(2, review.getOrder_no());
			pstmt.setString(3, review.getReview_title());
			pstmt.setString(4, review.getReview_text());
			pstmt.setInt(5, review.getReview_star());
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public Review getReviewByOrderNo(int order_no){
		Review review = new Review();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.GET_REVIEW_BY_ORDER_NO);
			pstmt.setInt(1, order_no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				review.setReview_no(rs.getInt("review_no"));
				review.setUser_id(rs.getString("user_id"));
				review.setOrder_no(order_no);
				review.setReview_date(rs.getString("review_date"));
				review.setReview_title(rs.getString("review_text"));
				review.setReview_star(rs.getInt("review_star"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return review;
	}
	
	public Review getReviewByReviewNo(int review_no){
		Review review = new Review();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.GET_REVIEW_BY_REVIEW_NO);
			pstmt.setInt(1, review_no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				review.setReview_no(review_no);
				review.setUser_id(rs.getString("user_id"));
				review.setOrder_no(rs.getInt("order_no"));
				review.setReview_date(rs.getString("review_date"));
				review.setReview_title(rs.getString("review_text"));
				review.setReview_star(rs.getInt("review_star"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return review;
	}

	public int UpdateReview(Review review) {
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.UPDATE_REVIEW);
			pstmt.setInt(1, review.getOrder_no());
			pstmt.setString(2, review.getReview_title());
			pstmt.setString(3, review.getReview_text());
			pstmt.setInt(4, review.getReview_star());
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
