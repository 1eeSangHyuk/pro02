package com.fanMall.controller.basket;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.model.BasketDAO;


@WebServlet("/InsertBasket.do")
public class InsertBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_code = request.getParameter("p_code");
		String uid = request.getParameter("uid");
		
		int i = 0;
		BasketDAO bdao = new BasketDAO();
		i = bdao.insertBasket(p_code, uid);
		if (i>0){
			response.sendRedirect(request.getContextPath()+"/GetUserBasket.do?uid="+uid);
		} else {
			response.sendRedirect(request.getContextPath()+"/ProductList.do?p_code="+p_code);
		}
	}
}