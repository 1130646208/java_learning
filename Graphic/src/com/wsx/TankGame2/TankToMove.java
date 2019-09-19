package com.wsx.TankGame2;
import java.awt.*;//��ͼ
import javax.swing.*;//��ͼ
import java.awt.event.*;//�¼�

import java.util.*;//Vector
/**
 * ̹��1.1
 * ̹�˻ᶯ
 * @author wsx
 *
 */
public class TankToMove extends JFrame{
	MyPanel mp =null;
	public static void main(String[]args){
		TankToMove tg=new TankToMove();
	}
	
	//���캯��
	public TankToMove(){
		mp=new MyPanel(); 
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
//�ҵ����
class MyPanel extends JPanel implements KeyListener{
	//����һ���ҵ�̹��
	Hero hero=null;
	//�������̹����
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	//��������
	int enSize=3;
	//���캯��
	public MyPanel(){
		hero=new Hero(100,100);
		//��ʼ��
		for (int i=0;i<enSize;i++){
			//��������̹�˶���
			EnemyTank et=new EnemyTank((i+1)*50,15);
			et.setColor(1);
			et.setDirect(2);
			ets.add(et);
		}
	}
	
	//��дpaint
	public void paint(Graphics g){
		super.paint(g);
		//����Ĭ����ɫ�ѻ���򻭳���
		g.fillRect(0, 0, 400, 300);
		//���Լ�̹��
		this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 0);
		//������̹��
		for(int i=0;i<ets.size();i++){
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
		}
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
			//1 ����
			g.fill3DRect(x-10, y-15, 5, 30,false);
			//2 ����
			g.fill3DRect(x+5, y-15, 5, 30,false);
			//3 �м����
			g.fill3DRect(x-5, y-10, 10, 20,false);
			//4 Բ��
			g.fillOval(x-5, y-5, 10, 10);
			//5 ����Ͳ
			g.drawLine(x, y-15, x,y);
			break;
		case 1://��
			//1 ����
			g.fill3DRect(x-15, y-10, 30, 5,false);
			//2 ����
			g.fill3DRect(x-15, y+5, 30, 5,false);
			//3 �м����
			g.fill3DRect(x-10, y-5, 20, 10,false);
			//4 Բ��
			g.fillOval(x-5, y-5, 10, 10);
			//5 ����Ͳ
			g.drawLine(x, y, x+15,y);
			break;
		case 2://��
			//1 ����
			g.fill3DRect(x-10, y-15, 5, 30,false);
			//2 ����
			g.fill3DRect(x+5, y-15, 5, 30,false);
			//3 �м����
			g.fill3DRect(x-5, y-10, 10, 20,false);
			//4 Բ��
			g.fillOval(x-5, y-5, 10, 10);
			//5 ����Ͳ
			g.drawLine(x, y, x,y+15);
			break;
		case 3://��
			//1 ����
			g.fill3DRect(x-15, y-10, 30, 5,false);
			//2 ����
			g.fill3DRect(x-15, y+5, 30, 5,false);
			//3 �м����
			g.fill3DRect(x-10, y-5, 20, 10,false);
			//4 Բ��
			g.fillOval(x-5, y-5, 10, 10);
			//5 ����Ͳ
			g.drawLine(x, y, x-15,y);
			break;
			
	
			
		}
	}



	//
	public void keyPressed(KeyEvent arg0) {
		// ����(�ı�)�ҵ�̹�˷���
		if(arg0.getKeyCode()==KeyEvent.VK_W){
			this.hero.setDirect(0);
			this.hero.moveUp();
		}else if(arg0.getKeyCode()==KeyEvent.VK_D){
			this.hero.setDirect(1);
			this.hero.moveRight();
		}else if(arg0.getKeyCode()==KeyEvent.VK_S){
			this.hero.setDirect(2);
			this.hero.moveDown();
		}else if(arg0.getKeyCode()==KeyEvent.VK_A){
			this.hero.setDirect(3);
			this.hero.moveLeft();}
		//�ػ�Panel
		this.repaint();
	}

	public void keyReleased(KeyEvent arg0) {
	
	}

	public void keyTyped(KeyEvent arg0) {
	
	}
}
