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
<title>제품 등록</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<h2>제품 등록하기</h2>
	<p>${msg }</p>
	<form action="${path }/InsertProductPro.do" method="post" enctype="multipart/form-data">
		<table class="table">
			<tbody>
				<tr>
					<th><label for="p_code">제품 코드</label></th>
					<td>
						
					</td>
				</tr>
				<tr>
					<th><label for="p_name">제품명</label></th>
					<td>
						<input type="text" id="p_name" name="p_name" maxlength="95" title="100자 이내로 작성해 주십시오."
						 placeholder="100자 이내로 작성해 주십시오."required="required">
					</td>
				</tr>
				<tr>
					<th><label for="p_price">가격</label></th>
					<td>
						<input type="number" id="p_price" name="p_price" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="p_about">제품명</label></th>
					<td>
						<textarea rows="20" cols="25" id="p_about" name="p_about" title="450자 이내로 작성해 주십시오."
						 placeholder="450자 이내로 작성해 주십시오." maxlength="450"></textarea>
					</td>
				</tr>
				<tr>
					<th><label for="p_amount">재고</label></th>
					<td>
						<input type="number" id="p_amount" name="p_amount" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="catno">카테고리 번호</label></th>
					<td>
						<input type="text" id="catno" name="catno" maxlength="9" title="숫자로만 10자 이내로 작성해 주십시오."
						 placeholder="숫자로만 10자 이내로 작성해 주십시오." required="required">
					</td>
				</tr>
				<tr>
					<th><label for="pic1">첨부 파일</label></th>
					<td>
						<input type="file" name="pic1" id="pic1">
					</td>
				</tr>
				<tr>
					<th><label for="pic2">첨부 파일</label></th>
					<td>
						<input type="file" name="pic2" id="pic2">
					</td>
				</tr>
				<tr>
					<th><label for="pic3">첨부 파일</label></th>
					<td>
						<input type="file" name="pic3" id="pic3">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="제품 등록" class="btn btn-primary">
						<a href="${path }/ProductListAll.do" class="btn btn-primary">전체 제품 목록으로</a>				
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>