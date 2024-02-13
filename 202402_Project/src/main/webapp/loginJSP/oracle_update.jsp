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
String sql = "update score set kor = ?, eng = ?, math = ? where name = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, request.getParameter("kor"));
pstmt.setString(2, request.getParameter("eng"));
pstmt.setString(3, request.getParameter("math"));
pstmt.setString(4, request.getParameter("name"));
pstmt.executeUpdate();
%>
수정 완료!
<a href="oracle_list.jsp"> 초기화면 </a>
</body>
</html>