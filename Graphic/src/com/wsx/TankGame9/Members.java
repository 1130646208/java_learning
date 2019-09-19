package com.wsx.TankGame9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

//ͬ�����ʻ���
//��̬��������ֱ������.����������
class Recorder{
	
	//��¼�ж��ٵ���
	private static int enNum=20;
	//ɱ����
	private static int killEnNum=0;
	//�Լ�������
	private static int myLife=3;
	//������������̹����Ϣ
	private static Vector<EnemyTank> ets =new Vector<EnemyTank>();
	//���ļ��лָ���¼�ĵ���̹��λ��
	static Vector<Node> nodes =new Vector<Node>();
	public static void getNodesAndEnNum(){
		try {
			fr=new FileReader("f:\\tankGameRecorder.txt");
			br=new BufferedReader(fr);
			//�ȶ�ȡ��һ��
			String s=br.readLine();
			killEnNum=Integer.parseInt(s);	
			System.out.println(s);
			while((s=br.readLine())!=null){
				String []xyz=s.split(" ");//�Կո�Ϊ��־,����ȡ���зֳ��ַ�������
				Node node=new Node(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));
				System.out.println(s);
				nodes.add(node);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static Vector<EnemyTank> getEts() {
		return ets;
	}
	public static void setEts(Vector<EnemyTank> ets) {
		Recorder.ets = ets;
	}
	//�ļ�
	private static FileWriter fw=null;
	private static BufferedWriter bw=null;
	private static FileReader fr=null;
	private static BufferedReader br=null;
	
	public static int getKillEnNum() {
		return killEnNum;
	}
	public static void setKillEnNum(int killEnNum) {
		Recorder.killEnNum = killEnNum;
	}
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}
	//���ٵ�����
	public static void reduceEnemy(){
		enNum--;
		killEnNum++;
	}
	//�Լ���������
	public static void reduceHero(){
		if(myLife>0){
			myLife--;
		}else{
			
		}	
	}
	//��ȡ��һ��ܵо���
	public static void readRecord(){
		try {
			fr=new FileReader("f:\\tankGameRecorder.txt");
			br=new BufferedReader(fr);
			String s=br.readLine();
			killEnNum=Integer.parseInt(s);	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	//�����˳�
	public static void saveExit(Vector<EnemyTank> ets){
		try {
			fw=new FileWriter("f:\\tankGameRecorder.txt");
			bw=new BufferedWriter(fw);
			//���������
			bw.write(killEnNum+"\r\n");
			//�������̹��λ��
			for (int i=0;i<ets.size();i++){
				EnemyTank et=ets.get(i);
				if(et.isLive){
					//������
					String locate=et.x+" "+et.y+" "+et.direct;
					bw.write(locate+"\r\n");
					System.out.println("���ڱ���");
					
				}
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ر���
			//���ȹ�
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}

//�������̹��λ�õĵ�
class Node{
	int x;
	int y;
	int direct;
	public Node(int x,int y,int direct){
		this.direct=direct;
		this.x=x;
		this.y=y;
		
	}
	
}

	
//̹����
class Tank{
	//��ʾ̹�˺�������
	int x=0;
	int y=0;
	//̹�˷��� 0 �� 1�� 2 �� 3 ��
	int direct=0;
	//̹���ٶ�
	int speed=1;
	//��ɫ
	int color=0;
	//�Ƿ�����
	boolean isLive=true;
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
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
	//�ƶ��Ľ�,����ʵʱ���direct,��ֹ̹�˺�����
	public void move(int direct){
		switch(direct){
		case 0:
			if(this.y>15){
			this.y-=this.speed;
			}
			break;
		case 1:
			if(this.x<385){
			this.x+=this.speed;
			}
			break;
		case 2:
			if(this.y<385){
			this.y+=this.speed;
			}
			break;
		case 3:
			if(this.x>15){
			this.x-=this.speed;
			}
			break;

		}
	}
}
//�ҵ�̹��
class Hero extends Tank implements Runnable{

	//����һ���ӵ�
	Shot s=null;
	//Vector ���̰߳�ȫ��
	//�����ӵ�������
	Vector<Shot> ss=new Vector<Shot>(); 
	
	public Hero(int x,int y){
		super(x,y);
	}
	//����
	public void shotEnemy(){
		
		switch(this.direct)
		{
		case 0:
			s=new Shot(x,y-15,0);
			ss.add(s);break;
		case 1:
			s=new Shot(x+15,y,1);
			ss.add(s);break;
		case 2:
			s=new Shot(x,y+15,2);
			ss.add(s);break;
		case 3:
			s=new Shot(x-15,y,3);
			ss.add(s);break;
		}
		Thread t=new Thread(s);
		t.start();//�����ӵ�
		
	}
	public void run() {
		while(true){

			for(int i=0;i<10;i++){
				move(this.direct);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			break;
			
		}
		
	}
	
}

//����̹�� ,Ϊʵ���ƶ�,�����߳�
class EnemyTank extends Tank implements Runnable{
	//boolean isLive=true;//�Ѿ��Ƶ�����,�����ٶ���,����Ḳ�Ǹ����,���µ���̹��������
	//�����ӵ�����
	//����̹������ӵ�,�ڴ���֮����ӵ�����֮��
	Vector<Shot> ss=new Vector<Shot>();
	//����һ������,���Է��ʵ�panel �����е�̹��
	Vector<EnemyTank> ets=new Vector<EnemyTank>();	
	public EnemyTank(int x, int y) {
		super(x, y);
	}

	//�õ�MyPanel������̹��,�˺�����Mypanel����̹�˳�ʼ��֮�����
	public void setEts(Vector<EnemyTank> vv){
		this.ets=vv;
	}
	
	
	//�ж��Ƿ�ײ����ĵ���̹��
	public boolean isTouchOther(){
		boolean b=false;
		switch(this.direct){
		case 0:
		case 2:
			//ȡ�����е���̹��
			for(int i=0;i<this.ets.size();i++){
				EnemyTank et=ets.get(i);
				//��������Լ�
				if(et!=this){
					if(et.direct==0||et.direct==2){
						if(Math.abs(this.x-et.x)<=20&&Math.abs(this.y-et.y)<=30){
							
								if(et.x>=this.x){
									this.setDirect(3);
									this.move(3);
								}else{
									this.setDirect(1);
									this.move(1);
								}				
							//System.out.println("ײ��");
							b=true;
						}		
					}else if(et.direct==1||et.direct==3){
						if(Math.abs(this.x-et.x)<=25&&Math.abs(this.y-et.y)<=25){
							//System.out.println("ײ��");
							if(et.x>=this.x){
								this.setDirect(3);
								this.move(3);
							}else{
								this.setDirect(1);
								this.move(1);
							}
							b=true;							
						}	
					}else {	
						System.out.println("����");
					}			
				}
			}
			break;
		case 1:
		case 3:
			//ȡ�����е���̹��
			for(int i=0;i<this.ets.size();i++){
				EnemyTank et=ets.get(i);
				//��������Լ�
				if(et!=this){
					if(et.direct==0||et.direct==2){
						if(Math.abs(this.x-et.x)<=25&&Math.abs(this.y-et.y)<=25){
							//System.out.println("ײ��");
							if(et.x>=this.x){
								this.setDirect(3);
								this.move(3);
							}else{
								this.setDirect(1);
								this.move(1);
							}
							b=true;
						}	
					}else if(et.direct==1||et.direct==3){
						if(Math.abs(this.x-et.x)<=30&&Math.abs(this.y-et.y)<=20){
							//System.out.println("ײ��");
							if(et.x>=this.x){
								
								this.move(3);
							}else{
								
								this.move(1);
							}
							b=true;					
						}	
					}else {	
						System.out.println("����");
					}			
				}
			}
			break;
		}
		return b;		
	}
	
	//
	public void run() {
		//���õ����ٶ�
		this.speed*=1;
		long sleepTime=30;
		
		while(true){
			switch(this.direct){//�����ж���Χ
			case 0:
				for (int i=0;i<30;i++){
					if(y>15&&!this.isTouchOther()){
						move(this.direct);
					}
					if(y<=15){
						this.direct=2;
					}
					
					
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();		
					}			
				}
				break;
			case 1:
				
				for (int i=0;i<30;i++){
					if(x<385&&!this.isTouchOther()){
						move(this.direct);
					}
					if(x>=385){
						this.direct=3;
					}
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();	
					}
				}
				break;
			case 2:
				
				for (int i=0;i<30;i++){
					if(y<385&&!this.isTouchOther()){
						move(this.direct);
					}
					if(y>=385){
						this.direct=0;
					}
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			case 3:
				for (int i=0;i<30;i++){
					if(x>15&&!this.isTouchOther()){
						move(this.direct);
					}
					if(x<=15){
						this.direct=1;
					}
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();	
					}
				}
				break;	
			}	
			//��̹������仯����
			this.direct=(int)(Math.random()*4);	
			//�жϵ����Ƿ�����
			if(this.isLive==false){
				//�߳̽���
				break;
			}
		}	
	}	
}
//�ӵ�
class Shot implements Runnable{
	int x;
	int y;
	//�ӵ��ٶ�=1000/sleepTime*speed
	int direct;
	int speed=3;
	long sleepTime=50;
	//�Ƿ񻹻���
	boolean isLive=true;
	public Shot(int x,int y,int direct){
		this.x=x;
		this.y=y;
		this.direct=direct;
		
	}
	public void run() {
		//System.out.println("ShotRunning");
		while(true){
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			switch(direct){
			case 0:
				y-=speed;break;
			case 1:
				x+=speed;break;
			case 2:
				y+=speed;break;
			case 3:
				x-=speed;break;
			}	
			//System.out.println("x "+this.x+" y "+this.y);
			//�ӵ���ʱ����
			//�ж��ӵ��Ƿ�������Ե
			if(this.x<0||this.x>400||this.y<0||this.y>400){
				this.isLive=false;
				break;
			}
		}
		
	}
	
}
// ը����
class Bomb{
	//����ը������
	int x;
	int y;
	//ը������
	int life=9;
	boolean isLive=true;
	public Bomb(int x,int y){
		
		this.x=x;
		this.y=y;
	}
	//��������
	
	public void lifeDown(){
		if(this.life>0){
			life--;
		}
		else{
			this.isLive=false;
		}
	}
}