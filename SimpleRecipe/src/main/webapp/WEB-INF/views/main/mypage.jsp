<%@ page import="com.simplerecipe.main.vo.RecipeVO" %>
<%@ page import="com.simplerecipe.main.dao.RecipeDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/mypage.css" />" >
</head>
<body>
<div class="mypage-wrap">
	<h2>마이페이지 입니다.</h2>
	<button class="commonBtn"><a href="insert.do">레시피 등록</a></button>
	<%-- 여기에 자기가 등록한 레시피들의 목록이 나타나야한다. 
	또한, 레시피에 대한 내용 보기 및 수정, 삭제도 가능해야한다. --%>
	<h2>${userTbId}님이 작성한 레시피 목록</h2>	
	<c:forEach var="myRecipe" items="${myRecipeList}">
		<div class="recipe-wrap">
			<a href="detail.do?recipeTbNo=${myRecipe.recipeTbNo}">
				<img src="<c:url value="${myRecipe.recipeTbImageLink}" />" />
				<span class="recipe-title">${myRecipe.recipeTbTitle}</span><br />
			</a>
		</div>
	</c:forEach>
</div> <%-- end mypage-wrap --%>
</body>
</html>