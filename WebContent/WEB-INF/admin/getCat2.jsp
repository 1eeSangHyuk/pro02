<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.lang.*, java.text.*, java.net.InetAddress" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
<%-- 	<select id="cat2" name="cat2">
		<option value="">선택안함</option>
		<c:forEach items="${catListCat2 }" var="cat">
		<option value="${cat.cat2 }" onclick="">${cat.catname }</option>
		</c:forEach>
	</select> --%>
	<c:param name="cat2List" value="${catListCat2 }" />
	<script>
	function close_window(){
		if (opener.document.getElementByName("cat2List").value != null){
			opener.document.getElementByName("cat2List").value = document.getElementsByName("cat2List").value;
			window.close();
		}
	}
	</script>
</body>
</html>