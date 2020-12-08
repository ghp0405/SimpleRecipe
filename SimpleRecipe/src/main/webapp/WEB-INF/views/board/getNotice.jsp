<%@ page import="com.simplerecipe.notice.dao.NoticeDAO" %>
<%@ page import="com.simplerecipe.notice.vo.NoticeVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/getNotice.css" />" >
</head>
<body>
<div class="notice-wrap">
	<table>
		<tr>
			<th>제목</th>
			<td>${notice.noticeTbTitle}</td>
		</tr>
		<tr>
			<th>관리자 ID</th>
			<td>${notice.adminTbId}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td width="1024">${notice.noticeTbContent}</td>
		</tr>
	</table>
	<c:if test="${userType == '관리자'}">
		<a href="/board/updateNotice?noticeTbNo=${notice.noticeTbNo}"><button class="commonBtn">수정하기</button></a>
		<a href="/board/deleteNotice?noticeTbNo=${notice.noticeTbNo}"><button class="commonBtn">삭제하기</button></a>
	</c:if>
	<a href="/board/getNoticeList"><button class="commonBtn">글 목록으로</button></a>
	<div id="disqus_thread"></div>
</div>
<script>

/**
*  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
*  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/

var disqus_config = function () {
this.page.url = "http://localhost:8080/board/getNotice.do?noticeTbNo=${notice.noticeTbNo}";  // Replace PAGE_URL with your page's canonical URL variable
this.page.identifier = "${notice.noticeTbNo}"; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
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