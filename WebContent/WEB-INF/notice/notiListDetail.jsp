<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<h2>공지사항 - ${noti.notice_title }</h2>
	<p>${msg }</p>
	<table class="table">
		<tbody>
			<tr>
				<th>제목</th>
				<td>${noti.notice_title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${noti.user_id }</td>
			</tr>			
			<tr>
				<th>작성일</th>
				<td>${noti.notice_date }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${noti.notice_text }</td>
			</tr>
			<c:if test="${!empty noti.notice_file }">
			<tr>
				<th>첨부파일</th>
				<td>
					<c:set var="lh" value="${fn:length(noti.notice_file) }" />
					<c:set var="download" value="${fn:substring(noti.notice_file,5,lh) }" />
					<a href="${path }/${filepath }/${notice_file }">${download }</a>
				</td>
			</tr>
			</c:if>	
			<tr>
				<th>조회수</th>
				<td>${noti.readcnt }</td>
			</tr>	
		</tbody>
	</table>
	<div class="btn-group">
		<a href="${path }/InsertNotice.do" class="btn btn-primary">글 쓰기</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if test="${uid.equals(noti.user_id) || uid.equals('admin') }">
			<a href="${path }/UpdateNotice.do?notice_no=${noti.notice_no }" class="btn btn-primary">글 수정하기</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${path }/DeleteNotice.do?notice_no=${noti.notice_no }" class="btn btn-primary">글 삭제하기</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</c:if>
	</div>
	<br>
	<div class="btn-group">
		<a href="${path }/NoticeList.do" class="btn btn-primary">공지사항 목록으로</a>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>