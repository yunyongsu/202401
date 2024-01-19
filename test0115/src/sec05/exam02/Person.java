package sec05.exam02;

public class Person {
	static final double PI = 3.141592; //상수 
	final String name = "홍길동";
	
//	public Person(String name) {    //초기값이 정해지면 수정 불가, 초기값이 없으면 한번만 선언 가능
//		this.name = name;
//	}
	
	public static void main(String[] args) {
		Person person = new Person();
//		person.name = "홍길동";
		System.out.println(person.name);
		System.out.println(PI);


	}

}
