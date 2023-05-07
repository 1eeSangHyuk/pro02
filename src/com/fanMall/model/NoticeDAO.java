package com.fanMall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fanMall.dto.Notice;


public class NoticeDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<Notice> noticeListAll(){
		ArrayList<Notice> notiList = new ArrayList<Notice>();
		//notice tbl에서 모든 레코드 검색 -> 반환된 rs를 notiList에 add
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Notice noti = new Notice();
				noti.setNotice_no(rs.getInt("notice_no"));
				noti.setUser_id(rs.getString("user_id"));
				noti.setNotice_title(rs.getString("notice_title"));
				noti.setNotice_date(rs.getString("notice_date"));
				noti.setReadcnt(rs.getInt("readcnt"));
				notiList.add(noti);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Oracle11.close(conn, pstmt, rs);
		return notiList;
	}
	
	public Notice noticeList(int notice_no){
		Notice noti = new Notice();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_SELECT_ONE);
			pstmt.setInt(1, notice_no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				noti.setNotice_no(notice_no);
				noti.setUser_id(rs.getString("user_id"));
				noti.setNotice_title(rs.getString("notice_title"));
				noti.setNotice_text(rs.getString("notice_text"));
				noti.setNotice_date(rs.getString("notice_date"));
				noti.setNotice_file(rs.getString("notice_file"));
				noti.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Oracle11.close(conn, pstmt, rs);
		return noti;
	}
	
	public void readCountUpdate(int notice_no){
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_READCOUNT_UPDATE);
			pstmt.setInt(1, notice_no);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Oracle11.close(conn, pstmt);
	}
	
	public int noticeInsert(Notice noti){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_INSERT);
			pstmt.setString(1, noti.getUser_id());
			pstmt.setString(2, noti.getNotice_title());
			pstmt.setString(3, noti.getNotice_text());
			pstmt.setString(4, "data/"+noti.getNotice_file());
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Oracle11.close(conn, pstmt);
		return i;
	}
	
	public int noticeUpdate(Notice noti){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_UPDATE);
			pstmt.setString(1, noti.getNotice_title());
			pstmt.setString(2, noti.getNotice_text());
			pstmt.setString(3, noti.getNotice_file());
			pstmt.setInt(4, noti.getNotice_no());
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Oracle11.close(conn, pstmt);
		return i;
	}
	
	public int noticeDelete(int notice_no){
		int i = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_DELETE);
			pstmt.setInt(1, notice_no);
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Oracle11.close(conn, pstmt);
		return i;
	}
}
