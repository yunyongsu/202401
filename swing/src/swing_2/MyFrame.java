package swing_2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import swing_2.Account;


public class MyFrame extends JFrame implements ActionListener, MouseListener {
	JButton jb1 = new JButton("전체내용");
	JButton jb2 = new JButton("입력");
	JButton jb3 = new JButton("조회");
	JButton jb4 = new JButton("수정");
	JButton jb5 = new JButton("삭제");
	
	JTextField jt1 = new JTextField();
	JTextField jt2 = new JTextField();
	JTextField jt3 = new JTextField();
	JTextField jt4 = new JTextField();
	JTextField jt5 = new JTextField();
	JTextField jt6 = new JTextField();

	public MyFrame() {
		Container con = this.getContentPane();
		con.setLayout(null);

		JLabel jl = new JLabel("이름");
		con.add(jl);
		jl.setLocation(35, 30);
		jl.setSize(80, 30);

		
		con.add(jt1);
		jt1.setLocation(80, 30);
		jt1.setSize(90, 30);

		JLabel j2 = new JLabel("아이디");
		con.add(j2);
		j2.setLocation(180, 30);
		j2.setSize(80, 30);

		
		con.add(jt2);
		jt2.setLocation(230, 30);
		jt2.setSize(90, 30);

		JLabel j3 = new JLabel("패스워드");
		con.add(j3);
		j3.setLocation(340, 30);
		j3.setSize(80, 30);

		
		con.add(jt3);
		jt3.setLocation(410, 30);
		jt3.setSize(90, 30);

		JLabel j4 = new JLabel("생년월일");
		con.add(j4);
		j4.setLocation(515, 30);
		j4.setSize(80, 30);

		
		con.add(jt4);
		jt4.setLocation(580, 30);
		jt4.setSize(90, 30);

		JLabel j5 = new JLabel("전화");
		con.add(j5);
		j5.setLocation(680, 30);
		j5.setSize(80, 30);

		
		con.add(jt5);
		jt5.setLocation(720, 30);
		jt5.setSize(90, 30);

		JLabel j6 = new JLabel("잔고");
		con.add(j6);
		j6.setLocation(820, 30);
		j6.setSize(80, 30);

		
		con.add(jt6);
		jt6.setLocation(860, 30);
		jt6.setSize(90, 30);

		jb1.addActionListener(this);
		con.add(jb1);
		jb1.setLocation(60, 500);
		jb1.setSize(130, 40);

		jb2.addActionListener(this);
		con.add(jb2);
		jb2.setLocation(250, 500);
		jb2.setSize(130, 40);

		jb3.addActionListener(this);
		con.add(jb3);
		jb3.setLocation(430, 500);
		jb3.setSize(130, 40);

		jb4.addActionListener(this);
		con.add(jb4);
		jb4.setLocation(610, 500);
		jb4.setSize(130, 40);

		jb5.addActionListener(this);
		con.add(jb5);
		jb5.setLocation(790, 500);
		jb5.setSize(130, 40);

		JTextArea ta = new JTextArea();
		ta.setLocation(20, 100);
		ta.setSize(960, 350);
		con.add(ta);

		con.addMouseListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1020, 650);
		this.setVisible(true); // 윈도우 프레임을 보이게
		this.setTitle("어마어마해");
		this.setLocation(300, 200);
		
	}
	
	List<Account> list = new ArrayList<>();
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getActionCommand());
		
		
		switch (e.getActionCommand()) {
		case "전체내용":
			System.out.println("전체내용");
			for (Account account : list) {
				System.out.println(account);
			}
			break;
		case "입력":
			System.out.println("입력");
			System.out.printf("%s, %s, %s, %s, %s, %s\n", jt1.getText(),jt2.getText(),
								jt3.getText(),jt4.getText(),jt5.getText(),jt6.getText());
			list.add(new Account(jt1.getText(),jt2.getText(), jt3.getText(),jt4.getText(),jt5.getText(),Integer.parseInt(jt6.getText())));
			break;
		case "조회":
			System.out.println("조회");
			break;
		case "수정":
			System.out.println("수정");
			break;
		case "삭제":
			System.out.println("삭제");
			break;
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

	public static void main(String[] arg) {
		new MyFrame(); // 객체 생성

	}
}
