package com.fanMall.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Notice;
import com.fanMall.model.NoticeDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/InsertNoticePro.do")
public class InsertNoticeProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/data";
		int uploadFileSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		String user_id = "";
		String notice_title = "";
		String notice_text = "";
		String fileName = "";
		
		NoticeDAO ndao = new NoticeDAO();
		Notice noti = new Notice();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath,
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("file1");
			if (fileName != null) {
				noti.setNotice_file("data/"+fileName);
			}
			user_id = multi.getParameter("id");
			notice_title = multi.getParameter("title");
			notice_text = multi.getParameter("textInput");
		} catch (Exception e) {
			e.printStackTrace();
		}
		noti.setUser_id(user_id);
		noti.setNotice_title(notice_title);
		noti.setNotice_text(notice_text);
		
		int i = ndao.noticeInsert(noti);
		if (i == 0){
			String msg = "공지사항을 등록하지 못했습니다.";
			request.setAttribute("msg", msg);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/insertNotice.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("NoticeList.do");
		}
	}

}
