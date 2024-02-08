<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    boolean login = false;
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    String sql = "select count(*) as ct from users where id = ? and pw = ?";
    try ( 
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        PreparedStatement pstmt = conn.prepareStatement(sql);
    ) {
    	pstmt.setString(1, id);
    	pstmt.setString(2, pw);
        ResultSet rs = pstmt.executeQuery();

    	rs.next();
    	int res = rs.getInt("ct");
    	if (res == 1) {
    		login = true;
    	} 
    } catch(Exception e) {
       System.out.println("오류!");
    }
    
    
    if (login) {
        Cookie cookie = new Cookie("userId", id);
        cookie.setMaxAge(-1);         // 웹 브라우저가 닫힐 때 쿠키 만료됨
        response.addCookie(cookie);
        
        response.sendRedirect("oracle_list.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>