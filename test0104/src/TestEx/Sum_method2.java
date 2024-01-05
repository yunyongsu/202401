package TestEx;

import java.util.Scanner;

public class Sum_method2 {

	public static void mult(int num1, int num2) {
		
		int result = num1 * num2;
		System.out.print("곱셈 결과: " + result);

	}

	public static void sum(int num1, int num2) {

		int result = num1 + num2;
		System.out.print("덧셈 결과: " + result);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수: ");
		String strNum1 = scanner.nextLine();
		System.out.print("두번째 수: ");
		String strNum2 = scanner.nextLine();

		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		sum(num1, num2);
		System.out.print("\n");
		mult(num1, num2);

	}

}
