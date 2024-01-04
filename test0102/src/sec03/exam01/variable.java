package sec03.exam01;

public class variable {

	public static void main(String[] args) {
		
		
		int hour = 3;     //hour변수에 초기값 3 부여
		int minute = 5;   //minute변수에 초기값 5 부여
		int totalminute = (hour*60) + minute;   //totalminute = hour(3)x 60 + minute(5)
		System.out.println(totalminute + "분");  
		
		

		//자료교환 (swap)
		int x = 10;
		int y = 20;
		
		System.out.printf("x는 %d, y는 %d \n", x, y);
		
		//임의의 영역(z)에 x값을 넣고 x에 y값을, y에 z값을 넣음. 
		int z = x;  
		x = y;
		y = z;
		System.out.printf("x는 %d, y는 %d", x, y);
		

	}
}
	
