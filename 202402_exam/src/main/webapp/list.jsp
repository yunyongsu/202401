<%@page import="dto.ArticlePage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Board"%>
<%@page import="java.util.List"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%
//로그인이 안됐을 시 로그인페이지로 이동
String userId = (String)session.getAttribute("userId");
if (userId == null) {
    response.sendRedirect("login_main.jsp");
}

BoardDao dao = BoardDao.getInstance();

//이름 검색
String searchName = request.getParameter("searchName"); // 검색어 가져오기
List<Board> list;
if (searchName != null && !searchName.isEmpty()) {
    list = dao.searchName(searchName); // 검색 결과 가져오기
} else {
    list = dao.selectList(); // 검색어가 없으면 전체 목록 가져오기
}

//리스트 페이징
String pageNoVal = request.getParameter("pageNo");
int pageNo = 1; // 기본 페이지 번호 설정
if (pageNoVal != null) {
    pageNo = Integer.parseInt(pageNoVal);
}

int total = dao.selectCount(); // 전체 게시글 수 조회
// 현재 페이지에 해당하는 게시글 목록 조회 (1페이지 당 5개)
list = dao.select((pageNo - 1) * 5, 5);
// ArticlePage 객체 생성
ArticlePage articlePage = new ArticlePage(total, pageNo, 5, list);

// articlePage를 request 속성으로 설정
request.setAttribute("articlePage", articlePage);
%>
<!doctype html>
<html lang="en">
 <head>
     <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 - 기업형 웹 페이지</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <script src="js/ie.js"></script>
     <link rel="stylesheet" href="css/home.css">
<style>
/* header */
header {
	width: 100%;
	border-bottom: 1px solid #ddd;
}
header .inner {
	width: 1180px;
	height: 120px;
	margin: 0 auto;
	position: relative; /*자식 absolute 요소의 기준점 설정*/
}
header .inner h1 {
	position: absolute;
	bottom: 42px;
}
header .inner h1 a {
	text-decoration: none;
}
header .inner .util li a {
	text-decoration: none;
}
header .inner #gnb{
	margin-bottom: -0px; 
}

header .inner #gnb li a {
	text-decoration: none;
}
table a{
text-decoration: none;
}
.button-write{
	text-align: center;
}
.pageNo{
text-align: center;
margin-bottom: 20px;
}
.pageNo a{
text-decoration: none;
}
</style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
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
<div class="container" style="padding-top: 50px">
<form action="" method="GET">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="이름 입력" name="searchName" value="<%= (searchName != null) ? searchName : "" %>">
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="submit">Search</button>
        </div>
      </div>
    </form>
<table class="table talbe-bordered table-hover">
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th                >조회수  </th>
    </tr>
<%
        for(Board board : list) {
%>         
        <tr>
            <td><%=board.getNum()%></td>
            <td style="text-align:left;">
                <a href="view.jsp?num=<%=board.getNum()%>">
                    <%=board.getTitle()%>
                </a>
            </td>
            <td><%=board.getWriter()%></td>
            <td><%=board.getRegtime()%></td>
            <td><%=board.getHits()%></td>
        </tr>
<%
        }
%>
</table>
<br>
 <div class="pageNo">
    <% if (articlePage.hasArticles()) { %>
        <% if (articlePage.getStartPage() > 5) { %>
            <a href="list.jsp?pageNo=<%= articlePage.getStartPage() - 5 %>">이전</a>
        <% } %>
        
        <% for (int i = articlePage.getStartPage(); i <= articlePage.getEndPage(); i++) { %>
            <% if (i == articlePage.getCurrentPage()) { %>
                <strong><%= i %></strong>
            <% } else { %>
                <a href="list.jsp?pageNo=<%= i %>"><%= i %></a>
            <% } %>
        <% } %>
        
        <% if (articlePage.getEndPage() < articlePage.getTotalPages()) { %>
            <a href="list.jsp?pageNo=<%= articlePage.getEndPage() + 5 %>">다음</a>
        <% } %>
    <% } %>
</div>
<div class="button-write">
<input type="button" value="글쓰기" class="btn btn-outline-primary" onclick="location.href='write.jsp'" >
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

  </body>
</html>