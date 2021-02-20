<%@ page import="com.simplerecipe.main.vo.RecipeVO" %>
<%@ page import="com.simplerecipe.main.dao.RecipeDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/update.css" />" >
</head>
<body>
<div class="update-form-wrap">
	<form action="/main/update" method="post" id="recipeSaveForm"
		encType="multipart/form-data" accept-charset="UTF-8" >
		<input type="hidden" name="recipeTbNo" value="${recipe.recipeTbNo}" />
		<%-- input file의 경우 보안문제상 read-only이기 때문에 value지정이 불가능하다. --%>
		<div class="file_input">
			<input type="text" readonly="readonly" id="file_route" >
			<label>
				<input type="file" name="imgFile" 
					onchange="javascript:document.getElementById('file_route').value=this.value"/>
			</label>
		</div>
		<input type="text" name="recipeTbTitle" class="recipeTbTitle" value="${recipe.recipeTbTitle}" /><br />
		<input type="button" id="addIngreBtn" value="재료 추가" /><br />
		<div id="addIngreWrap">
			<%-- 아래처럼하면 forEach문에서 2개 이상의 list를 반복문 돌릴 수 있다.
				status:반복문의 상태를 알려주는 지표로 사용된다. 
				현재 몇 번째 반복인지, 시작과 끝 등을 알려주는 편리한 기능을 제공
				<c:forEach var="list1" items="${list1}" varStatus="status">
	    			${list1.name}
	    			${list2[status.index].name}
				</c:forEach>
			--%>
			<c:forEach var="ing" items="${ingList}" varStatus="status">
				<div id="addIngre">
					<input type="text" name="ingredientTbName" class="ingredientTbName"
					value="${ings[status.index].ingredientTbName}" />
					<input type="text" name="addIngDetail" class="addIngDetail"
					value="${ing.ingredientListTbAmt}" />
					<input type="button" id="delIngreBtn" value="재료 삭제" /><br />
				</div>
			</c:forEach>
		</div>
		<%-- 네이버 스마트 에디터 입력란(조리순서) --%>
		<div class="input-smarteditor">
			<textarea name="recipeDetail" id="contents" rows="10" cols="100" 
			style="width:100%; height:412px; display:none;">${content}</textarea>
		</div>
		<input type="submit" id="EditorSaveBtn" value="레시피 수정" />
	</form>
</div>
<script>
$(document).ready(function(){
	
	$('#addIngreBtn').on('click', function(){
		console.log("재료 삽입 버튼 클릭");
		// before, after, clone 등의 함수는 오류 및 인식 안되는 경우가 많아 사용을 지양해야함
		// 태그를 붙일 때는 반드시 더미 div를 만들고 append 및 prepend 등을 이용하여 삽입해야함
		$('#addIngreWrap').append("<div id='addIngre'><input type='text' name='ingredientTbName' class='ingredientTbName' placeholder='재료를 입력해주세요.' /> <input type='text' name='addIngDetail' class='addIngDetail' placeholder='추가 옵션 및 설명을 입력해주세요.' /> <input type='button' id='delIngreBtn' value='재료 삭제' /><br /></div>");
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