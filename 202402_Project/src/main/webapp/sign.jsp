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
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(
    		"jdbc:mysql://localhost:3306/firm", "root", "mysql");
    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user (id, pw) VALUES (?, ?)");
    pstmt.setString(1, id);
    pstmt.setString(2, pw);
    pstmt.executeUpdate();
    pstmt.close();
    conn.close();

    response.sendRedirect("loginCK.jsp?success=true"); // 회원가입 성공 시 로그인 페이지로 이동
} catch (Exception e) {
    e.printStackTrace();
    out.println("회원가입 실패");
}
%>
 
</body>
</html>