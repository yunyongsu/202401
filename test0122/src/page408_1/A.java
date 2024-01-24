package page408_1;

public class A {	//인스턴스 멤버 클래스
	class B{
		B(){}	//생성자
		int field1;	//인스턴스필드
//		static int field2; //정적 필드 x,  
		
		void method1() {}//인스턴스 메소드
	}
	void methodA() {
		B b = new B();
		b.field1 = 3;
		b.method1();
	}
}
