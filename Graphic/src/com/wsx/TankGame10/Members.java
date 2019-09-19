package com.wsx.TankGame10;
import java.util.Vector;

//ͬ�����ʻ���


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