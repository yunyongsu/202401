package sec02.exam03;

public class Tire {
	
	int maxRotation;	//최대 회전수
	int accmulatedRotation;	//누적 회전수
	String location;	//타이어 위치
	
	public Tire(String location, int maxRotation) {	//생성자, 타이어 위치와 최대 회전수 초기화
		this.location = location;
		this.maxRotation = maxRotation;
	}
	public boolean roll() { 
		++accmulatedRotation; //누적 회전수 1 증가
		if(accmulatedRotation < maxRotation) { //만약 누적회전수가 최대 회전수보다 적으면 진행
			System.out.println(location + "Tire 수명 : " + (maxRotation-accmulatedRotation) + "회");
		return true;
		} else {		//만약 누적회전수가 최대회전수와 같다면(펑크) false
			System.out.println("***" + location + "Tire 펑크 ***");
			return false;
		}
	}
	

}
