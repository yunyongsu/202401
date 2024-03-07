<%@page import="dto.Comments"%>
<%@page import="dao.CommentsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
//한글 인코딩 설정
request.setCharacterEncoding("UTF-8");

// 댓글 수정을 위한 댓글 번호와 수정된 내용을 파라미터에서 가져옴
int commentNum = Integer.parseInt(request.getParameter("commentNum"));
String content = request.getParameter("content");
int boardNum = Integer.parseInt(request.getParameter("boardNum"));


// CommentsDao 객체 생성
CommentsDao dao = CommentsDao.getInstance();
// 수정된 댓글 내용을 설정한 Comments 객체 생성
Comments comment = new Comments(commentNum, content);
// 댓글 수정 메서드 호출
dao.update(comment);

%>
<script>
    // 댓글 수정이 완료되면 해당 글 번호로 다시 이동
    var boardNum = '<%= request.getParameter("boardNum") %>';
    window.location.href = "view.jsp?num=" + boardNum;
</script>