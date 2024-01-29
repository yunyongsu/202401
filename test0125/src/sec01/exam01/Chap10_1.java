package sec01.exam01;

public class Chap10_1 {

	void method(){
		System.out.println("method()");
	}
	void method2() {
		try {
			method();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("method2() - finally");
		}
	}
	
	public static void main(String[] args) {
		Chap10_1 chap = new Chap10_1();
		chap.method2();

	}

}
