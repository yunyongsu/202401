package ex.string;

public class StringTrimEx {

	public static void main(String[] args) {
		String str = "     가나 다  ";
		System.out.println(str);
		System.out.println(str.trim());   //앞뒤 공백 제거
		
		//문자열로 변환
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(true);
		
		System.out.println(str1 + 30); //1030
		System.out.println(str2 + 10); //10.510
	}

}
