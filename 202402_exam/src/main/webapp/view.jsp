<%@page import="java.util.List"%>
<%@page import="dao.CommentsDao"%>
<%@page import="dto.Comments"%>
<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%
int num = Integer.parseInt(request.getParameter("num"));

String userId = (String) session.getAttribute("userId");
String userName = (String) session.getAttribute("userName");

String writer = "";
String title = "";
String content = "";
String regtime = "";
int hits = 0;





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
title = title.replace(" ", "&nbsp;");
content = content.replace(" ", "&nbsp;").replace("\n", "<br>");

boolean isAdminOrAuthor = userName != null && (userName.equals("관리자") || userName.equals(writer));


CommentsDao comm = CommentsDao.getInstance();
List<Comments> list = comm.CommentsBoard(num);

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
	width: 90%;
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

/* 댓글 섹션 스타일 */
#comment-section {
	width: 70%;
	margin: 60px auto;
	text-align: center;
	border: 1px solid #ccc;
	padding: 20px;
	border-radius: 10px;
}

#comment-section h3 {
	margin-bottom: 20px;
	font-size: 24px;
	color: #333;
	border-bottom: 1px solid lightgray;
	padding: 30px;
}

.comment {
	margin-bottom: 20px;
	padding: 10px;
	border: 1px solid #eee;
	border-radius: 5px;
}

.comment-info {
	margin-bottom: 5px;
	font-size: 14px;
	color: #666;
}

.comment-content {
	font-size: 16px;
	color: #333;
}

/* 댓글 작성 폼 스타일 */
#comment-form {
	width: 70%;
	margin: 0 auto;
	margin-top: 80px; padding : 20px;
	border: 1px solid #ccc;
	border-radius: 10px;
	padding: 20px;
}

#comment-form h2 {
	margin-bottom: 20px;
	font-size: 24px;
	color: #333;
}


#comment-form textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 16px;
	resize: vertical;
}

#comment-form button[type="submit"] {
	background-color: sandybrown;
	color: #fff;
	border: none;
	padding: 12px 20px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s;
}

#comment-form button[type="submit"]:hover {
	background-color: #0056b3;
}

#comment-form p {
	text-align: left;
	color: black;
	font-size: 17px;
	margin-bottom: 30px;
}
#comment-section .delete_button{
	padding: 5px 15px;
	border: 1px solid black;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s, box-shadow 0.3s;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>
	<header>
		<div class="inner">
			 <a href="homePage.jsp">
            <img src="img/mainlogo.png" style="width:200px">
			</a>
			<ul id="gnb">
				<li><a href="list.jsp">게시판</a></li>
				<li><a href="#">GALLERY</a></li>
				<li><a href="#">YOUTUBE</a></li>
				<li><a href="#">COMMUNITY</a></li>
				<li><a href="#">LOCATION</a></li>
			</ul>

			<ul class="util">
				<%
				if (userId != null) {
				%>
				<li><p><%=userName%>님</p></li>
				<li><a href="logout.jsp">로그아웃</a></li>
				<li><a href="member_update_form.jsp">회원정보수정</a></li>
				<%
				} else {
				%>
				<li><a href="login_main.jsp">로그인</a></li>
				<li><a href="member_join_form.jsp">회원가입</a></li>
				<%
				}
				%>
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
				<td><%=writer%></td>
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
			<%
			if (isAdminOrAuthor) {
			%>
			<input type="button" value="수정"
				onclick="location.href='write.jsp?num=<%=num%>'"> 
				<input type="button" value="삭제"
				onclick="location.href='delete.jsp?num=<%=num%>'">
			<%
			}
			%>
		</div>		
	</div>
	
	<div id="comment-section">
    <h3>댓글 목록</h3>
    <table>
        <tr>
            <th class="writer">작성자</th>
            <th class="content">내용</th>
            <th class="regtime">작성일시</th>
            <th></th>
        </tr>
        <% for (Comments comment : list) { %>
        <tr>
            <td><%=comment.getWriter()%></td>
            <td><%=comment.getContent()%></td>
            <td><%=comment.getRegtime()%></td>
            <td>
        		<input type="button" value="삭제" class="delete_button"
        		onclick="location.href = 'comment_delete.jsp?commentNum=<%=comment.getCommentNum()%>&num=<%=num%>';">
    		</td>
        </tr>
        <% } %>
    </table>
</div>
	<!-- 댓글 작성 폼 -->
	<div id="comment-form">
		<form action="add_comment.jsp" method="post">
			<input type="hidden" name="num" value="<%=num%>">
			<input type="hidden" name="writer" value="<%=userId%>">
			<div>
				<p>
					<strong><%=writer%></strong>
				</p>
			</div>
			<div>
				<textarea id="comment-content" name="content"
					placeholder="댓글을 입력하세요" required></textarea>
			</div>
			<button type="submit">댓글 작성</button>
		</form>
	</div>
	</div>
</body>
</html>
