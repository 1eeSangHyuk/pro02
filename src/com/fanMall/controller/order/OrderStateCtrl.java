package com.fanMall.controller.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.model.OrderDAO;
import com.fanMall.vo.OrderVO;

@WebServlet("/OrderState.do")
public class OrderStateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
				
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		OrderVO orderVO = new OrderVO();
		OrderDAO odao = new OrderDAO();
		
		orderVO = odao.OrderByNo(order_no);
		request.setAttribute("list", orderVO);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/orderState.jsp");
		view.forward(request, response);
	}
}