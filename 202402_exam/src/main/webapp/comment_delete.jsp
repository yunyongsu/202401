<%@page import="dao.CommentsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 댓글 삭제를 위한 댓글 ID와 게시물 번호를 파라미터에서 가져옴
int commentNum = Integer.parseInt(request.getParameter("commentNum"));

// CommentsDao 객체 생성
CommentsDao dao = CommentsDao.getInstance();
// 댓글 삭제 메서드 호출
dao.delete(commentNum);
request.getRequestDispatcher("view.jsp").forward(request, response);
%>
