package sec05.exam02;

public class StudentEx {

	public static void main(String[] args) {
		StudentService ss = StudentService.getInstance();
		ss.student.name = "yun";
		ss.student.hakbun = "240115";
		ss.student.kor = 54;
		ss.student.math = 69;
		ss.student.eng = 79;
		
		
		StudentService ss1 = StudentService.getInstance();
		System.out.println(ss.student.name);
		System.out.println(ss1.student.name);
		if(ss.student.equals(ss1.student)) {
			System.out.println("같다");
		}
	}

}
