package com.CheckRadioDemo;
import java.awt.*;
import javax.swing.*;
/**
 * ��ѡ��RadioBox����ѡ����ʾCheckBox
 * @author wsx
 *
 */
public class Check extends JFrame{
	//�������
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;//��ѡ��
	JRadioButton jrb1,jrb2;  //��ѡ��
	ButtonGroup bg;
	public static void main(String []args){
		Check c =new Check();
	}
	
	
	public Check(){
		//panel
		jp1= new JPanel();
		jp2= new JPanel();
		jp3= new JPanel();
		//��ǩ
		jl1= new JLabel("ϲ�����˶�");
		jl2= new JLabel("�Ա�");
		//��ť
		jb1= new JButton("ע��");
		jb2= new JButton("ȡ��");
		//��ѡ��
		jcb1=new JCheckBox("����");
		jcb2=new JCheckBox("����");
		jcb3=new JCheckBox("����");
		//��ѡ��
		jrb1= new JRadioButton("��");
		jrb2= new JRadioButton("Ů");
		//Ҫ��jrb1��jrb2����һ��ButtonGroup
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		//���ò��ֹ���
		this.setLayout(new GridLayout(3,1));
		//������
		jp1.add(jl1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jl2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//���ô�������
		this.setSize(300,150);
		this.setTitle("ע�����");
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		
	}
}
