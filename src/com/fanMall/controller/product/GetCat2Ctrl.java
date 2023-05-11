package com.fanMall.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fanMall.dto.Category;
import com.fanMall.model.ProductDAO;


@WebServlet("/GetCat2.do")
public class GetCat2Ctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pdao = new ProductDAO();
		String cat1 = request.getParameter("cat1");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		if (cat1!=null){
			ArrayList<Category> catListCat2 = pdao.catListCat2(cat1);
			JSONObject json = new JSONObject();
			json.put("catListCat2", catListCat2);
			PrintWriter out = response.getWriter();
			out.println(json.toString());
		}
	}
}