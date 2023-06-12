<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../common.jsp" />
<title>루메나</title>
<style>
</style>
</head>
<body>
<jsp:include page="../header.jsp" />
<div>
	<h2>제품목록</h2>
	<fmt:setLocale value="ko-KR"/>
	<div class="row">
	  <c:forEach var="prod" items="${prodListAll }">
	  <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
	      <a href="ProductList.do?p_code=${prod.p_code }">	
	      	<img src="${path }/product/${prod.pic1 }" alt="${prod.p_name }">
	      </a>
	      <div class="caption">
	        <p><a href="ProductList.do?p_code=${prod.p_code }">${prod.p_name }</a></p>
	        <h3><fmt:formatNumber value="${prod.p_price }" type="currency" ></fmt:formatNumber></h3>
	      </div>
	    </div>
	  	  </div>
	  </c:forEach>
	</div>
	<c:if test="${empty prodListAll }">
		<h3>제품 목록이 비어있습니다.</h3>
	</c:if>
</div>
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
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>