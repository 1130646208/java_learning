/**
 * BorderLayout演示
 */
/**
 * 步骤
 * 1 继承JFrame
 * 2 定义需要的组件
 * 3 创建组件（构造函数）
 * 4 添加组件到合适的位置
 * 5 设置窗体属性
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
		//创建组件
		jb1=new JButton("中");
		jb2=new JButton("东");
		jb3=new JButton("南");
		jb4=new JButton("西");
		jb5=new JButton("北");
		
		//添加各个组件
		
		//this.add(jb1,BorderLayout.CENTER);
		this.add(jb2,BorderLayout.EAST);
		this.add(jb3,BorderLayout.SOUTH);
		this.add(jb4,BorderLayout.WEST);
		this.add(jb5,BorderLayout.NORTH);
		
		//设置窗体属性
		this.setTitle("演示边界布局管理器");
		this.setSize(200,200);
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
