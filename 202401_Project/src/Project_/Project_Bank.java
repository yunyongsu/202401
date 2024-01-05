package Project_;

import java.util.Scanner;

public class Project_Bank {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		boolean isLoggedIn = false; // 로그인 상태임을 알리는 변수 선언(변수가 true 면 경고문, false 면 계속 진행)
		boolean membershipStatus = false; // 회원가입 상태임을 알리는 변수 선언(변수가 true 면 경고문, false 면 계속 진행)
		boolean run2 = false;
		
		String userName = null; // 이름(아이디) 변수
		String ssn = null; // 주민번호(패스워드) 변수
		String phoneNumber = null; // 전화번호 변수
		String userId = null; // 아이디(이름) 변수
		String userPassword = null; // 패스워드(주민번호) 변수
		int balance = 0;

		AAA: while (run) { // 반복문
			System.out.println("-------------------------------------");
			System.out.println("1.회원가입 | 2.로그인 | 3.예금/출금 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scanner.nextLine());

			switch (menuNum) { // 입력값(menuNum)에 따른 상태 변화
			case 1: // 입력값이 1번일 때
				if (membershipStatus) { // 만약 (case 1)문 = true 일 때 경고문 표시(45번 라인 true)
					System.out.println("이미 회원가입 상태입니다.");
				
				do {
					System.out.println("가입절차를  계속 진행 하시겠습니까?(y/n)");
					String answer = scanner.nextLine();
					if (answer.equals("n") || answer.equals("N")) {
						continue AAA;
					} else if (answer.equals("y") || answer.equals("Y")) {
						break;
					}
				}while(true);
			}

				// 회원가입
				System.out.println("회원 가입");
				System.out.println("[필수 정보 입력]");
				System.out.print("1. 이름: ");
				userName = scanner.nextLine();
				System.out.print("2. 주민번호 앞 6자리: ");
				ssn = scanner.nextLine();
				System.out.print("3. 전화번호: ");
				phoneNumber = scanner.nextLine();
				System.out.println();
				System.out.println("[입력된 내용]");
				System.out.println("1. 이름: " + userName);
				System.out.println("2. 주민번호 앞 6자리: " + ssn);
				System.out.println("3. 전화번호: " + phoneNumber);
				membershipStatus = true; // (case 1)문 = true
				break; // (case 1)문 끝

			case 2:
				if (isLoggedIn) {
					System.out.println("이미 로그인 상태입니다.");
					continue;
				}
				if (!membershipStatus) {
					System.out.println("회원 가입을 하시기 바랍니다.");
					continue;
				}
				System.out.println("로그인 처리");
				System.out.print("아이디: ");
				String loginId = scanner.nextLine();
				System.out.print("패스워드: ");
				String loginPassword = scanner.nextLine();
				// 만약 로그인과 패스워드가 true 일 때
				if (loginId.equals(userName) && loginPassword.equals(ssn)) {
					System.out.println("로그인 성공");
					isLoggedIn = true;
				} else {
					System.out.println("로그인 실패: 아이디 또는 패스워드가 틀림");
				}
				break;

			case 3:
				// 예금 출금

				if (!isLoggedIn) {
					System.out.println("로그인이 필요합니다. 먼저 로그인하세요.");
					break;
				} else {
					run2 = true;
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
						balance += Integer.parseInt(scanner.nextLine());
						break;
					case 2:
						System.out.print("출금액> ");
						balance -= Integer.parseInt(scanner.nextLine());
						break;
					case 3:
						System.out.print("잔고> ");
						System.out.println(balance);
						break;
					case 4:
						run2 = false;
						break;
					}
					System.out.println();
				}
				System.out.println("프로그램 종료");
				break;
			case 4:
				run = false;
				break;
			}
		}

		System.out.println("프로그램 종료");
	}
}
