<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    session.removeAttribute("userId"  );
    session.removeAttribute("userName");
%> 
<script>
    alert('로그아웃 되었습니다.');
    window.location.href = "homePage.jsp";
</script>