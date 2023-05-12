package com.fanMall.controller.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Pay;
import com.fanMall.dto.Prod_order;

@WebServlet("/AddPayment.do")
public class AddPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		String count = request.getParameter("count");
		String user_id = request.getParameter("user_id");
		int basket_no = Integer.parseInt(request.getParameter("basket_no"));
		String catno = request.getParameter("catno");
		
		Pay pay = new Pay();
		Prod_order prod_order = new Prod_order();
		
//		pay.setPay_no(); --seq
		pay.setUser_id(user_id);
		pay.setPay_type(request.getParameter("ptype"));
		pay.setPay_price(Integer.parseInt(request.getParameter("totPrice")));
//		prod_order.setOrder_no(); --seq
	}
}