package sec02.exam02;

class AnyClass {
	void anyMethod() throws Exception {}
	void method(){
		try {
			this.anyMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

public class Ex {

	public static void main(String[] args) {
		AnyClass ac = new AnyClass();
		ac.method();

	}

}
