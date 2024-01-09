package test0109_3;

public class CalEx {

	public static void main(String[] args) {
		Cal.sx = 500;
		Cal cal = new Cal();
		cal.power();
		cal.x = 100;
		cal.printX();

		Cal cal2 = new Cal();
		System.out.println(cal2.x);
		cal2.power();
	}

}
