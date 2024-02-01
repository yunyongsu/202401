<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
request.setCharacterEncoding("utf-8"); /*form method가 post일때 한글처리를 위해 작성*/
String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
Class.forName(driver);
Connection conn = DriverManager.getConnection(url, "scott", "tiger");
String sql = "update emp1 set job = ?, sal = ? where ename = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, request.getParameter("job"));
pstmt.setString(2, request.getParameter("sal"));
pstmt.setString(3, request.getParameter("ename"));
pstmt.executeUpdate();
%>
수정 완료!
<a href="insertForm.jsp"> 초기화면 </a>
</body>
</html>