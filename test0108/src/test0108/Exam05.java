package test0108;

import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		double avg = 0;

		System.out.print("입력할 개수:");
		int count = scan.nextInt();
		int[] intNum = new int[count];

		for (int i = 0; i < intNum.length; i++) {
			System.out.print("정수입력:");
			intNum[i] = scan.nextInt();
			sum += intNum[i];
			avg = (double) sum / count;

		}
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + avg);
	}
}
