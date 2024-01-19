package ArrayFramework;

import java.util.ArrayList;
import java.util.List;

class Student{
	String name;
	int kor;

	public Student(String name, int kor) {
		this.name = name;
		this.kor = kor;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + "]";
	}
	

}

public class ArrayListEx {

	public static void main(String[] args) {
		List<Student> slist = new ArrayList<>();
		slist.add(new Student("홍길동", 80));
		slist.add(new Student("YUN", 70));
		
		for(Student str : slist) {
			System.out.println(str);
		}	
		
		
		
		
//		ArrayList<String> list = new ArrayList<String>();
//		//문자열을 가변적인 배열로 만듦
//		List<String> alist = new ArrayList<>();    //List는 ArrayList의 부모클래스
//		//축약형
//		list.add("Java");
//		list.add("JDBC");
//		list.add("YUN");
//		
//		for(String str : alist) {
//			System.out.println(str);
//		}
//		String skill = list.get(2);
//		System.out.println(skill);
//		
//		list.set(1, "YONGSU");
//		for(String str : alist) {
//		System.out.println(str);
//		}

	}

}
