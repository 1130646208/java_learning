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
		this.addKeyListener(mp);//this�����¼�,����mp֪��
		this.setVisible(true);
		this.setSize(200,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	

}

/**
 * һ����Ҫʵ�ּ�������
 * 1 ʵ����Ӧ�ӿ�
 * 2 �ӿڴ�������д
 * 3 �¼�Դ��ע�����
 * 4 �¼����ݿ��¼�����
 * @author wsx
 *
 */ 
class MyPanel extends JPanel implements java.awt.event.KeyListener{
	int x=10;
	int y=10;//��ʼλ��
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x, y, 20, 20);
	} 

	@Override
	//��������
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Press");
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
			y+=5;//��ӻ�����,�����ػ�
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
	//�����ͷ�
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Release");
	}

	@Override
	//��ֵ�����
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Typed");
	}
}