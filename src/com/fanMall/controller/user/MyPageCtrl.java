package com.fanMall.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.User;
import com.fanMall.model.UserDAO;

@WebServlet("/MyPage.do")
public class MyPageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("uid");
		UserDAO udao = new UserDAO();
		User user = new User();
		user = udao.getUserById(user_id);
		request.setAttribute("user", user);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/myPage.jsp");
		view.forward(request, response);
	}

}
