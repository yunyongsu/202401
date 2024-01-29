package ex.string;

public class StringCompEx {

	public static void main(String[] args) {
		String str1 = "aBc";
		String str2 = "Abc";
		
		System.out.println(str1.toUpperCase());
		System.out.println(str2.toLowerCase());
		
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("같다");
		}

	}

}
