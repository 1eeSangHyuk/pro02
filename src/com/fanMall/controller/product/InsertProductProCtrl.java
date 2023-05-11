package com.fanMall.controller.product;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.dto.Product;
import com.fanMall.model.ProductDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/InsertProductPro.do")
public class InsertProductProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String savePath = "/product/img/prod_img/fan";
		int uploadFileSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		String pic1 = "", pic2 = "", pic3 = "";
		
		ProductDAO pdao = new ProductDAO();
		Product prod = new Product();
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath,
				uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		pic1 = multi.getFilesystemName("pic1");
		pic2 = multi.getFilesystemName("pic2");
		pic3 = multi.getFilesystemName("pic3");
		if (pic1 != null){
			prod.setPic1("."+savePath.substring(8, savePath.length())+"/"+pic1);
		}
		if (pic2 != null){
			prod.setPic2("."+savePath.substring(8, savePath.length())+"/"+pic2);
		} 
		if (pic3 != null){
			prod.setPic3("."+savePath.substring(8, savePath.length())+"/"+pic3);
		}
		prod.setP_code(multi.getParameter("p_code"));
		prod.setP_name(multi.getParameter("p_name"));
		prod.setP_price(Integer.parseInt(multi.getParameter("p_price")));
		prod.setP_about(multi.getParameter("p_about"));
		prod.setP_amount(Integer.parseInt(multi.getParameter("p_amount")));
		prod.setCatno(multi.getParameter("catno"));
		
		int i = pdao.insertProduct(prod);
		
		if (i==1){
			response.sendRedirect("ProductListAll.do");
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}
}