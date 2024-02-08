<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="util.Cookies"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("password");

boolean login = false;

Class.forName("oracle.jdbc.driver.OracleDriver");
String sql = "select count(*) as ct from score where num = ? and name = ?";
try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		PreparedStatement pstmt = conn.prepareStatement(sql);) {
	pstmt.setString(1, id);
	pstmt.setString(2, pw);
	ResultSet rs = pstmt.executeQuery();

	rs.next();
	int res = rs.getInt("ct");
	if (res == 1) {
		login = true;
	}
} catch (Exception e) {
	System.out.println("오류!");
}

if (login) {
	response.addCookie(Cookies.createCookie("AUTH", id, "/", -1));
	
%>
<html>
<head>
<title>로그인성공</title>
</head>
<body>
<%response.sendRedirect("oracle_list.jsp");  %>
</body>
</html>
<%
} else { // 로그인 실패시
%>
<script>
	alert("로그인에 실패하였습니다.");
	history.go(-1);
</script>
<%
}
%>
