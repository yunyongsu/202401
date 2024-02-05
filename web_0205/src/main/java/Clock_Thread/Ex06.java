package Clock_Thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import thread.Task;

public class Ex06 {
	public static void main(String[] args) {
		ExClock clock = new ExClock();
		Thread th = new Thread(clock);
		th.start();
		mainEx();
	}
	public static void mainEx() {
		for(int i = 0; i < 5; i++) {
			System.out.println("beep");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("끝");
	}
}
