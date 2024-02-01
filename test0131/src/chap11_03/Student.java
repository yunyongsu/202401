package chap11_03;


public class Student {
	private String studentNum;
	
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getStudentNum() {
		return studentNum;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) { // Key클래스의 객체인지
			Student student = (Student) obj;	// Key 클래스 강제 형변환
			if (studentNum.equals(student.getStudentNum()));	//number 비교
			{
				return true;
			}
		}
		return false;
		
	}
	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}
	
}
