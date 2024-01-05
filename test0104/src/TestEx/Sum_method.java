package TestEx;

import java.util.Scanner;

public class Sum_method {

	public static void mult(Scanner scanner) {
		System.out.print("첫번째 수: ");
		String strNum1 = scanner.nextLine();
		System.out.print("두번째 수: ");
		String strNum2 = scanner.nextLine();
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 * num2;
		System.out.print("곱셈 결과: " + result);
		
	}
	public static void sum(Scanner scanner) {
		System.out.print("첫번째 수: ");
		String strNum1 = scanner.nextLine();
		System.out.print("두번째 수: ");
		String strNum2 = scanner.nextLine();
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.print("덧셈 결과: " + result);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		sum(scanner);
		mult(scanner);
		
	}

}
