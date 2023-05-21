package com.fanMall.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Product;
import com.fanMall.model.ProductDAO;
import com.fanMall.model.ReviewDAO;
import com.fanMall.vo.ReviewVO;

@WebServlet("/ProductList.do")
public class GetProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String p_code = request.getParameter("p_code");
		
		ProductDAO pdao = new ProductDAO();
		Product prod = pdao.prodList(p_code);
		HashMap<String, String> catMap = pdao.catMap(prod.getCatno());
		
		request.setAttribute("prod", prod);
		request.setAttribute("catMap", catMap);
		
		ReviewDAO rdao = new ReviewDAO();
		ArrayList<ReviewVO> reviewVOList = new ArrayList<ReviewVO>(); 
		reviewVOList = rdao.getReviewVOByPcode(p_code);
		request.setAttribute("reviewVOList", reviewVOList);
		
		RequestDispatcher view = request.getRequestDispatcher("/product/prodList.jsp");
		view.forward(request, response);
	}
}