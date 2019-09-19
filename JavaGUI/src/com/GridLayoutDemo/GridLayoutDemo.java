package com.GridLayoutDemo;
import java.awt.*;
import javax.swing.*;
/**
 * GridLayout演示
 * @author wsx
 *
 */
public class GridLayoutDemo extends JFrame {
	int size = 9;
	JButton jbs[]=new JButton[size];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GridLayoutDemo gld= new GridLayoutDemo();
	}
	
	public GridLayoutDemo(){
		
		//创建组件
		for(int i=0;i<size;i++){
			jbs[i]= new JButton(String.valueOf(i));
		}
		
		
		
		//设置网格布局管理器
		
		this.setLayout(new GridLayout(3,3,10,10));//行 列 水平间隙 垂直间隙
		
		//添加组件
		for(int i=0;i<size;i++){
			this.add(jbs[i]);
		}
		
		//设置窗体属性
		
		this.setTitle("演示流式布局管理器");
		this.setSize(200,200);
		this.setResizable(false);//禁止修改窗口大小
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
