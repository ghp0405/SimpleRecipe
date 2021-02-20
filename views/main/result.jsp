<%@ page import="com.simplerecipe.main.vo.RecipeVO" %>
<%@ page import="com.simplerecipe.main.dao.RecipeDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/resources/css/common.css' />" >
<link rel="stylesheet" href="<c:url value="/resources/css/result.css" />" >
</head>
<body>
<div class="result-wrap">
	<h2>검색 결과</h2>	
	<c:forEach var="result" items="${resultList}">
	<div class="recipe-wrap"><%-- 검색 결과에 대한 각 항목을 감싸는 div --%>
		<a href="/main/detail?recipeTbNo=${result.recipeTbNo}"> 
			<img src="<c:url value="${result.recipeTbImageLink}" />" /><br />
			<span class="recipe-title">${result.recipeTbTitle}</span><br />
		</a>
	</div><%-- end recipe-wrap --%>
	</c:forEach>
</div><%-- end result-wrap --%>
<%-- 페이징 처리 부분 --%>
<div class="paging-wrap">
	<ul> 
		<c:if test="${pageMaker.prev}">
			<li><a href="/main/result${pageMaker.makeQuery(pageMaker.startPage - 1)}&keywords=${keywords}"><</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<c:choose>
				<c:when test="${pageMaker.cri.page eq idx}">
					<li class="visit_page"><a href="/main/result${pageMaker.makeQuery(idx)}&keywords=${keywords}">${idx}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/main/result${pageMaker.makeQuery(idx)}&keywords=${keywords}">${idx}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="/main/result${pageMaker.makeQuery(pageMaker.endPage + 1)}&keywords=${keywords}">></a></li>
		</c:if>
	</ul>
</div>
</body>
</html>