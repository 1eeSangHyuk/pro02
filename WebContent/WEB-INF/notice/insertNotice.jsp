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
<%@ include file="../../header.jsp" %>
<div>
	<h2>공지사항 작성하기</h2>
	<p>${msg }</p>
	<form action="${path }/InsertNoticePro.do" method="post" enctype="multipart/form-data">
		<table class="table">
			<tbody>
				<tr>
					<th>
						<label for="title">제목</label>
					</th>
					<td>
						<input type="hidden" id="id" name="id" value="${uid }">
						<input type="text" id="title" name="title" maxlength="95" title="100자 이내로 작성해 주십시오." placeholder="100자 이내로 작성해 주십시오.">
					</td>
				</tr>
				<tr>
					<th>
						<label for="textInput">내용</label>
					</th>
					<td>
						<textarea rows="20" cols="50" id="textInput" name="textInput" title="1000자 이내로 작성해 주십시오." placeholder="1000자 이내로 작성해 주십시오." maxlength="990"></textarea>
					</td>
				</tr>
				<tr>
					<th><label for="file1">첨부 파일</label></th>
					<td>
						<input type="file" name="file1" id="file1">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="글쓰기" class="btn btn-primary">
						<a href="${path }/NoticeList.do" class="btn btn-primary">공지사항 목록으로</a>				
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>