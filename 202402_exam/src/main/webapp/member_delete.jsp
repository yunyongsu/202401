<%@page import="dto.Member"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String memberId = request.getParameter("id");

if(memberId != null && !memberId.isEmpty()) {
    // MemberDao를 이용하여 회원을 삭제합니다.
    MemberDao memberDao = MemberDao.getInstance();
    int deleted = memberDao.delete(memberId);
    
    // 회원을 삭제한 후, 성공 여부에 따라 메시지를 출력합니다.
    if(deleted > 0) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
    alert('회원탈퇴가 완료되었습니다.');
    window.location.href = "homePage.jsp";
</script>
<% session.invalidate(); // 세션 무효화 (로그아웃)} 
}
}%>
</body>
</html>