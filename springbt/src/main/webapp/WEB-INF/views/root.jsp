<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>top page</title>
	<meta http-equiv="Content-Type" 
		content="text/html; charset=UTF-8" />
	<style>
	h1 { font-size:18pt; font-weight:bold; color:gray; }
	body { font-size:13pt; color:gray; margin:5px 25px; }
	tr { margin:5px; }
	th { padding:5px; color:white; background:darkgray; }
	td { padding:5px; color:black; background:#e0e0ff; }
	.err { color:red; }
	</style>
</head>
<body>
	<table>
	<form method="post" action="/insert">
		<tr><td><label for="name">이름</label></td>
			<td><input type="text" name="name" /></td></tr>
		<tr><td><label for="age">연령</label></td>
			<td><input type="text" name="age" /></td></tr>
		<tr><td><label for="mail">메일</label></td>
			<td><input type="text" name="email"  /></td></tr>
		<tr><td><label for="memo">메모</label></td>
			<td><textarea name="memo" cols="20" rows="5" ></textarea></td></tr>
		<tr><td></td><td><input type="submit" /></td></tr>
	</form>
	</table>
	<hr/>
	<table>
	<tr>
		<th>ID</th>
		<th>이름</th>
		<th>연령</th>
		<th>메일</th>
		<th>메모</th>
		<th>   </th>
		<th>   </th>
        <c:forEach items="${members}" var="member">
            <tr>
                <td>${member.id}</td>
                <td>${member.name}</td>
                <td>${member.age}</td>
                <td>${member.email}</td>
                <td>${member.memo}</td>
                <td>
                 <form method="post" action="/delete">
                    <input type="hidden" name="id" value="${member.id}" />
                    <input type="submit" value="삭제" />
                 </form>
                </td>
                <td>
                 <form method="post" action="update_Form">
                 	<input type="hidden" name="id" value="${member.id}" />
                 	<input type="submit" value="수정" />
                 </form>
                </td>
            </tr>
        </c:forEach>
	</table>
</body>
</html>