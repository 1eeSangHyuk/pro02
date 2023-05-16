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
<title>공지사항</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<h2>로그인</h2>
	<p>${msg }</p>
	<form action="UserLoginPro.do" method="post">
		<table class="table">
			<tbody>
				<tr>
					<th><label for="">아이디 : </label></th>
					<td><input type="text" id="id" name="id" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th><label for="">비밀번호 : </label></th>
					<td><input type="password" id="pw" name="pw"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인하기" class="btn btn-primary">
						<input type="reset" value="리셋" class="btn btn-primary">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>