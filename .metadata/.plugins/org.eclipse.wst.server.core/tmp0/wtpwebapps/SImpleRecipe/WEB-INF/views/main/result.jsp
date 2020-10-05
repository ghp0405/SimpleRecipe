<%@ page import="com.simplerecipe.main.vo.RecipeVO" %>
<%@ page import="com.simplerecipe.main.dao.RecipeDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h2>검색 결과</h2>	
	<c:forEach var="result" items="${resultList}">
		<a href="detail.do?recipeTbNo=${result.recipeTbNo}"> <%-- 검색 결과에 대한 각 항목을 감싸는 div --%>
			<img src="<c:url value="${result.recipeTbImageLink}" />" />
			<span>${result.recipeTbTitle}</span><br />
		</a>
	</c:forEach>
	<%-- 페이징 처리 부분 --%>
	<ul> 
		<c:if test="${pageMaker.prev}">
			<li><a href="result.do${pageMaker.makeQuery(pageMaker.startPage - 1)}&keywords=${keywords}"><</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<li><a href="result.do${pageMaker.makeQuery(idx)}&keywords=${keywords}">${idx}</a></li>
		</c:forEach>
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="result.do${pageMaker.makeQuery(pageMaker.endPage + 1)}&keywords=${keywords}">></a></li>
		</c:if>
	</ul>
</body>
</html>