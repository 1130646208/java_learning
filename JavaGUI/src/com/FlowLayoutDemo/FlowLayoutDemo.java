package com.FlowLayoutDemo;
import java.awt.*;
import javax.swing.*;


public class FlowLayoutDemo extends JFrame{
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main (String [] args)
	{
		FlowLayoutDemo fld = new FlowLayoutDemo();
	}
	
	//���캯��
	public FlowLayoutDemo()
	{
		//�������
		jb1=new JButton("����");
		jb2=new JButton("�ŷ�");
		jb3=new JButton("����");
		jb4=new JButton("��");
		jb5=new JButton("����");
		jb6=new JButton("κ��");
		
		//������
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		//���ò��ֹ�����
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//���ô�������
		this.setTitle("��ʾ��ʽ���ֹ�����");
		this.setSize(200,200);
		this.setResizable(false);//��ֹ�޸Ĵ��ڴ�С
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
