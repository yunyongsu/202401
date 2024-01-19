package sec01;

public class Index2 {

	public static void main(String[] args) {
//		int x = 10;
//		int y = 20;
//
//		int p = x;
//		x = y;
//		y = p;
//
//		System.out.println("x값은:" + x + "y값은:" + y);

		int a[] = { 10, 3, 1, 4, 2 };
		for (int i = 0; i < a.length; i++) {   // 반복 횟수(5)
			for (int j = 0; j < a.length-1; j++) {  //a[j]와 a[j+1]를 비교하고 정렬하는 역할
				if (a[j] > a[j + 1]) {    // 만약 a[j]의 값이 a[j+1]의 값보다 크다면 두 값을 교환
					//a[j]와 a[j+1] 값을 바꾸는 코드
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					
					for (int n : a) {
						System.out.print(n + ",");
						
				}
					System.out.println();
			}
				
		}
	}
	}
}
