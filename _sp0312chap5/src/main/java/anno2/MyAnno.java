package anno2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//적용대상 : method
@Target (ElementType.METHOD)
//유지정책 : runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
	
	public String value();

}
