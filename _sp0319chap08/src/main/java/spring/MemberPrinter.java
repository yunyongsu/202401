package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	public void print(Member member) {
		System.out.println("member 객체: " + dateTimeFormatter);
		if (dateTimeFormatter == null) {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
					member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", 
					member.getId(), member.getEmail(),
					member.getName(), 
					dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	/* bean객체가 없을때 Autowired를 사용하면 나오는 nullPointerException 에러를 막기 위해 사용 */
	
//	@Autowired(required = false)
//	@Autowired
//	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	}

	@Autowired
	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
		if(formatterOpt.isPresent()) {
			this.dateTimeFormatter = formatterOpt.get();
		} else {
			this.dateTimeFormatter = null;
		}
	}
}
