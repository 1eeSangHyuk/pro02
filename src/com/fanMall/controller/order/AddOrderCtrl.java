package com.fanMall.controller.order;

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

@WebServlet("/AddOrder.do")
public class AddOrderCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasketDAO bdao = new BasketDAO();
		UserDAO udao = new UserDAO();
		ProductDAO pdao = new ProductDAO();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//※단일상품 결재

		//장바구니에서 넘어온 정보 처리
		int basket_no = 0;
		Basket basket = new Basket();
		if(request.getParameter("bno") != null){
			basket_no = Integer.parseInt(request.getParameter("bno"));
			basket = bdao.getUserBasket(basket_no);
			request.setAttribute("basket", basket);
		}
		
		//사용자 정보 로딩
		String user_id = request.getParameter("uid");
		User user = udao.getUserById(user_id);
		request.setAttribute("user", user);
		
		//제품 정보 로딩
		String p_code = request.getParameter("p_code");
		Product prod = pdao.prodList(p_code);
		
		request.setAttribute("prod", prod);
		
		RequestDispatcher view = request.getRequestDispatcher("/order/addOrder.jsp");
		view.forward(request, response);
	}
}