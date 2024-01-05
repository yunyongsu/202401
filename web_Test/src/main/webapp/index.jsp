<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
public static String print(){
	return "안녕";
}
%>
<%=print() %>



<%
int x= 10;
int y= 12;
int z = x+y;

%>
<h2><%=z %></h2>
<%
Date now = new Date();
%>
<%=now %>
<h1> 안녕안녕</h1>

</body>
</html>