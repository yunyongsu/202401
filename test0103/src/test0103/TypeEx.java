package test0103;

public class TypeEx {

	public static void main(String[] args) {
		String str = 19 + 3 + "";
		String str1 = String.valueOf(12);
		String str2 = "" + 14 + 4;	
		int num1 = Integer.parseInt(str2);

		
		String str3 = "3.14";
		double value = Double.parseDouble(str3);

		
		int x = 1;
		int y = 2;
		double result2 = x / y;

		
		int value1 = 10;
		int value2 = 100;
		int sum = value1 + value2;
			
		
		byte var1 = 100;
		int var2 = 122;		
		long var3 = 100000000000l;
		float var4 = var3;
		double var5 = var4;
		var1 = (byte) var2;
		
	}

}
