<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>

<%

String userId = (String)session.getAttribute("userId");
// 글 번호 값 얻기, 주어지지 않았으면 0으로 설정
//int num = Integer.parseInt(request.getParameter("num"));
String tmp = request.getParameter("num");
int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp)
                                            : 0;

// 새 글쓰기 모드를 가정하고 변수 초기값 설정
String writer  = "";
String title   = "";
String content = "";
String action  = "insert.jsp";

// 글 번호가 주어졌으면, 글 수정 모드
if (num > 0) {
    BoardDao dao = BoardDao.getInstance();
    Board board = dao.selectOne(num, false);

    // 글 데이터를 변수에 저장
    title   = board.getTitle();
    content = board.getContent();

    // 글 수정 모드일 때는 저장 버튼을 누르면 UPDATE 실행
    action  = "update.jsp?num=" + num;

}
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
 body { font-family: Arial, sans-serif; }
    table { width: 50%; margin: 50px auto; border-collapse: collapse;}
    th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }
    th { background-color: #f2f2f2; width: 30%; }
    input[type=text], textarea { width: calc(100% - 20px); padding: 10px; margin: 5px 0; box-sizing: border-box; }
    input[type=submit], input[type=button] { padding: 10px 20px; font-size: 16px; cursor: pointer;}
    input[type=submit] { background-color: dodgerblue; color: white; border: none; }
    input[type=button] { background-color: lightgray; color: black; border: none; }
    .button-container { text-align: center; }
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

<form method="post" action="<%=action%>">
<table>
    <tr>
        <th>제목</th>
        <td><input type="text" name="title"  maxlength="80"
                   value="<%=title%>">
        </td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><input type="text" name="writer" maxlength="20"
                   value="<%=session.getAttribute("userName")%>" readonly> <!-- 읽기 전용으로 설정하여 사용자가 수정할 수 없도록 함 -->
        </td>
    </tr>
    <tr>
        <th>내용</th>
        <td><textarea name="content" rows="10"><%=content%></textarea>
        </td>
    </tr>
</table>
<br>
<div class="button-container">
<input type="submit" value="저장">
<input type="button" value="취소" onclick="history.back()">
</div>
</form>

</body>
</html>