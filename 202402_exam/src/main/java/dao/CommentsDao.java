package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Comments;

public class CommentsDao {
	private static Connection conn;
	private static CommentsDao dao = new CommentsDao();

	private CommentsDao() {
		getConnection();
	}

	public static CommentsDao getInstance() {
		return dao;
	}

	private static void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// 댓글 추가 메서드
	public int addComment(Comments comments) {
		try {
			String sql = "INSERT INTO comments (comment_num, board_num, writer, content, regtime) VALUES "
					+ "(comment_seq.nextval, ?, ?, ?, sysdate)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comments.getBoardNum());
			pstmt.setString(2, comments.getWriter());
			pstmt.setString(3, comments.getContent());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// 특정 글의 댓글 목록을 가져오는 메서드
	public List<Comments> CommentsBoard(int boardNum) {
	        List<Comments> list = new ArrayList<Comments>();
	        String sql = "SELECT * FROM comments WHERE board_num = ?";
	        try (
	        	PreparedStatement pstmt = conn.prepareStatement(sql);
	        	ResultSet rs = pstmt.executeQuery();) {
	            pstmt.setInt(1, boardNum);
	                while (rs.next()) {
	                    Comments comment = new Comments(rs.getInt("comment_num"),rs.getInt("board_num"),rs.getString("writer"),
	                    		rs.getString("content"),rs.getString("regtime"));
	                    list.add(comment);
	                }
	            } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        return list;
	    }
}
