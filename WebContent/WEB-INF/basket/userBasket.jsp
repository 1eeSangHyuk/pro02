<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*, java.text.*, java.net.InetAddress" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../common.jsp" %>
<title>${uid }님의 장바구니</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<h2>${uid }님의 장바구니</h2>
	<table class="table">
		<thead>
			<tr>
				<th>연번</th>
				<th>제품명</th>
				<th>선택수량</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<fmt:setLocale value="ko-KR"/>
			<c:forEach var="bvo" items="${basketVOList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${bvo.p_name }</td>
				<td>${bvo.basket_count }</td>
				<td><fmt:formatNumber type="currency" >${bvo.p_price * bvo.basket_count }</fmt:formatNumber>
				<td><a href="${path }/" class="btn btn-primary">선택 상품 구매하러 가기</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="btn-group">
		<a href="${path }/" class="btn btn-primary">전체 상품 구매하러 가기</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>