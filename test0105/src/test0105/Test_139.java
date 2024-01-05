package test0105;

import java.util.Scanner;

public class Test_139 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("점수>");
		int score = scanner.nextInt();
		int grade = score/10;   //입력값 나누기 10
		
		switch(grade) {
		case 10: //100점일 때 = 100/10 = 10 
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("D");
			break;
		}
	}
}
