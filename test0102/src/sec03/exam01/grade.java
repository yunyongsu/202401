package sec03.exam01;

import java.util.Scanner;

public class grade {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int inputData;
		
		
		while(true) {
			System.out.println("입력>");
			inputData = scanner.nextInt();
				if(inputData == 0) {
					System.out.println("종료");
					break;
			}
		
		if(inputData >= 90 && inputData < 100) {
			System.out.println("A");
		}
		else if(inputData >= 80 && inputData < 89){
			System.out.println("B");
		}
		else if(inputData >= 70 && inputData < 79) {
			System.out.println("C");
		}
		else if(inputData <70){
			System.out.println("D");
		}
		}
			
	
		}
		

	}

