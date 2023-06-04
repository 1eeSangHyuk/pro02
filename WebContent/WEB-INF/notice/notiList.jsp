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
<title>공지사항</title>
<style>
</style>
</head>
<body>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
<%@ include file="../../header.jsp" %>
<div>
	<h2>공지사항</h2>
	<table class="table">
		<thead>
			<tr>
				<th>연번</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>	
		</thead>
		<tbody>
		<c:forEach var="list" items="${notiList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="${path }/NoticeListDetail.do?notice_no=${list.notice_no }">${list.notice_title }</a></td>
				<td>${list.user_id }</td>
				<td>${list.notice_date }</td>
				<td>${list.readcnt }</td>
			</tr>
		</c:forEach>
			<c:if test="${empty notiList }">
			<tr>
				<td colspan="4">해당 공지사항이 존재하지 않습니다.</td>
			</tr>
			</c:if>	
		</tbody>
	</table>
	<div class="btn-group">
		<a href="${path }/InsertNotice.do" class="btn btn-primary">공지사항 작성하기</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로가기</a>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>