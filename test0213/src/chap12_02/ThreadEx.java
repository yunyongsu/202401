package chap12_02;

public class ThreadEx {

	public static void main(String[] args) {
		Thread mth = Thread.currentThread();
		System.out.println(mth.getName());
		
		Thread thread1 = new MovieThread();
		System.out.println(thread1.getName());
		thread1.start();
		
		
		Thread thread2 = new Thread(new MusicRunnable());
		thread2.setName("Music");
		System.out.println(thread2.getName());
		thread2.start();

	}

}
