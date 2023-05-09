package com.fanMall.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crypto.util.AES256;
import com.fanMall.dto.User;
import com.fanMall.model.UserDAO;

@WebServlet("/UserJoinPro.do")
public class UserJoinProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String pw = request.getParameter("pw1"), key = "%03x";
		
		try {
			pw = AES256.encryptAES256(pw, key);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| InvalidKeySpecException | NoSuchPaddingException
				| InvalidParameterSpecException | UnsupportedEncodingException
				| BadPaddingException | IllegalBlockSizeException e1) {
			e1.printStackTrace();
		}
		
		User user = new User();
		user.setUser_id(request.getParameter("id"));
		user.setUser_pw(pw);
		user.setUser_name(request.getParameter("name1"));
		user.setUser_phone(request.getParameter("phone"));
		user.setUser_addr(request.getParameter("address1")+" "+request.getParameter("address2"));
		user.setUser_email(request.getParameter("email"));
		
		UserDAO udao = new UserDAO();
		int i = udao.insertUser(user);
		if (i >= 1){
			response.sendRedirect("UserLogin.do");
		} else {
			response.sendRedirect("UserSignUp.do");
		}
	}
}
