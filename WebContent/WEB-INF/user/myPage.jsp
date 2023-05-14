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
<title>회원정보</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<h2>회원정보</h2>
<table class="table">
	<tbody>
		<tr>
			<th>아이디</th>
			<td>${user.user_id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${user.user_pw }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${user.user_name }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${user.user_phone }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${user.user_addr }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${user.user_email }</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${user.user_regdate }</td>
		</tr>
		<tr>
			<th>포인트</th>
			<td>${user.user_point }</td>
		</tr>
	</tbody>
</table>
<div>
	<a href="${path }/UserUpdate.do?user_id=${user.user_id }" class="btn btn-primary">회원정보 수정</a>
	<a href="${path }/UserDelete.do?user_id=${user.user_id }" class="btn btn-primary">회원 탈퇴</a>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>