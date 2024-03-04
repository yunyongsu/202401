package sec03.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class GetLineEx {

	public static void main(String[] args) throws IOException {
//		InputStream is = System.in;
//		Reader reader = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(reader);
		Scanner br = new Scanner(System.in);
		
		while(true) {
			System.out.print("입력하세여: ");
//			String lineStr = br.readLine();
			String lineStr = br.nextLine();
			if(lineStr.equals("q") || lineStr.equals("quit")) {
				break;
			}
			System.out.print("입력된 내용: "+ lineStr + "\n");
		}
		System.out.println("종료");
		br.close();
	}

}
