package test0112;

public class Computer {
	int sum1(int[] valuse) {
		int sum = 0;
		for(int val : valuse) {
			sum += val;
		}
		return sum;
	}
	int sum2(int ... valuse) {
		int sum = 0;
		for(int i= 0; i < valuse.length; i++) {
			sum += valuse[i];
		}
		return sum;
	}
	
	
}
