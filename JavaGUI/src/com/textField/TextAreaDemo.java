package com.textField;
/**
 * 多行文本域演示
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
		//上半部分

		jta=new JTextArea();
		jsp=new JScrollPane(jta);//不能在创建之后用jsp.add()
		//下半部分
		String chatter[]={"小明","小红","本拉登","习近平","希特勒","毛阿敏"};
		jcb=new JComboBox(chatter);
		jtf=new JTextField(10);
		jb=new JButton("发送");
		jp1=new JPanel();
		jp1.add(jcb);
		jp1.add(jtf);
		jp1.add(jb);
		
		//添加到主窗口
		
		this.add(jsp);
		this.add(jp1,BorderLayout.SOUTH);
		//窗口设置
		//设置小图标
		this.setIconImage(new ImageIcon("Images\\icon.PNG").getImage());
		this.setSize(300,200);
		this.setTitle("腾讯QQ");
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
}
