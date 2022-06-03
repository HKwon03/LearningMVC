<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class = "dao.Person" scope = "request" />
	
	<!-- setProperty : Setter 주입 -->
	
	<jsp:setProperty name="person" property="id" value = "20220601" />
			<!-- Person 객체의 id 컬럼을 setter를 통해서 접근 setId(20220601) -->
	<jsp:setProperty name="person" property="name" value = "지방선거(휴일)" />
			<!-- Person 객체의 name 컬럼을 setter를 통해서 접근 setName(지방선거(휴일)) -->
	<p> 아이디 : <% out.println(person.getId()); %>
	<p> 이름 : <% out.println(person.getName()); %>
	
	<p><p><p>
	
	<p> 아이디 : <%= person.getId() %>
	<p> 이름 : <%= person.getName() %>
	
</body>
</html>