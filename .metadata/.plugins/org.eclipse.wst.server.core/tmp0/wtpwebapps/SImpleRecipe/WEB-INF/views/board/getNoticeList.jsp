<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/getNoticeList.css" />" >
</head>
<body>
<div class="notice-list-wrap">
	<h2>공지사항 목록</h2>
	<c:if test="${userType == '관리자'}">
		<a href="/insertNotice.do"><button class="commonBtn">공지사항 등록</button></a>
	</c:if>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>관리자 ID</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="notice" items="${noticeList}">
			<tr>
				<td>${notice.noticeTbNo}</td>
				<td><a href="getNotice.do?noticeTbNo=${notice.noticeTbNo}">${notice.noticeTbTitle}</a></td>
				<td>${notice.adminTbId}</td>
				<td><fmt:formatDate value="${notice.noticeTbRegDate}" pattern="yyyy.MM.dd" /></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>