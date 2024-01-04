package sec03.exam01;

import java.util.Scanner;

public class sum2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int inputData;
		
		System.out.print("숫자 입력>");
		int num1 = Integer.parseInt(scanner.nextLine());
		System.out.print("숫자 입력>");
		int num2 = Integer.parseInt(scanner.nextLine());
		int sum = num1 + num2;
		System.out.printf("두 수의 합 = %d\n", sum);
		

	}

}
