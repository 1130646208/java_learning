package com.FlowLayoutDemo;
import java.awt.*;
import javax.swing.*;


public class FlowLayoutDemo extends JFrame{
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main (String [] args)
	{
		FlowLayoutDemo fld = new FlowLayoutDemo();
	}
	
	//构造函数
	public FlowLayoutDemo()
	{
		//创建组件
		jb1=new JButton("关羽");
		jb2=new JButton("张飞");
		jb3=new JButton("赵云");
		jb4=new JButton("马超");
		jb5=new JButton("黄忠");
		jb6=new JButton("魏延");
		
		//添加组件
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		//设置布局管理器
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//设置窗体属性
		this.setTitle("演示流式布局管理器");
		this.setSize(200,200);
		this.setResizable(false);//禁止修改窗口大小
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
