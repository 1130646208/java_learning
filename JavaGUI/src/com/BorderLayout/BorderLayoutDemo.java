/**
 * BorderLayout��ʾ
 */
/**
 * ����
 * 1 �̳�JFrame
 * 2 ������Ҫ�����
 * 3 ������������캯����
 * 4 �����������ʵ�λ��
 * 5 ���ô�������
 */
package com.BorderLayout;
import java.awt.*;
import javax.swing.*;
public class BorderLayoutDemo extends JFrame{

	JButton jb1,jb2,jb3,jb4,jb5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BorderLayoutDemo bld=new BorderLayoutDemo();
	}
	public BorderLayoutDemo()
	{
		//�������
		jb1=new JButton("��");
		jb2=new JButton("��");
		jb3=new JButton("��");
		jb4=new JButton("��");
		jb5=new JButton("��");
		
		//��Ӹ������
		
		//this.add(jb1,BorderLayout.CENTER);
		this.add(jb2,BorderLayout.EAST);
		this.add(jb3,BorderLayout.SOUTH);
		this.add(jb4,BorderLayout.WEST);
		this.add(jb5,BorderLayout.NORTH);
		
		//���ô�������
		this.setTitle("��ʾ�߽粼�ֹ�����");
		this.setSize(200,200);
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
