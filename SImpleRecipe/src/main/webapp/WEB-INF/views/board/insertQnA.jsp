<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="insertQnA.do" method="post" id="insertQnAForm"
	encType="multipart/form-data" >
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
			<td width="1024"><%-- 네이버 스마트 에디터 입력란 --%>
				<textarea name="qnaTbContent" id="contents" rows="10" cols="100" 
				style="width:100%; height:412px; display:none;"></textarea>
			</td>
		</tr>
		<tr>
			<td><input type="submit" id="EditorSaveBtn" value="QnA 등록" /></td>
			<td><a href="getQnAList.do"><button type="button">돌아가기</button></a></td>
		</tr>
	</table>
</form>
</body>
</html>