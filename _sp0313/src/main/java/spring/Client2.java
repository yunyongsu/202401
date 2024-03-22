package spring;



public class Client2 {

	private String host;
	
	public void send() {
		System.out.println("Client.send() to " + host);
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	public void close() {
		System.out.println("Client.close 실행");
	}

	public void connect(){
		System.out.println("Cilent.connect 실행");
	}

}
