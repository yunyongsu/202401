package main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import config.AppCtx;
import config.DbConfig;
import config.DbQueryConfig;
import dbquery.DbQuery;
import spring.Member;
import spring.MemberDao;


public class MainForDao {
	private static Logger logger = LoggerFactory.getLogger(MainForDao.class);
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		MemberDao dao = ctx.getBean(MemberDao.class);		

		Member member2 = new Member("fff@korea.com", "12345", "김다섯", null);
		dao.insert2(member2);
		logger.info("입력되었습니다");
		logger.info("새로 입력 된 회원의 ID :{}", member2.getId());
		
//		Member member3 = new Member("bbb@korea.com", "asd123", "홍길서", null);
//		dao.update(member3);
//		logger.info("수정되었습니다");
		
//		int cnt = dao.count();
//		logger.info("총 인원수 : {}", cnt);
		
		List<Member> list = dao.selectAll();
		logger.info("-----MEMBER 테이블 내용-----");
		for(Member member : list) {
			logger.info(member.toString());
		}
		logger.info("-----MEMBER 테이블 내용 끝 --");
		
//		Member member = dao.selectByEmail("hong@korea.com");
//		if(member != null) {
//			logger.info("아이디:{},이메일:{},패스워드:{},이름:{}, 등록일:{}",
//					member.getId(),member.getEmail(),member.getPassword(), member.getName(), member.getRegisterDateTime());
//		}
		
		ctx.close();
	}
}
