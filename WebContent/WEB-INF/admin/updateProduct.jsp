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
<title>제품 정보 수정</title>
<style>
</style>
</head>
<body>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
<%@ include file="../../header.jsp" %>
<div>
	<h2>${catMap.get('catname') } - 제품 정보 수정</h2>
	<form action="${path }/UpdateProductPro.do" method="post" enctype="multipart/form-data">
		<table class="table">
			<tbody>
				<tr>
					<th><label for="p_name">제품명</label></th>
					<td>
						<input type="hidden" id="p_code" name="p_code" value="${prod.p_code }">
						<input type="text" id="p_name" name="p_name" maxlength="95" value="${prod.p_name }" "required="required">
					</td>
				</tr>
				<tr>
					<th><label for="p_price">가격</label></th>
					<td>
						<input type="number" id="p_price" name="p_price" value="${prod.p_price }" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="p_about">제품설명</label></th>
					<td>
						<textarea rows="20" cols="25" id="p_about" name="p_about" title="${prod.p_about }" placeholder="${prod.p_about }" maxlength="450"></textarea>
					</td>
				</tr>
				<tr>
					<th><label for="catno">카테고리 번호</label></th>
					<td>
						${prod.catno }
						<input type="hidden" id="catno" name="catno" value="${prod.catno }">
					</td>
				</tr>
				<tr>
					<th><label for="p_amount">재고</label></th>
					<td>
						<input type="number" id="p_amount" name="p_amount" value="${prod.p_amount }" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="pic1">첨부 파일</label></th>
					<td>
						<c:if test="${!empty prod.pic1 }">
						<img src="${path }/product/${prod.pic1 }" alt="${prod.p_name }">
						</c:if>
						<p></p>
						<input type="file" name="pic1" id="pic1" class="form-control file">
						<c:if test="${!empty prod.pic1 }">
						<input type="hidden" name="og_pic1" id="og_pic1" value="${prod.pic1 }">
						</c:if>
					</td>
				</tr>
				<tr>
					<th><label for="pic2">첨부 파일</label></th>
					<td>
						<c:if test="${!empty prod.pic2 }">
						<img src="${path }/product/${prod.pic2 }" alt="${prod.p_name }">
						</c:if>
						<p></p>
						<input type="file" name="pic2" id="pic2" class="form-control file">
						<c:if test="${!empty prod.pic2 }">
						<input type="hidden" name="og_pic2" id="og_pic2" value="${prod.pic2 }">
						</c:if>
					</td>
				</tr>
				<tr>
					<th><label for="pic3">첨부 파일</label></th>
					<td>
						<c:if test="${!empty prod.pic3 }">
						<img src="${path }/product/${prod.pic3 }" alt="${prod.p_name }">
						</c:if>
						<p></p>
						<input type="file" name="pic3" id="pic3" class="form-control file">
						<c:if test="${!empty prod.pic3 }">
						<input type="hidden" name="og_pic3" id="og_pic3" value="${prod.pic3 }">
						</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="제품 업데이트" class="btn btn-primary">
						<a href="${path }/ProductListAll.do" class="btn btn-primary">전체 제품 목록으로</a>				
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<script>
		$(document).ready(function(){
			$(".file").change(function(){
				var tar = $(this).index();
				if($(this).val()!=""){
					$(this).prev("p").html("<strong>이미지 첨부 성공</strong>");
				}
			});
		});
	</script>
	<div>
		<input type="submit" value="제품 정보 수정하기">
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>