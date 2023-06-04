<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="header_path" value="${pageContext.request.contextPath }" />
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
<!-- Bootstrap -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

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
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">fan <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="${header_path }/ProductCatList.do?catno=0101">써큘레이터</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0102">데스크팬</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0103">핸디팬</a></li>
	          </ul>
	        </li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">light <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="${header_path }/ProductCatList.do?catno=0201">테이블 램프</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0202">멀티 랜턴</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0203">아웃도어 캠핑 랜턴</a></li>
	          </ul>
	        </li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">air <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="${header_path }/ProductCatList.do?catno=0301">공기청정기</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0302">온풍기</a></li>
	            <li><a href="${header_path }/ProductCatList.do?catno=0303">가습기</a></li>
	          </ul>
	        </li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">life <span class="caret"></span></a>
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
		            <li><a href="${header_path }/MyOrder.do?uid=${uid }">주문내역</a></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">커뮤니티 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="${header_path }/NoticeList.do">공지사항</a></li>
		            <li><a href="${header_path }/">자주하는 질문</a></li>
		            <li><a href="${header_path }/">QnA</a></li>
		          </ul>
		        </li>
				<li><a href="${header_path }/UserLogout.do">로그아웃</a></li>
			</c:if>
			<c:if test="${uid.equals('admin') }">
				<li><a>관리자님, 안녕하세요!</a></li>
				<li class="dropdown">
			        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">상품/판매 관리 페이지<span class="caret"></span></a>
			        <ul class="dropdown-menu" role="menu">
						<li><a href="${header_path }/ProductListAll.do">전체 제품 관리 페이지(제품업데이트  O, 주문관리 O, 삭제 O, 리뷰)</a></li>
						<li><a href="${header_path }/InsertCategory.do">새로운 카테고리 등록</a></li>
						<li><a href="${header_path }/InsertProduct.do">새로운 물품 등록 O</a></li>
						<li class="divider"></li>
						<li><a href="${header_path }/OrderListAll.do">전체 주문 관리 O</a></li>
					</ul>
				</li>
				<li class="dropdown">
			        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">글 관리 페이지<span class="caret"></span></a>
			        <ul class="dropdown-menu" role="menu">
						<li><a href="${header_path }/ReviewProduct.do">전체 리뷰 관리</a></li>
						<li><a href="${header_path }/NoticeList.do">공지사항 관리</a></li>
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