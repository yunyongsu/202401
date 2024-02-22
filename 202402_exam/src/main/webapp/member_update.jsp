<%@page import="dto.Member"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String email = request.getParameter("email");
String name = request.getParameter("name");

MemberDao dao = MemberDao.getInstance();
Member member = new Member(id, email, name);
dao.update(member);

session.setAttribute("userName", request.getParameter("name"));
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('수정이 완료되었습니다.');
    window.location.href = "homePage.jsp";
</script>

</body>
</html>