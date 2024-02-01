package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Emp {
	// DB의 기본적인 정보 입력
	private static final String DB_URL = "jdbc:mysql://localhost:3306/firm";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "mysql";

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// DB와 연결
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			// while문의 반복을 위한 boolean
			boolean exit = false;
			// exit가 true일 때, 사용자의 선택에 따라 반복 실행
			while (!exit) {
				System.out.println("-----------------------------------------------------");
				System.out.println("1.데이터 보기 | 2.데이터 삽입 | 3.데이터 수정 | 4.데이터 삭제 | 5.종료");
				System.out.println("-----------------------------------------------------");
				System.out.print("선택> ");
				String choice = scan.nextLine();

				switch (choice) {
				case "1":
					viewData(connection);
					break;
				case "2":
					insertData(connection);
					break;
				case "3":
					update(connection);
					break;
				case "4":
					deleteData(connection);
					break;
				case "5":
					System.out.println("시스템 종료");
					exit = true;
					break;
				default:
					System.out.println("다시 시도하세요.");
					break;
				}
			}
		} catch (SQLException e) { // 예외 발생 시
			e.printStackTrace(); // 어떤 예외가 발생했는지 알려줌
		}
	}

	// 데이터 보기 메서드
	private static void viewData(Connection connection) {
		String sql = "select * from emp"; // emp의 모든 정보를 보겠다는 쿼리문.

		// statement와 ResultSet의 예외처리를 위해 try/catch문 사용
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getString("hiredate") + "\t");
				System.out.print(rs.getString("sal") + "\t");
				System.out.print(rs.getInt("comm") + "\t");
				System.out.println(rs.getString("deptno"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 데이터 삽입 메서드
	private static void insertData(Connection connection) {

		// 사원의 정보를 입력하고 입력 한 변수들을 쿼리문으로 DB에 저장
		try {
			System.out.print("사원 번호: ");
			int empno = Integer.parseInt(scan.nextLine());
			System.out.print("사원 이름: ");
			String ename = scan.nextLine();
			System.out.print("부서 직책: ");
			String job = scan.nextLine();
			System.out.print("사수 번호 : ");
			int mgr = Integer.parseInt(scan.nextLine());
			System.out.print("입사일: ");
			String hiredate = scan.nextLine();
			System.out.print("월급: ");
			double sal = Double.parseDouble(scan.nextLine());
			System.out.print("인센티브: ");
			double comm = Double.parseDouble(scan.nextLine());
			System.out.print("부서 번호: ");
			int deptno = Integer.parseInt(scan.nextLine());
			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setDouble(6, sal);
			pstmt.setDouble(7, comm);
			pstmt.setInt(8, deptno);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("데이터가 성공적으로 추가되었습니다.");
			} else {
				System.out.println("추가에 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 데이터 수정 메서드
	private static void update(Connection connection) {

		// 사원번호에 해당하는 인원의 나머지 정보를 수정
		try {
			System.out.print("수정할 사원 번호를 입력하세요: ");
			int empno = Integer.parseInt(scan.nextLine());
			System.out.print("새로운 부서 직책: ");
			String job = scan.nextLine();
			System.out.print("새로운 사수 번호: ");
			int mgr = Integer.parseInt(scan.nextLine());
			System.out.print("새로운 월급: ");
			double sal = Double.parseDouble(scan.nextLine());
			System.out.print("인센티브: ");
			double comm = Double.parseDouble(scan.nextLine());
			System.out.print("부서 번호: ");
			int deptno = Integer.parseInt(scan.nextLine());

			String sql = "UPDATE emp SET job = ?, mgr = ?, sal = ?, comm = ?, deptno = ? WHERE empno = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, job);
			pstmt.setInt(2, mgr);
			pstmt.setDouble(3, sal);
			pstmt.setDouble(4, comm);
			pstmt.setInt(5, deptno);
			pstmt.setInt(6, empno);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("데이터가 성공적으로 수정되었습니다.");
			}else {
				System.out.println("수정에 실패했습니다.");
				System.out.println("해당하는 사원 번호가 존재하지 않거나 입력 형식에 맞춰주세요.");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터 삭제 메서드
	private static void deleteData(Connection connection) {

		// 수정과 같이 사원번호를 통해 나머지 모든 정보를 삭제
		try {
			Statement stmt = connection.createStatement();
			System.out.print("삭제 할 사원 번호: ");
			int empno = Integer.parseInt(scan.nextLine());

			String sql = "delete from emp where empno = " + empno;
			int result = stmt.executeUpdate(sql);
			if (result == 1) {
				System.out.println("데이터가 성공적으로 삭제되었습니다.");
			} else {
				System.out.println("삭제에 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}