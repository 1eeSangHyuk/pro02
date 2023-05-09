package com.fanMall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fanMall.model.UserDAO;

@WebServlet("/IdCheck.do")
public class IdCheckCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		UserDAO udao = new UserDAO();
		int i = udao.idCheck(id);
		boolean res = false;
		if (i==1){
			res = false;
		} else {
			res = true;
		}
		JSONObject json = new JSONObject();
		json.put("result", res);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}

}
