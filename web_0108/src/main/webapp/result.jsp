<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num = Integer.parseInt(("mmm")); //String str = request.getParameter
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<%
for (int i = 1; i < 10; i++){
%>
	<h1><%=num %> x <%=i %> = <%=i*num%></h1>
<%} %>
</body> 
</html>
