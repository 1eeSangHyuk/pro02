package com.fanMall.dto;

public class Prod_order {
	private	int	order_no;
	private	String	user_id;
	private	String	p_code;
	private	int	order_count;
	private	int	order_price;
	private	String	order_date;
	private String user_phone;
	private	String	order_addr;
	private	String	deliver_company;
	private	int	deliver_num;
	private	String	deliver_state;
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public String getDeliver_company() {
		return deliver_company;
	}
	public void setDeliver_company(String order_company) {
		this.deliver_company = order_company;
	}
	public int getDeliver_num() {
		return deliver_num;
	}
	public void setDeliver_num(int order_num) {
		this.deliver_num = order_num;
	}
	public String getDeliver_state() {
		return deliver_state;
	}
	public void setDeliver_state(String order_state) {
		this.deliver_state = order_state;
	}

}
