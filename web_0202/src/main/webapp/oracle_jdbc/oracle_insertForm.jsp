<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = oracle_insert.jsp>
번호<input type="text" name="num"/><br/>
이름<input type="text" name="name"/><br/>
국어<input type="text" name="kor" /><br/>
수학<input type="text" name="eng"/><br/>
영어<input type="text" name="math"/><br/>
<input type="submit" value="전송" />
<input type="reset"/> <br/>
<a href="oracle_insert.jsp"> 돌아가기 </a>
</form>
</body>
</html>