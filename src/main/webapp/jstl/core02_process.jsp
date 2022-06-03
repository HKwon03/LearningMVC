<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String number = request.getParameter("number");
%>

	 스크립트 리태크로 출력 :
	<%= number %> <p>
	
	 JSTL로 출력 :
	<c:out value = "${param.number }" /> <p>
	
	
<c:choose>
	<c:when test="${param.number % 2 == 0 }" >
		<c:out value = "${param.number }" /> 은 짝수 입니다.
	</c:when>
	<c:when test="${param.number % 2 == 1 }" >
		<c:out value="${param.number }" /> 은 홀수 입니다.
	</c:when>
	<c:otherwise>
		숫자가 아닙니다.
	</c:otherwise>


</c:choose>



</body>
</html>