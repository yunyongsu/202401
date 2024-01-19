package sec05.exam02;

public class SingletonEx {

	public static void main(String[] args) {
//			Singleton obj1 = new Singleton();   //생성자가 private이기 때문에 생성 불가
//			Singleton obj2 = new Singleton();

		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		

		if (obj1 == obj2) {
			System.out.println("같은 객체");
		} else {
			System.out.println("다른 객체");
		}
	}

}
