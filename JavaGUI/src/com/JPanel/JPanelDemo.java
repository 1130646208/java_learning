package com.JPanel;
import java.awt.*;
import javax.swing.*;
/**
 * Panel演示
 * @author wsx
 *
 */
public class JPanelDemo extends JFrame{
	//定义组件
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String []args){
		JPanelDemo jpd=new JPanelDemo();
	}
	
	//构造函数
	
	public JPanelDemo(){
		jp1=new JPanel();
		jp2=new JPanel();
		
		jb1=new JButton("西瓜");
		jb2=new JButton("苹果");
		jb3=new JButton("荔枝");
		jb4=new JButton("葡萄");
		jb5=new JButton("橘子");
		jb6=new JButton("香蕉");
		//设置布局
		
		
		
		//添加组件
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jb6,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);
		
		this.setSize(300,200);
		this.setLocation(500,500);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
