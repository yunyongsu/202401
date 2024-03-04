package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Board;

public class BoardDao {
	private static Connection conn;
	private static BoardDao dao = new BoardDao();

	private BoardDao() {
		getConnection();
	}

	public static BoardDao getInstance() {
		return dao;
	}

	private static void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn = DriverManager.getConnection(
		                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
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

	
	public ArrayList<Board> select(int startRow, int size) {
	    ArrayList<Board> list = new ArrayList<Board>();
	    String sql = "SELECT * FROM (SELECT ROWNUM AS rnum, B.* FROM (SELECT * FROM board ORDER BY num DESC) B) WHERE rnum BETWEEN ? AND ?";
	    PreparedStatement pstmt;
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, startRow + 1); // 첫 번째 행이 1부터 시작하기 때문에 startRow에 1을 더해줍니다.
	        pstmt.setInt(2, startRow + size); // startRow부터 size만큼의 행을 가져오기 위해 startRow + size를 설정합니다.
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            Board board = new Board(rs.getInt("num"), rs.getString("Writer"), rs.getString("title"),
	                    rs.getString("content"), rs.getString("regtime"), rs.getInt("hits"));
	            list.add(board);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	public int selectCount() {
		String sql = "select count(*) from board";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
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
		PreparedStatement pstmt;
		String sql = "delete from board where num= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		}
		return 0;
	}

	public int insert(Board board) {
		try {
			PreparedStatement pstmt;
			String sql = String
					.format("insert into board (num, writer, title, content, regtime, hits)" + 
			"values (board_seq.nextval,?,?,?,sysdate,0)"); 

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int update(Board board) {
		 String sql = "update board set writer=?, title=?, content=?, regtime=sysdate where num=?";
		    try ( 
		        PreparedStatement pstmt = conn.prepareStatement(sql);            
		    ) {

		        
		        // 쿼리 실행
		    	pstmt.setString(1, board.getWriter());
		    	pstmt.setString(2, board.getTitle());
		    	pstmt.setString(3, board.getContent());
		    	pstmt.setInt(4, board.getNum());
		        return pstmt.executeUpdate();
		    
		    } catch(Exception e) {
		        e.printStackTrace();
		    } 
			return 0;
		}
	public List<Board> searchName(String name, int startRow, int pageSize) {
	    List<Board> searchResult = new ArrayList<>();
	    String sql = "SELECT * FROM (SELECT ROWNUM AS rnum, B.* FROM (SELECT * FROM board WHERE writer LIKE ? ORDER BY num DESC) B) WHERE rnum BETWEEN ? AND ?";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, "%" + name + "%");
	        pstmt.setInt(2, startRow + 1);
	        pstmt.setInt(3, startRow + pageSize);
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            Board board = new Board(rs.getInt("num"), rs.getString("Writer"), rs.getString("title"),
	                    rs.getString("content"), rs.getString("regtime"), rs.getInt("hits"));
	            searchResult.add(board);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return searchResult;
	}
	public int searchCount(String searchName) {
	    int count = 0;
	    String sql = "SELECT COUNT(*) FROM board WHERE writer LIKE ?";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, "%" + searchName + "%");
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}


}
