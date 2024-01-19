package test0112;

public class CarEx {

	public static void main(String[] args) {
		Car myCar = new Car();   //
		
		myCar.setGas(5);   //Car의 setGas()메소드 호출 후 값 대입
		
		if(myCar.isLeftGas()) { //Car의 isLeftGas 메소드 호출, 가스가 5 있으므로 return=true 실행
			System.out.println("출발합니다"); // 출력
			myCar.run();  //Car의 run 메소드 호출 , 입력받은 5가 0이 될때까지 반복
		}
		if(myCar.isLeftGas()) {   //isLeftGas 메소드를 호출하여 gas가 0이기 때문에 return=false 실행 
			System.out.println("가스를 주입할 필요가 없습니다.");
		} else {
			System.out.println("가스를 주입해주세요."); // 출력
		}

	}

}
