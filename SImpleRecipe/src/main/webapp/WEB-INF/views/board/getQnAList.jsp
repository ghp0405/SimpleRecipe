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
<h2>Q&A 목록</h2>
<c:if test="${userType == '일반사용자'}">
	<a href="/insertQnA.do"><button type="button">Q&A 등록</button></a>
</c:if>
<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자 ID</th>
		<th>작성일</th>
	</tr>
	<c:forEach var="qna" items="${qnaList}">
		<tr>
			<td>${qna.qnaTbNo}</td>
			<td><a href="getQnA.do?qnaTbNo=${qna.qnaTbNo}">${qna.qnaTbTitle}</a></td>
			<td>${qna.userTbId}</td>
			<td>${qna.qnaTbRegDate}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>