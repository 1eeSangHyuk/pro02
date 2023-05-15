package com.fanMall.controller.basket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.model.BasketDAO;

@WebServlet("/DeleteBasket.do")
public class DeleteBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int basket_no = Integer.parseInt(request.getParameter("basket_no"));
		String uid = request.getParameter("uid");
		
		int i = 0;
		BasketDAO bdao = new BasketDAO();
		i = bdao.deleteBasket(basket_no);
		if ( i > 0 ){
			response.sendRedirect(request.getContextPath()+"/GetUserBasket.do?uid="+uid);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
