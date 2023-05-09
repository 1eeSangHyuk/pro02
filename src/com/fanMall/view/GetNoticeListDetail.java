package com.fanMall.view;

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


@WebServlet("/NoticeListDetail.do")
public class GetNoticeListDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "공지사항 자세히보기";
		String notice_file = "";
		String filepath1 = "";
		
		NoticeDAO ndao = new NoticeDAO();
		Notice noti = new Notice();
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		noti = ndao.noticeList(notice_no);
		ndao.readCountUpdate(notice_no);
		
		
		//한글 파일 이름 인코딩 처리
		if (noti.getNotice_file() != null){
			notice_file = noti.getNotice_file().substring(5); 
			filepath1 = noti.getNotice_file().substring(0,4);
			
			notice_file = URLEncoder.encode(notice_file, "UTF-8");	
		}
		request.setAttribute("notice_file", notice_file);
		request.setAttribute("filepath", filepath1);
		request.setAttribute("noti", noti);
		request.setAttribute("msg", msg);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/notiListDetail.jsp");
		view.forward(request, response);
	}

}
