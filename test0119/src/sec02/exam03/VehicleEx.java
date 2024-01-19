package sec02.exam03;

class Acc{
	
}
public class VehicleEx {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Bus();  //자동 타입 변환
		vehicle.run();	//재정의 된 run 메소드 호출
		
		Bus bus = (Bus)vehicle;	//강제 타입 변환
		bus.checkFare();  //bus 클래스에 있는 checkFare메소드 호출

	}

}
