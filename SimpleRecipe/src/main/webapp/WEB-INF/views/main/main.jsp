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
<link rel="stylesheet" href="<c:url value="/resources/css/owl.carousel.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/owl.theme.default.min.css"/>">
<script src="/resources/js/owl.carousel.min.js"></script>
</head>
<body>
<div class="main-wrap">
	<div class="owl-carousel owl-theme owl-loaded">
	    <div class="owl-stage-outer">
	        <div class="owl-stage">
	            <div class="owl-item"><img src="/resources/img/simplerecipe_main.jpg" alt="음식"></div>
	            <div class="owl-item"><img src="/resources/img/simplerecipe_main02.jpg" alt="음식"></div>
	            <div class="owl-item"><img src="/resources/img/simplerecipe_main03.jpg" alt="음식"></div>
	        </div>
	    </div>
	</div>
	<div class="form-wrap txt-c">
		<form action="/main/result" method="get">
			<h1><label>Simple Recipe</label></h1>
			<input type="text" name="keywords" class="inputTxt" placeholder="검색어를 입력하세요.(예시: 당근, 오이)"/>
			<button type="submit" class="commonBtn mt40">검색</button>
		</form>
	</div><%-- end form-wrap --%>
</div><%-- end main-wrap --%>
<script>
	var owl = $('.owl-carousel');
	owl.owlCarousel({
		items: 1,
		loop: true,
		margin: 20,
		dots: true,
		autoplay: true,
		autoplayHoverPause: true,
		smartSpeed: 800,

	});

	$('.inputTxt').focus(function() {
		$('h1 label').css({
			'color' : '#ff940f',
			'text-shadow' : '1px 1px 1px rgba(0,0,0,1)'
		})
	});

	$('.inputTxt').focusout(function() {
		$('h1 label').css({
			'color' : '#fff',
		})
	})
		
</script>
</body>
</html>