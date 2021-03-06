<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "utils.CookieManager" %>
<%@ page import = "utils.JSFunction" %>
    
<%

	//폼에서 넘기는 파라미터 값 받기
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String save_check = request.getParameter("save_check");

	if ("hong".equals(user_id) && "1234".equals(user_pw)) {
		//로그인 성공
		if (save_check != null && save_check.equals("Y")) {	//아이디 저장 체크한 경우 : 쿠키 생성
			//쿠키저장(쿠키를 사용해서 ID를 저장함)
			CookieManager.makeCookie(response, "loginId", user_id, (60 * 60 * 24));
		} else {	//아이디 저장 체크 안한 경우 : 쿠키 삭제
			CookieManager.deleteCookie(response, "loginId");
		}
		
		//로그인 성공 후 성공 페이지로 이동
		JSFunction.alertLocation("로그인 성공 했습니다", "IdSaveMain.jsp", out);
		
	} else {
		//로그인 실패 후 페이지 이동
		JSFunction.alertBack("로그인 실패 했습니다", out);
		
	}
%>