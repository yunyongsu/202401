package sec01.exam01;

public class BeepPrintEx {
	
	public static void main(String[] arg) {
		Thread th = new Thread(new BeepTask());
		th.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}

		}
	}
}