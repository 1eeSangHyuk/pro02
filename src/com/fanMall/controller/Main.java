package com.fanMall.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Notice;
import com.fanMall.dto.Product;
import com.fanMall.model.NoticeDAO;
import com.fanMall.model.ProductDAO;

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Main() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//홈 디렉토리 잡기
		ServletContext application = request.getServletContext();
		String realPath = request.getSession().getServletContext().getRealPath("/");
		application.setAttribute("realPath", realPath);
		
		NoticeDAO ndao = new NoticeDAO();
		ArrayList<Notice> notiList = new ArrayList<Notice>();
		notiList = ndao.noticeListAll();
		request.setAttribute("notiList", notiList);
		
		ProductDAO pdao = new ProductDAO();
		ArrayList<Product> prodListAll = pdao.prodListAll();
		request.setAttribute("prodListAll", prodListAll);
		
		//메인 페이지 포워딩
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
	}
}