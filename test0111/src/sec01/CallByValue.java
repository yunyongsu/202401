package sec01;

class MyClass{
	int n;
}
public class CallByValue {


	public static void increase(int n, MyClass mc) {
		n = n + 1;
		System.out.println(n);
		
	}
	public static void main(String[] args) {
		int n = 100;
		MyClass mc = new MyClass();
		System.out.println(mc.n);
//		increase(n, mc);
		increase(n, new MyClass());
		System.out.println(n);
		System.out.println(mc.n);
		
		

	}

}
