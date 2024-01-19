package sec03.exam02_intf;

//public은 파일 하나 당 한개만 가능. 
//Cat과 Dog는 default타입으로 다른 클래스에서 사용불가하므로 새로 파일을 만들어 public으로 생성해야함.


class Cat implements Soundable{

	@Override
	public String sound() {
		return "야옹";
	}
	
}
class Dog implements Soundable{

	@Override
	public String sound() {
		return "멍멍";
	}
	
}

public class SoundableEx {
	
	public static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}

	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());
		

	}

}
