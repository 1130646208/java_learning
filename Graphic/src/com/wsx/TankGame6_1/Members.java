package com.wsx.TankGame6_1;

import java.util.Vector;

//ͬ�����ʻ���
//̹����
class Tank{
	//��ʾ̹�˺�������
	int x=0;
	int y=0;
	//̹�˷��� 0 �� 1�� 2 �� 3 ��
	int direct=0;
	//̹���ٶ�
	int speed=5;
	//��ɫ
	int color=0;
	
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
			this.y-=this.speed;
			break;
		case 1:
			this.x+=this.speed;
			break;
		case 2:
			this.y+=this.speed;
			break;
		case 3:
			this.x-=this.speed;

		}
	}
}
//�ҵ�̹��
class Hero extends Tank{

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
	
//	//̹���ƶ�
//	public void moveUp(){
//		this.y-=this.speed;
//	}
//	public void moveDown(){
//		this.y+=this.speed;
//	}
//	public void moveRight(){
//		this.x+=this.speed;
//	}
//	public void moveLeft(){
//		this.x-=this.speed;
//	}
	
}

//����̹�� ,Ϊʵ���ƶ�,�����߳�
class EnemyTank extends Tank implements Runnable{

	boolean isLive=true;
	//�����ӵ�����
	Vector<Shot> ss=new Vector<Shot>();
	//����̹������ӵ�,�ڴ���֮����ӵ�����֮��
	public EnemyTank(int x, int y) {
		super(x, y);
	}

	public void run() {
		
		while(true){
			switch(this.direct){//�����ж���Χ
			case 0:
				for (int i=0;i<20;i++){
					if(y>15){
						super.move(this.direct);
					}
					try {
						Thread.sleep(70);
					} catch (InterruptedException e) {
						e.printStackTrace();						
					}	
				}
				break;
			case 1:
				
				for (int i=0;i<20;i++){
					if(x<385){
						super.move(this.direct);
					}
					try {
						Thread.sleep(70);
					} catch (InterruptedException e) {
						e.printStackTrace();	
					}
				}
				break;
			case 2:
				
				for (int i=0;i<20;i++){
					if(y<385){
						super.move(this.direct);
					}
					try {
						Thread.sleep(70);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			case 3:
				for (int i=0;i<20;i++){
					if(x>15){
						super.move(this.direct);
					}
					try {
						Thread.sleep(70);
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
	int direct;
	int speed=6;
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
				Thread.sleep(50);
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