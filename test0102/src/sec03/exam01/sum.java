package sec03.exam01;

public class sum {
	public static void main(String[] args) {
		// 1~10까지 더한 값
		
		int sum=0;  //합한 값의 초기화
	
		for(int b = 1; b <= 10; b++ ) {  //1~10까지 반복 
			sum = sum+b; //초기값 sum('0') + 반복문 b('1~10')
		}
		System.out.println("1부터 10까지의 합 : " + sum);  //sum + b 의 값 출력, print는 어느자리에 쓰이느냐에 따라 출력이 다름
	}
}

