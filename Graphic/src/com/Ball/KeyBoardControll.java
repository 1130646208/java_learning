package com.Ball;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class KeyBoardControll extends JFrame{

	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KeyBoardControll kbc=new KeyBoardControll();
	}
	
	
	public KeyBoardControll(){
		mp=new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);//this发生事件,想让mp知道
		this.setVisible(true);
		this.setSize(200,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	

}

/**
 * 一个类要实现监听步骤
 * 1 实现相应接口
 * 2 接口处理方法重写
 * 3 事件源上注册监听
 * 4 事件传递靠事件对象
 * @author wsx
 *
 */ 
class MyPanel extends JPanel implements java.awt.event.KeyListener{
	int x=10;
	int y=10;//初始位置
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x, y, 20, 20);
	} 

	@Override
	//键被按下
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Press");
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
			y+=5;//光加还不行,还得重绘
		}else if(arg0.getKeyCode()==KeyEvent.VK_UP){
			y-=5;
		}else if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
			x-=5;	
		}else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
			x+=5;
		}
		this.repaint();
	}
	@Override
	//键被释放
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Release");
	}

	@Override
	//键值被输出
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Typed");
	}
}