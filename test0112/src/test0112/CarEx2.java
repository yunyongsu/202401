package test0112;

public class CarEx2 {

	public static void main(String[] args) {
		Car2 myCar = new Car2();
		Car2 yourCar = new Car2();
		
		myCar.setModel("포르쉐");
		yourCar.setModel("벤츠");
		
		myCar.run();
		yourCar.run();
		
	}

}
