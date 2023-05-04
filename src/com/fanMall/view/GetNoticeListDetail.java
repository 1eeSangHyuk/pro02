package com.fanMall.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Notice;
import com.fanMall.model.NoticeDAO;


@WebServlet("/NoticeListDetail.do")
public class GetNoticeListDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO ndao = new NoticeDAO();
		Notice noti = new Notice();
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		noti = ndao.noticeList(notice_no);
		ndao.readCountUpdate(notice_no);
		request.setAttribute("noti", noti);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/notiListDetail.jsp");
		view.forward(request, response);
	}

}
