package sec05.exam02;

public class ClassName {

	int field1;

	void method1() {
	}

	static int field2;  //사용 가능

	static void method2() {	//사용 가능
	}

	static void method3() {	//사용 가능
//		field1 = 10;	//즉시 사용 불가, 객체 생성 후 사용 가능
		ClassName cn = new ClassName();
		cn.field1 = 10;
		ClassName.field2 = 10;	//사용 가능
	}

	void method4() {
		this.field1 = 10;
		ClassName.field2 = 10;
	}
}
