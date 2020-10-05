<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>사용자 목록</h2>
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>ID</th>
		<th>성별</th>
		<th>생일</th>
		<th>이메일</th>
		<th>휴대전화</th>
		<th>가입일</th>
		<th>가입경로</th>
		<th>계정정지</th>
	</tr>
	<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.userTbNo}</td>
			<td>${user.userTbName}</td>
			<td>${user.userTbId}</td>
			<c:choose>
				<c:when test="${user.userTbGender eq 'M'.charAt(0)}">
					<td>남</td>
				</c:when>
				<c:when test="${user.userTbGender eq 'F'.charAt(0)}">
					<td>여</td>
				</c:when>
				<c:otherwise>
					<td>ERROR</td>
				</c:otherwise>
			</c:choose>
			<td>${user.userTbBirthday}</td>
			<td>${user.userTbEmail}</td>
			<td>${user.userTbPhone}</td>
			<td>${user.userTbJoinDate}</td>
			<c:choose>
				<c:when test="${user.userTbJoinPath eq 'C'.charAt(0)}">
					<td>기본</td>
				</c:when>
				<c:when test="${user.userTbJoinPath eq 'K'.charAt(0)}">
					<td>카카오</td>
				</c:when>
				<c:otherwise>
					<td>ERROR</td>
				</c:otherwise>
			</c:choose>
			<td><a href="/deleteUser.do?userTbNo=${user.userTbNo}">정지하기</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>