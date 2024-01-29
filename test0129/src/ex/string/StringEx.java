package ex.string;

public class StringEx {

	public static void main(String[] args) {
		String aaa = "aaa";
		String bbb = "bbb";
		
		StringBuilder sb = new StringBuilder();
		sb.append(aaa);
		sb.append(bbb);
		System.out.println(sb);
		
		//비교
		String str = aaa + bbb;
		System.out.println(str);
		
		//비교
		String str1 = aaa.concat(bbb);
		System.out.println(str1);

	}

}
