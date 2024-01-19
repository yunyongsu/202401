package sec01.exam2;

import java.rmi.Remote;

public class Ex {

	public static void main(String[] args) {
		RemoteControl rc = new Audio();
		rc.turnOn();
		System.out.println(rc.MAX_VOLUME);


	}

}
