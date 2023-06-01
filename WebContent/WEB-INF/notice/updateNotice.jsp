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
<title>공지사항</title>
<style>
</style>
</head>
<body>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
<%@ include file="../../header.jsp" %>
<div>
	<h2>공지사항 업데이트하기</h2>
	<p>${msg }</p>
	<form action="${path }/UpdateNoticePro.do" method="post" enctype="multipart/form-data">
		<table class="table">
			<tbody>
				<tr>
					<th><label for="title">제목</label></th>
					<td>
						<input type="hidden" id="no" name="no" value="${noti.notice_no }">
						<input type="text" id="title" name="title" maxlength="95" title="${noti.notice_title }"
						 placeholder="${noti.notice_title }">
					</td>
				</tr>
				<tr>
					<th><label for="textInput">내용</label></th>
					<td>
						<textarea rows="20" cols="50" id="textInput" name="textInput" title="${noti.notice_text }"
						 placeholder="${noti.notice_text }" maxlength="990"></textarea>
					</td>
				</tr>
				<tr>
					<th><label for="file1">첨부 파일</label></th>
					<td>
						<span>
							<c:set var="len" value="${noti.notice_file }" />
							<c:set var="download" value="${fn:substring(noti.notice_file,5,lh) }" />
							${download }
						</span><br>
						<input type="radio" name="selFile1" id="selFile1" onclick="fileCall()" checked>파일 교체 안함<br>
						<input type="radio" name="selFile2" id="selFile2" onclick="fileCall()">파일 교체<br>
						<input type="file" name="file1" id="file1">
						<input type="hidden" name="file1" id="file2" value="${download }">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="공지사항 업데이트하기" class="btn btn-primary">
						<a href="${path }/NoticeList.do" class="btn btn-primary">공지사항 목록으로</a>				
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<script>
		function fileCall(){
			var selFile1 = document.getElementById("selFile1");
			var selFile2 = document.getElementById("selFile2");
			var file1 = document.getElementById("file1");
			var file2 = document.getElementById("file2");
			if (selFile1.checked){
				file1.style.display = "none";
				file1.setAttribute("disabled");
				file2.removeAttribute("disabled");
			} else {
				file1.style.display = "block";
				file2.setAttribute("disabled");
				file1.removeAttribute("disabled");
			}
		}
	</script>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>