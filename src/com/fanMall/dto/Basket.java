package com.fanMall.dto;

public class Basket {
	private	int	basket_no;
	private	String	user_id;
	private	String	p_code;
	private	int	basket_count;
	
	public int getBasket_no() {
		return basket_no;
	}
	public void setBasket_no(int basket_no) {
		this.basket_no = basket_no;
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
	public int getBasket_count() {
		return basket_count;
	}
	public void setBasket_count(int basket_count) {
		this.basket_count = basket_count;
	}

}	
