<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/insertQnA.css" />" >
</head>
<body>
<div class="insert-form-wrap">
	<form action="insertQnA.do" method="post" id="insertQnAForm"
		encType="multipart/form-data" accept-charset="UTF-8" >
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="qnaTbTitle" placeholder="제목을 입력하세요." /></td>
			</tr>
			<tr>
				<th>작성자 ID</th>
				<td>${userTbId}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td width="1024" class="input-smarteditor"><%-- 네이버 스마트 에디터 입력란 --%>
					<textarea name="qnaTbContent" id="contents" rows="10" cols="100" 
					style="width:100%; height:412px; display:none;"></textarea>
				</td>
			</tr>
		</table>
		<button type="submit" id="EditorSaveBtn" class="commonBtn">QnA 등록</button>
		<a href="getQnAList.do"><button type="button" class="commonBtn">돌아가기</button></a>
	</form>
</div>
</body>
</html>