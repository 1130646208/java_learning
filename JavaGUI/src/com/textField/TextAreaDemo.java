package com.textField;
/**
 * �����ı�����ʾ
 */
import java.awt.*;
import javax.swing.*;
public class TextAreaDemo extends JFrame{
	JTextArea jta;
	JScrollPane jsp;
	JComboBox jcb;
	JTextField jtf;
	JButton jb;
	JPanel jp1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextAreaDemo tad=new TextAreaDemo();
	}

	public TextAreaDemo(){
		//�ϰ벿��

		jta=new JTextArea();
		jsp=new JScrollPane(jta);//�����ڴ���֮����jsp.add()
		//�°벿��
		String chatter[]={"С��","С��","������","ϰ��ƽ","ϣ����","ë����"};
		jcb=new JComboBox(chatter);
		jtf=new JTextField(10);
		jb=new JButton("����");
		jp1=new JPanel();
		jp1.add(jcb);
		jp1.add(jtf);
		jp1.add(jb);
		
		//��ӵ�������
		
		this.add(jsp);
		this.add(jp1,BorderLayout.SOUTH);
		//��������
		//����Сͼ��
		this.setIconImage(new ImageIcon("Images\\icon.PNG").getImage());
		this.setSize(300,200);
		this.setTitle("��ѶQQ");
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
}
