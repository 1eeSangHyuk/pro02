package com.fanMall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				rvo.setCatno(rs.getString("catno"));
				rvo.setPic1(rs.getString("pic1"));
				reviewVOList.add(rvo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(conn, pstmt, rs);
		}
		return reviewVOList;
	}
}
