package test0110;

public class CircleEx {

	public static void main(String[] args) {
		Circle[] c;
		c = new Circle[5];
		
		for (int i=0; i < c.length; i++) {
			c[i] = new Circle(i);
		}
		
		for (int i=0; i < c.length; i++) {
			System.out.println(c[i].getArea());
		}

	}

}
	