package test0109_2;

public class CarEx {

	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = new Car("기아자동차", "기아");
		Car car3 = new Car("현대자동차");
		System.out.println("car3.company :" + car3.company);
		System.out.println("car2.company,model :" + car2.company);
		System.out.println(car3);
		Car car4 = new Car("현대", "코나", "블랙", 200);
		System.out.println(car4);
		
		System.out.println(car2);
		

		car.company = "KIA";
		car.color = "RED";
		car.model = "K7";
		car.maxSpeed = 200;
		
		System.out.println(car);
	}

}
