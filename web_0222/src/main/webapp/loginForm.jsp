<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

input{
	width:100%;
}
#divid{
	color: red;
}
</style>
</head>
<body>
<form action="login.do" method="post">
<div id="divid">
<lable>아이디</lable><input type="text" name="id">
</div>
<lable>이메일</lable><input type="text" name="email"><br>
<input type="submit" value="로그인">
</form>

</body>
</html>