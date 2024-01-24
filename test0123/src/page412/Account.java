package page412;

//static 필드를 초기화하기 위해서는 static 클래스로 가능
public class Account {
	
	Name name = new Name();
	School school = new School();
	
	class Name{}
	static class School{}

}
