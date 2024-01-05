package TestEx;

import java.util.Scanner;

public class Exam3_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		for (;;) {
			System.out.println("첫 번째 수:");
			double sum = scanner.nextDouble();

			System.out.println("두 번째 수:");
			double sum2 = scanner.nextDouble();

			System.out.println("결과 :" + (sum / sum2));

			if (sum ==0 || sum2 ==0 ) {
				System.out.println("결과 : 무한대");
				break;
			}

		}

	}
}
