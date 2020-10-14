<%@ page import="com.simplerecipe.notice.dao.NoticeDAO" %>
<%@ page import="com.simplerecipe.notice.vo.NoticeVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/insertNotice.css" />" >
</head>
<body>
<div class="insert-form-wrap">
	<form action="insertNotice.do" method="post" id="insertNoticeForm"
		encType="multipart/form-data" >
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="noticeTbTitle" placeholder="제목을 입력하세요." /></td>
			</tr>
			<tr>
				<th>관리자 ID</th>
				<td>${adminTbId}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td width="1024" class="input-smarteditor">
					<%-- 네이버 스마트 에디터 입력란 --%>
					<textarea name="noticeTbContent" id="contents" rows="10" cols="100" 
					style="width:100%; height:412px; display:none;"></textarea>
				</td>
			</tr>
		</table>
	</form>
	<button type="submit" id="EditorSaveBtn" class="commonBtn">공지 등록</button>
	<a href="getNoticeList.do"><button class="commonBtn">돌아가기</button></a>
</div>
</body>
</html>