package sec02.exam05;

public class ChildEx {

	public static void main(String[] args) {
		
		
		Parent parent =new Child();	//자식 타입이 부모 타입으로 변환
		
		parent.method1();
		parent.method2();

//		parent.method3;				부모클래스에 없기때문에 불가능
		
		Child child = (Child) parent; //문법상 오류 없음
		child.method3();
		

	}

}
