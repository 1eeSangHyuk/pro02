package com.fanMall.controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Category;
import com.fanMall.model.ProductDAO;

@WebServlet("/InsertProduct.do")
public class InsertProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pdao = new ProductDAO();
		ArrayList<Category> catList = pdao.catListAll();
		request.setAttribute("catList", catList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/insertProduct.jsp");
		view.forward(request, response);
	}
}