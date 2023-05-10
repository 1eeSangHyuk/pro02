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

@WebServlet("/ProductCatList.do")
public class GetProductCatList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String catno = request.getParameter("catno");
		if(catno==null){
			catno = "0000";
		}
		
		ProductDAO pdao = new ProductDAO();
		
		HashMap<String, String> catMap = pdao.catMap(catno);
		
		ArrayList<Product> prodCatList = pdao.prodCatList(catno);
		request.setAttribute("prodCatList", prodCatList);
		request.setAttribute("catMap", catMap);
		
		RequestDispatcher view = request.getRequestDispatcher("/product/prodCatList.jsp");
		view.forward(request, response);
	}
}