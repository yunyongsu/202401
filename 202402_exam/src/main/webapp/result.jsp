<%@page import="javax.swing.RepaintManager"%>
<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//Cookies cookies = new Cookies(request);
String remember = request.getParameter("remember");
String id = request.getParameter("id");
if (remember != null && remember.equals("on")) {
	response.addCookie(Cookies.createCookie("id", id, "/", 60 * 60));
} else {
	response.addCookie(Cookies.createCookie("id", "", "/", 0));
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
@@Start@@
</body>
</html>