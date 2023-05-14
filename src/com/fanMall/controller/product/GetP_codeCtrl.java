package com.fanMall.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.fanMall.model.ProductDAO;

@WebServlet("/GetP_code.do")
public class GetP_codeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_code = request.getParameter("p_code");
		String cat1 = request.getParameter("catno").substring(0, 2);
		ProductDAO pdao = new ProductDAO();
		String newP_code = pdao.getP_codeGenerator(cat1);
		JSONObject json = new JSONObject();
		json.put("result", newP_code);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}
}