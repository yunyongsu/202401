package page413;

 //내부 static 클래스는 A클래스에 종속되지 않고 단독으로 사용 가능.
public class A {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	class B {
		void method() {
			field1 = 10;
			method1();
			
			field2 = 10;
			method2();
			System.out.println("B method()," + field1);
		}
	}
	static class C{
		void method() {
//			field1 = 10;	//내부 static 클래스에서는 같은 static 멤버만 실행 가능
//			method1();
			
			field2 = 20;
			method2();
			System.out.println("C method(), " + field2 );
		}
	}
	//내부 클래스 B를 불러오기 위해선 A클래스 객체를 먼저 호출하고, A클래스 안에있는 B라는 의미로 a.new B(); 라고 표현
	//내부 static 클래스 C를 불러오기 위해선 A클래스 객체를 호출 할 필요없이 단독으로 호출 가능
	public static void main(String[] ar) {
		A a = new A();
		B b = a.new B();
		b.method();
		C c = new C();	//단독으로 객체 생성 가능
		c.method();
	}
}
