package sec02.exam02;

public class ChildEx {

	public static void main(String[] args) {
		Child child = new Child();
		//Parent parent = new Child();
		
		Parent parent = child;	//자동 타입 변환
		parent.method1();
		parent.method2();    //재정의된 메소드가 호출
		//parent.method3();   //부모클래스에 없기때문에 호출 불가능
	}

}
