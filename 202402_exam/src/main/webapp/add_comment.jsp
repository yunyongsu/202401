<%@page import="dao.CommentsDao"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Comments"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String memberId = (String)session.getAttribute("userId");
if (memberId == null) {
	response.sendRedirect("login_main.jsp");
}

int boardNum = Integer.parseInt(request.getParameter("num"));
String writer = request.getParameter("writer");
String content = request.getParameter("content");

if (content  == null || content.length()  == 0){
	%>      
    <script>
        alert('빈칸 없이 입력되어야 합니다.');
        history.back();
    </script>
<%        
    return;
}


CommentsDao daoc = CommentsDao.getInstance();
Comments comm = new Comments(boardNum, writer, content);
int result = daoc.addComment(comm);
if (result > 0) {
	response.sendRedirect("list.jsp");
} else {
    response.sendRedirect("error.jsp");
}
%>