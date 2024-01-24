package sec02.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TryCatchEx {
	
	// try = 한번 실행해보고 catch = 예외 시 처리
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) { //예외가 뭔지 모르겠다면 Exception 사용, e는 변수명
			System.out.println("클래스가 존재하지 않음");
//			e.printStackTrace(); //어떤 오류인지 출력해주는
		}finally {
			System.out.println("반드시 실행하는 부분"); //예외가 있어도 실행 하는 부분
		}
		try {
			Connection conn = DriverManager.getConnection(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
