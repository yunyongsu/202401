package swing_0123;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class MyFrameSample extends JFrame{
	public MyFrameSample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		con.setLayout(new FlowLayout());
		setLocation(500, 400);
		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrameSample();

	}

}
