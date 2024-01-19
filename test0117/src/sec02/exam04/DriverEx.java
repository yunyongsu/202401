package sec02.exam04;

import java.util.Scanner;

public class DriverEx {

	public static void main(String[] args) {
		Driver driver = new Driver();

//		Bus bus = new Bus();
//		Taxi taxi = new Taxi();		
		driver.drive(new Bus());
		driver.drive(new Taxi());

		Scanner scan = new Scanner(System.in);
		System.out.println("이동할 차량을 선택하시오: (1:버스, 2:택시)");
		System.out.println("번호 : ");
		int num = scan.nextInt();
		Vehicle vehicle = null;

			switch (num) {
			case 1:
				vehicle = new Bus();
				break;
			case 2:
				vehicle = new Taxi();
				break;
			default :
				break;
			}
			driver.drive(vehicle);
		}
	}

