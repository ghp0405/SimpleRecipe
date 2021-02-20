<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/updateQnA.css" />" >
</head>
<body>
<div class="update-form-wrap">
	<form action="/board/updateQnA" method="post" id="updateQnAForm"
		encType="multipart/form-data" >
		<input type="hidden" name="qnaTbNo" value="${qna.qnaTbNo}" />
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="qnaTbTitle" value="${qna.qnaTbTitle}" /></td>
			</tr>
			<tr>
				<th>관리자 ID</th>
				<td>${qna.userTbId}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td width="1024" class="input-smarteditor"><%-- 네이버 스마트 에디터 입력란 --%>
					<textarea name="qnaTbContent" id="contents" rows="10" cols="100" 
					style="width:100%; height:412px; display:none;">
					${qna.qnaTbContent}</textarea>
				</td>
			</tr>
				
		</table>
		<button type="submit" id="EditorSaveBtn" class="commonBtn">QnA 수정</button>
		<a href="/board/getQnAList"><button type="button" class="commonBtn">돌아가기</button></a>
	</form>
</div>
</body>
</html>