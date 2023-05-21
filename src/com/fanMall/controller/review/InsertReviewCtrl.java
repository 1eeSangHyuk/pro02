package com.fanMall.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertReview.do")
public class InsertReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		request.setAttribute("order_no", order_no);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/review/insertReview.jsp");
		view.forward(request, response);
	}
}