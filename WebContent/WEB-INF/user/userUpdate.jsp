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
<title>회원정보 수정</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<h2>회원정보 수정</h2>
	<p>${msg }</p>
	<form action="${path }/UserUpdatePro.do" method="post" onsubmit="return joinCheck(this)">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디 : </th>
					<td>
						${user.user_id }
						<input type="hidden" id="id" name="id" value="${user.user_id }">
					</td>
				</tr>
				<tr>
					<th>비밀번호 : </th>
					<td>
						<input type="password" id="pw1" name="pw1">
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인 : </th>
					<td>
						<input type="password" id="pw2" name="pw2">
					</td>
				</tr>
				<tr>
					<th>이름 : </th>
					<td>
						<input type="text" id="name1" name="name1" title="${user.user_name }" placeholder="${user.user_name }">
					</td>
				</tr>
				<tr>
					<th>전화번호 : </th>
					<td>
						<input type="text" id="phone" name="phone" title="${user.user_phone }" placeholder="${user.user_phone }">
					</td>
				</tr>
				<tr>
					<th>주소 : </th>
					<td>
						<input type="text" id="address1" name="address1" placeholder="기본주소">
						<input type="text" id="address2" name="address2" placeholder="상세주소">
						<input type="text" id="postcode" name="postcode" placeholder="우편번호">
						<button type="button" onclick="findAddr()" class="btn btn-primary">우편번호 검색</button>
					</td>
				</tr>
				<tr>
					<th><label for="">이메일 : </label></th>
					<td><input type="text" id="email" name="email" title="${user.user_email }" placeholder="${user.user_email }"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="회원정보 변경하기">
						<input type="reset" value="리셋">
					</td>
				</tr>
			</tbody>
		</table>
		<script>
			function joinCheck(f){
				if(f.pw1.value != f.pw2.value){
					alert("비밀번호가 서로 일치하지 않습니다.");
					f.pw1.focus();
					return false;
				}
			}
			function findAddr(){
				new daum.Postcode({
					oncomplete: function(data) {
						console.log(data);
						var roadAddr = data.roadAddress;
						var jibunAddr = data.jibunAddress;
						document.getElementById("postcode").value = data.zonecode;
						if(roadAddr !== '') {
							document.getElementById("address1").value = roadAddr;				
						} else if(jibunAddr !== ''){
							document.getElementById("address1").value = jibunAddr;
						}
						document.getElementById("address2").focus();
					}
				}).open();		
			}
			</script>
			<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	</form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>