package ramda;

public class MyFuncEx {

	/*람다식, 메소드가 오직 하나여야만 사용 가능.
	어차피 메소드를 하나밖에 쓸 수 없기때문에 뻔한 문장 생략*/
	
	public static void main(String[] args) {
		MyFunc mf, mf2;
		
		mf = new MyFunc() {
			@Override
			public void method(int x, int y) {
				System.out.println("Ramdasik");
			}
		};
		mf.method(10, 100);
		
		mf2 = (x, y) -> {System.out.println("Ramdasik");}; 
		
	}
	public static int sum(int x, int y) {
		return x+y;
	}
}
