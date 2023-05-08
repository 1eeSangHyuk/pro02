package com.fanMall.controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fanMall.model.UserDAO;

@WebServlet("/UserLoginPro.do")
public class UserLoginProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String msg = "";
		int cnt = 0;
		
		UserDAO udao = new UserDAO();

		try {
			cnt = udao.loginTest(id, pw);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| InvalidKeySpecException | NoSuchPaddingException
				| InvalidParameterSpecException | BadPaddingException
				| IllegalBlockSizeException
				| InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if (cnt==1){
			session.setAttribute("uid", id);
			response.sendRedirect(request.getContextPath());
		} else if (cnt==0){
			msg = "비밀번호를 다시 확인해 주세요";
			response.sendRedirect("UserLogin.do");
		} else {
			msg = "아이디를 다시 확인해 주세요";
			response.sendRedirect("UserLogin.do");
		}
	}
}