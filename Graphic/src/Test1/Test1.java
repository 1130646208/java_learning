package Test1;
/**
 * Java��ͼԭ����
 * @author wsx
 *
 */
import java.awt.*;
import javax.swing.*;

public class Test1 extends JFrame{
	MyPanel mp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test1 t=new Test1();
		
	}
	public Test1(){
		mp=new MyPanel();
		this.add(mp);
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
class MyPanel extends JPanel{
	//����JPanel��paint����
	//Graphics�ǻ�ͼ����Ҫ�� �൱��һ֧����
	int i=0;
	public void paint(Graphics g){
		//���ø��ຯ����ɳ�ʼ��
		super.paint(g);
//		g.setColor(Color.CYAN);
//		System.out.println("����"+i++);
//		//��Բ
//		g.drawOval(10, 10, 30, 30);
//		//����ֱ��
//		g.drawLine(50, 50, 100, 100);
//		//�����α߿�
//		g.draw3DRect(70, 70, 90, 90, false);
		//����һ��ͼƬ
//		Image im=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1.jpg"));
//		g.drawImage(im, 10, 10, 500, 500, this);
		g.setColor(Color.red);
		g.setFont(new Font("΢���ź�",Font.BOLD,100));
		g.drawString("�������", 200, 200);
		g.drawArc(100, 100, 100, 100, 500, 50);
		g.drawRect(100, 100, 100, 100);
		
	}
}