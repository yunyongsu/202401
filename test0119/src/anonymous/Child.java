package anonymous;

class Parent {
	void Method() {
	}
}

public class Child extends Parent {

	@Override
	void Method() {
		super.Method();
	}

	public static void main(String[] args) {
		new Child();
		Parent parent = new Parent() {
			@Override
			void Method() {
				super.Method();
			}

		};

	}

}
