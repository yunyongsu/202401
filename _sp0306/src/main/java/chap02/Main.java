package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*자바 설정에서 정보를 읽어와 bean 객체를 생성하고 관리하는 클래스
		 AppContext를 생성자 파라미터로 전달하여 객체를 사용할 수 있게 한다.
		 ctx라는 '컨테이너'에서 bean이라는 물건(객체)을 하나씩 꺼내와 사용*/
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		/*getBean = ctx가 자바 설정을 읽어와 생성한 bean 객체를 검색할 때 사용한다.
		  앞부분은 메서드의 이름, 뒷부분은 리턴타입. */
		Greeter g = ctx.getBean("greeter", Greeter.class);
		/*Greeter 클래스의 greet 메서드를 실행.
		 AppContext에서 생성한 Greeter객체의 format 필드값이 ("%s, 안녕하세요")이므로
		 합치게되면 ("%s, 안녕하세요", "스프링")이 된다.
		 */
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();

	}

}
