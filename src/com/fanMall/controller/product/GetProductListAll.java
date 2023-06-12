package com.fanMall.controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Product;
import com.fanMall.model.ProductDAO;

@WebServlet("/ProductListAll.do")
public class GetProductListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		ProductDAO pdao = new ProductDAO();
		ArrayList<Product> prodListAll = pdao.prodListAll();
		request.setAttribute("prodListAll", prodListAll);
				
		RequestDispatcher view = request.getRequestDispatcher("/product/prodListAll.jsp");
		view.forward(request, response);
	}
}