<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 200px;
    padding: 0;
    background-color: #f9f9f9;
  }
  .container {
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
  input[type="text"],
  input[type="password"],
  input[type="email"] {
    width: calc(100% - 20px);
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    transition: border-color 0.3s ease;
  }
  input[type="text"]:focus,
  input[type="password"]:focus,
  input[type="email"]:focus {
    border-color: #007bff;
  }
  input[type="submit"] {
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 5px;
    background-color: #007bff;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  input[type="submit"]:hover {
    background-color: #0056b3;
  }
  .message {
    text-align: center;
    color: #555;
  }
  .message a {
    color: #007bff;
    text-decoration: none;
  }
  .message a:hover {
    text-decoration: underline;
  }
</style>
</head>
<body>
 <div class="container">
        <h2>회원가입</h2>
        <form action="/loginCk.jsp">
          <input type="text" name="id" placeholder="아이디" required>
          <input type="password" name="pw" placeholder="비밀번호" required>
          <input type="submit" value="가입하기">
        </form>
        <div class="message">
          이미 계정이 있으신가요? <a href="/loginCK.jsp">로그인</a>
        </div>
      </div>
</body>
</html>