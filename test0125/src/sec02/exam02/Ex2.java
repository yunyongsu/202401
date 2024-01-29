package sec02.exam02;

class AnyClass2 {
	void anyMethod() throws Exception{
		throw new Exception();	//예외를 발생시킴
	}

}

public class Ex2 {

	public static void main(String[] args) {
		AnyClass2 ac = new AnyClass2();
		try {
			ac.anyMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
