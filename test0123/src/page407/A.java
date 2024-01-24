package page407;

//클래스 중첩, 메소드 안에도 클래스 선언 가능, static은 불가
public class A {
	class B{}
	static class C{}
	void method1() {
		class D{}
	}

}
