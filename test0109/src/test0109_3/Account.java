package test0109_3;

public class Account {
	String name;
	String ssn;
	String tel;
	int age;

	public Account() {
		System.out.println("내가만든 accout");
	}

	public Account(String name) {
		this.name = name;
		
	}
	public Account(String name,String ssn) {
		this.name = name;
		this.ssn = ssn;
		
	}
	
	
	public Account(String name, String ssn, String tel, int age) {
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", ssn=" + ssn + ", tel=" + tel + ", age=" + age + "]";
	}

}
