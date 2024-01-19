package sec01;

public class indexEx {

	public static void main(String[] args) {
		int a[] = { 10, 3, 1, 4, 2 };
		int arr = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 4) {
				arr = i;
			}

		}
		System.out.println("인덱스 : " + arr);

	}

}
