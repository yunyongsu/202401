package anno2;

import anno1.MyAnnotation;

public class Target {
	@MyAnnotation(value = "sssss")
	@MyAnno(value = "연습")
	public void sub() {
		System.out.println("Target");
	}
}
