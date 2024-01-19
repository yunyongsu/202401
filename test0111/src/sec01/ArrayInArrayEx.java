package sec01;

import java.util.Scanner;

public class ArrayInArrayEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		double avg;
		int count = 0;
		int scores[][];

		System.out.print("크기를 입력하세요: ");
		int n1 = scan.nextInt();
		System.out.print("크기를 입력하세요: ");
		int n2 = scan.nextInt();
		scores = new int[n1][n2];

		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores.length; j++) {
				System.out.printf("(%d, %d) 입력: ", i, j);
				scores[i][j] = scan.nextInt();
			}
		}
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores.length; j++) {
				sum += scores[i][j];
				count++;
				//count = n1*n2
			}
		}

		avg = sum /(double)count; 
		System.out.println("총합: " + sum);
		System.out.println("평균: " + avg);
	}

}
