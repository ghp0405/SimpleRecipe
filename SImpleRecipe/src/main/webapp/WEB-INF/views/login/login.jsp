<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="<c:url value="/resources/css/common.css" />" >
<link rel="stylesheet" href="<c:url value="/resources/css/login.css" />" >
<script src="/resources/js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<div class="login-wrap">
		<h2>Log-in</h2>
		<p>Welcome to SIMPLE RECIPE</p>
		<form action="/loginCheck.do" method="post">
			<div class="login-div login-id-wrap">
				<label>ID</label>
				<input type="text" name="userTbId" class="inputTxt"/>
			</div>
			<div class="login-div login-pw-wrap">
				<label>PW</label>
				<input type="password" name="userTbPwd" class="inputTxt"/>
			</div>
			<div class="btn-wrap txt-c mt40">
				<button type="submit" class="commonBtn" value="login">login</button>
				<a href="register.do"><button type="button" class="commonBtn">register</button></a>
			</div>
		</form>
	</div>
	<script>
		$(".inputTxt").on("focus", function(){
			$(this).siblings('label').css({
				'left': '-16px',
				'top' : '-42px',
				'font-size' : '20px'
			})	
		})
	</script>
</body>
</html>