package sec03.exam02;

public class AnimalEx {

	public static void main(String[] args) {
//		Animal animal = new Animal();  //추상클래스는 객체생성이 안됨
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		System.out.println("-----------");
		
		
		Animal animal = new Dog();
		animal.sound();
		Animal animal2 = new Cat();
		animal2.sound();
		System.out.println("-----------");
		
		animalSound(new Dog());
		animalSound(new Cat());
	}
	public static void animalSound(Animal animal) {
		animal.sound();
	}
}
