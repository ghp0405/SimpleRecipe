<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
</head>
<body>
<div>
<h2>header</h2>
	<c:choose>
		<c:when test="${userType == '일반사용자'}">
			<h1>${userTbId}님 방문을 환영합니다.</h1>
			<ul>
				<li><a href="logout.do">로그아웃</a></li>
				<li>마이페이지</li>
			</ul>
		</c:when>
		<c:when test="${userType == '관리자'}">
			<h1>${adminTbId}님 방문을 환영합니다.</h1>
			<ul>
				<li><a href="logout.do">로그아웃</a></li>
				<li>마이페이지</li>
				<li>관리자페이지</li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul>
				<li><a href="login.do">로그인</a></li>
				<li><a href="register.do">회원가입</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>