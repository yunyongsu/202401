package anonymous;

class AnyClass{	
	void aaa() {};
}

public class Ex {
	public static void main(String[] args) {
		AnyClass ac = new AnyClass() {	//익명의 자식 객체 생성, 변수가 없기 때문에 호출 불가능

			@Override
			void aaa() {
				super.aaa();
			}
			
		};

	}

}
