package sec01;

public class chap05_5 {

	public static void main(String[] args) {
		int array[][] = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int sum = 0;
		double avg = 0.0;
		int count = 0;
		
		for (int arr[] : array) {
			for (int val : arr) {
				sum += val;
				count++;
			}
		}
		avg = sum / (double)count;

		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);

	}
}
