package com.fanMall.controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanMall.model.OrderDAO;
import com.fanMall.vo.OrderVO;

@WebServlet("/UpdateOrderState.do")
public class UpdateOrderStateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		String deliver_company = request.getParameter("deliver_company");
		String deliver_state = request.getParameter("deliver_state");
		String deliver_num = request.getParameter("deliver_num");
		
		OrderVO orderVO = new OrderVO();
		OrderDAO odao = new OrderDAO();
				
		orderVO.setOrder_no(order_no);
		orderVO.setDeliver_company(deliver_company);
		if (deliver_company != null){
			orderVO.setDeliver_state(deliver_state);
			if (deliver_state.equals("배송 전")){
				orderVO.setDeliver_company("");
			}
		} else {
			orderVO.setDeliver_state("배송 전");
		}
		if ((!deliver_state.equals("배송 전")) && (deliver_company != null) && (deliver_num == null)){
			orderVO.setDeliver_num(odao.deliverNumGenerator());
		} else {
			orderVO.setDeliver_num(deliver_num);
		}
		
		int i = odao.UpdateOrder(orderVO);
		if (i>0){
			response.sendRedirect(request.getContextPath()+"/OrderListAll.do");
		} else {
			response.sendRedirect(request.getContextPath()+"/OrderState.do?order_no="+order_no);
		}
	}
}