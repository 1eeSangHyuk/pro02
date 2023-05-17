package com.fanMall.controller.product;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Product;
import com.fanMall.model.ProductDAO;

@WebServlet("/UpdateProduct.do")
public class UpdateProductCtrl extends HttpServlet {
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
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/updateProduct.jsp");
		view.forward(request, response);
	}
}