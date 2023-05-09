package com.fanMall.dto;

public class Notice {
	private int notice_no;
	private String user_id;
	private String notice_date;
	private String notice_title;
	private String notice_text;
	private String notice_file;
	private int readcnt;
	public int getNotice_no() {return notice_no;}
	public void setNotice_no(int notice_no) {this.notice_no = notice_no;}
	public String getUser_id() {return user_id;}
	public void setUser_id(String user_id) {this.user_id = user_id;}
	public String getNotice_date() {return notice_date;}
	public void setNotice_date(String notice_date) {this.notice_date = notice_date;}
	public String getNotice_title() {return notice_title;}
	public void setNotice_title(String notice_title) {this.notice_title = notice_title;}
	public String getNotice_text() {return notice_text;}
	public void setNotice_text(String notice_text) {this.notice_text = notice_text;}
	public int getReadcnt() {return readcnt;}
	public void setReadcnt(int readcnt) {this.readcnt = readcnt;}
	public String getNotice_file() {return notice_file;}
	public void setNotice_file(String notice_file) {this.notice_file = notice_file;}
}
