package test0109_2;

public class Car {
	String company;
	String model;
	String color;
	int maxSpeed;
	
	public Car() {
		
	}
	public Car(String str) {
		company = str;
	}
	public Car(String str, String str1) {
		company = str;
		model = str1;
	}
	
	
	
	public Car(String company, String model, String color, int maxSpeed) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

}