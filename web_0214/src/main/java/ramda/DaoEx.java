package ramda;

import java.util.List;

import dao.BoardDao;
import dto.Board;

public class DaoEx {

	public static void main(String[] args) {
		BoardDao dao = BoardDao.getInstance();
		List<Board> list = dao.selectList();
		
		//람다식
		list.stream().forEach(s->{
			System.out.println(s);
		});
		
		for(Board board : list) {
			System.out.println(board);
		}
	}

}
