package thread;

public class Ex04 {

	public static void main(String[] args) {
		WorkerThread wh = new WorkerThread();
		wh.start();
		mainTask();

	}
	public static void mainTask() {
		for (int i = 0; i < 5; i++) {
			System.out.println("진행");
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
