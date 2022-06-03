<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	// 쿠키 삭제 : cookie.setMaxAge(0);

	Cookie[] cookies = request.getCookies();
	
	for(int i = 0 ; i < cookies.length ; i++) {
		cookies[i].setPath(request.getContextPath());
		cookies[i].setMaxAge(0);	// 모든 쿠키의 정보를 삭제, <서버에서 설정만 구성>
		
		//클라이언트에 전송(적용) : response.addCookie(cookies[i]);
		response.addCookie(cookies[i]);
		
		out.println("쿠키 삭제 성공");
		
	}

	//페이지 이동
	response.sendRedirect("cookie02.jsp");
%>

</body>
</html>