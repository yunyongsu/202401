package sec02.exam01;

class A{}

class B extends A{}
class C extends A{}

class D extends B{}
class E extends C{}

public class PromotionEx {

	public static void main(String[] args) {
		//Object obj = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		//상속관계일 땐 부모로 변수선언을 하고 자식으로 객체생성이 가능
		
		
		//B b3 = e;    상속관계가 아니기 때문에 컴파일 에러
		//C c2 = d;

	}

}
