package com.wsx.TankGame3;
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
}
//我的坦克
class Hero extends Tank{

	//定义一个子弹
	Shot s=null;
	
	
	public Hero(int x,int y){
		super(x,y);
	}
	//开火
	public void shotEnemy(){
		
		switch(this.direct)
		{
		case 0:
			s=new Shot(x,y-15,0);break;
		case 1:
			s=new Shot(x+15,y,1);break;
		case 2:
			s=new Shot(x,y+15,2);break;
		case 3:
			s=new Shot(x-15,y,3);break;
		}
		Thread t=new Thread(s);
		t.start();//启动子弹
		
	}
	
	//坦克移动
	public void moveUp(){
		this.y-=this.speed;
	}
	public void moveDown(){
		this.y+=this.speed;
	}
	public void moveRight(){
		this.x+=this.speed;
	}
	public void moveLeft(){
		this.x-=this.speed;
	}
}

//敌人坦克
class EnemyTank extends Tank{

	public EnemyTank(int x, int y) {
		super(x, y);
	}
	
}


//子弹
class Shot implements Runnable{
	int x;
	int y;
	int direct;
	int speed=10;
	//是否还活着
	boolean isLive=true;
	public Shot(int x,int y,int direct){
		this.x=x;
		this.y=y;
		this.direct=direct;
		
	}
	public void run() {

		while(true){
			try {
				Thread.sleep(10);
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
			System.out.println("x "+this.x+" y "+this.y);
			//子弹何时死亡
			//判断子弹是否碰到边缘
			if(this.x<0||this.x>400||this.y<0||this.y>400){
				this.isLive=false;
				break;
			}
		}
		
	}
	
	
}