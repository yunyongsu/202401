package anno2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import anno1.MyAnnotation;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		String className = "anno2.Target";
		Class<?> cls = Class.forName(className);
		Target a = (Target) cls.getDeclaredConstructor().newInstance();
		a.sub();
		
		Method[] methods = cls.getDeclaredMethods();
		for( int i=0; i<methods.length; i++) {
			if(methods[i].isAnnotationPresent(MyAnno.class)) {
				MyAnno myAnno = methods[i].getAnnotation(MyAnno.class);
				System.out.println(myAnno.value());
			}
			if(methods[i].isAnnotationPresent(MyAnnotation.class)) {
				MyAnnotation annotation = methods[i].getDeclaredAnnotation(MyAnnotation.class);
				String value = annotation.value();
				System.out.println(methods[i].getName() + " : " + value);
			}
		}
		
//		Method method = Target.class.getMethod("sub");
//		Annotation[] annotations = method.getDeclaredAnnotations();
//
//		for (Annotation anno : annotations) {
//			MyAnno myAnno = (MyAnno) anno;
//			System.out.println(myAnno.value());
//		}
	}

}
