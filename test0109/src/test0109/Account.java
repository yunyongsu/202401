package test0109;

public class Account {
	String name;
	String ssn;
	String tel;
	int balance;
	
	public Account(String name, String ssn, String tel) {
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 주민번호=" + ssn + ", 전화=" + tel + ", 잔액=" + balance + "]";
	}	
	
}
