<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web_0108.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for(int i = 0; i< Student.name.length; i++){
%>
	<%=Student.name[i] %><br>
<%} %>
</body>
</html>