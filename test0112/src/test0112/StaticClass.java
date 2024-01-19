package test0112;

class MyClass{
	void method1() {
		System.out.println(this.toString());
		System.out.println("method1");
	}
	static void method2() {
		System.out.println("method2");
	}
	
}
public class StaticClass {
	static void method3() {
		System.out.println("method3");
	}
	public static void main(String[] args) {	
		MyClass myc = new MyClass();
		myc.method1();
		myc.method2();
		MyClass mc = new MyClass();
		mc.method1();
		mc.method2();
	}

}
