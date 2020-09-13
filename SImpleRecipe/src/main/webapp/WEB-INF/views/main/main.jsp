<%@ page import="com.simplerecipe.main.vo.RecipeVO" %>
<%@ page import="com.simplerecipe.main.dao.RecipeDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>My Simple Recipe</h1>
	<form action="/result.do" method="get">
		<label>검색어 입력</label>
		<input type="text" name="keywords" />
		<button type="submit" value="검색" />
	</form>
</body>
</html>