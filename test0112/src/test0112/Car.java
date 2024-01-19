package test0112;

public class Car {
	int gas;


	void setGas(int gas) {  //gas값 초기화
		this.gas = gas;
	}

	boolean isLeftGas() {    //리턴값이 boolean인 메소드로 gas값이 0이면 false, 아니면 true를 리턴
		if (gas == 0) {
			System.out.println("가스가 없습니다");
			return false;
		}
		System.out.println("gas가 있습니다");
		return true;
	}
	void run() {   //gas가 0이 될때까지 반복하는 메소드
		while(true) {
			if(gas > 0) { //gas가 0보다 크다면 "달립니다"
				System.out.println("달립니다.(gas잔량:" + gas + ")");
				gas --;   //gas가 1씩 줄어듬
			} else {  //gas가 0이되면 "멈춥니다"
				System.out.println("멈춥니다.(gas잔량:" + gas + ")");
				return; //메소드(반복문)를 빠져나감.
			}
		}
	}
}
