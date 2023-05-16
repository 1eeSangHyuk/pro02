package com.fanMall.controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Pay;
import com.fanMall.dto.Prod_order;
import com.fanMall.model.OrderDAO;

@WebServlet("/AddPayment.do")
public class AddPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		String user_id = request.getParameter("user_id");
		String p_code = request.getParameter("p_code");
		int basket_no = Integer.parseInt(request.getParameter("basket_no"));
		
		OrderDAO odao = new OrderDAO();
		Prod_order order = new Prod_order();
		
		order.setOrder_no(odao.orderNoGenerator());
		order.setUser_id(user_id);
		order.setP_code(p_code);
		order.setOrder_count(Integer.parseInt(request.getParameter("count")));
		order.setOrder_price(Integer.parseInt(request.getParameter("payamount")));
		//Order_date - default
		order.setUser_phone(request.getParameter("user_phone"));
		order.setOrder_addr(request.getParameter("address1")+" "+request.getParameter("address2")+" ("+request.getParameter("postcode")+")");
		order.setDeliver_company("");
		order.setDeliver_num(odao.deliverNumGenerator());
//		order.setDeliver_state("배송 전"); --default
		
		Pay pay = new Pay();
		
		pay.setPay_no(odao.payNoGenerator());
		pay.setOrder_no(order.getOrder_no());
		pay.setPay_type(request.getParameter("pay_type"));
		pay.setPay_price(order.getOrder_price());
		//pay_date - default
		
		int i = 0;
		i = odao.addOrder(order, pay, basket_no);
		System.out.println(i);
		if(i>=3){
			response.sendRedirect("/MyOrder.do?uid="+user_id);
		} else {
			response.sendRedirect("/AddOrder.do?bno="+basket_no+"&uid="+user_id+"&p_code="+p_code);
		}
		
	}
}