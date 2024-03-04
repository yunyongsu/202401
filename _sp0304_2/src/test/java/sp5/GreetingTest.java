package sp5;

import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class GreetingTest {
	private Greeting target = new Greeting();
	
	@Test
	public void getMessage_아침인사() {
		String msg = this.target.getMessage(5);
		assertThat(msg, is("좋은 아침입니다"));
	}
	@Test
	public void getMessage_평시() {
		String msg = this.target.getMessage(11);
		assertThat(msg, is("안녕하십니까"));
	}
	@Test
	public void getMessage_저녁인사() {
		String msg = this.target.getMessage(17);
		assertThat(msg, is("수고 많으십니다"));
	}
}
