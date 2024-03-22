package practice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	private static Logger LOGGER = LoggerFactory.getLogger(Main.class); 
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class, DbQueryConfig.class);
		
		MemberDao dbQuery = ctx.getBean(MemberDao.class);
//		int count = dbQuery.count();
//		LOGGER.info("인원 {}명", count);
//		
//		String MemberName = dbQuery.MemberName(1);
//		LOGGER.info("1번 이름: {}", MemberName);
		
//		Member member = new Member("Yong", "yong@naver.com", "용");
//		dbQuery.insert(member);
		
//		Member member1 = new Member(3, "yun@naver.com","윤");
//		dbQuery.update(member1);
		
//		dbQuery.delete(4);
		
		List<Member> memberList = dbQuery.selectAll();
		for (Member member : memberList) {
			
			LOGGER.info("{},{},{},{}", member.getMemberno(),member.getId(),member.getPw(), member.getName() );
//            System.out.println("회원번호: " + member.getMemberno());
//            System.out.println("ID: " + member.getId());
//            System.out.println("이름: " + member.getName());
//            System.out.println();
        }
		
	}
		

}
