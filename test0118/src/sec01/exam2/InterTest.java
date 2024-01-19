package sec01.exam2;

public interface InterTest {
	void test();  //추상 메소드
	default void test1() {
		System.out.println("test");
	}
	private void test2() {    //인터페이스 내에서만 사용 가능
		System.out.println("test2");
	}
	static void test3() {
		System.out.println("test3");
	}
}
