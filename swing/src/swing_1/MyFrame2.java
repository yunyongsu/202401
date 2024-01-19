package swing_1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame implements ActionListener, MouseListener{
	JButton jb = new JButton("클릭");
	JButton jb2 = new JButton("클릭");
	public MyFrame2() {
		Container con = this.getContentPane();    //JFrame에 있는 컨텐츠들을 불러올 때 사용
		con.setLayout(null);  //컨테이너에 추가되는 구성 요소(버튼, 텍스트 필드 등)를 자유롭게 움직일 수 있게 사용
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 프레임을 닫을 때 프로그램을 종료하라는 것
		this.setVisible(true);	//프레임이 눈에 보이도록 설정
		this.setSize(1020, 650);
		this.setLocation(300,200);
		this.setTitle("냠냠쩝쩝");
		
		con.addMouseListener(this);
		con.setLayout(new FlowLayout());
		
		con.add(jb);
		jb.addActionListener(this);
		JButton jb2 = new JButton("클릭");
		con.add(jb2);
		jb2.addActionListener(this);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb) {
			System.out.println("버튼1");
		}else if(e.getSource()==jb2) {
			System.out.println("버튼2");
		}
	
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + ", " + e.getY());
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}


}
