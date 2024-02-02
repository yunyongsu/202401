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
            margin: 20px;
        }

        table {
            width: 70%;
            border-collapse: collapse;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
        }

        th {
            background-color: cyan;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        button {
            padding: 10px;
            background-color: #4caf50;
            color: white;
            border: none;
            cursor: pointer;
            display: block;
            margin: auto; 
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <table>
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
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");) {
            String sql = "select * from score";
            PreparedStatement pstmt = conn.prepareStatement(sql);
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
            <td><a href="oracle_updateForm.jsp?name=<%=rs.getString("name")%>"><%=rs.getString("name")%></a></td>
            <td><%=rs.getInt("kor")%></td>
            <td><%=rs.getInt("eng")%></td>
            <td><%=rs.getInt("math")%></td>
            <td><%=sum%></td>
            <td><%=String.format("%.2f", (float) sum / 3)%></td>
            <td><a href="oracle_delete.jsp?num=<%=rs.getString("num")%>">삭제</a></td>
        </tr>
        <%
        }
              if (rowCount > 0) {
                    // 전체 평균 계산
                    double totalAverage = (double) totalSum / (rowCount * 3);
             
           %>
        <tr>
            <td colspan="5" style="text-align: right; font-weight: bold;">전체 총점</td>
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
    <button onclick="location.href='oracle_insertForm.jsp'">학생 등록</button>
</body>
</html>