package test0103;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		
		Scanner scr1 = new Scanner(System.in);
		
		
		System.out.println("이름 : ");
		String name = scr1.nextLine();
		
		System.out.println("주민번호 앞 6자리 :");
		String strnum = scr1.nextLine();
		int num = Integer.parseInt(strnum);
		// int num = scr1.nextInt();
		System.out.println("전화번호 : ");
		String phone = scr1.nextLine();

		
		System.out.println(name + "\n"+ num + "\n" + phone);
	}

}
