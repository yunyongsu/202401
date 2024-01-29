package sec01.exam01;

class Car{}

public class ClassEx {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = Car.class;
		
		String str = clazz.getResource("photo2.jpg").getPath();
		System.out.println(str);
		String str2 = clazz.getResource("images/photo2.jpg").getPath();
		System.out.println(str2);
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackageName());
		
		Class clazz2 = Class.forName("sec01.exam01.Car");
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackageName());
		
		Car car = new Car();
		Class clazz3 = car.getClass();
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackageName());

	}

}
