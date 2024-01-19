package sec05.exam02;

public class StudentService {
	Student student = new Student();
	
	private static StudentService studentEx = new StudentService();
	
	private StudentService() {
	}
	public static StudentService getInstance() {
		return studentEx;
	}
}
