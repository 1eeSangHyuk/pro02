<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="header_path" value="${pageContext.request.contextPath }" />
<%@ include file="../common.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<%
	String uid = "";
	if(session != null){
		uid = (String) session.getAttribute("uid");
	}
%>
<header id="hd" class="container">
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="${header_path }">Lumena</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
	        <li><a href="${header_path }/NoticeList.do">공지사항</a></li>
	        <li class="dropdown">
	          <a href="${header_path }/ProductListAll.do?catno=01" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">fan <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="${header_path }/ProductCatList.do?catno=0101">써큘레이터</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0102">데스크팬</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0103">핸디팬</a></li>
	          </ul>
	        </li>
	        <li class="dropdown">
	          <a href="${header_path }/ProductListAll.do?catno=02" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">light <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="${header_path }/ProductCatList.do?catno=0201">테이블 램프</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0202">멀티 랜턴</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0203">아웃도어 캠핑 랜턴</a></li>
	          </ul>
	        </li>
	        <li class="dropdown">
	          <a href="${header_path }/ProductListAll.do?catno=03" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">air <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="${header_path }/ProductCatList.do?catno=0301">공기청정기</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0302">온풍기</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0303">가습기</a></li>
	          </ul>
	        </li>
	        <li class="dropdown">
	          <a href="${header_path }/ProductListAll.do?catno=04" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">life <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="${header_path }/ProductCatList.do?catno=0401">휴대용 배터리</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0402">무선 충전기</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0403">모기채</a></li>
	          </ul>
	        </li>
	      </ul>
	      <form class="navbar-form navbar-left" role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search">
	        </div>
	        <button type="submit" class="btn btn-default">Submit</button>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
			<c:if test="${empty uid }">
				<li><a href="${header_path }/UserLogin.do">로그인</a></li>
				<li><a href="${header_path }/UserTerms.do">회원가입</a></li>
			</c:if>
			<c:if test="${!empty uid && !uid.equals('admin') }">
				<li><a>${uid }님, 안녕하세요!</a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">마이페이지 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="${header_path }/MyPage.do?uid=${uid }">회원정보</a></li>
		            <li><a href="${header_path }/GetUserBasket.do?uid=${uid }">장바구니</a></li>
		            <li><a href="#">주문내역</a></li>
		            <li class="divider"></li>
		            <li><a href="#">고객센터(qna)</a></li>
		          </ul>
		        </li>
				<li><a href="${header_path }/UserLogout.do">로그아웃</a></li>
			</c:if>
			<c:if test="${uid.equals('admin') }">
				<li><a>관리자님, 안녕하세요!</a></li>
				<li class="dropdown">
			        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">관리자페이지(전체 제품 관리 페이지) <span class="caret"></span></a>
			        <ul class="dropdown-menu" role="menu">
						<li><a href="${header_path }/UpdateProduct.do">전체 물품 재고관리 view</a></li>
						<li><a href="${header_path }/ReceiptProduct.do">전체 물품에 대한 주문 관리view</a></li>
						<li><a href="${header_path }/ProductListAll.do">물품 삭제 O -- 전체 물품 리스트로 포워딩</a></li>
						<li><a href="${header_path }/ReviewProduct.do">전체 물품에 대한 리뷰 관리</a></li>
						<li><a href="${header_path }/InsertProduct.do">물품 등록 O</a></li>
						<li class="divider"></li>
					</ul>
				</li>
				<li><a href="${header_path }/UserLogout.do">로그아웃</a></li>
			</c:if>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
</header>