package test0103;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scr = new Scanner(System.in);

	while(run) {
		System.out.println("----------------------");
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료 ");
		System.out.println("----------------------");
		System.out.println("선택> ");
		
		int num = Integer.parseInt(scr.nextLine());
		//int num = scr.nextInt();
		if(num == 1) {
			System.out.printf("예금액> ");
			balance += Integer.parseInt(scr.nextLine());
		} else if(num == 2) {
			System.out.println("출금액> ");
			balance -= Integer.parseInt(scr.nextLine());
		} else if(num == 3) {
			System.out.println("잔고> ");
			System.out.println(balance);
		} else {
			System.out.println("종료");
			break;
			
		}
	}
	}

}
