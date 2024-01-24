package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/firm";
		String id = "root";
		String pass = "mysql";
		Connection conn = DriverManager.getConnection(url, id, pass);
		
		Statement stmt = conn.createStatement();
		/*createStatement() 메서드를 호출하여 Statement 객체를 생성합니다. 
		Statement 객체는 SQL 문을 실행하기 위한 역할을 함 */
		
		String sql = "select * from emp";
		//select 쿼리문 sql 변수에 저장
		
		ResultSet rs = stmt.executeQuery(sql);	
		/*executeQuery 메서드를 사용하여 sql 쿼리를 실행
		  실행 결과인 ResultSet 객체가 반환되어 rs 변수에 저장. 
		  ResultSet은 쿼리 실행 결과를 나타내는 객체 */
		
		while(rs.next()) {	//next = '첫 레코드'부터 순차적으로
			System.out.print(rs.getInt("empno") + "\t");
			System.out.print(rs.getString("ename")+ "\t");
			System.out.println(rs.getDouble("sal"));
		}

	}

}
