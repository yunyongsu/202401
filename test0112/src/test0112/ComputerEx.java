package test0112;

public class ComputerEx {

	public static void main(String[] args) {
		Computer myCom = new Computer();
		
		int[] valuse1 = {1,2,3};
		int result1 = myCom.sum1(valuse1);
		System.out.println("result:" + result1);
		
		int result2 = myCom.sum1(new int[] {1,2,3,4,5});
		System.out.println("result:" + result2);
		
		int result3 = myCom.sum2(1,2,3);
		System.out.println("result:" + result3);
		
		int result4 = myCom.sum2(1,2,3,4,5);
		System.out.println("result:" + result4);
	}

}
