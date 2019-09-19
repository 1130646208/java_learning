package com.CheckRadioDemo;
import java.awt.*;
import javax.swing.*;
/**
 * 单选框RadioBox、复选框演示CheckBox
 * @author wsx
 *
 */
public class Check extends JFrame{
	//定义组件
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;//复选框
	JRadioButton jrb1,jrb2;  //单选框
	ButtonGroup bg;
	public static void main(String []args){
		Check c =new Check();
	}
	
	
	public Check(){
		//panel
		jp1= new JPanel();
		jp2= new JPanel();
		jp3= new JPanel();
		//标签
		jl1= new JLabel("喜欢的运动");
		jl2= new JLabel("性别");
		//按钮
		jb1= new JButton("注册");
		jb2= new JButton("取消");
		//多选框
		jcb1=new JCheckBox("足球");
		jcb2=new JCheckBox("篮球");
		jcb3=new JCheckBox("网球");
		//单选框
		jrb1= new JRadioButton("男");
		jrb2= new JRadioButton("女");
		//要把jrb1和jrb2放入一个ButtonGroup
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		//设置布局管理
		this.setLayout(new GridLayout(3,1));
		//添加组件
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
		
		//设置窗口属性
		this.setSize(300,150);
		this.setTitle("注册界面");
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		
	}
}
