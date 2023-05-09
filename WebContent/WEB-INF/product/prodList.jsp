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
	<h2>제품목록</h2>
	<table class="table">
		<thead>
			<tr>
				<th>연번</th>
				<th>이름</th>
				<th>가격</th>
			</tr>	
		</thead>
		<tbody>
		<c:forEach var="list" items="${prodList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="${path }/ProductListDetail.do?p_code=${list.p_code }">${list.p_name }</a></td>
				<td>${list.p_price }</td>
				<td>${list.p_about }</td>
			</tr>
		</c:forEach>
			<c:if test="${empty prodList }">
			<tr>
				<td colspan="4">등록된 제품이 존재하지 않습니다.</td>
			</tr>
			</c:if>	
		</tbody>
	</table>
	<c:if test="${uid.equals('admin' }" >
		<div class="btn-group">
			<a href="${path }/InsertProduct.do" class="btn btn-primary">제품 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</c:if>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>