<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%
String userId = (String)session.getAttribute("userId");
String userName = (String)session.getAttribute("userName");
	String writer  = "";
	String title   = "";
	String content = "";
	String regtime = "";
	int    hits    = 0;
	
	int num = Integer.parseInt(request.getParameter("num"));

	String memberId = (String) session.getAttribute("userId");
	if (memberId == null) {
		response.sendRedirect("login_main.jsp");
	}
	
	BoardDao dao = BoardDao.getInstance();
	Board board = dao.selectOne(num, true);

	
	writer = board.getWriter();
	title = board.getTitle();
	content = board.getContent();
	regtime = board.getRegtime();
	hits = board.getHits();
	
	// 글 제목과 내용이 웹 페이지에 올바르게 출력되도록 
    // 공백과 줄 바꿈 처리
    title   = title.replace  (" ", "&nbsp;");
    content = content.replace(" ", "&nbsp;").replace("\n", "<br>");
    
    boolean isAdminOrAuthor = userName != null && (userName.equals("관리자") || userName.equals(writer));
%>

<!DOCTYPE html>
<html>
<head>
     <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 - 기업형 웹 페이지</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <script src="js/ie.js"></script>
     <link rel="stylesheet" href="css/home.css">
<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 0px;
    padding: 0;
}
.container {
    width: 80%;
    margin: 20px auto;
    padding: 20px;
    text-align: center;
    position: relative;
}

table {
    width: 70%;
    margin: 0 auto;
}

th, td {
    padding: 12px;
    border-bottom: 1px solid #dee2e6;
    text-align: left;
}

th {
    background-color: #f2f2f2;
    font-weight: 600;
}

td {
    font-weight: 400;
}

.button-container {
    position: absolute;
    right: 200px;
}

.button-container input[type="button"] {
    padding: 10px 20px;
    border: 1px solid black;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s, box-shadow 0.3s;    
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);

}


.button-container input[type="button"]:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
   <header>
        <div class="inner">
            <h1><a href="homePage.jsp">중앙정보기술인재개발원</a></h1>

            <ul id="gnb">
                <li><a href="list.jsp">게시판</a></li>
                <li><a href="#">GALLERY</a></li>
                <li><a href="#">YOUTUBE</a></li>
                <li><a href="#">COMMUNITY</a></li>
                <li><a href="#">LOCATION</a></li>
            </ul>

            <ul class="util">
                <% if (userId != null) { %>
                    <li><a href="logout.jsp">로그아웃</a></li>
                    <li><a href="member_update_form.jsp">회원정보수정</a></li>
                <% } else { %>
                    <li><a href="login_main.jsp">로그인</a></li>
                    <li><a href="member_join_form.jsp">회원가입</a></li>
                <% } %>
            </ul>
        </div>
    </header>
<div class="container">

	<table>
		<tr>
			<th>제목</th>
			<td><%=title%></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=userName%></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td><%=regtime%></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=hits%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=content%></td>
		</tr>
	</table>
	<br>
	<div class="button-container">
	<input type="button" value="목록보기" onclick="location.href='list.jsp'">
	<% if (isAdminOrAuthor) { %>
	<input type="button" value="수정"
		onclick="location.href='write.jsp?num=<%=num%>'">
	<input type="button" value="삭제"
		onclick="location.href='delete.jsp?num=<%=num%>'">
	<%} %>
	</div>

</div>
</body>
</html>
