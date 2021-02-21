<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/getUserList.css" />" >
</head>
<body>
<div class="user-list-wrap">
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
				<td><fmt:formatDate value="${user.userTbBirthday}" pattern="yyyy.MM.dd" /></td>
				<td>${user.userTbEmail}</td>
				<td>${user.userTbPhone}</td>
				<td><fmt:formatDate value="${user.userTbJoinDate}" pattern="yyyy.MM.dd" /></td>
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
				<c:choose>
					<c:when test="${user.userTbState eq 'E'.charAt(0)}">
						<td><a href="/admin/suspendUser?userTbNo=${user.userTbNo}">정지하기</a></td>
					</c:when>
					<c:when test="${user.userTbState eq 'D'.charAt(0)}">
						<td><a href="/admin/unsuspendUser?userTbNo=${user.userTbNo}">복구하기</a></td>
					</c:when>
					<c:otherwise>
						<td>ERROR</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
</div>
<%-- 페이징 처리 부분 --%>
<div class="paging-wrap">
	<ul> 
		<c:if test="${pageMaker.prev}">
			<li><a href="/admin/getUserList${pageMaker.makeQuery(pageMaker.startPage - 1)}"><</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<li><a href="/admin/getUserList${pageMaker.makeQuery(idx)}">${idx}</a></li>
		</c:forEach>
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="/admin/getUserList${pageMaker.makeQuery(pageMaker.endPage + 1)}">></a></li>
		</c:if>
	</ul>
</div>
</body>
</html>