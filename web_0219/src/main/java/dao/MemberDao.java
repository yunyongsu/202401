package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Board;
import dto.Member;

public class MemberDao {
	private static Connection conn;
	private static MemberDao dao = new MemberDao();

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		getConnection();
		return dao;
	}

	private static void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "mysql");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Member selectForLogin(String id, String email) {
		Member member = null;
		String sql = "SELECT * FROM member WHERE id = ? and email = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getString("id"), rs.getString("email"), rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	public Member select(String id) {
		Member member = null;
		String sql = "SELECT * FROM member WHERE id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getString("id"), rs.getString("email"), rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	
	public int insert(Member member) {
		try {
			PreparedStatement pstmt;
			String sql = "insert into member (id, email, name) values (?,?,?)"; 

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getName());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	
	public int update(Member member) {
		try {
			PreparedStatement pstmt;
			String sql = "update member set email = ?, name = ? where id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getId());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
}
