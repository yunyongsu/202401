<%@page import="dao.MemberDao"%>
<%@page import="util.Cookies"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   

<%
	String id = request.getParameter("id");
	String email = request.getParameter("pw");
	
	String remember = request.getParameter("remember");
	if (remember != null && remember.equals("on")) {
		response.addCookie(Cookies.createCookie("id", id, "/", 60 * 60));
	} else {
		response.addCookie(Cookies.createCookie("id", "", "/", 0));
	}

	Member member = MemberDao.getInstance().selectForLogin(id, email);
	
    if (member != null) {
        session.setAttribute("userId",   member.getId());
        session.setAttribute("userName", member.getName());
        
        response.sendRedirect("login_main.jsp"); 
        return;
    }
%>
	
<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    window.location.href = "login_main.jsp";
</script>
