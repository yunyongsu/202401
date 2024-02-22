<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    session.removeAttribute("userId"  );
    session.removeAttribute("userName");
    
    Cookie cookie = new Cookie("id", "");
    cookie.setMaxAge(0); // 쿠키의 유효 시간을 0으로 설정하여 삭제합니다.
    response.addCookie(cookie);

    response.sendRedirect("homePage.jsp"); // 로그인 메인 화면으로
%> 
