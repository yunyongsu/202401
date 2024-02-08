<%@page import="java.sql.ResultSet"%>
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
<%String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
Class.forName(driver);
Connection conn = DriverManager.getConnection(url, "scott", "tiger");
String sql = "select num, name, kor, eng, math from score where name = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1,request.getParameter("name"));
ResultSet rs = pstmt.executeQuery();
String num = "";
String name = "";
String kor = "";
String eng = "";
String math = "";
if (rs.next()){
	num = rs.getString("num");
	name = rs.getString("name");
	kor = rs.getString("kor");
	eng = rs.getString("eng");
	math = rs.getString("math");
}
%>
<form action = oracle_update.jsp>
번호<input type="text" name="num" value="<%=num%>"><br/>
이름<input type="text" name="name" value="<%=name%>"><br/>
국어<input type="text" name="kor" value="<%=kor%>"><br/>
수학<input type="text" name="eng" value="<%=eng%>"><br/>
영어<input type="text" name="math" value="<%=math%>"><br/>
 <input type="submit" value="수정">
<input type="reset"/>
<a href="oracle_list.jsp"> 돌아가기 </a>
</form>
</body>
</html>