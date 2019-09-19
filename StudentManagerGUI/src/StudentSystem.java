import java.awt.*;
import java.util.*;
import java.util.Map.Entry;
import javax.swing.*;

public class StudentSystem extends JFrame {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Student> information = new HashMap<>();
	private JLabel shownumber = new JLabel("A");
	private JLabel showname = new JLabel("B");
	private JLabel showgrades = new JLabel("C");
	private JLabel showavegrades = new JLabel("D");
	private JButton addstudent = new JButton("添加新的学生");
	private JButton deletestudent = new JButton("删除当前学生");
	private JButton sortbyone = new JButton("按照语文成绩排序");
	private JButton sortbytwo = new JButton("按照数学成绩排序");
	private JButton sortbythree = new JButton("按照英语成绩排序");
	private JButton sortbyfour = new JButton("按照java课成绩排序");
	private JComboBox<String> selectstudent = new JComboBox<>();

	public StudentSystem() {
		Font t = new Font("", 0, 20);
		Student[] stu = new Student[3];
		for (int k = 0; k < 3; k++) {
			int sum = 0;
			int[] grades = new int[4];
			for (int i = 0; i < 4; i++) {
				grades[i] = (int) (Math.random() * 100);
				sum += grades[i];
			}
			switch (k) {
			case 0:
				stu[k] = new Student(k + 1, "张三", grades, sum / 4);
				selectstudent.addItem(stu[k].getName());
				information.put(stu[k].getName(), stu[k]);
				break;
			case 1:
				stu[k] = new Student(k + 1, "李四", grades, sum / 4);
				selectstudent.addItem(stu[k].getName());
				information.put(stu[k].getName(), stu[k]);
				break;
			case 2:
				stu[k] = new Student(k + 1, "王五", grades, sum / 4);
				selectstudent.addItem(stu[k].getName());
				information.put(stu[k].getName(), stu[k]);
			}
		}
		shownumber.setFont(t);
		showname.setFont(t);
		showgrades.setFont(t);
		showavegrades.setFont(t);
		showMessage(stu[0], 1, stu[0].getName(), stu[0].getGrades(), stu[0].getAvegrades());
	}

	private void showMessage(Student s, int number, String name, int[] grades, float avegrades) {
		shownumber.setText("学号：" + s.getNumber());
		showname.setText("姓名：" + s.getName());
		String str = "";
		for (int i : grades) {
			str += i + "   ";
		}
		showgrades.setText("语文，数学，英语，java课成绩依次为：" + str);
		showavegrades.setText("平均分为：" + s.getAvegrades());
	}

	class AddInterface extends JFrame {
		private static final long serialVersionUID = 1L;

		public AddInterface() {
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			JPanel center = new JPanel();
			JPanel south = new JPanel();
			JButton yes = new JButton("确定");
			JButton no = new JButton("取消");
			JTextArea ja0 = new JTextArea();
			JTextArea ja1 = new JTextArea();
			JTextArea ja2 = new JTextArea();
			JLabel l0 = new JLabel("学号");
			JLabel l1 = new JLabel("姓名");
			JLabel l2 = new JLabel("成绩（请用逗号分开）");
			south.add(yes);
			south.add(no);
			yes.addActionListener(e -> {
				int number = Integer.parseInt(ja0.getText());
				String name = ja1.getText();
				String[] sgrades = ja2.getText().split(",");
				int[] grades = new int[4];
				int sum = 0;
				for (int i = 0; i < 4; i++) {
					grades[i] = Integer.parseInt(sgrades[i]);
					sum += grades[i];
				}
				Student newstudent = new Student(number, name, grades, sum / 4);
				information.put(name, newstudent);
				selectstudent.addItem(newstudent.getName());
				this.setVisible(false);
			});
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			p1.setLayout(new GridLayout(3, 1, 20, 20));
			p2.setLayout(new GridLayout(3, 1, 20, 20));
			p2.add(ja0);
			p2.add(ja1);
			p2.add(ja2);
			p1.add(l0);
			p1.add(l1);
			p1.add(l2);
			center.setLayout(new BorderLayout());
			center.add(p1, BorderLayout.WEST);
			center.add(p2, BorderLayout.CENTER);
			this.add(center, BorderLayout.CENTER);
			this.add(south, BorderLayout.SOUTH);
			this.setSize(300, 170);
			this.setLocation(450, 150);
			this.setVisible(true);
		}
	}

	private Student findStudent() {
		String message = (String) selectstudent.getSelectedItem();
		Student x = null;
		for (String key : information.keySet()) {
			x = information.get(key);
			if (x.getName() == message) {
				break;
			}
		}
		return x;
	}

	private String sort(int pos) {
		int[] sortgra = new int[information.size()];
		int i = 0;
		StringBuilder sb = new StringBuilder();
		String[] sortname = new String[information.size()];
		for (String key : information.keySet()) {
			Student x = information.get(key);
			sortgra[i] = x.getGrades()[pos];
			sortname[i++] = x.getName();
		}
		boolean t = true;
		while (t) {
			t = false;
			for (int j = 0; j < i - 1; j++) {
				if (sortgra[j] > sortgra[j + 1]) {
					int temp = sortgra[j];
					sortgra[j] = sortgra[j + 1];
					sortgra[j + 1] = temp;
					String str = sortname[j];
					sortname[j] = sortname[j + 1];
					sortname[j + 1] = str;
					t=true;
				}
			}
		}
		for (int j = 0; j < i; j++) {
			sb.append(sortname[j] + " " + sortgra[j] + "< ");
		}
		sb.delete(sb.length() - 2, sb.length());
		return sb.toString();
	}

	public void iniInterface() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addstudent.addActionListener(e -> {
			new AddInterface();
		});
		selectstudent.addActionListener(e -> {
			Student x = findStudent();
			showMessage(x, x.getNumber(), x.getName(), x.getGrades(), x.getAvegrades());
		});
		deletestudent.addActionListener(e -> {
			Student x = findStudent();
			information.remove(x.getName(), x);
			selectstudent.removeItem((String) selectstudent.getSelectedItem());
		});
		sortbyone.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, sort(0));
		});
		sortbytwo.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, sort(1));
		});
		sortbythree.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, sort(2));
		});
		sortbyfour.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, sort(3));
		});
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		north.add(addstudent);
		north.add(deletestudent);
		north.add(selectstudent);
		center.setLayout(new GridLayout(4, 1));
		center.add(shownumber);
		center.add(showname);
		center.add(showgrades);
		center.add(showavegrades);
		south.add(sortbyone);
		south.add(sortbytwo);
		south.add(sortbythree);
		south.add(sortbyfour);
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
		this.setLocation(400, 100);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		StudentSystem s = new StudentSystem();
		s.iniInterface();
	}
}

class Student {
	private int number;
	private String name;
	private int[] grades = new int[4];
	private float avegrades;

	public Student(int number, String name, int[] grades, float avegrades) {
		this.number = number;
		this.name = name;
		this.grades = grades;
		this.avegrades = avegrades;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getGrades() {
		return grades;
	}

	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	public float getAvegrades() {
		return avegrades;
	}

	public void setAvegrades(float avegrades) {
		this.avegrades = avegrades;
	}
}
