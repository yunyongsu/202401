package test;

import dao.MemberDao;
import dto.Member;

public class MemberDaoEx {

	public static void main(String[] args) {
		MemberDao dao = MemberDao.getInstance();
		Member member = dao.select("admin");
		System.out.println(member);
		
		Member member2 = dao.selectForLogin("admin", "admin@korea.com");
		System.out.println(member2);
		
//		Member member3 = new Member("test", "test@korea.com", "테스트");
//		dao.insert(member3);
		
		Member member4 = new Member("test", "test@korea.com", "테스트2");
		dao.update(member4);

	}

}
