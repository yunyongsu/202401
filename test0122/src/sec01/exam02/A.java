package sec01.exam02;

public class A {
	class B{}
	static class C{}
	
	B field1 = new B();
	C field2 = new C();
	static C field4 = new C();
	static B field3 = new A().new B();  //A의 객체를 생성 후 B 생성 가능
	
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	static void method2() {
//		B var1 = new B();
		C var2 = new C();
	}
	
	

}
