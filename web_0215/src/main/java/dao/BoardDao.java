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
					.format("insert into board (writer, title, content, regtime, hits)" + "values (?,?,?,now(),0)"); 

			// 현재 시간 얻기
//			 String curTime = LocalDate.now() + " " + 
//                     LocalTime.now().toString().substring(0, 8);

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
		 String sql = "update board set writer=?, title=?, content=?, regtime=now() where num=?";
		    try ( 
		        PreparedStatement pstmt = conn.prepareStatement(sql);            
		    ) {
		        // 현재 시간 얻기
//		        String curTime = LocalDate.now() + " " + 
//		                         LocalTime.now().toString().substring(0, 8);
		        
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
	public boolean login(Board board ) {
		
		boolean login = false;
		String sql = "SELECT count(*) from board where num = ? and writer = ?";
		
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setInt(1, board.getNum());
				pstmt.setString(2, board.getWriter());
				
				try(ResultSet rs = pstmt.executeQuery()) {
					rs.next();
					if (rs.getInt(1) == 1) {  // 로그인 성공 조건
						login = true;
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return login;
	}
}
