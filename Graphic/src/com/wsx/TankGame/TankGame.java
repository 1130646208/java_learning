package com.wsx.TankGame;
import java.awt.*;
import javax.swing.*;
/**
 * ̹��1.0
 * @author wsx
 *
 */
public class TankGame extends JFrame{
	MyPanel mp =null;
	public static void main(String[]args){
		TankGame tg=new TankGame();
	}
	
	//���캯��
	public TankGame(){
		mp=new MyPanel(); 
		this.add(mp);
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
//�ҵ����
class MyPanel extends JPanel{
	//����һ���ҵ�̹��
	Hero hero=null;
	//���캯��
	public MyPanel(){
		hero=new Hero(10,10);
	}
	
	
	
	//��дpaint
	public void paint(Graphics g){
		super.paint(g);
		//����Ĭ����ɫ�ѻ���򻭳���
		g.fillRect(0, 0, 400, 300);
		this.drawTank(hero.getX(), hero.getY(), g, 0, 0);
		
	}
	public void drawTank(int x,int y,Graphics g,int direct ,int type){//��װ�Ļ�̹�˺���,����̹������(��ɫ),̹�˷���
		switch(type){
		case 0:
			g.setColor(Color.CYAN);break;
		case 1:
			g.setColor(Color.yellow);break;
		}
		switch(direct){
		case 0:
			//����̹��,��ʱ�ٷ�װ�ɺ���
			//1 ����
			g.fill3DRect(x, y, 5, 30,true);
			//2 ����
			g.fill3DRect(x+15, y, 5, 30,true);
			//3 �м����
			g.fillRect(x+5, y+5, 10, 20);
			//4 Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//5 ����Ͳ
			g.drawLine(x+10, y, x+10,y+15);
			break;
		}
	}
}

//̹����
class Tank{
	//��ʾ̹�˺�������
	int x=0;
	int y=0;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	//���캯��
	public Tank(int x,int y) {
		this.x=x;
		this.y=y;	
	}
}
//�ҵ�̹��
class Hero extends Tank{
	public Hero(int x,int y){
		super(x,y);
	}
}
