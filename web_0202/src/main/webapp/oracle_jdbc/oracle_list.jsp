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
            margin-top: 20px;
        }
        
        .container {
            margin: 0 auto;
            width: 80%;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        
        th, td {
            padding: 10px;
            border: 1px solid #000;
        }
        
        th {
            background-color: green;
            color: #fff;
        }
        
        h1 {
            margin-bottom: 20px;
        }
        
        form {
            text-align: right;
        }
        
        input[type="text"] {
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        
        .btn {
            padding: 5px 10px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        
        .btn:hover {
            background-color: #45a049;
        }
        
        .pagination {
            margin-top: 20px;
            display: flex;
            justify-content: center;
        }
        
        .pagination a {
            margin: 0 5px;
            padding: 5px 10px;
            background-color: #ddd;
            border: 1px solid #888;
            border-radius: 5px;
            text-decoration: none;
            color: #000;
        }
        
        .pagination a:hover {
            background-color: #ccc;
        }
        
        .add-btn {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
       
        <h1>
            <strong> 학생 성적 관리 프로그램 </strong>
        </h1>
        <form>
            <label for="searchName">이름 검색: </label> 
            <input type="text" id="searchName" name="searchName">
            <button type="submit" class="btn">검색</button>
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
        <div class="pagination">
            <a href="<%=request.getRequestURI()%>?page=<%=prevPage%>&searchName=<%=searchName%>">이전</a>
            <%-- 현재 페이지 번호 표시 --%>
            <%=currentPage%>
            <a href="<%=request.getRequestURI()%>?page=<%=nextPage%>&searchName=<%=searchName%>">다음</a>
        </div>
        
        <button onclick="location.href='oracle_insertForm.jsp'" class="btn add-btn">학생 등록</button>
        
    </div>
</body>
</html>