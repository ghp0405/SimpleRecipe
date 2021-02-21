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
<link rel="stylesheet" href="<c:url value="/resources/css/detail.css" />" >
</head>
<body>
<div class="detail-wrap">
	<img src="<c:url value="${recipe.recipeTbImageLink}" />" 
		style="width: 700px; height: 700px; display: block; margin: 0 auto;" /><br />
	<c:set var="lineSorter" value="0" scope="page" /> 
	<c:forEach var="line" items="${content}">
		<c:choose>
			<%-- line에 들어있는 문자열에 '[재료]'가 있을 경우 --%>
			<c:when test="${fn:contains(line, '[재료]')}"> 
				<br /><br /><span class="detail-content">${line}</span><br />
			</c:when>
			<c:when test="${fn:contains(line, '조리순서')}">
				<br /><br /><span class="detail-content">${line}</span><br />
				<c:set var="lineSorter" value="1" scope="page" />
			</c:when>
			<c:otherwise>
				<c:if test="${lineSorter eq 0}">
					<span class="detail-content">${line}</span>
				</c:if>
				<c:if test="${lineSorter eq 1}">
					<span class="detail-content">${line}</span><br />
				</c:if>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<%-- 뒤로가기 버튼 --%>
	<button class="commonBtn" onclick="history.back()">이전 페이지로 이동</button>
	<%-- 여기에 사용자와 작성자 NO가 서로 같을 경우, 
	수정 및 삭제가 가능하도록 a태그가 추가로 들어와야한다. --%>
	<c:if test="${userTbNo eq recipe.userTbNo}">
		<a href="/main/update?recipeTbNo=${recipe.recipeTbNo}"><button class="commonBtn">글 수정</button></a>
		<a href="/main/delete?recipeTbNo=${recipe.recipeTbNo}"><button class="commonBtn">글 삭제</button></a>
	</c:if>
	<div id="disqus_thread"></div>
</div><%-- end detail-wrap --%>
<script>

/**
*  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
*  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/

var disqus_config = function () {
	this.page.url = "http://localhost:8080/main/detail?recipeTbNo=${recipe.recipeTbNo}";  // Replace PAGE_URL with your page's canonical URL variable
	this.page.identifier = "${recipe.recipeTbNo}"; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
};

(function() { // DON'T EDIT BELOW THIS LINE
	var d = document, s = d.createElement('script');
	s.src = 'https://simplerecipe.disqus.com/embed.js';
	s.setAttribute('data-timestamp', +new Date());
	(d.head || d.body).appendChild(s);
})();
</script>
<noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>               
</body>
</html>