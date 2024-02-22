<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-image: url(img/main.jpg);
	background-size: cover; /* 화면에 꽉 차도록 배경 이미지 크기 조절 */
}

header {
	padding: 20px;
	text-align: center;
	height: 500px;

}

header a {
	text-decoration: none;
	margin-left: 10px;
}

nav {
	float: left;
	width: 20%;
	margin-top: 20px;
	margin-left: 100px;
	padding: 10px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

nav h2 {
	margin-top: 0;
}

nav ul {
	list-style-type: none;
	padding: 0;
}

nav ul li {
	margin-bottom: 10px;
}

nav ul li a {
	text-decoration: none;
	color: #007bff;
}

nav ul li a:hover {
	color: #0056b3;
}

.container {
	display: flex;
}

.content {
	width: 40%;
	margin-right: 20px;
	margin-left: 20px;
	padding: 20px;
	background-color: rgba(255, 255, 255, 0.8); /* 내용 영역 배경색 */
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

@media screen and (max-width: 768px) {
	.container {
		flex-direction: column;
	}
	.content {
		width: 100%;
		margin: 0;
		margin-bottom: 20px;
	}
	nav {
		float: none;
		width: 100%;
	}
}

header a {
	position: relative;
	float: right;
	bottom: 100px;
}
</style>
</head>
<body>
	<%
	// 쿠키 배열 가져오기
	Cookie[] cookies = request.getCookies();

	// 로그인 상태를 확인하고, 쿠키에 로그인 정보가 있는지 확인합니다.
	boolean loggedIn = false;
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if ("loggedIn".equals(cookie.getName()) && "true".equals(cookie.getValue())) {
		loggedIn = true;
		break;
			}
		}
	}

	// 로그인 상태에 따라 로그인 버튼 또는 로그아웃 버튼을 표시합니다.
	if (loggedIn) {
		// 로그인한 경우: 로그아웃 버튼 표시
	%>
	<header>
		<h1>홈페이지</h1>
		<a href="logoutPS.jsp">로그아웃</a>
	</header>
	<%
	} else {
	// 로그인하지 않은 경우: 로그인 버튼 표시
	%>
	<header>
		<h1>홈페이지</h1>
		<a href="signForm.jsp">회원가입</a> <a href="loginCK.jsp">로그인</a>
	</header>
	<%
	}
	%>

	<div class="container">
		<nav>
			<h2>게시판</h2>
			<ul>
				<li><a href="board/">게시판 1</a></li>
				<li><a href="board/">게시판 2</a></li>
				<li><a href="board/">게시판 3</a></li>
			</ul>
			<h2>학생 관리 프로그램</h2>
			<ul>
				<li><a href="student/">학생 목록</a></li>
				<li><a href="student/add/">학생 추가</a></li>
				<li><a href="student/edit/">학생 편집</a></li>
			</ul>
		</nav>
		<div class="content">
			<!-- 본문 내용 -->
		</div>

	</div>

</body>
</html>