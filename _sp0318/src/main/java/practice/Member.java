package practice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Member {
	private int memberno;
	private String id;
	private String pw;
	private String name;
	
	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public Member(int memberno, String pw, String name) {
		super();
		this.memberno = memberno;
		this.pw = pw;
		this.name = name;
	}
	
	
	
}
