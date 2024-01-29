package swing_Project;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MyFrame extends JFrame implements ActionListener {
	List<Account> list = new ArrayList<>();
	JButton jb1 = new JButton("전체내용");
	JButton jb2 = new JButton("입력");
	JButton jb3 = new JButton("조회");
	JButton jb4 = new JButton("수정");
	JButton jb5 = new JButton("삭제");
	JButton jb6 = new JButton("x");
	
	JTextField jt1 = new JTextField();
	JTextField jt2 = new JTextField();
	JTextField jt3 = new JTextField();
	JTextField jt4 = new JTextField();
	JTextField jt5 = new JTextField();
	JTextField jt6 = new JTextField();
	
	JLabel lb7 = new JLabel("메시지: ");

	JTextArea ta = new JTextArea();
	
	public MyFrame() {

		Container con = this.getContentPane();
		con.setLayout(null);
		
		con.add(lb7);
		lb7.setLocation(40, 420);
		lb7.setSize(400, 30);

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
		
		jb6.addActionListener(this);
		con.add(jb6);
		jb6.setLocation(950, 10);
		jb6.setSize(50, 20);

		JScrollPane scroll = new JScrollPane(ta);
		scroll.setLocation(25, 100);
		scroll.setSize(950,350);
		con.add(scroll);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(1020, 650);
		this.setVisible(true); // 윈도우 프레임을 보이게
		this.setTitle("어마어마해");
		this.setLocation(300, 200);

		
		
		jb6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				confirmExit();
			}
		});
	}
	public void confirmExit() {
		int answer = JOptionPane.showConfirmDialog(this, "종료하시겠습니까", "confirm", JOptionPane.YES_NO_OPTION);
		if(answer == JOptionPane.YES_OPTION) {
			System.out.println("프로그램을 종료합니다.");
			try {
				saveAccountsToFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		} else {
			System.out.println("종료를 취소합니다");
		}
		
	}
    private void saveAccountsToFile() throws IOException {
    	FileOutputStream fos = new FileOutputStream("c:/temp/acc.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
    }
    private void loadAccountsFromFile() {
        try {
            FileInputStream fis = new FileInputStream("c:/temp/acc.db");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Account> loadedList = (List<Account>) ois.readObject();
            ois.close();

            list.addAll(loadedList);

            lb7.setText("파일에서 데이터를 불러왔습니다.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            lb7.setText("파일 읽기 오류");
        }
    }

   

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "전체내용":
			lb7.setText("전체내용");
			for (Account acc : list) {
				ta.append(acc.toString());
				ta.append("\n");
			}
			break;
		case "입력":
			System.out.println("입력");
//			System.out.printf("%s, %s, %s, %s, %s, %s\n", jt1.getText(),jt2.getText(),
//								jt3.getText(),jt4.getText(),jt5.getText(),jt6.getText());
//			list.add(new Account(jt1.getText(),jt2.getText(), jt3.getText(),jt4.getText(),jt5.getText(),Integer.parseInt(jt6.getText())));
			String name = jt1.getText();
			String id = jt2.getText();
			String pass = jt3.getText();
			String tel = jt4.getText();
			String ssn = jt5.getText();
			int balance = Integer.parseInt(jt6.getText());
			Account acc = new Account(name, id, pass, tel, ssn, balance);
			list.add(acc);
			lb7.setText(acc.toString());
//			list.add(new Account(name, id, pass, tel, ssn, balance));
//			String str = String.format("%s, %s, %s, %s, %s, %s\n",name, id, pass, tel, ssn, balance);
//			lb7.setText(str);
			
			break;
		case "조회":
			loadAccountsFromFile();
			break;
		case "수정":
			System.out.println("수정");
			break;
		case "삭제":
			System.out.println("삭제");
			break;
		}
	}
	public static void main(String[] ar) {
		new MyFrame();
	}
}
