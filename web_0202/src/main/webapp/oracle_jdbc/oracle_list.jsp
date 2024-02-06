<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	background-color: rgb(211, 199, 199);
	margin-top:20px;
}
div {
	margin: 0 auto;
	
}
table {
	text-align: center;
	border-collapse: collapse;
	width: 100%
}

th {
	background-color: green;
}

td, th {
	padding: 10px;
}

h1 {
	display: inline-block;
}

form {
	text-align: right;
}

.bt1 {
	background-color: #fff;
	margin: auto;
	margin-bottom: 20px;
}

.bt1:hover {
	background-color: #756d6d;
	border: 2px solid #756d6d;
}

.bt2 {
	padding: 10px;
	background-color: #4caf50;
	color: white;
	border: none;
	display: block;
	margin: auto;
	margin-bottom: 30px;
}

.page{
	width: 100px;
	height: 50px;
	margin: 0 auto;
	margin-top : 20px;
	border: none;
	padding: 0;
	}

</style>
</head>
<body>
    <div class="center">
       
        <h1>
            <strong> 학생 성적 관리 프로그램 </strong>
        </h1>
        <form>
            <label for="searchName">이름 검색: </label> 
            <input type="text" id="searchName" name="searchName">
            <button type="submit" class="bt1">검색</button>
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
                <th>삭제</th>
            </tr>
            <%
            Class.forName("oracle.jdbc.driver.OracleDriver");
            PreparedStatement pstmt;
            String searchName = request.getParameter("searchName");
            String sql;
            
            int pageSize = 7; // 한 페이지에 표시할 행의 개수
            int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
            int startRow = (currentPage - 1) * pageSize + 1;
            int endRow = currentPage * pageSize;
            
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");) {
            	
                if (searchName != null && !searchName.isEmpty()) {
                    // 이름 검색 쿼리
                    sql = "SELECT * FROM (SELECT ROWNUM AS rnum, s.* FROM (SELECT * FROM score WHERE name = ?) s WHERE ROWNUM <= ?) WHERE rnum >= ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, searchName);
                    pstmt.setInt(2, endRow);
                    pstmt.setInt(3, startRow);
                } else {
                    // 전체 학생 목록 쿼리
                    sql = "SELECT * FROM (SELECT ROWNUM AS rnum, s.* FROM (SELECT * FROM score) s WHERE ROWNUM <= ?) WHERE rnum >= ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, endRow);
                    pstmt.setInt(2, startRow);
                }

                ResultSet rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    int sum = rs.getInt("kor") + rs.getInt("eng") + rs.getInt("math");
            %>
            <tr>
                <td><%=rs.getInt("num")%></td>
                <td><a href="oracle_updateForm.jsp?num=<%=rs.getInt("num")%>"><%=rs.getString("name")%></a></td>
                <td><%=rs.getInt("kor")%></td>
                <td><%=rs.getInt("eng")%></td>
                <td><%=rs.getInt("math")%></td>
                <td><%=sum%></td>
                <td><%=String.format("%.2f", (float) sum / 3)%></td>
                <td><a href="oracle_delete.jsp?num=<%=rs.getInt("num")%>">삭제</a></td>
            </tr>
            <%
            }
            } catch (Exception e) {
            e.printStackTrace();
            }
            %>
        </table>
        
        <!-- 페이징 링크 -->
        <%
        // 이전 페이지
        int prevPage = (currentPage > 1) ? currentPage - 1 : 1;
        // 다음 페이지
        int nextPage = currentPage + 1;
        %>
        <div class = "page">
            <a href="<%=request.getRequestURI()%>?page=<%=prevPage%>&searchName=<%=searchName%>">이전</a>
            <%-- 현재 페이지 번호 표시 --%>
            <%=currentPage%>
            <a href="<%=request.getRequestURI()%>?page=<%=nextPage%>&searchName=<%=searchName%>">다음</a>
        </div>
        
        <button onclick="location.href='oracle_insertForm.jsp'" class="bt2">학생 등록</button>
        
    </div>
</body>
</html>