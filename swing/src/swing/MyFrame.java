package swing;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	public MyFrame() {
		Container con = this.getContentPane();
		con.setLayout(null);
		
		JLabel jl = new JLabel("이름");
		con.add(jl);
		jl.setLocation(35, 30);
		jl.setSize(80,30);
		
		JTextField jt1 = new JTextField("");
		con.add(jt1);
		jt1.setLocation(80, 30);
		jt1.setSize(90,30);
		
		JLabel j2 = new JLabel("아이디");
		con.add(j2);
		j2.setLocation(180, 30);
		j2.setSize(80,30);
		
		JTextField jt2 = new JTextField("");
		con.add(jt2);
		jt2.setLocation(230, 30);
		jt2.setSize(90,30);
		
		JLabel j3 = new JLabel("패스워드");
		con.add(j3);
		j3.setLocation(340, 30);
		j3.setSize(80,30);
		
		JTextField jt3 = new JTextField("");
		con.add(jt3);
		jt3.setLocation(410, 30);
		jt3.setSize(90,30);
		
		JLabel j4 = new JLabel("생년월일");
		con.add(j4);
		j4.setLocation(515, 30);
		j4.setSize(80,30);
		
		JTextField jt4 = new JTextField("");
		con.add(jt4);
		jt4.setLocation(580, 30);
		jt4.setSize(90,30);
		
		JLabel j5 = new JLabel("전화");
		con.add(j5);
		j5.setLocation(680, 30);
		j5.setSize(80,30);
		
		JTextField jt5 = new JTextField("");
		con.add(jt5);
		jt5.setLocation(720, 30);
		jt5.setSize(90,30);
		
		JLabel j6 = new JLabel("잔고");
		con.add(j6);
		j6.setLocation(820, 30);
		j6.setSize(80,30);
		
		JTextField jt6 = new JTextField("");
		con.add(jt6);
		jt6.setLocation(860, 30);
		jt6.setSize(90,30);
		
		JButton jb1 = new JButton("버튼");
		con.add(jb1);
		jb1.setLocation(60, 500);
		jb1.setSize(130,40);
		
		JButton jb2 = new JButton("버튼");
		con.add(jb2);
		jb2.setLocation(250, 500);
		jb2.setSize(130,40);
		
		JButton jb3 = new JButton("버튼");
		con.add(jb3);
		jb3.setLocation(430, 500);
		jb3.setSize(130,40);
		
		JButton jb4 = new JButton("버튼");
		con.add(jb4);
		jb4.setLocation(610, 500);
		jb4.setSize(130,40);
		
		JButton jb5 = new JButton("버튼");
		con.add(jb5);
		jb5.setLocation(790, 500);
		jb5.setSize(130,40);
		

		JTextArea ta = new JTextArea();
		ta.setLocation(20, 120);
		ta.setSize(960, 350);
		con.add(ta);

		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1020, 650);
		this.setVisible(true);	//윈도우 프레임을 보이게
		this.setTitle("어마어마해");
		this.setLocation(300,200);
		
	}
	
	public static void main(String[] arg) {
		new MyFrame();	//객체 생성
		
	}
}
