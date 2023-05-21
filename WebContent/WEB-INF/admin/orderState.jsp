<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*, java.text.*, java.net.InetAddress" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../common.jsp" %>
<title>배송 처리</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<h2>배송 처리</h2>
	<form action="${path }/UpdateOrderState.do" method="post">
		<table class="table" style="width: 90%">
			<tbody>
			<fmt:setLocale value="ko-KR"/>
				<tr>
					<th>주문번호</th>
					<td>
						<span>${list.order_no }</span>
						<input type="hidden" id="order_no" name="order_no" value="${list.order_no }">
					</td>
				</tr>
				<tr>
					<th>구매자</th>
					<td><span title="연락처 : ${list.user_phone }" style="cursor:pointer; display:inline-block;">${list.user_id }</span></td>
				</tr>
				<tr>
					<th>주문제품</th>
					<td>
						<img src="${path }/product/${list.pic1 }" alt="${list.p_name }" width="200" height="200"> &nbsp;&nbsp;&nbsp;
						<span title="제품코드 : ${list.p_code }" style="cursor:pointer; display:inline-block;">${list.p_name }</span>
					</td>
				</tr>
				<tr>
					<th>구매수량</th>
					<td>${list.order_count }</td>
				</tr>
				<tr>
					<th>결제금액</th>
					<td><fmt:formatNumber type="currency">${list.order_price }</fmt:formatNumber></td>
				</tr>
				<tr>
					<th>주문일</th>
					<td>${list.order_date }</td>
				<tr>
					<th>배송주소</th>
					<td>${list.order_addr }</td>
				</tr>
				<tr>
					<th><label for="deliver_company">배송회사</label></th>
					<td>
						<span>${list.deliver_company }</span>
						<select id="deliver_company" name="deliver_company" required>
							<option value="">선택안함</option>
							<option value="CJ대한통운">CJ대한통운</option>
							<option value="롯데택배">롯데택배</option>
							<option value="우체국택배">우체국택배</option>
							<option value="로젠택배">로젠택배</option>
							<option value="한진택배">한진택배</option>
							<option value="CU 편의점택배">CU 편의점택배</option>
							<option value="EMS 택배">EMS 택배</option>
							<option value="경동택배">경동택배</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>배송번호</th>
					<td>
						<span>${list.deliver_num }</span>
						<input type="hidden" id="deliver_num" name="deliver_num" value="${list.deliver_num }">
					</td>
				</tr>
				<tr>
					<th><label for="deliver_state">배송상태</label></th>
					<td>
						<span>${list.deliver_state }</span>
						<select id="deliver_state" name="deliver_state" required>
							<option value="배송 전">배송 전</option>
							<option value="배송 중">배송 중</option>
							<option value="배송완료">배송완료</option>
							<option value="구매 확정">구매 확정</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<div>
			<input type="submit" value="배송 처리 변경" class="btn btn-primary">
			<c:if test="${! list.deliver_state.equals('구매완료') }">
			<a href="${path }/CancelOrder.do?order_no=${list.order_no }" class="btn btn-primary">주문취소</a>
			</c:if>
			<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로가기</a>
		</div>
	</form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>