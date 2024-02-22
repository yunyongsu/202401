<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
        <style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin-top: 200px;
    padding: 0;
    background-color: #f9f9f9;
  }
  .container {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  }
  table{
  	width: 90%;
  }
  input[type="text"]{
    width: calc(100% - 20px);
    padding: 10px;
    margin-bottom: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    transition: border-color 0.3s ease;
  }

  .member-upd {
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 5px;
    background-color: #007bff;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  .member-upd:hover {
    background-color: #0056b3;
  }
  .member-del{
  	width: 100%;
  	color: black;
  	border: none;
  	background-color: white;
  	margin-top: 20px;
  	cursor: pointer;
  }
  .member-del:hover{
  	color: blue;
  }
  .home-btn {
    display: block;
    width: 100px; /* 버튼의 너비 설정 */
    margin: 20px auto; /* 중앙 정렬 */
    cursor: pointer; /* 포인터 형태의 커서 설정 */
        }

</style>
</head>
<body>
<div>
<a href="homePage.jsp">
<img class="home-btn" src="assets/brand/house-door.svg" alt="homeButton" width="72" height="57">
</a>
</div>
<div class="container">
<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");

//Member member = MemberDao.getInstance().select(id);
//String userId = (String)session.getAttribute("userId");

Member member = MemberDao.getInstance().select((String)session.getAttribute("userId"));
%>
        <form action="member_update.jsp" method="post">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="id" readonly
                               value="<%=member.getId()%>"></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" name="email" 
                               value="<%=member.getEmail()%>"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="name" 
                               value="<%=member.getName()%>"></td>
                </tr>
            </table>    
            <input type="submit" class="member-upd" value="저장">       
        </form>  
        <form action="member_delete.jsp" method="post">
        	<input type="hidden" name="id" value="<%= member.getId() %>">
   			<input type="submit"  class="member-del" value="회원탈퇴">
		</form>
    
</body>
</html>