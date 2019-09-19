package com.wsx.TankGame9;
import java.awt.*;//��ͼ
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;//��ͼ

import java.awt.event.*;//�¼�

import java.util.*;//Vector
/**
 * ̹��1.8
 * ̹�˻ᶯ�����ϻᷢ���ӵ� 
 * ʵ������(�������5��)
 * ʵ��ɱ��̹��(����̹����ʧ)
 * ʵ�ֱ�ըЧ��
 * ���������ƶ�
 * �Լ��ᱻ�򵽲�����
 * ��ֹ�����ص� * �ŵ�enemyTank��
 * ���Էֹ� *
 * ������ͣ ���� * ���û������ͣ,�ӵ��ٶȺ��ٶ���Ϊ��
 * ���Լ�¼��ҳɼ� * �ļ��� ����һ����¼�� ��ɼ�¼
 * ��¼̹����Ϸ��һ�� 
 * java���������� *
 */
public class TankGameAlmostFinish extends JFrame implements ActionListener{
	MyPanel mp=null;
	//�ؿ���ʾ
	MyStart ms=null;
	//��Ϸ�˵�
	JMenuBar jmb=null;
	JMenu jm1=null;
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	JMenuItem jmi3=null;
	JMenuItem jmi4=null;
	public static void main(String[]args){
		TankGameAlmostFinish tg=new TankGameAlmostFinish();
	}
	//���캯�� 
	public TankGameAlmostFinish(){
		
		//�����˵���ѡ��
		jmb=new JMenuBar();
		jm1=new JMenu("��Ϸ(G)");
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("��ʼ��Ϸ(N)");
		jmi1.setMnemonic('N');
		jmi2=new JMenuItem("�˳���Ϸ(E)");
		jmi2.setMnemonic('E');
		jmi3=new JMenuItem("�����˳�(S)");
		jmi3.setMnemonic('S');
		jmi4=new JMenuItem("�����ϴ���Ϸ(C)");
		jmi4.setMnemonic('C');
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jmb.add(jm1);
		this.setJMenuBar(jmb);
		//ע�����
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newGame");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("exit");
		jmi3.addActionListener(this);
		jmi3.setActionCommand("saveAndExit");
		jmi4.addActionListener(this);
		jmi4.setActionCommand("continue");
		//�ؿ���ʾ���
		ms=new MyStart();
		this.add(ms);
		Thread t2=new Thread(ms);
		t2.start();
		//������
		this.setSize(500,550);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("newGame")){
			mp=new MyPanel("newGame");
			System.out.println("�����ʼ");
			//��ɾ���ɵĹؿ���ʾ���
			this.remove(ms);
			this.add(mp);
			this.addKeyListener(mp);
			this.setVisible(true);
			//����mp�߳�
			Thread t=new Thread(mp);
			t.start();
			
		}
		else if(arg0.getActionCommand().equals("exit")){
			//����˳�
			System.out.println("ExitWithoutSaving...");
			System.exit(0);
			
		}
		else if(arg0.getActionCommand().equals("saveAndExit")){
			//��¼̹��λ��
			//������ٵ���,��������,�ҵ�����
			Recorder.saveExit(mp.ets);
			//�˳�
			System.exit(0);
		}
		else if(arg0.getActionCommand().equals("continue")){
			mp=new MyPanel("continueGame");
			System.out.println("��ȡ�ϴ�����...");
			//��ɾ���ɵĹؿ���ʾ���
			this.remove(ms);
			this.add(mp);
			this.addKeyListener(mp);
			this.setVisible(true);
			//����mp�߳�
			Thread t=new Thread(mp);
			t.start();
		}
		else{
			System.out.println("����");
		}
		
	}
}
//��ʾ��ʼ
class MyStart extends JPanel implements Runnable{
	boolean drawStage=true;
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 400, 400);
		if(this.drawStage){//��˸Ч��
			//��ʾ��Ϣ
			g.setColor(Color.yellow);
			Font myFont=new Font("΢���ź�",Font.BOLD,30);
			g.setFont(myFont);
			g.drawString("STAGE 1", 100, 150);
		}
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
				this.drawStage=!this.drawStage;
				this.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
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
	public MyPanel(String flag){
		constructGame(flag);
		//��ʼ��ͼƬ,����ֵ�һ��ͼƬ���ز����Ե�����
//		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
//		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
//		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
		//�µļ���ͼƬ���� �ٶȸ���
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
	//������Ϸ�ĺ���
	public void constructGame(String flag){
		if(flag.equals("newGame")){
			System.out.println("��������Ϸ...");
			//��ʼ���ҵ�̹��
			hero=new Hero(100,300);
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
				//���ݵ�enemyTank
				et.setEts(ets);
			}
		}else if(flag.equals("continueGame")){
			System.out.println("������Ϸ");
			//��ȡ��¼
			new Recorder();
			Recorder.getNodesAndEnNum();
			//��ʼ���ҵ�̹��
			hero=new Hero(100,300);
			//��ʼ������̹��
			Node node=null;
			for (int i=0;i<Recorder.nodes.size();i++){
				node=Recorder.nodes.get(i);
				//��������̹�˶���
				EnemyTank et=new EnemyTank(node.x,node.y);
				et.setColor(1);
				et.setDirect(node.direct);
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
				//���ݵ�enemyTank
				et.setEts(ets);
			}
		}else{
			System.out.println("����");
		}
	}
	//������ʾ��Ϣ
	public void showInfo(Graphics g){
		//������ʾ��Ϣ��ָʾ��̹��
		this.drawTank(80, 440, g, 0, 1);
		this.drawTank(150, 440, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Recorder.getEnNum()+"", 110, 450);
		g.drawString(Recorder.getMyLife()+"", 180, 450);
		//��ҳɼ�
		g.setColor(Color.black);
		Font f=new Font("΢���ź�",Font.BOLD,20);
		g.setFont(f);
		g.drawString("����:",415,50);
		this.drawTank(420, 80, g, 0, 1);
		g.setColor(Color.black);
		g.drawString(Recorder.getKillEnNum()+"", 440, 85);
	}
	//��дpaint
	//��̹�˺��ӵ�
	public void paint(Graphics g){
		super.paint(g);
		//����Ĭ����ɫ�ѻ���򻭳���
		
		g.fillRect(0, 0, 400, 400);
		this.showInfo(g);
		//���Լ�̹��
		if(this.hero.isLive){
		
			this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 0);
		}
		//����ը��
		for (int i=0;i<bombs.size();i++){
			//ȡ��ը��
			Bomb b=bombs.get(i);
			//System.out.println("ը������"+bombs.size());
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
				this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
			}
			//������̹�˵�̹��ʱ˳�㽫�ӵ�����
			for(int j=0;j<et.ss.size();j++){
				Shot enemyShot=et.ss.get(j);
				if(enemyShot.isLive){
					g.setColor(Color.WHITE);
					g.fill3DRect(enemyShot.x-2, enemyShot.y-2, 4, 4,true);
				}else{
					//����ӵ����� ��Vector���Ƴ�
					et.ss.remove(j);
				}
			}
		}
		//��װ�ӵ�
		this.enemyReload();
		//��ss�б��������ӵ� (�ҵ��ӵ�)
		for(int i=0;i<this.hero.ss.size();i++){
			//ȡ��һ���ӵ�
			Shot myShot=hero.ss.get(i);
			//����һ���ӵ�
			if(myShot!=null && myShot.isLive==true){
				g.setColor(Color.WHITE);
				g.fill3DRect(myShot.x-2, myShot.y-2, 4, 4,true);
			}
			//�����ӵ�����
			if(myShot.isLive==false){
				hero.ss.remove(myShot);
			}
		}	
	}
	//�ж��ӵ��Ƿ����̹��
	public boolean hitTank(Shot s,Tank t){
		boolean hit=false;
		//�жϸ�̹�˵ķ���
		switch(t.direct){
		//�ϻ���
		case 0:
		case 2:
			if (s.x>t.x-15&&s.x<t.x+15&&s.y>t.y-15&&s.y<t.y+15){
				t.isLive=false;
				s.isLive=false;
				//����һ��ը��,��������
				Bomb b=new Bomb(t.x-15,t.y-15);
				bombs.add(b);
				hit=true;
			}else hit=false;
		case 1:
		case 3:
			if (s.y>t.y-15&&s.y<t.y+15&&s.x>t.x-15&&s.x<t.x+15){
				t.isLive=false;
				s.isLive=false;
				//����һ��ը��,��������
				Bomb b=new Bomb(t.x-15,t.y-15);
				bombs.add(b);
				hit=true;
			}else hit=false;
		}
		return hit;	
	}
	//�����Ƿ����
	public void hitMe(){
		//ȡ��ÿ��̹��	
		for (int i=0;i<this.ets.size();i++){
			EnemyTank et=ets.get(i);
			for (int j=0;j<et.ss.size();j++){
				//ȡ���ӵ�
				Shot enemyShot=et.ss.get(j);
				if(this.hero.isLive){
					if(this.hitTank(enemyShot, hero))
					{
						hero.isLive=false;
						Recorder.reduceHero();
						//���Լ��Ƴ�,�������
					}
				}
			}	
		}
	}
	//�ж������ӵ��Ƿ��л��е���̹�˵�
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
						if(this.hitTank(myShot, et)){
							Recorder.reduceEnemy();
						}
					}
				}
			}
		}
	}
	//��̹����״
 	public void drawTank(int x,int y,Graphics g,int direct ,int type){//��װ�Ļ�̹�˺���,����̹������(��ɫ),̹�˷���
		switch(type){
		case 0:
			g.setColor(Color.red);break;//�ҵ�
		case 1:
			g.setColor(Color.yellow);break;//����
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
 	//��Ҫװ�ӵ�
 	public void enemyReload(){
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
 	}
	//����
	public void keyPressed(KeyEvent arg0) {
		Thread t=new Thread(this.hero);
		// ����(�ı�)�ҵ�̹�˷���
		if(arg0.getKeyCode()==KeyEvent.VK_W){
			this.hero.setDirect(0);
			t.start();
		}else if(arg0.getKeyCode()==KeyEvent.VK_D){
			this.hero.setDirect(1);
			t.start();
		}else if(arg0.getKeyCode()==KeyEvent.VK_S){
			this.hero.setDirect(2);
			t.start();
		}else if(arg0.getKeyCode()==KeyEvent.VK_A){
			this.hero.setDirect(3);
			t.start();
		}else{
			
		}
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
	
	//panelˢ�º���
	public void run() {
		System.out.println("PanelRunning");
		//ÿ�� ms�ػ�
		while(true){
		try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//�ж�panel���Ƿ��������¼�
		//�ж��Ƿ��е���̹�˱�����
		this.hitEnemyTank();
		//��������û
		this.hitMe();
		//�ػ� 
		this.repaint();
		}	
	}
}
