package com.wsx.TankGame7;
import java.awt.*;//��ͼ
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;//��ͼ
import java.awt.event.*;//�¼�

import java.util.*;//Vector
/**
 * ̹��1.6
 * ̹�˻ᶯ�����ϻᷢ���ӵ� 
 * ʵ������(�������5��)
 * ʵ��ɱ��̹��(����̹����ʧ)
 * ʵ�ֱ�ըЧ��
 * ���������ƶ�
 * �Լ��ᱻ�򵽲�����
 * @author wsx
 *
 */
public class TankCanBeKilled extends JFrame{
	MyPanel mp =null;
	public static void main(String[]args){
		TankCanBeKilled tg=new TankCanBeKilled();
	}
	
	//���캯�� 
	public TankCanBeKilled(){
		mp=new MyPanel(); 
		//����mp�߳�
		Thread t=new Thread(mp);
		t.start();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(450,450);
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
	//��������ͼƬ,����ͼƬ���һ��ը��
	Image image1=null;
	Image image2=null;
	Image image3=null;
	//����һ��ը����������
	Vector<Bomb> bombs=new Vector<Bomb>();
	//���캯��
	public MyPanel(){
		//��ʼ���ҵ�̹��
		hero=new Hero(100,500);
		//��ʼ������̹��
		for (int i=0;i<enSize;i++){
			//��������̹�˶���
			EnemyTank et=new EnemyTank((i+1)*50,15);
			et.setColor(1);
			et.setDirect(2);
			//��������̹��
			Thread t=new Thread(et);
			t.start();
			//������̹�����һ���ӵ�
			Shot s=new Shot(et.x,et.y+15,2);
			//������̹������ӵ�
			et.ss.add(s);
			Thread t2=new Thread(s);
			t2.start();
			ets.add(et);
		}
		//��ʼ��ͼƬ,����ֵ�һ��ͼƬ���ز����Ե�����
//		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
//		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
//		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
		//�µļ���ͼƬ����
		try {
			//����ͼƬ
			System.out.println("����ͼƬ");
			image1=ImageIO.read(new File("bomb_1.gif"));
			image2=ImageIO.read(new File("bomb_2.gif"));
			image3=ImageIO.read(new File("bomb_3.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
	//��дpaint
	//��̹�˺��ӵ�
	public void paint(Graphics g){
		super.paint(g);
		//����Ĭ����ɫ�ѻ���򻭳���
		g.fillRect(0, 0, 400, 400);
		//���Լ�̹��
		if(this.hero.isLive){
		
			this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 0);
		
		}
		//����ը��
		for (int i=0;i<bombs.size();i++){
			//ȡ��ը��
			Bomb b=bombs.get(i);
			System.out.println(""+bombs.size());
			if(b.life>6){
				g.drawImage(image1, b.x, b.y, 30, 30,this);
			}else if(b.life>3){
				g.drawImage(image2, b.x, b.y, 30, 30,this);
			}else{
				g.drawImage(image3, b.x, b.y, 30, 30,this);
			}
			//��b������ֵ����
			b.lifeDown();
			//ը������Ϊ��
			if(b.isLive==false){
				bombs.remove(b);
			}
		}
		
		//������̹��
		for(int i=0;i<ets.size();i++){
			//ֻ�����
			EnemyTank et=ets.get(i);
			if(et.isLive){
				//������̹�˵�̹��ʱ˳�㽫�ӵ�����
				this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
				for(int j=0;j<et.ss.size();j++){
					Shot enemyShot=et.ss.get(j);
					if(enemyShot.isLive){
						g.fill3DRect(enemyShot.x-2, enemyShot.y-2, 4, 4,true);
					}else{
						//����ӵ����� ��Vector���Ƴ�
						et.ss.remove(j);
					}
				}
			}
		}
		
		//��ss�б��������ӵ� (�ҵ��ӵ�)
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
	
	//�ж��ӵ��Ƿ����̹��
	public void hitTank(Shot s,Tank t){
		//�жϸ�̹�˵ķ���
		switch(t.direct){
		//�ϻ���
		case 0:
		case 2:
			if (s.x>t.x-10&&s.x<t.x+10&&s.y>t.y-15&&s.y<t.y+15){
				t.isLive=false;
				s.isLive=false;
				//����һ��ը��,��������
				Bomb b=new Bomb(t.x-15,t.y-15);
				bombs.add(b);
				}
			break;
		case 1:
		case 3:
			if (s.y>t.y-10&&s.y<t.y+10&&s.x>t.x-15&&s.x<t.x+15){
				t.isLive=false;
				s.isLive=false;
				//����һ��ը��,��������
				Bomb b=new Bomb(t.x-15,t.y-15);
				bombs.add(b);
				}
			break;
		}
		
	}
	//�����Ƿ����
	public void hitMe(){
		//ȡ��ÿ��̹��	
		for (int i=0;i<this.ets.size();i++){
			EnemyTank et=ets.get(i);
			for (int j=0;j<et.ss.size();j++){
				//ȡ���ӵ�
				Shot enemyShot=et.ss.get(j);
				this.hitTank(enemyShot, hero);
			}
			
		}
	}
	
	//�ж������ӵ��Ƿ��л���̹�˵�
	public void hitEnemyTank(){
		//�ж��Ƿ���е���̹��
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
			this.hero.move(hero.direct);
		}else if(arg0.getKeyCode()==KeyEvent.VK_D){
			this.hero.setDirect(1);
			this.hero.move(hero.direct);
		}else if(arg0.getKeyCode()==KeyEvent.VK_S){
			this.hero.setDirect(2);
			this.hero.move(hero.direct);
		}else if(arg0.getKeyCode()==KeyEvent.VK_A){
			this.hero.setDirect(3);
			this.hero.move(hero.direct);}
		if(arg0.getKeyCode()==KeyEvent.VK_J){
			//����
			//����5���ӵ�
			if (this.hero.ss.size()<=3){
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
		System.out.println("PanelRunning");
		//ÿ�� ms�ػ�
		while(true){
		try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//�ж��Ƿ��е���̹�˱�����
		this.hitEnemyTank();
		//��������û
		this.hitMe();
		//�ж��Ƿ���̹����Ҫ���µ��ӵ�
		for(int i=0;i<ets.size();i++){
			EnemyTank et=ets.get(i);
			if(et.isLive==true){
				if(et.ss.size()<1){//������������ӵ�����
					//û���ӵ� ���
					Shot s=null;
					switch(et.direct){
					case 0:
						s=new Shot(et.x,et.y-15,0);
						et.ss.add(s);break;
					case 1:
						s=new Shot(et.x+15,et.y,1);
						et.ss.add(s);break;
					case 2:
						s=new Shot(et.x,et.y+15,2);
						et.ss.add(s);break;
					case 3:
						s=new Shot(et.x-15,et.y,3);
						et.ss.add(s);break;
					
					}
					//�����ӵ�
					Thread t=new Thread(s);
					t.start();
				}
			}
		}
		
		//�ػ� 
		this.repaint();
		}
		
	}
}
