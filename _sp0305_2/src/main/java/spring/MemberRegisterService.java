package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	/*MemberDao memberDao = new MemberDao(); 처럼 객체 생성을 하지않고 
	  아래와 같이 생성자를 통해 생성*/
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//생성자를 통해 생성 된 memberDao 사용
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateMemberException("dup email" + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
	
}
