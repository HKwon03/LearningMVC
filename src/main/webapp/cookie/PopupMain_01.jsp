<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 팝업 띄우기 </title>
<!-- JQuery를 사용할 수 있는 라이브러리 등록 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	div#popup {
		position : absolute; top : 50px; left : 50px; color : yellow;
		width : 270px; height : 100px; background-color : gray;
	}
	div#popup>div {
		position : relative; background-color : #ffffff;
		top : 0px; border : 1px solid gray; padding : 10px; color : black;
		
	}
	
</style>

<script>
$(function() {
	$('#closeBtn').click(function(){
		$('#popup').hide();
	});	
});

</script>

</head>
<body>

<%
	String popupMode = "on";
%>

<h2> 팝업 메인 페이지</h2>
<%
	for(int i = 0 ; i <= 10 ; i++) {
		out.println("현재 팝업 창은 " + popupMode + "상태입니다. <br>");
	}

	if(popupMode.equals("on")) {
%>
	<!-- popupMode = "on" 일때 출력되는 html 블럭 -->

	<div id = "popup">
		<h2 align = "center"> 공지사항 팝업 입니다.</h2>
		<div align = "left">
			-- 내용 1 <br>
			-- 내용 2 <br>
			-- 내용 3 <br> <p>
			<form name = "popupFrm">
				<input type = "checkbox" id = "inactiveToday" value = "1">
				하루동안 열리지 않기
				<input type = "button" value = "닫기" id = "closeBtn">
			</form>
		</div>
	</div>
<%
	}
%>

</body>
</html>