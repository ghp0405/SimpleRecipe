<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<h2>회원가입</h2>
<form action="/register.do" method="post">
	<label>ID</label>
	<input type="text" name="userTbId" required/><br /><br />
	<label>PWD</label>
	<input type="password" id="pwd" name="userTbPwd" required/><br /><br />
	<label>PWD CHECK</label>
	<input type="password" id="pwd2" name="userTbPwd2" required/><br /><br />
	<label>NAME</label>
	<input type="text" name="userTbName" required/><br /><br />
	<label>GENDER</label>
	남<input type="radio" name="userTbGender" value="M" checked required/>
	여<input type="radio" name="userTbGender" value="F" required/><br /><br />
	<label>BIRTHDAY</label>
	<input type="text" id="birthday" name="userTbBirthdayTemp" placeholder="예)2001-01-01" required/><br /><br />
	<label>EMAIL</label>
	<input type="text" id="email" name="userTbEmail" required/><br /><br />
	<label>PHONE</label>
	<input type="text" id="phone" name="userTbPhone" placeholder="'-'없이 작성해주세요 예)01012345678" /><br /><br />
	<button type="button" id="submitReg">회원가입</button><br /><br />
	<a href="login.do"><button type="button">취소</button></a><br /><br />
</form>
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
})
</script>
</body>
</html>