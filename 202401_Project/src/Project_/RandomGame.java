package Project_;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {

		public static void main(String[] args) {
			for(int i=0; i<3; i++) {
				multiplication();
			}
			
		}
		public static void multiplication() {

			Scanner scanner = new Scanner(System.in);
			Random random = new Random();

			int num1 = createNumber(random);
			int num2 = createNumber(random);
			int mult = num1 * num2;
			System.out.printf("%d * %d = ", num1, num2);
			
			for (;;) {
				int dan = scanner.nextInt();
				if (dan == mult) {
					System.out.println("정답입니다.");
					break;
				} else {
					System.out.println("틀렸습니다.");
					
				}

			}
		}
		public static int createNumber(Random random) {
			
			return random.nextInt(10) + 1;
		}
	}

