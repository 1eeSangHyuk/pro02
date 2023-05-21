package com.fanMall.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Review;
import com.fanMall.model.ReviewDAO;


@WebServlet("/InsertReviewPro.do")
public class InsertReviewProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Review review = new Review();
		review.setUser_id(request.getParameter("id"));
		review.setOrder_no(Integer.parseInt(request.getParameter("order_no")));
		review.setReview_title(request.getParameter("title"));
		review.setReview_text(request.getParameter("textInput"));
		review.setReview_star(Integer.parseInt(request.getParameter("star")));
		
		ReviewDAO rdao = new ReviewDAO();
		int i = rdao.insertReview(review);
		if (i == 0){
			String msg = "리뷰를 등록하지 못했습니다.";
			request.setAttribute("msg", msg);
			
			RequestDispatcher view = request.getRequestDispatcher(request.getContextPath()+"/InsertReview.do?order_no="+request.getParameter("order_no"));
			view.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath()+"/MyOrder.do?uid="+request.getParameter("id"));
		}
	}
}