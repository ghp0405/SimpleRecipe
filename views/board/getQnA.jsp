<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/getQnA.css" />" >
</head>
<body>
<div class="qna-wrap">
	<table>
		<tr>
			<th>제목</th>
			<td>${qna.qnaTbTitle}</td>
		</tr>
		<tr>
			<th>작성자 ID</th>
			<td>${qna.userTbId}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td width="1024">${qna.qnaTbContent}</td>
		</tr>
	</table>
	<c:if test="${qna.userTbId eq userTbId}">
		<a href="/board/updateQnA?qnaTbNo=${qna.qnaTbNo}"><button class="commonBtn">글 수정하기</button></a>
		<a href="/board/deleteQnA?qnaTbNo=${qna.qnaTbNo}"><button class="commonBtn">글 삭제하기</button></a>
	</c:if>
	<a href="/board/getQnAList"><button class="commonBtn">글 목록으로</button></a>
	<div id="disqus_thread"></div>
</div>
<script>

/**
*  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
*  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/

var disqus_config = function () {
this.page.url = "http://localhost:8080/board/getQnA?qnaTbNo=${qna.qnaTbNo}";  // Replace PAGE_URL with your page's canonical URL variable
this.page.identifier = "${qna.qnaTbNo}"; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
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