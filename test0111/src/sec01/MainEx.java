package sec01;

public class MainEx {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("값의 수가 부족합니다.");
			System.exit(0);
		}
		String str = args[0];
		System.out.println(str);
		
	}

}
