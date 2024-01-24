package page427;

class Parent{
	void parentMethod() {}
}

public class A {
	Parent field = new Parent() {
		int childField;
		void childmethod() {}
	};	//필드: Parent의 익명 자식 객체 생성
	void method() {
		
	}	// 메소드
}
