<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
div {
	width: 800px;
	height: 500px;
	margin: 0 auto;
	padding-top: 30px;
	border-width: 1px;
	border-style: solid;
	border-color: green;
}

body {
	padding-top: 100px;
	font-family: Arial, sans-serif;
	text-align: center;
}

table {
	width: 700px;
	text-align: center;
	margin: 20px auto;
	border-collapse: collapse;
}

th {
	background-color:;
}

td, th {
	padding: 10px;
}

.bt2{
	padding: 10px;
	background-color: #4caf50;
	color: white;
	border: none;
	display: block;
	margin: auto;
}

h1 {
	display: inline-block;
}

form {
	text-align: right;

}

.bt1 {
background-color: #fff;
margin:auto;
margin-bottom: 20px;
}
.bt1:hover {
            background-color: #756d6d;
            border: 2px solid #756d6d;
</style>
</head>
<body>
	<div class="center">
		
		<h1>
			<strong> 학생 성적 관리 프로그램 </strong>
		</h1>
		<form>
			<label for="searchName">이름 검색: </label> <input type="text"
				id="searchName" name="searchName">
			<button type="submit" class ="bt1">검색</button>
		</form>
		<table border="1px">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
			</tr>
			<%
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");) {

				String searchName = request.getParameter("searchName");
				String sql;

				if (searchName != null && !searchName.isEmpty()) {
					// 이름 검색 쿼리
					sql = "SELECT * FROM score WHERE name LIKE ?";
				} else {
					// 전체 학생 목록 쿼리
					sql = "SELECT * FROM score";
				}
				PreparedStatement pstmt = conn.prepareStatement(sql);

				if (searchName != null && !searchName.isEmpty()) {
					pstmt.setString(1, "%" + searchName + "%");
				}

				ResultSet rs = pstmt.executeQuery();
				int totalSum = 0; // 전체 총점
				int rowCount = 0; // 행의 수 (학생 수)
				while (rs.next()) {
					int sum = rs.getInt("kor") + rs.getInt("eng") + rs.getInt("math");
					totalSum += sum;
					rowCount++;
			%>
			<tr>
				<td><%=rs.getInt("num")%></td>
				<td><a
					href="oracle_updateForm.jsp?name=<%=rs.getString("name")%>"><%=rs.getString("name")%></a></td>
				<td><%=rs.getInt("kor")%></td>
				<td><%=rs.getInt("eng")%></td>
				<td><%=rs.getInt("math")%></td>
				<td><%=sum%></td>
				<td><%=String.format("%.2f", (float) sum / 3)%></td>
				<td><a href="oracle_delete.jsp?num=<%=rs.getString("num")%>">
						삭제 </a></td>
			</tr>
			<%
			}
			if (rowCount > 0) {
			// 전체 평균 계산
			double totalAverage = (double) totalSum / (rowCount * 3);
			%>
			<tr>

				<td colspan="5"></td>
				<td><%=totalSum%></td>
				<td><%=String.format("%.2f", totalAverage)%></td>
				<td></td>
			</tr>

			<%
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			%>
		</table>
		<button onclick="location.href='oracle_insertForm.jsp'" class="bt2">학생 등록</button>
		
	</div>
</body>
</html>