<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Cookie ck = new Cookie("loginID","admin");
//ck.setMaxAge(60);
response.addCookie(ck);
%>
<%=ck.getName()  %>
<%=ck.getValue() %>
</body>
</html>