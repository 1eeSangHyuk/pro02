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
<title>구매내역</title>
<style>
</style>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<h2>구매내역</h2>
	<fmt:setLocale value="ko-KR"/>
	<table class="table"> 
		<thead>
			<tr>
				<th>주문번호</th>
				<th colspan="2">제품명</th>
				<th>구매수량</th>
				<th>가격</th>
				<th>구매일</th>
				<th>배송주소</th>
				<th>배송회사</th>
				<th>운송장번호</th>
				<th>배송상태</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="order" items="${orderVOList }">
			<tr>
				<td>${order.order_no }</td>
				<td><img src="${path }/product/${order.pic1 }" alt="${order.p_name }" width="200" height="200"></td>
				<td>${order.p_name }</td>
				<td>${order.order_count }</td>
				<td>
					<fmt:formatNumber type="currency">
					${order.order_price }
					</fmt:formatNumber>
				</td>
				<td>${order.order_date }</td>
				<td>${order.order_addr }</td>
				<td>${order.deliver_company }</td>
				<td>${order.deliver_num }</td>
				<td>${order.deliver_state }
					<c:if test="${order.deliver_state eq '배송 전'}">
					<br>
					<a href="${path }/CanclePay.do?order_no=${order.order_no }" class="btn btn-primary">주문 취소하기</a>
					</c:if>
					<c:if test="${order.deliver_state != '배송 전'}">
					<br>
					<a href="${path }/ReturnBuy.do?order_no=${order.order_no }">반품 요청</a>
					<a href="${path }/OkBuy.do?order_no=${order.order_no }">구매 확정하기</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty orderVOList }">
			<tr>
				<td colspan="11">
					주문내역이 존재하지 않습니다.
				</td>
			</tr>
		</c:if>
		</tbody>
	</table>
	<div>
		<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로가기</a>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>