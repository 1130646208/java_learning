package com.wsx.ComBox;
import java.awt.*;
import javax.swing.*;
/**
 * JComboBox(������) JList(�б�) JScrollPane(������)
 * @author wsx
 *
 */
public class ComBox extends JFrame{
	//�������
	JPanel jp1,jp2;
	JLabel jl1,jl2;
	JComboBox jcb1;
	JList jlist;
	JScrollPane jsp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComBox c=new ComBox();
		
	}
	public ComBox(){
		//�������
		jp1=new JPanel();
		jp2=new JPanel();
		
		jl1=new JLabel("����");
		jl2=new JLabel("���εص�");
		
		String []jg={"����","���","�Ϻ�","����"};
		jcb1=new JComboBox(jg);
		
		String []dd={"��կ��","�찲��","�ʹ�","����","��ɽ"};
		jlist =new JList(dd);
		jlist.setVisibleRowCount(2);
		//��list��ӵ�scrollpane
		jsp=new JScrollPane(jlist);
		
		
		//���ò���
		this.setLayout(new GridLayout(2,1));
		//������
		
		jp1.add(jl1);
		jp1.add(jcb1);
		
		jp2.add(jl2);
		jp2.add(jsp);
		
		this.add(jp1);
		this.add(jp2);
		//���ô�������
		this.setSize(300,250);
		this.setTitle("����");
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setResizable(false);
		
	}
	

}
