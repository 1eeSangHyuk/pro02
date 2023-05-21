package com.fanMall.controller.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Review;
import com.fanMall.model.OrderDAO;
import com.fanMall.model.ReviewDAO;
import com.fanMall.vo.OrderVO;

@WebServlet("/MyOrder.do")
public class MyOrderCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("uid");
		
		OrderDAO odao = new OrderDAO();
		ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>();
		orderVOList = odao.myOrder(user_id);
		request.setAttribute("orderVOList", orderVOList);
		
		ReviewDAO rdao = new ReviewDAO();
		for (OrderVO o : orderVOList){
			Review review = rdao.getReviewByOrderNo(o.getOrder_no());
			if(review.getOrder_no()==o.getOrder_no()){
				request.setAttribute("review", review);
			}
		}
			
		RequestDispatcher view = request.getRequestDispatcher("/order/myOrder.jsp");
		view.forward(request, response);
	}
}