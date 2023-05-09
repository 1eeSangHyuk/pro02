package com.fanMall.controller.notice;

import java.io.IOException;

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


@WebServlet("/UpdateNoticePro.do")
public class UpdateNoticeProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		String savePath = "/data";
		int uploadFileSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		int notice_no = 0;
		String user_id = "";
		String notice_title = "";
		String notice_text = "";
		String fileName = "";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath,
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			notice_no = Integer.parseInt(multi.getParameter("no"));
			user_id = multi.getParameter("user_id");
			fileName = multi.getFilesystemName("file1");
			notice_title = multi.getParameter("title");
			notice_text = multi.getParameter("textInput");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		NoticeDAO ndao = new NoticeDAO();
		Notice noti = new Notice();
		noti.setUser_id(user_id);
		noti.setNotice_no(notice_no);
		noti.setNotice_title(notice_title);
		noti.setNotice_text(notice_text);
		noti.setNotice_file(fileName);
		int i = ndao.noticeUpdate(noti);

		if (i == 0){
			response.sendRedirect("UpdateNotice.do?notice_no="+notice_no);
		} else {
			response.sendRedirect("NoticeList.do");
		}
	}

}
