
<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType = "text/html; charset=utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	BoardDao dao = BoardDao.getInstance();
	Board board = new Board(Integer.parseInt(id), password);
	boolean login = dao.login(board);
	
	
	if (login) {
		session.setAttribute("MEMBERID", id);
		session.setAttribute("PASSWORD", password);
		response.sendRedirect("list.jsp");
%>
<html>
<head></head>
<body>

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