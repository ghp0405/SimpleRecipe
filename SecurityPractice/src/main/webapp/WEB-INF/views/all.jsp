<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Insert title here</title>
</head>
<body>

<h1>/users/all page</h1>

<sec:authorize access="isAnonymous()">
	<a href="/login">로그인</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a href="/customLogout">로그아웃</a>
</sec:authorize>

</body>
</html>
