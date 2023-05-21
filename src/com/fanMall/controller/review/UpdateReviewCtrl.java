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

@WebServlet("/UpdateReview.do")
public class UpdateReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int review_no = Integer.parseInt(request.getParameter("review_no"));
		ReviewDAO rdao = new ReviewDAO();
		Review review = rdao.getReviewByReviewNo(review_no);
		
		request.setAttribute("review", review);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/review/updateReview.jsp");
		view.forward(request, response);
	}
}