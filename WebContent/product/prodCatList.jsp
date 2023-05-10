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
<title>제품목록</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<h2>제품목록 > ${catMap.get("catname") }</h2>
	<fmt:setLocale value="ko-KR"/>
	<c:forEach var="prod" items="${prodCatList }">
	<div class="row">
	  <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
	      <a href="ProductList.do?p_code=${prod.p_code }">	
	      	<img src="${path }/product/${prod.pic1 }" alt="${prod.p_name }">
	      </a>
	      <div class="caption">
	        <p><a href="ProductList.do?p_code=${prod.p_code }">${prod.p_name }</a></p>
	        <h3><fmt:formatNumber value="${prod.p_price }" type="currency" ></fmt:formatNumber></h3>
	        <c:if test="${!empty uid } && ${!uid.equals('admin') }">
	        <p>
	        	<a href="InsertBasket.do?p_code=${prod.p_code }" class="btn btn-default" role="button">장바구니에 담기</a>
	        	<a href="InsertSales.do?p_code=${prod.p_code }" class="btn btn-default" role="button">바로 구매하기</a>
	        </p>
	        </c:if>
	        <c:if test="${uid.equals('admin') }">
	        	<a href="ProductList.do?p_code=${prod.p_code }" class="btn btn-default" role="button">제품 관리 페이지</a>	
	        </c:if>
	      </div>
	    </div>
	  </div>
	</div>
	</c:forEach>
	<c:if test="${empty prodCatList }">
		<h3>제품 목록이 비어있습니다.</h3>
	</c:if>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>