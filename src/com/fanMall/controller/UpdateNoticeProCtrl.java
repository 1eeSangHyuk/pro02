package com.fanMall.controller;

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


@WebServlet("/UpdateNoticePro.do")
public class UpdateNoticeProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/data";	//업로드할 디렉토리
		int uploadFileSizeLimit = 10 * 1024 * 1024;	//업로드할 파일 크기 제한
		String encType = "UTF-8";		//멀티파트 데이터의 인코딩 설정
		ServletContext context = getServletContext();	//현재 서블릿(프로젝트)의 위치 저장
		String uploadFilePath = context.getRealPath(savePath);  //서버 상에 실제 업로드되는 디렉토리 지정
		
		int notice_no = 0;
		String notice_title = "";
		String notice_text = "";
		String fileName = "";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath,
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			notice_no = Integer.parseInt(multi.getParameter("no"));
			fileName = multi.getFilesystemName("file1");
			notice_title = multi.getParameter("title");
			notice_text = multi.getParameter("textInput");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NoticeDAO ndao = new NoticeDAO();
		Notice noti = new Notice();
		/*noti.setUser_id(user_id);*/
		noti.setNotice_no(notice_no);
		noti.setNotice_title(notice_title);
		noti.setNotice_text(notice_text);
		noti.setNotice_file(fileName);
		int i = ndao.noticeUpdate(noti);

		if (i == 0){
			String msg = "업데이트가 이뤄지지 않았습니다.";
			request.setAttribute("msg", msg);
			
			response.sendRedirect("UpdateNotice.do?notice_no="+notice_no);
		} else {
			response.sendRedirect("NoticeListDetail.do");
		}
	}

}
