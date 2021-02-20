<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/jquery-3.5.1.min.js" ></script>
<script type="text/javascript">
$(document).ready(function(){
	var city = "Seoul";
	var apiURI = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+"5443581f5ab47b63ff5c4a3a4508d19f";

    // async: "false", 해당부분은 type아래에 있었고, 해당 줄 유무에 상관없이 정상 작동함
	$.ajax({
	    url: apiURI,
	    dataType: "json",
	    type: "GET",
	    success: function(resp) {
	        console.log(resp);
	        console.log("현재온도 : "+ (resp.main.temp- 273.15) );
	        console.log("현재습도 : "+ resp.main.humidity);
	        console.log("날씨 : "+ resp.weather[0].main );
	        console.log("상세날씨설명 : "+ resp.weather[0].description );
	        console.log("날씨 이미지 : "+ resp.weather[0].icon );
	        console.log("바람   : "+ resp.wind.speed );
	        console.log("나라   : "+ resp.sys.country );
	        console.log("도시이름  : "+ resp.name );
	        console.log("구름  : "+ (resp.clouds.all) +"%" );                 
	    }
	});
});
</script>
</head>
<body>

</body>
</html>