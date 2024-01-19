package project1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project1.Account;

/* while문으로 메뉴 만들고 로그인에 필요한 정보를 account클래스에 작성.
 * Account가 담긴 ArrayList 선언하고 회원등록 scanner로 받기
 * 받은 정보에 넣고 list.add로 account값 저장  
 * 회원출력에 for문으로 저장 된 account값 출력 */

public class Project {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Scanner scan = new Scanner(System.in);
		boolean run = true;
		List<Account> list = new ArrayList<>();

		while (run) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1.회원출력 | 2.회원등록 | 3.파일저장 | 4.파일읽기 | 종료");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("선택-> ");
			int menuNum = Integer.parseInt(scan.nextLine());
			switch (menuNum) {

			case 1:
				System.out.println("회원출력");
				for (Account account : list) {
					System.out.println(account);
				}
				break;
			case 2:
				System.out.println("회원등록");
				System.out.print("이름: ");
				String name = scan.nextLine();

				System.out.print("아이디: ");
				String id = scan.nextLine();

				System.out.print("비밀번호: ");
				String pass = scan.nextLine();

				System.out.print("전화번호: ");
				String tel = scan.nextLine();

				System.out.print("생년월일: ");
				String birth = scan.nextLine();

				list.add(new Account(name, id, pass, tel, birth));
				break;
			case 3:
				System.out.println("파일저장");
				FileOutputStream fos = new FileOutputStream("c:/temp/acc.db");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
				oos.flush();
				oos.close();
				break;
			case 4:
				System.out.println("파일읽기");
				FileInputStream fis = new FileInputStream("c:/temp/acc.db");
				ObjectInputStream ois = new ObjectInputStream(fis);
				list = (List<Account>) ois.readObject();
				for (Account acc : list) {
					System.out.println(acc);
				}
				ois.close();
				break;
			case 5:
				run = false;
				break;
			}
		}
		
	}
}