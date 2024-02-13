package chap12_02;

public class MovieThread extends Thread{
	
	public MovieThread() {
		this.setName("Movie");
	}

	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
//			System.out.println("동영상을 재생합니다");
			System.out.println(this.getName());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
			}
		}
	}
	

}
