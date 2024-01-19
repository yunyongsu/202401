package sec03.exam01;

import java.util.Scanner;

public class grade {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int inputData;

		while (true) {
			System.out.print("입력> ");
			inputData = scanner.nextInt();
			if (inputData == 0) {
				System.out.println("종료");
				break;
			}

			if (inputData >= 90) {
				System.out.println("학점 : A");
			} else if (inputData >= 80) {
				System.out.println("학점 : B");
			} else if (inputData >= 70) {
				System.out.println("학점 : C");
			} else {
				System.out.println("학점 : D");
				
			}
			break;
		}

	}

}
