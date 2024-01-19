package proxy;

public class Client {

	public static void main(String[] args) {
//		ISubJect sub1 = new RealSubject();
//		sub1.action();
		
		ISubJect sub = new Proxy(new RealSubject());
		sub.action();
	}

}
