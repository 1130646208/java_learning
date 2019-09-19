package com.wsx.TankGame6_1;

import java.util.Vector;

//同包访问机制
//坦克类
class Tank{
	//表示坦克横纵坐标
	int x=0;
	int y=0;
	//坦克方向 0 上 1右 2 下 3 左
	int direct=0;
	//坦克速度
	int speed=5;
	//颜色
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
	//构造函数
	public Tank(int x,int y) {
		this.x=x;
		this.y=y;	
	}
	//移动改进,可以实时监控direct,防止坦克横着走
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
//我的坦克
class Hero extends Tank{

	//定义一个子弹
	Shot s=null;
	//Vector 有线程安全性
	//定义子弹向量组
	Vector<Shot> ss=new Vector<Shot>(); 
	
	public Hero(int x,int y){
		super(x,y);
	}
	//开火
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
		t.start();//启动子弹
		
	}
	
//	//坦克移动
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

//敌人坦克 ,为实现移动,做成线程
class EnemyTank extends Tank implements Runnable{

	boolean isLive=true;
	//敌人子弹向量
	Vector<Shot> ss=new Vector<Shot>();
	//敌人坦克添加子弹,在创建之后和子弹死亡之后
	public EnemyTank(int x, int y) {
		super(x, y);
	}

	public void run() {
		
		while(true){
			switch(this.direct){//限制行动范围
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
			
			//让坦克随机变化方向
			this.direct=(int)(Math.random()*4);	
			//判断敌人是否死亡
			if(this.isLive==false){
				//线程结束
				break;
			}
			
		}
		
	}
	
}


//子弹
class Shot implements Runnable{
	int x;
	int y;
	int direct;
	int speed=6;
	//是否还活着
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
			//子弹何时死亡
			//判断子弹是否碰到边缘
			if(this.x<0||this.x>400||this.y<0||this.y>400){
				this.isLive=false;
				break;
			}
		}
		
	}
	
}
// 炸弹类
class Bomb{
	//定义炸弹坐标
	int x;
	int y;
	//炸弹生命
	int life=9;
	boolean isLive=true;
	public Bomb(int x,int y){
		
		this.x=x;
		this.y=y;
	}
	//生命减少
	
	public void lifeDown(){
		if(this.life>0){
			life--;
		}
		else{
			this.isLive=false;
		}
	}
}