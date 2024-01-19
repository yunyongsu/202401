package sec02.exam04;


//vehicle에 있는 메소드를 매개변수를 통해 실행
public class Driver {
	public void drive(Vehicle vehicle) {	//매개변수의 다형성
		vehicle.run();
	}

}
