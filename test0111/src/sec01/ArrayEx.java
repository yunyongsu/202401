package sec01;

public class ArrayEx {

	public static void main(String[] args) {
		int[] a = { 1, 3, 10, 2, 8 };     //배열 변수 a 선언
		int sum = 0;	//총합 변수
		double avg = 0;	// 평균 변수
		int max = 0;	//최대값 변수
		
		for(int i = 0; i < a.length; i++) { //i가  변수a의 길이(5)만큼 반복
			sum += a[i];  // 총합 += 변수a[5]
			if (max < a[i]) { 	/*현재 배열의 원소가 현재까지의 최대값보다 크다면
				max = a[i];       max = array[i]; 최대값(max)을 array[i]로 업데이트*/
			}
		}
//		for (int num : a) {
//			sum += num;
//
//			if (max < num) {
//				max = num;
//			}
//		}
		avg = (double) sum / a.length;   // 평균 = 총합 / 변수a의 길이(5)

		System.out.println("합계 :" + sum);
		System.out.println("평균 :" + avg);
		System.out.println("최대값:" + max);
	}
}
