<%@page import="java.net.URLDecoder"%>
<%@page import="util.Cookies"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookies cookies = new Cookies(request);
	
%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin-top: 200px;
    padding: 0;
    background-color: #f9f9f9;
  }
.login-container {
    max-width: 400px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}
  h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
  }

.login-title {
    font-size: 24px;
    margin-bottom: 20px;
    color: #333;
}

.input-field {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

.login-btn {
	width:100%;
    background-color: #007bff;
    border: none;
    color: #fff;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.login-btn:hover {
    background-color: #0056b3;
}

.signup-link {
	text-align:center;
    display: block;
    margin-top: 15px;
    color: #007bff;
    text-decoration: none;
}

.signup-link:hover {
    text-decoration: underline;
}
.home-btn {
    display: block;
    width: 100px; /* 버튼의 너비 설정 */
    margin: 20px auto; /* 중앙 정렬 */
    cursor: pointer; /* 포인터 형태의 커서 설정 */
        }
    .check{
    margin-bottom: 20px;
    }
</style>
</head>
<body>
<div>
<a href="homePage.jsp">
<img class="home-btn" src="assets/brand/house-door.svg" alt="homeButton" width="72" height="57">
</a>
</div>
<div class="login-container">
    <h2 class="로그인">Login</h2>
<%
    if ((String)session.getAttribute("userId") != null) {  
    //Member member = (Member)session.getAttribute("member");
    //if(member != null){
        // 로그인 상태일 때의 출력 
      response.sendRedirect("homePage.jsp"); 
%>

<%  
    } else {                       
        // 로그인되지 않은 상태일 때의 출력
%>

        <form action="login.jsp" method="post">
        <%	if(cookies.exists("id")){ %>
            <input type="text" class="input-field" name="id" placeholder="아이디" value="<%=cookies.getValue("id")%>"><br>
            <input type="text" class="input-field" name="pw" placeholder="비밀번호" ><br>
            <%} else{ %>
            <input type="text" class="input-field" name="id" placeholder="아이디"><br>
            <input type="text" class="input-field" name="pw" placeholder="비밀번호" ><br>
            <%} %>
            <div class="check">
            아이디 저장<input type="checkbox" name="remember" checked>
            </div>
            <button type="submit" class="login-btn">로그인</button>
            <a href="member_join_form.jsp" class="signup-link">회원가입</a>
        </form>
        
               <% } %>
    <% if ("true".equals(request.getParameter("success"))) { %>
    <script>
        alert("회원가입이 성공적으로 완료되었습니다!");
    </script>
     <% } %>
</div>
</body>
</html>
