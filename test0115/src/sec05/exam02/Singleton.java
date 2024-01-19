package sec05.exam02;

public class Singleton {
		//private 접근제한은 자신 클래스 내에서만 접근 가능
		private static Singleton singleton = new Singleton();
		private Singleton(){} //생성자를 private으로 하면?
		static Singleton getInstance() {   //메소드 안에 추가 개발 가능
			return singleton;
		}

	}

/*자신이 객체를 생성하고 private 생성자로 다른곳에서 사용불가로 만듬. 
  그리고 getInstance 메소드를 만들어서 오직 이 메소드 사용할 수 있게 함.*/
