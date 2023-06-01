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
<%@ include file="../common.jsp" %>
<title>전체제품목록</title>
<style>
</style>
</head>
<body>
<%@ include file="../header.jsp" %>
<div>
	<h2>전체제품목록</h2>
	<fmt:setLocale value="ko-KR"/>
	<c:forEach var="prod" items="${prodListAll }">
	<div class="row">
	  <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
	      <a href="ProductList.do?p_code=${prod.p_code }">	
	      	<img src="${path }/product/${prod.pic1 }" alt="${prod.p_name }">
	      </a>
	      <div class="caption">
	        <p><a href="ProductList.do?p_code=${prod.p_code }">${prod.p_name }</a></p>
	        <h3><fmt:formatNumber value="${prod.p_price }" type="currency" ></fmt:formatNumber></h3>
	        <a href="ProductList.do?p_code=${prod.p_code }" class="btn btn-default" role="button">제품 관리 페이지</a>	
	      </div>
	    </div>
	  </div>
	</div>
	</c:forEach>
	<c:if test="${empty prodListAll }">
		<h3>제품 목록이 비어있습니다.</h3>
	</c:if>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>