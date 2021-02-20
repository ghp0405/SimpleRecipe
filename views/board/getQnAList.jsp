<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/getQnAList.css" />" >
</head>
<body>
<div class="qna-list-wrap">
	<h2>Q&A 목록</h2>
	<c:if test="${userType == '일반사용자'}">
		<a href="/board/insertQnA"><button class="commonBtn">Q&A 등록</button></a>
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
				<td><a href="/board/getQnA?qnaTbNo=${qna.qnaTbNo}">${qna.qnaTbTitle}</a></td>
				<td>${qna.userTbId}</td>
				<td><fmt:formatDate value="${qna.qnaTbRegDate}" pattern="yyyy.MM.dd" /></td>
			</tr>
		</c:forEach>
	</table>
</div>
<%-- 페이징 처리 부분 --%>
<div class="paging-wrap">
	<ul> 
		<c:if test="${pageMaker.prev}">
			<li><a href="/board/getQnAList${pageMaker.makeQuery(pageMaker.startPage - 1)}"><</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<li><a href="/board/getQnAList${pageMaker.makeQuery(idx)}">${idx}</a></li>
		</c:forEach>
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="/board/getQnAList${pageMaker.makeQuery(pageMaker.endPage + 1)}">></a></li>
		</c:if>
	</ul>
</div>
</body>
</html>