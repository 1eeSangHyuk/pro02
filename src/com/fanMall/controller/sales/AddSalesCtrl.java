package com.fanMall.controller.sales;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Basket;
import com.fanMall.dto.Product;
import com.fanMall.dto.User;
import com.fanMall.model.BasketDAO;
import com.fanMall.model.ProductDAO;
import com.fanMall.model.UserDAO;

@WebServlet("/AddSales.do")
public class AddSalesCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasketDAO bdao = new BasketDAO();
		UserDAO udao = new UserDAO();
		ProductDAO pdao = new ProductDAO();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//※단일상품 결재

		//결제창으로 넘길 
		int basket_no = Integer.parseInt(request.getParameter("bno"));
		Basket basket = bdao.getUserBasket(basket_no);
		request.setAttribute("basket", basket);
		
		String user_id = basket.getUser_id();
		User user = udao.getUserSales(user_id);
		request.setAttribute("user", user);
		
		String p_code = basket.getP_code();
		Product prod = pdao.prodList(p_code);
		
		request.setAttribute("prod", prod);
		
		RequestDispatcher view = request.getRequestDispatcher("/sales/addSales.jsp");
		view.forward(request, response);
	}
}