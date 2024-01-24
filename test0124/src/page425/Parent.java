package page425;

public class Parent {
	void parentMethod() {};
}
class child extends Parent{
}
class A{
	void method1(Parent p) {}
	void method2() {
		method1(new Parent());
	}
	
	Parent field = new Parent() {
		@Override
		void parentMethod() {
			super.parentMethod();
		}
		
	};
	void method() {
		Parent var = new Parent() {

			@Override
			void parentMethod() {
				super.parentMethod();
			}
			
		};
	}
}
