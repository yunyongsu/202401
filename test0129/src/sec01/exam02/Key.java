package sec01.exam02;

public class Key {
	public int number;

	public Key(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) { //매개변수의 다형성, Object 로부터 상속
		if (obj instanceof Key) { // Key클래스의 객체인지
			Key compareKey = (Key) obj;	// Key 클래스 강제 형변환
			if (this.number == compareKey.number);	//number 비교
			{
				return true;
			}
		}
		return false;
		
	}

	@Override
	public int hashCode() {
		return number;
	}
}
