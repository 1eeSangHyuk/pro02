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
	<form action="${path }/UpdateReviewPro.do" method="post">
		<table class="table">
			<tbody>
				<tr>
					<th><label for="title">제목</label></th>
					<td>
						<input type="hidden" id="no" name="no" value="${review.review_no }">
						<input type="text" id="title" name="title" maxlength="95" title="${review.review_title }"
						 placeholder="${review.review_title }">
					</td>
				</tr>
				<tr>
					<th><label for="textInput">내용</label></th>
					<td>
						<textarea rows="20" cols="50" id="textInput" name="textInput" title="${review.review_text }"
						 placeholder="${review.review_text }" maxlength="990"></textarea>
					</td>
				</tr>
				<tr>
					<th>별점</th>
					<td>
						<label for="5star">★★★★★</label>
						<input type="radio" id="5star" name="star" value="5" checked>
						<label for="4star">★★★★</label>
						<input type="radio" id="4star" name="star" value="4">
						<label for="3star">★★★</label>
						<input type="radio" id="3star" name="star" value="3">
						<label for="2star">★★</label>
						<input type="radio" id="2star" name="star" value="2">
						<label for="1star">★</label>
						<input type="radio" id="1star" name="star" value="1">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="리뷰 업데이트하기" class="btn btn-primary">
						<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로가기</a>				
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