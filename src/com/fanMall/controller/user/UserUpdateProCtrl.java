package com.fanMall.controller.user;

import java.io.IOException;
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

import com.crypto.util.AES256;
import com.fanMall.dto.User;
import com.fanMall.model.UserDAO;


@WebServlet("/UserUpdatePro.do")
public class UserUpdateProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String key = "%03x";
		User user = new User();
		String user_id = request.getParameter("id");
		user.setUser_id(user_id);
		try {
			user.setUser_pw(AES256.encryptAES256(request.getParameter("pw1"), key));
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| InvalidKeySpecException | NoSuchPaddingException
				| InvalidParameterSpecException | BadPaddingException
				| IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		user.setUser_name(request.getParameter("name1"));
		user.setUser_phone(request.getParameter("phone"));
		user.setUser_addr(request.getParameter("address1")+" "+request.getParameter("address2")+"("+request.getParameter("postcode")+")");
		user.setUser_email(request.getParameter("email"));
		
		UserDAO udao = new UserDAO();
		int i = udao.updateUser(user);
		if (i==1){
			response.sendRedirect(request.getContextPath()+"/MyPage.do?uid="+user_id);
		} else {
			response.sendRedirect(request.getContextPath()+"/UserUpdate.do?user_id="+user_id);
		}
	}
}