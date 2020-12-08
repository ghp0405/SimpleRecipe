<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/insert.css" />" >
</head>
<body>
<div class="insert-form-wrap">
	<form action="/main/insert" method="post" id="recipeSaveForm"
		encType="multipart/form-data" accept-charset="UTF-8">
		<input type="file" name="imgFile" placeholder="레시피 이미지를 삽입해주세요."/><br />
		<input type="text" name="recipeTbTitle" placeholder="레시피 제목을 입력해주세요." /><br />
		<input type="button" id="addIngreBtn" value="재료 추가" /><br />
		<div id="addIngreWrap">
			<div id="addIngre">
				<input type="text" name="ingredientTbName" 
				placeholder="재료를 입력해주세요." />
				<input type="text" name="addIngDetail" 
				placeholder="추가 옵션 및 설명을 입력해주세요." />
				<input type="button" id="delIngreBtn" value="재료 삭제" /><br />
			</div>
		</div>
		<%-- 네이버 스마트 에디터 입력란(조리순서) --%>
		<div class="input-smarteditor">
			<textarea name="recipeDetail" id="contents" rows="10" cols="100" 
			style="width:100%; height:412px; display:none;"></textarea>
		</div>
		<input type="submit" id="EditorSaveBtn" value="레시피 등록" />
	</form>
</div>
<script>
$(document).ready(function(){
	
	$('#addIngreBtn').on('click', function(){
		console.log("재료 삽입 버튼 클릭");
		// before, after, clone 등의 함수는 오류 및 인식 안되는 경우가 많아 사용을 지양해야함
		// 태그를 붙일 때는 반드시 더미 div를 만들고 append 및 prepend 등을 이용하여 삽입해야함
		$('#addIngreWrap').append("<div id='addIngre'><input type='text' name='ingredientTbName' placeholder='재료를 입력해주세요.' /> <input type='text' name='addIngDetail' placeholder='추가 옵션 및 설명을 입력해주세요.' /> <input type='button' id='delIngreBtn' value='재료 삭제' /><br /></div>");
	});

	// 위처럼 append 등을 이용한 삽입 함수로 생성된 동적 태그들은
	// 일반적인 이벤트가 적용되지 않는다. 대신, 아래와 같은 형식을 사용하면
	// 정상적으로 이벤트가 동작한다.
	$(document).on("click", "#delIngreBtn", function(){
		console.log("재료 삭제 버튼 클릭");
		// #delIngreBtn에 연동된 이벤트를 삭제하지 않고 태그만 삭제하려면 detach를 사용해야함.
		// remove()의 경우 연동된 이벤트까지 삭제할 수 있으므로 사용시 주의할 것!
		$(this).parent().detach();
	});
	
})
</script>
</body>
</html>