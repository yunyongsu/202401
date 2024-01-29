package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Emp_Swing extends JFrame {

	static Scanner scan = new Scanner(System.in);

	JLabel lb1 = new JLabel("부서코드:");
	JTextField tf1 = new JTextField(5);
	JLabel lb2 = new JLabel("부서명:");
	JTextField tf2 = new JTextField(5);
	JLabel lb3 = new JLabel("부서위치:");
	JTextField tf3 = new JTextField(5);

	JButton bt1 = new JButton("전체 내용");
	JButton bt2 = new JButton("입력");
	JButton bt3 = new JButton("이름 검색");
	JButton bt4 = new JButton("수정");
	JButton bt5 = new JButton("삭제");
	JTextArea ta = new JTextArea(10, 40);
	Connection conn;
	Statement stmt;

	public Emp_Swing() {
		String url = "jdbc:mysql://localhost:3306/firm";
		String id = "root";
		String pass = "mysql";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());

		JPanel jp1 = new JPanel(new FlowLayout());
		jp1.add(bt1);
		jp1.add(bt2);
		jp1.add(bt3);
		jp1.add(bt4);
		jp1.add(bt5);
		con.add(jp1, BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(ta);

		JPanel jp2 = new JPanel(new FlowLayout());
		con.add(jp2, BorderLayout.CENTER);
		jp2.add(scroll);

		JPanel jp3 = new JPanel(new FlowLayout());
		con.add(jp3, BorderLayout.NORTH);
		jp3.add(lb1);
		jp3.add(tf1);
		jp3.add(lb2);
		jp3.add(tf2);
		jp3.add(lb3);
		jp3.add(tf3);

		this.setTitle("EMP_Manager");
		this.setLocation(500, 400);
		this.setSize(500, 300);
		this.setVisible(true);
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insert();
				clearTextField();
				select();
				
			}
		});
	}
	
	private void clearTextField() {
		tf1.setText(""); tf2.setText(""); tf3.setText("");
	}

	public void select() {
		String sql = "select * from dept";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			ta.setText("");
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				String str = String.format("%d, %s, %s\n", deptno, dname, loc);
				
//				rs.getInt("empno");
//				rs.getString("ename");
//				System.out.print(rs.getString("job") + "\t");
//				System.out.print(rs.getInt("mgr") + "\t");
//				System.out.print(rs.getString("hiredate") + "\t");
//				System.out.print(rs.getString("sal") + "\t");
//				System.out.print(rs.getInt("comm") + "\t");
//				System.out.println(rs.getString("deptno"));
				
				ta.append(str);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void insert() {
		String sql = String.format("insert into dept values(%s,'%s','%s')", tf1.getText(), tf2.getText(), tf3.getText());
		try {
			
			int result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Emp_Swing();

	}

}
