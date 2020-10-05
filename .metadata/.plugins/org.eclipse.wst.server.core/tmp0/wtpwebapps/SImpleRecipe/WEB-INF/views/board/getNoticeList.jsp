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
<h2>공지사항 목록</h2>
<c:if test="${userType == '관리자'}">
	<a href="/insertNotice.do"><button type="button">공지사항 등록</button></a>
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
			<td>${notice.adminTbId}</td><%-- 나중에 여기 관리자 ID로 변경해야함 --%>
			<td>${notice.noticeTbRegDate}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>