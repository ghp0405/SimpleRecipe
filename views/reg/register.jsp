<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" href="<c:url value="/resources/css/common.css" />" >
<link rel="stylesheet" href="<c:url value="/resources/css/register.css" />" >
<script src="/resources/js/jquery-3.5.1.min.js"></script>
</head>
<body>
<div class="reg-wrap">
	<h2>회원가입</h2>
	<p>Welcome to SimpleRecipe</p>
	<form action="/reg/register" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<div class="reg-div reg-id-wrap">
			<label>ID</label>
			<input type="text" name="userTbId" class="inputTxt" required/>
		</div>
		<div class="reg-div reg-pw-wrap">
			<label>PWD</label>
			<input type="password" id="pwd" name="userTbPwd" class="inputTxt" required/>
		</div>
		<div class="reg-div reg-pw-check-wrap">
			<label>PWD CHECK</label>
			<input type="password" id="pwd2" name="userTbPwd2" class="inputTxt" required/>
		</div>
		<div class="reg-div reg-name-wrap">
			<label>NAME</label>
			<input type="text" name="userTbName" class="inputTxt" required/>
		</div>
		<div class="reg-div reg-gender-wrap">
			<label>GENDER</label>
			<div class="reg-gender-inner-wrap">
				<label class="inputRadioLabel" for="male-checked">남</label><input type="radio" name="userTbGender" class="inputRadio" id="male-checked" value="M" checked required/>
				<label class="inputRadioLabel" for="female-checked">여</label><input type="radio" name="userTbGender" class="inputRadio" id="female-checked" value="F" required/>
			</div>
		</div>
		<div class="reg-div reg-birth-wrap">
			<label>BIRTHDAY</label>
			<input type="text" id="birthday" name="userTbBirthdayTemp" class="inputTxt" placeholder="                         예)2001-01-01" required />
		</div>
		<div class="reg-div reg-email-wrap">
			<label>EMAIL</label>
			<input type="text" id="email" name="userTbEmail" class="inputTxt" required/>
		</div>
		<div class="reg-div reg-phone-wrap">
			<label>PHONE</label>
			<input type="text" id="phone" name="userTbPhone" class="inputTxt" placeholder="                         '-'없이 작성해주세요 예)01012345678" />
		</div>
		<div class="btn-wrap txt-c mt40">
			<button type="button" id="submitReg" class="commonBtn" >회원가입</button>
			<a href="/login/login"><button type="button" class="commonBtn">취소</button></a>
		</div>
	</form>
</div>
<script>
$(document).ready(function(){
	$('#submitReg').click(function(){
		var pwd = $('#pwd').val();
		var pwd2 = $('#pwd2').val();
		var birthday = $('#birthday').val();
		var email = $('#email').val();
		var phone = $('#phone').val();
		
		var regBirthdayExp = RegExp(/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/);
		var regEmailExp = RegExp(/^[a-zA-Z0-9]([-_.]?[a-zA-Z0-9])*@[a-zA-Z0-9]([-_.]?[a-zA-Z0-9])*.[a-zA-Z]{2,3}$/);
		var regPhoneExp = RegExp(/^01(0|1|[6-9])([0-9]{3,4})([0-9]{4})$/);
		if(pwd != pwd2){
			alert("비밀번호 2개가 불일치합니다.");
			return false;
		}
		// 생년월일 데이터 처리
		if(!regBirthdayExp.test(birthday)){
			alert("생년월일 형식에 맞춰 입력해주세요.");
			return false;
		}
		// 이메일 데이터 처리
		if(!regEmailExp.test(email)){
			alert("이메일 형식에 맞춰 입력해주세요.");
			return false;
		}
		// 전화번호 데이터 처리
		if(!regPhoneExp.test(phone)){
			alert("전화번호 형식에 맞춰 입력해주세요.");
			return false;
		}
		alert("회원가입 성공");
		$('form').submit();
	});
	
	$(".inputTxt").on("focus", function(){
		$(this).siblings('label').css({
			'left': '-16px',
			'top' : '-42px',
			'font-size' : '20px'
		});	
	});
	
	$(".reg-birth-wrap .inputTxt").on("focus", function(){
		$(this).attr('placeholder', '예)2001-01-01');	
	});
	
	$(".reg-phone-wrap .inputTxt").on("focus", function(){
		$(this).attr('placeholder', "'-'없이 작성해주세요 예)01012345678");	
	})
	
})
</script>
</body>
</html>