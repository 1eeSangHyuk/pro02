package com.fanMall.controller.user;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fanMall.model.UserDAO;

@WebServlet("/UserDelete.do")
public class UserDeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 0;
		String user_id = request.getParameter("user_id");
		UserDAO udao = new UserDAO();
		i = udao.deleteUser(user_id);
		HttpSession session = request.getSession();
		if (i==1){
			session.invalidate();
			response.sendRedirect(request.getContextPath());
		} else {
			response.sendRedirect("/UserDelete.do?user_id="+user_id);
		}
	}

}
