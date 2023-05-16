package com.fanMall.controller.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.model.OrderDAO;
import com.fanMall.vo.OrderVO;

@WebServlet("/OrderListAll.do")
public class OrderListAllCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDAO odao = new OrderDAO();
		ArrayList<OrderVO> orderVOList = new ArrayList<>();
		orderVOList = odao.OrderListAll();
		request.setAttribute("orderVOList", orderVOList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/orderListAll.jsp");
		view.forward(request, response);
	}
}