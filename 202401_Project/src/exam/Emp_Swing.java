package exam;

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
import java.util.ArrayList;
import java.util.List;
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

	JLabel lb1 = new JLabel("사원번호:");
	JTextField tf1 = new JTextField(5);
	JLabel lb2 = new JLabel("사원이름:");
	JTextField tf2 = new JTextField(5);
	JLabel lb3 = new JLabel("부서직책:");
	JTextField tf3 = new JTextField(5);
	JLabel lb4 = new JLabel("사수번호:");
	JTextField tf4 = new JTextField(5);
	JLabel lb5 = new JLabel("입사일:");
	JTextField tf5 = new JTextField(5);
	JLabel lb6 = new JLabel("월급:");
	JTextField tf6 = new JTextField(5);
	JLabel lb7 = new JLabel("인센티브:");
	JTextField tf7 = new JTextField(5);
	JLabel lb8 = new JLabel("부서번호:");
	JTextField tf8 = new JTextField(5);

	JButton bt1 = new JButton("전체 내용");
	JButton bt2 = new JButton("입력");
	JButton bt3 = new JButton("사원 검색");
	JButton bt4 = new JButton("수정");
	JButton bt5 = new JButton("삭제");
	JTextArea ta = new JTextArea(20, 60);
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
		jp3.add(lb4);
		jp3.add(tf4);
		jp3.add(lb5);
		jp3.add(tf5);
		jp3.add(lb6);
		jp3.add(tf6);
		jp3.add(lb7);
		jp3.add(tf7);
		jp3.add(lb8);
		jp3.add(tf8);

		this.setTitle("EMP_Manager");
		this.setLocation(500, 400);
		this.setSize(1000, 450);
		this.setVisible(true);

		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearTextField();
				select();
			}
		});
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				insert();
				clearTextField();
			}
		});
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		bt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				clearTextField();
			}
		});
		bt5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
				clearTextField();
			}
		});
	}

	private void clearTextField() {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf6.setText("");
		tf7.setText("");
		tf8.setText("");
	}

	public void select() {
		String sql = "select * from emp";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			ta.setText("");
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				String str = String.format("%d, %s, %s, %d, %s, %.2f, %.2f, %d\n", empno, ename, job, mgr, hiredate,
						sal, comm, deptno);
				ta.append(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert() {
		if (TextFieldEmpty()) {
			ta.setText("모든 정보를 입력하세요.");
			return;
		}
		try {
			String sql = String.format("insert into emp values(%s, '%s', '%s', %s, '%s', %s, %s, %s)", tf1.getText(),
					tf2.getText(), tf3.getText(), tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText(),
					tf8.getText());
			int result = stmt.executeUpdate(sql);
			ta.setText("");
			ta.append("입력이 완료되었습니다.");
		} catch (Exception e) {
			ta.append("입력에 실패했습니다.");
			ta.append("숫자 형식에 맞게 입력하세요.");
		}
	}

	public void search() {
		String sql = String.format(
				"select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where ename = '%s'",
				tf2.getText());
		try {
			ResultSet rs = stmt.executeQuery(sql);
			ta.setText("");
			if (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				String str = String.format("%d, %s, %s, %d, %s, %.2f, %.2f, %d\n", empno, ename, job, mgr, hiredate,
						sal, comm, deptno);
				ta.append(str);
				tf1.setText(empno + "");
				tf2.setText(ename);
				tf3.setText(job);
				tf4.setText(mgr + "");
				tf5.setText(hiredate);
				tf6.setText(sal + "");
				tf7.setText(comm + "");
				tf8.setText(deptno + "");

			} else {
				ta.append("사원 이름을 검색해주세요.");
				clearTextField();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void delete() {
		if (!tf2.getText().isEmpty()) {
			try {
				String sql = String.format("delete from emp where ename = '%s'", tf2.getText());
				int result = stmt.executeUpdate(sql);
				ta.setText("");
				ta.append("삭제가 완료되었습니다.");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			ta.setText("사원 이름을 입력해 주세요.");
		}
	}

	public void update() {
		if (TextFieldEmpty()) { // 하나라도 비어있는지 확인
			ta.setText("모든 정보를 입력하세요.");
			return;
		}
		String sql = String.format(
				"update emp set empno=%s, job='%s', mgr=%s, hiredate='%s', sal=%s, comm=%s, deptno=%s where ename='%s'",
				tf1.getText(), tf3.getText(), tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText(), tf8.getText(),
				tf2.getText());
		try {
			int result = stmt.executeUpdate(sql);
			if (result >= 1) {
				ta.setText("수정이 완료되었습니다.");
				}else {
				ta.setText("이름은 변경할 수 없습니다.");
			}
		} catch (SQLException e) {
			ta.setText("숫자 형식에 맞게 입력하세요.");
		}
	}

	private boolean TextFieldEmpty() {
			//List.of = 불변 리스트 생성, 추가/제거 불가, final 같은 느낌?
//		List<JTextField> list = new ArrayList<>(List.of(tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8));
//		list.add(tf1); list.add(tf2); list.add(tf3); list.add(tf4);
//		list.add(tf5); list.add(tf6); list.add(tf7); list.add(tf8);
		JTextField[] textFields = {tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8};
		for (JTextField Jt : textFields) {
			if (Jt.getText().isEmpty()) {
				return true; // 하나라도 비어있으면 true 반환
			}
		}

		return false; // 모두 비어있지 않으면 false 반환
	}

	public static void main(String[] args) {
		new Emp_Swing();

	}

}
