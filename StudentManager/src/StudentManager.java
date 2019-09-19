import java.util.LinkedList;
import java.util.Scanner;

public class StudentManager {
	private LinkedList<Students> message = new LinkedList<>();
	private Scanner sc = new Scanner(System.in);

	public void mainInterface() {
		System.out.println("输入数字执行相关的操作：");
		System.out.println("1添加新的学生\t2删除学生\t3查看所有学生");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			inputMessage();
			System.out.println("输入成功");
			mainInterface();
			break;
		case 2:
			if (delete()) {
				System.out.println("删除成功");
			} else {
				System.out.println("未找到");
			}
			mainInterface();
			break;
		case 3:
			showMessage();
			System.out.println("\n\n按任意键返回");
			sc.next();
			mainInterface();
		}

	}

	public void inputMessage() {
		System.out.println("请输入学号");
		String number = sc.next();
		try {
			if (message.size() > 0) {
				for (Students s : message) {
					if (number.equals(s.getNumber())) {
						throw new Exception();
					}
				}
			}
			System.out.println("请输入姓名");
			String name = sc.next();
			int[] a = new int[4];
			String[] gradesname = { "高数成绩:", "大物成绩:", "Java课成绩:", "英语课成绩:" };
			for (int i = 0; i < 4; i++) {
				System.out.print(gradesname[i]);
				int grades = sc.nextInt();
				a[i] = grades;
			}
			Students newstudent = new Students(number, name, a);
			message.add(newstudent);
		} catch (Exception e) {
			System.out.println("学号已存在,请重新输入");
			inputMessage();
		}
	}

	public boolean delete() {
		boolean t = false;
		showMessage();
		System.out.println("输入要删除的学号:");
		String num = sc.next();
		for (Students s : message) {
			if (s.getName().equals(num)) {
				t = true;
				message.remove(s);
			}
		}
		return t;
	}

	public void showMessage() {
		System.out.println("姓名\t\t学号\t\t高数\t\t大物\t\tJava\t\t英语");
		for (Students s : message) {
			System.out.print(s.getName() + "\t\t");
			System.out.print(s.getNumber() + "\t\t");
			for (int i = 0; i < 4; i++) {
				System.out.print(s.getFourgragers()[i] + "\t\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		StudentManager sm = new StudentManager();
		sm.mainInterface();

	}

}

class Students {
	private String number;
	private String name;
	private int[] fourgragers = new int[4];

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getFourgragers() {
		return fourgragers;
	}
     
	public Students(String number, String name, int[] fourgragers) {
		super();
		this.number = number;
		this.name = name;
		this.fourgragers = fourgragers;
	}

	public void setFourgragers(int[] fourgragers) {
		this.fourgragers = fourgragers;
	}

}
