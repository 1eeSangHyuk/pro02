package com.fanMall.controller.notice;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Notice;
import com.fanMall.model.NoticeDAO;


@WebServlet("/UpdateNotice.do")
public class UpdateNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "공지사항을 업데이트합니다.";
		request.setAttribute("msg", msg);
		
		NoticeDAO ndao = new NoticeDAO();
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		Notice noti = new Notice();
		
		noti = ndao.noticeList(notice_no);
		
		String file1 = "", filepath = "";
		
		if(noti.getNotice_file() != null){
			file1 = noti.getNotice_file().substring(5); 
			filepath = noti.getNotice_file().substring(0,4);
			file1 = URLEncoder.encode(file1, "UTF-8");	
			
			request.setAttribute("file1", file1);
			request.setAttribute("filepath", filepath);
		}

		request.setAttribute("noti", noti);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/notice/updateNotice.jsp");
		view.forward(request, response);
	}

}
