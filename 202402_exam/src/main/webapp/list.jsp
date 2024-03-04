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

String userName = (String)session.getAttribute("userName");
BoardDao dao = BoardDao.getInstance();
//이름 검색
String searchName = request.getParameter("searchName"); // 검색어 가져오기

int currentPage = 1; //현재페이지 1로 설정
String pageNoVal = request.getParameter("pageNo");

//pageNo값이 존재할 때 현재페이지에 할당
if (pageNoVal != null) {
    currentPage = Integer.parseInt(pageNoVal);
}


int pageSize = 5; //한 페이지에 표시 할 게시글 수 5개로 설정

//현재 페이지에서 시작해야 하는 게시물의 인덱스를 계산(0부터 시작)
//ex)만약 현재페이지가 4라면 4-1 * 5 = 15 즉 16번째 게시글부터 출력
int startRow = (currentPage - 1) * pageSize;
List<Board> list;
int totalResults = 0; // 검색 결과의 총 개수

//이름 검색 시
if (searchName != null && !searchName.isEmpty()) {
    // 이름 검색 결과 가져오기
    list = dao.searchName(searchName, startRow, pageSize);
    // 검색 결과의 총 개수 가져오기
    totalResults = dao.searchCount(searchName);
    
//검색창이 비어있을 시
} else {
    // 전체 목록 가져오기
    list = dao.select(startRow, pageSize);
    // 전체 게시글 수 가져오기
    totalResults = dao.selectCount();
}

// ArticlePage 객체 생성하여 페이지 정보를 저장
ArticlePage articlePage = new ArticlePage(totalResults, currentPage, pageSize, list);
// articlePage를 request 속성으로 설정
request.setAttribute("articlePage", articlePage);
request.setAttribute("searchName", searchName);
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
                <li><p><%=userName%>님</p></li>
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
        <% if (articlePage.getStartPage() > 1) { %>
             <a href="list.jsp?pageNo=<%= currentPage - 1 %>&searchName=<%= (searchName != null) ? searchName : "" %>">이전</a>
        <% } %>
        
        <% for (int i = articlePage.getStartPage(); i <= articlePage.getEndPage(); i++) { %>
            <% if (i == currentPage) { %>
                <strong><%= i %></strong>
            <% } else { %>
                 <a href="list.jsp?pageNo=<%= i %>&searchName=<%= (searchName != null) ? searchName : "" %>"><%= i %></a>
            <% } %>
        <% } %>
        
        <% if (articlePage.getEndPage() < articlePage.getTotalPages()) { %>
           <a href="list.jsp?pageNo=<%= currentPage + 1 %>&searchName=<%= (searchName != null) ? searchName : "" %>">다음</a>
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