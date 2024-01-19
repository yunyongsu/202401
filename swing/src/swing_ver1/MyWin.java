package swing_ver1;

import java.awt.Container;
import java.awt.Frame;

import javax.swing.JFrame;

public class MyWin extends JFrame{
	public MyWin(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		this.setVisible(true);
		this.setSize(1000, 700);
		this.setLocation(500, 200);
		this.setTitle("YUYUYUYUYUN");
		
		
		
	}
	
	
	public static void main(String[] args) {
		new MyWin();

	}

}
