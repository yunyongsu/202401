<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: white;
            text-align: center;
        }
        
        table {
            width: 680px;
            margin: 20px auto;
            border-collapse: collapse;
            text-align: center;
        }
        
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        
        th {
            background-color: #00bcd4;
            color: white;
            font-weight: bold;
        }
        
        .num {
            width: 80px;
        }
        
        .title {
            width: 230px;
            text-align: left;
        }
        
        .writer, .regtime {
            width: 100px;
        }
        
        a:link, a:visited {
            color: #007bff;
            text-decoration: none;
        }
        
        a:hover {
            color: #0056b3;
        }
        
        input[type="button"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        
        input[type="button"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<table>
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th                >조회수  </th>
    </tr>
<%
    // 게시글 리스트 읽어오기
    Class.forName("com.mysql.cj.jdbc.Driver");
    try (
        Connection conn = DriverManager.getConnection(
        		"jdbc:mysql://localhost:3306/project1", "root", "mysql");
        Statement stmt = conn.createStatement();
    
        // 쿼리 실행
        ResultSet rs = stmt.executeQuery(
                "select * from board order by num desc");           
    ) {
        // 게시글 레코드가 남아있는 동안 반복하며 화면에 출력
        while (rs.next()) {
%>         
        <tr>
            <td><%=rs.getInt("num")%></td>
            <td style="text-align:left;">
                <a href="view.jsp?num=<%=rs.getInt("num")%>">
                    <%=rs.getString("title")%>
                </a>
            </td>
            <td><%=rs.getString("writer" )%></td>
            <td><%=rs.getString("regtime")%></td>
            <td><%=rs.getInt   ("hits"   )%></td>
        </tr>
<%
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
%>
</table>

<br>
<input type="button" value="글쓰기" onclick="location.href='write.jsp'">

</body>
</html>
