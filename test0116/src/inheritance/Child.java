package inheritance;	


class Parent{   //부모 클래스
	int money = 100;
	
	void disp() {
		System.out.println(money);
	}
}

public class Child extends Parent{	// 자식클래스, 상속
	
	public Child() {  //생성자
		this.money += 300;
		
	}
	
	public static void main(String[] args) {
		Child ch = new Child();
		ch.disp();

	}

}
