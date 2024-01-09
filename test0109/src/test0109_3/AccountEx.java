package test0109_3;

public class AccountEx {

	public static void main(String[] args) {
		Account acc = new Account();
		acc.name = "kimhana";
		acc.ssn = "123456";
		acc.tel = "123-456-789";
		acc.age = 13;
		System.out.println(acc);
		System.out.println(acc.name);
		
		Account acc1 = new Account("kimhana", "950419", "010-454-041", 26);
		System.out.println(acc1);

	}

}
