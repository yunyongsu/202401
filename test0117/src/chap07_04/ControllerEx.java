package chap07_04;

public class ControllerEx {

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.setService(new MemberService());   //자신을 포함해서 자식클래스만 가능(부모클래스 x)

	}

}
