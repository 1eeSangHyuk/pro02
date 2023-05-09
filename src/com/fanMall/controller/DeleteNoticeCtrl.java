package com.fanMall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.model.NoticeDAO;


@WebServlet("/DeleteNotice.do")
public class DeleteNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO ndao = new NoticeDAO();
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		
		int i = ndao.noticeDelete(notice_no);
		if (i == 0){
			response.sendRedirect("NoticeListDetail.do?notice_no="+notice_no);
		} else {
			response.sendRedirect("NoticeList.do");
		}
	}
}
