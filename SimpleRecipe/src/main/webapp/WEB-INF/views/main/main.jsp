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
<link rel="stylesheet" href="<c:url value='/resources/css/common.css' />" >
<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" >
</head>
<body>
<div class="main-wrap">
	<div class="form-wrap txt-c">
		<form action="/main/result" method="get">
			<h1><label>Simple Recipe</label></h1>
			<input type="text" name="keywords" class="inputTxt"/>
			<button type="submit" class="commonBtn mt40">검색</button>
		</form>
	</div><%-- end form-wrap --%>
</div><%-- end main-wrap --%>
</body>
</html>