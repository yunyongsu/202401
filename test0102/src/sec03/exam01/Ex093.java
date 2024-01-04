package sec03.exam01;

import java.io.IOException;

public class Ex093 {

	public static void main(String[] args) throws IOException {
		int keyCode;
				
		for(;;) {
			System.out.print("입력>");
			keyCode = System.in.read();
			System.out.println("keyCode:" + keyCode);
			
				if ( keyCode == 113) { //q입력 시
					break;
			}
		}
	}

}
