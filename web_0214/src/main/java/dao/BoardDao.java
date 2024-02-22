package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;

public class BoardDao {
	private static Connection conn;
	private static BoardDao dao = new BoardDao();

	private BoardDao() {
	}

	public static BoardDao getInstance() {
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

	public ArrayList<Board> selectList() {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from board order by num desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board(rs.getInt("num"), rs.getString("Writer"), rs.getString("title"),
						rs.getString("content"), rs.getString("regtime"), rs.getInt("hits"));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public Board selectOne(int num, boolean inc) {
		Board board = null;
		String sql = "SELECT * FROM board WHERE num = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new Board(rs.getInt("num"), rs.getString("Writer"), rs.getString("title"),
						rs.getString("content"), rs.getString("regtime"), rs.getInt("hits"));
			}
			if (inc) {
				pstmt.executeUpdate("update board set hits=hits+1 where num =" + num);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

	public int delete(int num) {

		String sql = "delete from board where num= ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

		} catch (SQLException e) {
		}
		return 0;
	}

	public int insert(Board board) {
		try {
			PreparedStatement pstmt;
			String sql = String.format("insert into board " + "(writer, title, content, regtime, hits)"
										+ "values (?,?,?,?,0)");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getRegtime());
			pstmt.setInt(5, board.getHits());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int update(Board board) {

		return 0;
	}
}
