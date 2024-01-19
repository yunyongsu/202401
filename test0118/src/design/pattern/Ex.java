package design.pattern;

import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CarFactory carFactory = null;
		System.out.println("생산하려는 차종을 선택(1.국산차, 2.미국차)");
		System.out.println("선택->");
		String key = scan.nextLine();
		switch(key) {
		case "1":
			carFactory = new KoreaCarFactory();
			break;
		case "2":
			carFactory = new StateCarFactory();
		default:
			System.out.println("다시 선택");
			break;
		}
		
//		CarFactory carFactory = new KoreaCarFactory();
		TireProduct tireProduct = carFactory.createTire();
		DoorProduct doorProduct = carFactory.createDoor();
		
		String tire = tireProduct.makeAssemble();
		String door = doorProduct.makeAssemble();
		System.out.println(tire);
		System.out.println(door);
		
		CarFactory carFactory2 = new StateCarFactory();
		TireProduct tireProduct2 = carFactory2.createTire();
		DoorProduct doorProduct2 = carFactory2.createDoor();
		
		String tire2 = tireProduct2.makeAssemble();
		String door2 = doorProduct2.makeAssemble();
		System.out.println(tire2);
		System.out.println(door2);
		

	}

}
