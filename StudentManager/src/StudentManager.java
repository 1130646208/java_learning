import java.util.LinkedList;
import java.util.Scanner;

public class StudentManager {
	private LinkedList<Students> message = new LinkedList<>();
	private Scanner sc = new Scanner(System.in);

	public void mainInterface() {
		System.out.println("��������ִ����صĲ�����");
		System.out.println("1����µ�ѧ��\t2ɾ��ѧ��\t3�鿴����ѧ��");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			inputMessage();
			System.out.println("����ɹ�");
			mainInterface();
			break;
		case 2:
			if (delete()) {
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("δ�ҵ�");
			}
			mainInterface();
			break;
		case 3:
			showMessage();
			System.out.println("\n\n�����������");
			sc.next();
			mainInterface();
		}

	}

	public void inputMessage() {
		System.out.println("������ѧ��");
		String number = sc.next();
		try {
			if (message.size() > 0) {
				for (Students s : message) {
					if (number.equals(s.getNumber())) {
						throw new Exception();
					}
				}
			}
			System.out.println("����������");
			String name = sc.next();
			int[] a = new int[4];
			String[] gradesname = { "�����ɼ�:", "����ɼ�:", "Java�γɼ�:", "Ӣ��γɼ�:" };
			for (int i = 0; i < 4; i++) {
				System.out.print(gradesname[i]);
				int grades = sc.nextInt();
				a[i] = grades;
			}
			Students newstudent = new Students(number, name, a);
			message.add(newstudent);
		} catch (Exception e) {
			System.out.println("ѧ���Ѵ���,����������");
			inputMessage();
		}
	}

	public boolean delete() {
		boolean t = false;
		showMessage();
		System.out.println("����Ҫɾ����ѧ��:");
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
		System.out.println("����\t\tѧ��\t\t����\t\t����\t\tJava\t\tӢ��");
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
