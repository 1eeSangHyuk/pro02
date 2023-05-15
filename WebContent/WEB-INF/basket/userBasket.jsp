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
	<!-- 
	userBasket같은 updateBasket(선택수량 조정)
	이어지는 addSales.do에서 Basket 물품 수량 조절 처리 / basketBOList 받아서 -> 결제창으로 
	-->
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
				<td>
					<c:if test="${uid.equals(bvo.user_id) }">
					<a href="${path }/AddOrder.do?bno=${bvo.basket_no }&uid=${uid }&p_code=${bvo.p_code }" class="btn btn-primary">선택 상품 구매하러 가기</a>
					<a href="${path }/DeleteBasket.do?basket_no=${bvo.basket_no }&uid=${uid }" class="btn btn-primary">장바구니에서 삭제하기</a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
			<c:if test="${empty basketVOList }">
			<tr>
				<td>장바구니가 비어있습니다.</td>
			</tr>
			</c:if>
		</tbody>
	</table>
	<div class="btn-group">
		<a href="${path }/" class="btn btn-primary">전체 상품 구매하러 가기</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로 가기</a>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>