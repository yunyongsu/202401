package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Emp {
	private int empno;
	private String ename;
	private String job;
	private double sal;
	public Emp(int empno, String ename, String job, double sale) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sale;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sale) {
		this.sal = sale;
	}

}

public class JdbcArrayEx2 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/firm";
		String id = "root";
		String pass = "mysql";
		Statement stmt = null;
		Connection conn = null;
		List<Emp> list = new ArrayList<>();

		String sql = "select empno, ename, job, sal from emp";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 없어도 되는 코드
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				double sale = rs.getDouble("sal"); 
				Emp emp = new Emp(empno, ename, job, sale);
				list.add(emp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			for(Emp emp : list) {
//				System.out.println(emp.getEmpno() + "," + emp.getEname() + "," + emp.getJob() + "," + emp.getSal());
				System.out.printf("%d , %s, %s, %.2f\n",emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getSal());
			}
	}

}
