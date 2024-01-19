package sec01.exam2;

public class MyClass implements InterTest{
	
	@Override
	public void test1() {
		System.out.println("새로운 test");
	}

	@Override
	public void test() {
	}
	
	public static void main(String[] args) {
		InterTest it = new MyClass();
		it.test1();
		InterTest.test3();
		
		

	}

}
