package sec01;

public class Bubble1 {

	public static void printArr(int a[]) {
		for (int n : a) {
			System.out.print(n + ",");
		}
		System.out.println();
	}
					// 오름차순
	public static void main(String[] args) {
		int a[] = { 10, 3, 1, 4, 2 };
		printArr(a);

		for (int i = 0; i < a.length; i++) { 			// 반복 횟수(5)
			for (int j = 0; j < a.length - 1; j++) { //a[j]와 a[j+1]를 비교하고 정렬하는 역할
				if (a[j] > a[j + 1]) {
					// 만약 a[j]의 값이 a[j+1]의 값(다음값)보다 크다면 두 값을 교환
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					printArr(a);
				}
				
			}
		}
		printArr(a);
	}

}
