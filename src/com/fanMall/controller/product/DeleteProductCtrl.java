package com.fanMall.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.model.ProductDAO;

@WebServlet("/DeleteProduct.do")
public class DeleteProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_code = request.getParameter("p_code");
		ProductDAO pdao = new ProductDAO();
		int i = pdao.deleteProduct(p_code);
		if (i>1){
			response.sendRedirect("/product/prodListAll.jsp");
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
