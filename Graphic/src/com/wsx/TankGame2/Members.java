package com.wsx.TankGame2;
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

	
	
	public Hero(int x,int y){
		super(x,y);
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