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
<title>구매페이지</title>
<style>
</style>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div>
	<h2>제품 구매</h2>
	<h3>선택 제품</h3>
	<fmt:setLocale value="ko-KR"/>
	<form action="${path }/AddPayment.do" method="post">
		<table class="table"> 
			<thead>
				<tr>
					<th>썸네일사진</th>
					<th>제품명</th>
					<th>구매희망수량</th>
					<th>재고수량</th>
					<th>단품가격</th>
					<th>--제거하기--</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<img src="${path }/product/${prod.pic1 }" alt="${prod.p_name }" height="200" width="200">
						<input type="hidden" id="user_id" name="user_id" value="${user.user_id }">
						<input type="hidden" id="user_addr" name="user_addr" value="${user.user_addr }">
						<input type="hidden" id="user_email" name="user_email" value="${user.user_email }">
						<input type="hidden" id="p_code" name="p_code" value="${prod.p_code }">
						<input type="hidden" id="p_name" name="p_name" value="${prod.p_name }">
						<input type="hidden" id="p_amount" name="p_amount" value="${prod.p_amount }">
						<input type="hidden" id="catno" name="catno" value="${prod.catno }">
						<c:if test="${!empty basket }">
						<input type="hidden" id="basket_no" name="basket_no" value="${basket.basket_no }">
						<input type="hidden" id="basket_count" name="basket_count" value="${basket.basket_count }">
						</c:if>
					</td>
					<td>${prod.p_name }</td>
					<td>
						<c:if test="${!empty basket }">
						<input type="number" id="count" name="count" min="0" max="${prod.p_amount }" value="${basket.basket_count }">
						</c:if>
						<c:if test="${empty basket }">
						<input type="number" id="count" name="count" min="0" max="${prod.p_amount }" value="1">
						</c:if>
					</td>
					<td>${prod.p_amount }</td>
					<td>
						<input type="hidden" id="p_price" name="p_price" value="${prod.p_price }">
						<fmt:formatNumber type="currency">${prod.p_price }</fmt:formatNumber>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<h3>배송정보</h3>
		<table>
			<tbody>
				<tr>
					<th>배송주소</th>
					<td>
						<input type="text" id="address1" name="address1" placeholder="기본주소" required="required">
						<input type="text" id="address2" name="address2" placeholder="상세주소" required="required">
						<input type="text" id="postcode" name="postcode" placeholder="우편번호" required="required">
						<button type="button" onclick="findAddr()" class="btn btn-primary">우편번호 검색</button>
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="number" id="user_phone" name="user_phone" value="${user.user_phone }" required="required"></td>
				</tr>
			</tbody>
		</table>
		<h3>결제 정보</h3>
			<table class="table">
				<tbody>
					<tr>
						<th>결제 금액</th>
						<td>
							<label for="payamount" id="totPrice">${prod.p_price * basket.basket_count }</label>
							<input type="hidden" name="payamount" id="payamount" value="">
						</td>
					</tr>
					<tr>
						<th>결제 수단</th>
						<td>
							<input type="hidden" name="conf" id="pay_type">
							<input type="radio" name="pay_type" id="pay_type1" value="신용카드" class="paytype" checked><label for="pay_type1">신용카드</label> &nbsp;
							<input type="radio" name="pay_type" id="pay_type2" value="체크카드" class="paytype"><label for="pay_type2">체크카드</label> &nbsp;
							<input type="radio" name="pay_type" id="pay_type3" value="계좌이체" class="paytype"><label for="pay_type3">계좌이체</label> &nbsp;
						</td>
					</tr>
					<tr>
						<th><label for="paycom" id="paycomLb">결제사</label></th>
						<td>			
							<select name="paycom" id="paycom" class="form-control" required>
								<option value="">선택안함</option>
							</select>
						</td>
					</tr>
					<tr>
						<th><label for="paycom" id="ptnumLb">결제 번호</label></th>
						<td>			
							<input type="text" name="ptnum" id="ptnum" class="form-control" required>
							<input type="hidden" name="payck" id="payck" value="no">
						</td>
					</tr>
					<tr>
						<td>
							<button type="button" id="pay" class="btn btn-primary">결제하기</button>
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<input type="submit" value="상품 구매 완료" class="btn btn-danger">
				<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로 가기</a>	
			</div>
		<script>
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
		<script>
		//결제모듈 연동
		$(document).ready(function(){
			var totalPay=0;
			var proName;
			$("#count").click(function(){
				totalPay = parseInt($("#p_price").val()) * parseInt($("#count").val());
				$("#totPrice").html(totalPay);
				$("#payamount").val(totalPay);
			})
			$("#pay").click(function(){
				proName = $("#p_name").val();
				if($("#count").val()!="") {
					totalPay = parseInt($("#p_price").val()) * parseInt($("#count").val());
					$("#totPrice").html(totalPay);
				}
				alert("결제할 금액 : "+totalPay);
				//상품명_현재시간
	 			var d = new Date();
				var date = d.getFullYear()+''+(d.getMonth()+1)+''+d.getDate()+''+d.getHours()+''+d.getMinutes()+''+d.getSeconds();
				IMP.init('imp31083748'); // 결제 API를 사용하기 위한 코드 입력!
				IMP.request_pay({		//결제 요청
					merchant_uid : $("#p_name").val() + '_' + date, //상점 거래 ID
					name : $("#p_name").val(),				// 결제 명
					amount : totalPay,					// 결제금액
					buyer_email : $("#user_email").val(), // 구매자 email
					buyer_name : $("#user_name").val(),				// 구매자 이름
					buyer_tel : $("#user_phone").val(),		// 구매자 전화번호
					buyer_addr : $("#user_addr").val(),		// 구매자 주소
					buyer_postcode : $("#postcode").val()			// 구매자 우편번호
					
					//지정 가능한 속성
					//https://docs.iamport.kr/sdk/javascript-sdk 참조
					//pg : 결제 프로그램 코드
					//pay_method : 결제 방법
					//escrow : 에스크로 결제창 호출 여부
					//merchant_uid : 상점 거래 ID
					//name : 주문명
					//amount : 결제 금액
					//custom_data : 가맹점 임의 지정 데이터
					//tax_free : 면세공급가액
					//currency : 거래 통화
					//language : 결제창 화면의 언어
					//buyer_name : 주문자명
					//buyer_tel : 주문자 연락처
					//buyer_email : 주문자 이메일
					//buyer_addr : 주문자 주소
					//buyer_postcode : 주문자 우편번호
					//display : 결제 화면 구성 설정
					//display.card_quota : 50,000원 이상 금액 결제시 할부 개월 수 옵션
					//digital : 결제 상품이 컨텐츠인지 여부(휴대폰 소액 결제시 필수)
					//v_bank_due : 가상계좌 입금기한
					//m_redirect_url : 리다이렉션 방식으로 호출된 결제창에서 결제 후 이동 될 주소
					//app_scheme : 모바일 앱 결제 중 앱 복귀를 위한 URL
					//biz_num : 계약된 사업자등록번호 10자리
					
				}, function(rsp){
					if(rsp.success){
						console.log(rsp);
						var msg = '결제가 완료 되었습니다.';
						var r1 = '고유 아이디 : ' +rsp.imp_uid;
						var r2 = '상점 거래 아이디 : ' +rsp.merchant_uid;
						var r3 = '결제 금액 : ' +rsp.paid_amount;
						var r4 = '카드 승인 번호 : '+rsp.apply_num;
						
						//반환 가능한 속성
						//https://docs.iamport.kr/sdk/javascript-sdk 참조
						//rsp.success : 결제 성공 여부
						//rsp.error_code : 결제 실패시 에러 코드
						//rsp.error_msg : 결제 실패시 에러 메시지
						//rsp.imp_uid : 아임포트 고유 결제번호
						//rsp.merchant_uid : 가맹점 고유 주문번호
						//rsp.pay_method : 결제 방법
						//rsp.paid_amount : 결제 금액
						//rsp.status : 결제 상태
						//rsp.name : 주문명
						//rsp.pg_provider : 일반 결제 승인된 PG사
						//rsp.emb_pg_provider : 간편 결제 승인된 PG사 
						//rsp.pg_tid : PG사 거래고유번호
						//rsp.buyer_name : 주문자 이름
						//rsp.buyer_email : 주문자 Email
						//rsp.buyer_tel : 주문자 연락처
						//rsp.buyer_addr : 주문자 주소
						//rsp.buyer_postcode : 주문자 우편번호
						//rsp.custom_data : 가맹점 임의 지정 데이터
						//rsp.paid_at : 결제승인시각
						//rsp.receipt_url : PG사에서 발행되는 거래 매출전표 URL
						//rsp.apply_num : 카드사 승인번호
						//rsp.vbank_num : 가상계좌 입금계좌번호
						//rsp.vbank_name : 가상계좌 은행명
						//rsp.vbank_holder : 가상계좌 예금주
						//rsp.vbank_date : 가상계좌 입금기한
						
						/* 아래 내용은 각주 처리 해제 */
						//$("#payck").val("yes");
						//$("#payamount").val(rsp.paid_amount);
						//$("#paymethod").val(rsp.pay_method);
						//$("#paycom").val(rsp.pg_provider);
						//$("#ptnum").val(rsp.apply_num);
						//alert(msg);
						//$("#paymentResult").html(r1+"<br>"+r2+"<br>"+r3+"<br>"+r4);
					} else{
						//$("#paymentResult").html('결제실패<br>'+'에러내용 : ' +rsp.error_msg);
					}
					//테스트용이므로 실패시에도 그냥 통과시킴 그러므로 실제 사용시에는 아래 내용은 각주 처리하든지 지워야함
					$("#payck").val("yes");
					$("#payamount").val(totalPay);
					//$("#ptype").val("카드");
					//$("#paycom").val("삼성카드");
					//$("#ptnum").val("123-1234-1234-1278");
				});
	 		});
		});
		</script>
		<script>
		$(document).ready(function(){
			var card = ["BC카드", "KB국민카드", "삼성카드", "신한카드", "우리카드", "하나카드", "롯데카드", "현대카드", "NH농협카드"];
			var bank = ["IBK기업은행", "하나은행", "농협은행", "우리은행", "우체국", "새마을금고", "신협", "한국씨티은행", "수협은행", "대구은행", "부산은행", "케이뱅크", "토스뱅크", "카카오뱅크"];
			$("input[name='pay_type']").change(function(){
				// 신용카드 결제 선택 시.
				if($("#pay_type1:checked").val() == '신용카드'){
					$("#pay_type").val("신용카드");
					$('#paycomLb').text("신용카드사 또는 종류");
					$('#ptnumLb').text("신용카드번호");
					$("#paycom").empty();
					$("#paycom").append("<option value=''>선택안함</option>");
					for(var key in card){
						$("#paycom").append("<option value='"+card[key]+"'>"+card[key]+"</option>");
					}
					$('#ptnum').val("");
				}	
				// 체크카드 결제 선택 시.
				else if($("#pay_type2:checked").val() == '체크카드'){
					$("#pay_typee").val("체크카드");
					$('#paycomLb').text("체크카드사 또는 종류");
					$('#ptnumLb').text("체크카드번호");
					$("#paycom").empty();
					$("#paycom").append("<option value=''>선택안함</option>");
					for(var key in card){
						$("#paycom").append("<option value='"+card[key]+"'>"+card[key]+"</option>");
					}
					$('#ptnum').val("");
				}
				// 계좌이체 결제 선택 시.
				else if($("#pay_type3:checked").val() == '계좌이체'){
					$("#pay_type").val("계좌이체");
					$('#paycomLb').html("입금 은행 : 농협,<br> 예금주 : 루메나");
					$('#ptnumLb').html("계좌 번호 :<br> 217-23-25639");
					$("#paycom").empty();
					$("#paycom").append("<option value=''>선택안함</option>");
					for(var key in bank){
						$("#paycom").append("<option value='"+bank[key]+"'>"+bank[key]+"</option>");
					}
					$('#ptnum').val("");
				}
			}).change();
			
			$("#pay").click(function(){
				console.log($("#pay_type").val());
				console.log($("#paycom").val());
				console.log($("#ptnum").val());
				$("#paymentResult").html($("#pay_type").val()+"<br>"+$("#paycom").val()+"<br>"+$("#ptnum").val());
			});
		});
		function payCheck(f){
			var payCk = f.payck.value;
			if(payCk!="yes"){
				alert("아직 결제 전 입니다.");
				return;
			}
		}
		</script>
	</form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>