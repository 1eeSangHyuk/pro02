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
<title>제품목록</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<h2>제품목록 > ${catMap.get('catname') } > ${prod.p_name }</h2>
	<fmt:setLocale value="ko-KR"/>
	<table class="table">
		<tbody>
			<tr>
				<td>
					<img src="${path }/product/${prod.pic1 }" alt="${prod.p_name }">
				</td>
			</tr>
			<tr>
				<td>${prod.p_name }</td>
			</tr>
			<tr>
				<td><fmt:formatNumber value="${prod.p_price }" type="currency" /></td>
			</tr>
			<tr>
				<td>재고 : ${prod.p_amount }</td>
			</tr>
			<c:if test="${!empty uid && !uid.equals('admin') }">
			<tr>
	        	<td>
	        		<a href="InsertBasket.do?p_code=${prod.p_code }&uid=${uid }" class="btn btn-default" role="button">장바구니에 담기</a>
	        		<a href="${path }/AddOrder.do?uid=${uid }&p_code=${prod.p_code }" class="btn btn-primary">바로 구매하기</a>
	        	</td>
			</tr>
			</c:if>
	        <c:if test="${uid.equals('admin') }">
	        <tr>
	        	<td>
	        		<a href="UpdateProduct.do?p_code=${prod.p_code }" class="btn btn-default" role="button">헤당 물품 편집(재고 관리 포함)</a>
	        		<a href="${path }/OrderListByPcode.do?p_code=${prod.p_code }" class="btn btn-default" role="button">헤당 물품에 대한 주문 관리</a>
	        		<a href="DeleteProduct.do?p_code=${prod.p_code }" class="btn btn-default" role="button">헤당 물품 삭제</a>
	        		<a href="ReviewProduct.do?p_code=${prod.p_code }" class="btn btn-default" role="button">헤당 물품에 대한 리뷰 관리</a>
	        	</td>
	        </tr>
	        </c:if>
			<tr>
				<td>${prod.p_about }</td>
			</tr>
 			<tr>
	        	<td>
	        		<a href="${path }/ProductCatList.do?catno=${prod.catno }" class="btn btn-default" role="button">제품목록 > ${catMap.get('catname') }으로 가기</a>
	        	</td>
			</tr>
		</tbody>
	</table>
</div>
<div>
	<h2>${catMap.get('catname') } 제품 후기</h2>
	<table class="table">
		
	</table>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>