package swing_ver2;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyWin extends JFrame{
	JLabel lb1 = new JLabel("이름");
	JTextField jt1 = new JTextField(10);
	JButton jb1 = new JButton("버튼");
	
	JLabel lb2 = new JLabel("이름1");
	JTextField jt2 = new JTextField(10);
	JButton jb2 = new JButton("버튼1");
	
	
	
	public MyWin(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		this.setVisible(true);
		this.setSize(700, 500);
		this.setLocation(500, 200);
		this.setTitle("YUYUYUYUYUN");
		
		con.setLayout(new FlowLayout());
		con.add(lb1);	con.add(jb1);	con.add(jt1);
		con.add(lb2);	con.add(jb2);	con.add(jt2);
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		new MyWin();

	}

}
