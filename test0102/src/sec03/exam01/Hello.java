package sec03.exam01;

import java.util.Random;
import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		
		Scanner scr1 = new Scanner(System.in);
		
		
		System.out.println("이름 : ");
		String name = scr1.nextLine();
		
		System.out.println("주민번호 앞 6자리 :");
		String num= scr1.nextLine();
		//int num = scr1.nextInt();
		
		System.out.println("전화번호 : ");
		String phone = scr1.nextLine();

		
		System.out.println(name + "\n"+ num + "\n" + phone);
	}

}