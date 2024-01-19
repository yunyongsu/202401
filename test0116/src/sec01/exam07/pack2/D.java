package sec01.exam07.pack2;

import sec01.exam07.pack1.A;

public class D extends A{
		D() {
		this.field = "value";
		this.method();
	}
		public void method() {
			this.field = "value";
			this.method();
		}
}
