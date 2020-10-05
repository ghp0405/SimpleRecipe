$(function(){
	var oEditors = [];
	//스마트 에디터 생성 함수
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "contents",
		sSkinURI : "resources/smarteditor2/SmartEditor2Skin.html",
		htParams : {
			bUseToolbar : true,
			bUseVerticalResizer : true,
			bUseModeChanger : true,
		},
		fCreator: "createSEditor2"
	});
	
	$("#EditorSaveBtn").click(function(){
		oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
		
		$("#EditorForm").submit();
	});
	
})