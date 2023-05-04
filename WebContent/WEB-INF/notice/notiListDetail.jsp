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
<title>공지사항 상세보기</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<div>
		<h2>공지사항 - ${list.notice_title }</h2>
		<table class="table">
			<thead>
				<tr>
					<th>작성자</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>	
			</thead>
			<tbody>
				<tr>
					<td>${noti.user_id }</td>
					<td>${noti.notice_title }</td>
					<td>${noti.notice_text }</td>
					<td>${noti.notice_date }</td>
					<td>${noti.readcnt }</td>
				</tr>
			</tbody>
		</table>
		<div class="btn-group">
			<a href="${path }/NoticeList.do">공지사항 목록으로</a>
			<a href="${path }/InsertList.do?user_id=${noti.user_id }">글 쓰기</a>
			<a href="${path }/UpdateList.do?notice_no=${noti.notice_no }">글 수정하기</a>
			<a href="${path }/DeleteList.do?notice_no=${noti.notice_no }">글 삭제하기</a>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>