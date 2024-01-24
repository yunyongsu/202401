package swing_Test2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	JLabel lb1 = new JLabel("이름1:");
	JTextField tf1 = new JTextField(5);
	JButton bt1 = new JButton("버튼1");
	JLabel lb2 = new JLabel("이름2:");
	JTextField tf2 = new JTextField(5);
	JButton bt2 = new JButton("종료");
	JLabel lb3 = new JLabel("메세지를 보여 줍니다.");
	JTextArea ta1 = new JTextArea(5,10);
	
	public MyFrame() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container con = this.getContentPane();
		con.setLayout(new FlowLayout());
		con.add(lb1);
		con.add(tf1);
		con.add(bt1);
		con.add(lb2);
		con.add(tf2);
		con.add(bt2);
		con.add(lb3);
		JScrollPane scroll = new JScrollPane(ta1);
//		scroll.setSize(30,30);
		con.add(ta1);
		this.setTitle("자바 스윙");
		this.setSize(400, 300);
		this.setLocation(700, 400);
		this.setVisible(true);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1");
				lb3.setText("버튼1을 클릭했습니다.");
			}
		});
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				confirmExit();
			}
		});
		//파일 읽기 작업 처리
		JOptionPane.showMessageDialog(this, "파일을 읽었습니다.", "파일 읽기", JOptionPane.INFORMATION_MESSAGE);
	}

	public void confirmExit() {
		int answer = JOptionPane.showConfirmDialog(this, "종료하시겠습니까", "confirm", JOptionPane.YES_NO_OPTION);
		if(answer == JOptionPane.YES_OPTION) {
			System.out.println("프로그램을 종료합니다.");
			//파일로 객체를 보내는 일(저장)
			System.exit(0);
		} else {
			System.out.println("종료를 취소합니다");
		}
		
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}