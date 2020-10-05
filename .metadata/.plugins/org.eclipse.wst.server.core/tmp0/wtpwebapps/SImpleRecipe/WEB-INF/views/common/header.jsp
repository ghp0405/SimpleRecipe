<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet" href="<c:url value="/resources/css/header.css" />" >
</head>
<body>
<div id="header">
<h2>SimpleRecipe</h2>
	<div class="header-wrap">
	<c:choose>
		<c:when test="${userType == '일반사용자'}">
			<h1>${userTbId}님 방문을 환영합니다.</h1>
			<ul>
				<li><a href="logout.do">로그아웃</a></li>
				<li><a href="mypage.do">마이페이지</a></li>
			</ul>
		</c:when>
		<c:when test="${userType == '관리자'}">
			<h1>${adminTbId}님 방문을 환영합니다.</h1>
			<ul>
				<li><a href="logout.do">로그아웃</a></li>
				<li><a href="getUserList.do">사용자 관리 페이지</a></li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul>
				<li><a href="login.do">로그인</a></li>
				<li><a href="register.do">회원가입</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
	<ul>
		<li><a href="getNoticeList.do">공지사항</a></li>
		<li><a href="getQnAList.do">Q&A</a></li>
	</ul>
	</div><%-- end header-wrap --%>
</div><%-- end header --%>
</body>
</html>