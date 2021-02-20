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
	<div class="header-wrap">
		<c:choose>
			<c:when test="${userType == '일반사용자'}">
				<div class="nav-wrap">
					<a href="/main/main" class="logo">Simple Recipe</a>
					<ul>
						<li><a href="/login/logout">로그아웃</a></li>
						<li><a href="/main/main">메인페이지</a></li>
						<li><a href="/main/mypage">마이페이지</a></li>
						<li><a href="/board/getNoticeList">공지사항</a></li>
						<li><a href="/board/getQnAList">Q&A</a></li>
					</ul>
				</div>
				<h2>${userLogin.userTbId}님 방문을 환영합니다</h2>
			</c:when>
			<c:when test="${userType == '관리자'}">
				<div class="nav-wrap">
					<ul>
						<li><a href="/login/logout">로그아웃</a></li>
						<li><a href="/main/main">메인페이지</a></li>
						<li><a href="/admin/getUserList">사용자 관리 페이지</a></li>
						<li><a href="/board/getNoticeList">공지사항</a></li>
						<li><a href="/board/getQnAList">Q&A</a></li>
					</ul>
				</div>
				<h2>${adminLogin.adminTbId}님 방문을 환영합니다</h2>
			</c:when>
			<c:otherwise>
				<div class="nav-wrap">
					<a href="/main/main" class="logo">Simple Recipe</a>
					<ul>
						<li><a href="/login/login">로그인</a></li>
						<li><a href="/login/register">회원가입</a></li>
						<li><a href="/main/main">메인페이지</a></li>
						<li><a href="/board/getNoticeList">공지사항</a></li>
						<li><a href="/board/getQnAList">Q&A</a></li>
					</ul>
				</div>
				<h2></h2>
			</c:otherwise>
		</c:choose>
	</div><%-- end header-wrap --%>
</div><%-- end header --%>
</body>
</html>