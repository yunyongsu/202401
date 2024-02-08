<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
 <style>
    body {
  font-family: Arial, sans-serif;
  background-color: #f5f5f5;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-container {
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  padding: 20px;
  width: 300px;
  text-align: center;
  margin-bottom: 200px;
}

.login-title {
  font-size: 24px;
  margin-bottom: 40px;
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
</style>
</head>
<body>
 <div class="login-container">
        <h2 class="login-title">Login</h2>
<%
    String userId = null;

    Cookie[] cookies = request.getCookies();           
    if (cookies != null) {
        for(Cookie cookie : cookies) {           
            if (cookie.getName().equals("userId")) { // userId 쿠키의 값을
                userId = cookie.getValue();          // 변수 userId에 넣음
                break;
            }
        }
    }
    
    if (userId != null) {          // 로그인 상태일 때의 출력 
%>
        <form action="logoutPS.jsp" method="post"> <!--8-3.jsp:로그아웃 처리--> 
            <%=userId%>님 로그인된 상태
            <input type="submit" value="로그아웃"> 
        </form>
<%  
    } else {                       // 로그인되지 않은 상태일 때의 출력
%>
        <form action="loginPS.jsp" method="post"> <!--8-2.jsp:로그인 처리-->
            <input type="text" class="input-field" name="id" placeholder="아이디" maxlength="10" required><br>
            <input type="password" class="input-field" name="pw" placeholder="비밀번호" maxlength="10" required><br>
            <button type="submit" class="login-btn">로그인</button>
			<a href="signForm.jsp">회원가입</a>
        </form>
        
<%
    }
%>
<% if ("true".equals(request.getParameter("success"))) { %>
        <script>
            alert("회원가입이 성공적으로 완료되었습니다!");
        </script>
    <% } %>

</body>
</html>