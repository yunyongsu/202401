package sec02.exam03;

public class Window {
	Button bt1 = new Button();
	Button bt2 = new Button();
	
	Button.OnClickListener listener = new Button.OnClickListener() {
		
		@Override
		public void onClick() {
			System.out.println("전화를 건다");
		}
	};
	Window(){
		bt1.setOnClickListener(listener);{
		bt2.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("메시지를 보낸다");
			}
		});
		}
		
	}
}
