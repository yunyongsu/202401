package test0103;

public class FloatDoubleEx {

	public static void main(String[] args) {
		float num1 = 123.45646456456456f;
		double num2 = 123.45646456456456; 
		
		System.out.println(num1);
		System.out.println(num2);
		
		double var = 0.1;
		for(int i = 0; i < 1000; i++) {
			var += 0.1;
		}
		System.out.println(var);
	}

}
