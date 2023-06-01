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
<title>리뷰 작성</title>
<style>
</style>
</head>
<body>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
<%@ include file="../../header.jsp" %>
<div>
	<h2>리뷰 작성하기</h2>
	<p>${msg }</p>
	<form action="${path }/InsertReviewPro.do" method="post">
		<table class="table">
			<tbody>
				<tr>
					<th><label for="title">제목</label></th>
					<td>
						<input type="hidden" id="id" name="id" value="${uid }">
						<input type="hidden" id="order_no" name="order_no" value="${order_no }">
						<input type="text" id="title" name="title" maxlength="95" title="100자 이내로 작성해 주십시오."
						 placeholder="100자 이내로 작성해 주십시오.">
					</td>
				</tr>
				<tr>
					<th><label for="textInput">내용</label></th>
					<td>
						<textarea rows="20" cols="50" id="textInput" name="textInput" title="1000자 이내로 작성해 주십시오."
						 placeholder="1000자 이내로 작성해 주십시오." maxlength="990"></textarea>
					</td>
				</tr>
				<tr>
					<th>별점</th>
					<td>
						<input type="radio" id="5star" name="star" value="5" checked>
						<label for="5star">★★★★★</label><br>
						<input type="radio" id="4star" name="star" value="4">
						<label for="4star">★★★★</label><br>
						<input type="radio" id="3star" name="star" value="3">
						<label for="3star">★★★</label><br>
						<input type="radio" id="2star" name="star" value="2">
						<label for="2star">★★</label><br>
						<input type="radio" id="1star" name="star" value="1">
						<label for="1star">★</label><br>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="리뷰 작성하기" class="btn btn-primary">
						<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로가기</a>				
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>