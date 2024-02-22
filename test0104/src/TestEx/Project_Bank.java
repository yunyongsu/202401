package TestEx;

import java.util.Scanner;

public class Project_Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        boolean isLoggedIn = false;

        String userName = null;
        String ssn = null;
        String phoneNumber = null;
        String userId = null;
        String userPassword = null;

        while (run) {
            System.out.println("-------------------------------------");
            System.out.println("1.회원가입 | 2.로그인 | 3.예금/출금 | 4.종료");
            System.out.println("-------------------------------------");
            System.out.print("선택> ");
            int menuNum = Integer.parseInt(scanner.nextLine());

            switch (menuNum) {
        	case 1:
				// 회원 가입

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

				break;

                case 2:
                    // 로그인 처리
                    System.out.println("로그인 처리");
                    System.out.print("아이디: ");
                    String loginId = scanner.nextLine();
                    System.out.print("패스워드: ");
                    String loginPassword = scanner.nextLine();

                    if (loginId.equals(userName) && loginPassword.equals(ssn)) {
                        System.out.println("로그인 성공");
                        isLoggedIn = true;
                    } else {
                        System.out.println("로그인 실패: 아이디 또는 패스워드가 틀림");
                    }
                    break;

                case 3:
                    // 예금 출금
                    System.out.println("예금 출금");
                    if (!isLoggedIn) {
                        System.out.println("로그인이 필요합니다. 먼저 로그인하세요.");
                        break;
                    }

                    boolean run2 = true;
                    int balance = 0;

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

