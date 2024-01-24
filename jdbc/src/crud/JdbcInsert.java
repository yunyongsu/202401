package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/firm";
		String id = "root";
		String pass = "mysql";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("부서 번호: ");
		int deptno = Integer.parseInt(scan.nextLine());
		System.out.println("부서 이름: ");
		String dname = scan.nextLine();
		System.out.println("부서 위치: ");
		String loc = scan.nextLine();
		
		Connection conn = DriverManager.getConnection(url, id, pass);
		Statement stmt = conn.createStatement();
		
		String sql = "insert into dept(deptno, dname, loc) values ("+deptno+", '"+dname+"', '"+loc+"')";
		int result = stmt.executeUpdate(sql);
		if(result == 1) {
			System.out.println("입력성공");
		} else {
			System.out.println("입력실패");
		}
		
	}

}
