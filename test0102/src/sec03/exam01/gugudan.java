package sec03.exam01;

import java.util.Scanner;

public class gugudan {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// String str;

		for (;;) {
			System.out.print("입력>");
			int inputData = scanner.nextInt();

			if (inputData == 0) {
				System.out.println("종료");
				break;
			}
			for (int i = 1; i < 10; i++) {

				System.out.println(inputData + "*" + i + " = " + (inputData * i));

			}
		}

	}

}
