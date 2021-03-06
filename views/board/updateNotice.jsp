<%@ page import="com.simplerecipe.notice.dao.NoticeDAO" %>
<%@ page import="com.simplerecipe.notice.vo.NoticeVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/updateNotice.css" />" >
</head>
<body>
<div class="update-form-wrap">
	<form action="/board/updateNotice" method="post" id="updateNoticeForm"
		encType="multipart/form-data" >
		<input type="hidden" name="noticeTbNo" value="${notice.noticeTbNo}" />
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="noticeTbTitle" value="${notice.noticeTbTitle}" /></td>
			</tr>
			<tr>
				<th>관리자 ID</th>
				<td>${notice.adminTbId}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td width="1024" class="input-smarteditor"><%-- 네이버 스마트 에디터 입력란 --%>
					<textarea name="noticeTbContent" id="contents" rows="10" cols="100" 
					style="width:100%; height:412px; display:none;">
					${notice.noticeTbContent}</textarea>
				</td>
			</tr>
		</table>
		<button type="submit" id="EditorSaveBtn" class="commonBtn">공지 수정</button>
		<a href="/board/getNoticeList"><button type="button" class="commonBtn">돌아가기</button></a>
	</form>
</div>
</body>
</html>