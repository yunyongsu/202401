package TestEx;

import java.util.Scanner;

public class CoOpEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("입력");
		int score = scanner.nextInt();
		char grade = (score > 90) ? 'A' : 'B';
		
		
		System.out.println(grade);
		/*
		if(score > 90) {
			grade = 'A';
		} else {
			grade = 'B';
		}
*/
	}

}
