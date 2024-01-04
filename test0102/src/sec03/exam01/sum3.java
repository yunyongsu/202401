package sec03.exam01;

import java.util.Scanner;

public class sum3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int inputData;
		int sum = 0;
		
		System.out.print("숫자 입력>");
		int num1 = Integer.parseInt(scanner.nextLine());
		System.out.print("숫자 입력>");
		int num2 = Integer.parseInt(scanner.nextLine());
		
		for(int i = num1; i <= num2; i++ ) {
			sum = sum+i;
		}
		System.out.println(sum);
	}
}
