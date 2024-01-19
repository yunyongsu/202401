package sec01;

public class Passing1 {
	
	public static int method1(int y) {
	//int y = 지역변수(단 호출한 곳에서 값을 넘겨 줘야 한다)
		y += 1;
		return y;
	}
	

	public static void main(String[] args) {
		int x = 100;
		int num = method1(x);
		System.out.println(num);
	}

}
