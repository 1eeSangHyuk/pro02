package com.fanMall.controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.model.OrderDAO;

@WebServlet("/OkBuy.do")
public class OkBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("uid");
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		OrderDAO odao = new OrderDAO();
		odao.UpdateDeliverStatefin(order_no);
		
		response.sendRedirect(request.getContextPath()+"/MyOrder.do?uid="+user_id);
	}
}