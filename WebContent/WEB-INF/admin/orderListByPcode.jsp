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
<title>주문 관리</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<h2>주문 관리</h2>
	<table class="table" style="width: 90%">
		<thead>
			<tr> 
				<th>연번</th>
				<th>구매자</th>
				<th colspan="2">주문제품</th>
				<th>구매수량</th>
				<th>결제금액</th>
				<th>주문일</th>
				<th>배송주소</th>
				<th colspan="2">배송상태</th>
			</tr>
		</thead>
		<tbody>
		<fmt:setLocale value="ko-KR"/>
			<c:forEach var="list" items="${orderVOList }" varStatus="status">
			<tr>
				<td><span title="주문번호 : ${list.order_no }" style="cursor:pointer; display:inline-block;">${status.count }</span></td>
				<td><span title="연락처 : ${list.user_phone }" style="cursor:pointer; display:inline-block;">${list.user_id }</span></td>
				<td><img src="${path }/product/${list.pic1 }" alt="${list.p_name }" width="200" height="200"></td>
				<td><span title="제품코드 : ${list.p_code }" style="cursor:pointer; display:inline-block;">${list.p_name }</span></td>
				<td>${list.order_count }</td>
				<td><fmt:formatNumber type="currency">${list.order_price }</fmt:formatNumber></td>
				<td>${list.order_date }</td>
				<td>${list.order_addr }</td>
				<td><span title="배송회사 : ${list.deliver_company }" style="cursor:pointer; display:inline-block;">${list.deliver_state }</span></td>
				<c:if test="${!list.deliver_state.equals('배송완료') }">
				<td><a href="${path }/OrderState.do?order_no=${list.order_no }" class="btn btn-primary">배송 처리</a></td>
				</c:if>
			</tr>
			</c:forEach>
			<c:if test="${empty orderVOList }">
			<tr>
				<td>헤당 상품에 대한 주문이 존재하지 않습니다.</td>
			</tr>
			</c:if>
		</tbody>
	</table>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>