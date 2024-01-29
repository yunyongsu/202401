package sec01.exam01;

public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
//		if(obj instanceof Member) {	//매개값이 member 타입인지 확인
			Member member = (Member)obj;	//member 타입으로 강제 변환하고
			if(id.equals(member.id)) {		//id 필드값이 동일한지 검사
//			if(id.equalsIgnoreCase(member.id))	//대소문자를 무시하고 비교
				return true;
			}
//		}
		return false;
	}
	

	@Override
	public String toString() {
		return "member 객체[" + id + "]";
	}

	@Override
	public int hashCode() {

		return id.hashCode();
	}
	
	
	

}
