package com.wsx.TankGame5;
import java.awt.*;//��ͼ
import javax.swing.*;//��ͼ
import java.awt.event.*;//�¼�

import java.util.*;//Vector
/**
 * ̹��1.5
 * ̹�˻ᶯ�����ϻᷢ���ӵ� 
 * ʵ������(�������5��)
 * ʵ��ɱ��̹��(����̹����ʧ)
 * @author wsx
 *
 */
public class TankToKillEnemy extends JFrame{
	MyPanel mp =null;
	public static void main(String[]args){
		TankToKillEnemy tg=new TankToKillEnemy();
	}
	
	//���캯�� 
	public TankToKillEnemy(){
		mp=new MyPanel(); 
		//����mp�߳�
		Thread t=new Thread(mp);
		t.start();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
//�ҵ����
class MyPanel extends JPanel implements KeyListener,Runnable{
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
	//��̹�˺��ӵ�
	public void paint(Graphics g){
		super.paint(g);
		//����Ĭ����ɫ�ѻ���򻭳���
		g.fillRect(0, 0, 400, 400);
		//���Լ�̹��
		this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 0);
		//������̹��
		for(int i=0;i<ets.size();i++){
			//ֻ�����
			EnemyTank et=ets.get(i);
			if(et.isLive==true){
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
			}
		}
		
		//��ss�б��������ӵ�
		for(int i=0;i<this.hero.ss.size();i++){
			//ȡ��һ���ӵ�
			Shot myShot=hero.ss.get(i);
			//����һ���ӵ�
			if(myShot!=null && myShot.isLive==true){
				g.fill3DRect(myShot.x-2, myShot.y-2, 4, 4,true);
			}
			//�����ӵ�����
			if(myShot.isLive==false){
				hero.ss.remove(myShot);
			}
		}
		
	}
	
	//�ж��Ƿ����
	public void hitTank(Shot s,EnemyTank et){
		
		//�жϸ�̹�˵ķ���
		switch(et.direct){
		//�ϻ���
		case 0:
		case 2:
			if (s.x>et.x-10&&s.x<et.x+10&&s.y>et.y-15&&s.y<et.y+15){
				et.isLive=false;
				s.isLive=false;
				}
			break;
		case 1:
		case 3:
			if (s.y>et.y-10&&s.y<et.y+10&&s.x>et.x-15&&s.x<et.x+15){
				et.isLive=false;
				s.isLive=false;
				}
			break;
		}
		
	}
	
	
	
	
	//��̹����״
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

	//����
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
		if(arg0.getKeyCode()==KeyEvent.VK_J){
			//����
			//����5���ӵ�
			if (this.hero.ss.size()<=5){
			this.hero.shotEnemy();
			}
		}
		
		//�ػ�Panel
		
		this.repaint();
	}

	public void keyReleased(KeyEvent arg0) {
	
	}

	public void keyTyped(KeyEvent arg0) {
	
	}


	public void run() {
		//ÿ�� ms�ػ�
		while(true){
		try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		for(int i=0;i<hero.ss.size();i++){
			//ȡ���ӵ�
			Shot myShot=hero.ss.get(i);
			//�ж��ӵ��Ƿ���Ч
			if(myShot.isLive==true){
				//ȡ��ÿ������̹���ж�
				for(int j=0;j<ets.size();j++){
					EnemyTank et=ets.get(j);
					if(et.isLive==true){
						this.hitTank(myShot, et);
					}
				}
			}
			
		}
		//�ػ� 
		this.repaint();
		}
		
	}
}
