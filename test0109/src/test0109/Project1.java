package test0109;

import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		boolean run2 = true;
		boolean logIn = false;
		boolean membership = false;
		Account acc = null;
			while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch (menuNum) {
			case 1:
				if (logIn) {
					System.out.println("이미 로그인되었습니다.");
					continue;
				}
				if (!membership) {
					System.out.println("회원가입 해주시길 바랍니다.");
					continue;
				}

				System.out.println("로그인");
				System.out.print("아이디: ");
				String id = scanner.nextLine();
				System.out.print("패스워드: ");
				String pass = scanner.nextLine();
				if (id.equals(acc.name) && pass.equals(acc.ssn)) {
					System.out.println("로그인 성공");
					logIn = true;
				} else {
					System.out.println("로그인 실패: 아이디 또는 패스워드가 틀림");
				}
				break;
			case 2:
				if (membership) { // 만약 (case 1)문 = true 일 때 경고문 표시(45번 라인 true)
					System.out.println("이미 회원가입 상태입니다.");

					do {
						System.out.println("가입절차를  계속 진행 하시겠습니까?(y/n)");
						String answer = scanner.nextLine();
						if (answer.equals("n") || answer.equals("N")) {
							run = true;
							continue;
						} else if (answer.equals("y") || answer.equals("Y")) {
							break;	
						}
					} while (true);
				}
				System.out.println("회원 가입");
				System.out.print("이름> ");
				String name = scanner.nextLine();
				System.out.print("주민등록번호> ");
				String ssn = scanner.nextLine();
				System.out.print("전화번호> ");
				String tel = scanner.nextLine();
				acc = new Account(name, ssn, tel);
				System.out.println(acc);
				membership = true;

				break;
			case 3:
				if (logIn) { // 로그인 여부
					run2 = true;
				} else {
					System.out.println("로그인 하시기 바랍니다.");
					break;
				}
				while (run2) {
					System.out.println("-------------------------------------");
					System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
					System.out.println("-------------------------------------");
					System.out.print("선택> ");
					int menuNum2 = Integer.parseInt(scanner.nextLine());
					switch (menuNum2) {
					case 1:
						System.out.print("예금액> ");
						acc.balance += Integer.parseInt(scanner.nextLine());
						break;
					case 2:
						System.out.print("출금액> ");
						acc.balance -= Integer.parseInt(scanner.nextLine());
						break;
					case 3:
						System.out.print("잔고> ");
						System.out.println(acc.balance);
						break;
					case 4:
						run2 = false;
						break;
					}
					
				}System.out.println("프로그램 종료");
				break;

			case 4:
				run = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}
