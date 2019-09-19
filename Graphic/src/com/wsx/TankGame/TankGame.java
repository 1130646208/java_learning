package com.wsx.TankGame;
import java.awt.*;
import javax.swing.*;
/**
 * 坦克1.0
 * @author wsx
 *
 */
public class TankGame extends JFrame{
	MyPanel mp =null;
	public static void main(String[]args){
		TankGame tg=new TankGame();
	}
	
	//构造函数
	public TankGame(){
		mp=new MyPanel(); 
		this.add(mp);
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
//我的面板
class MyPanel extends JPanel{
	//定义一个我的坦克
	Hero hero=null;
	//构造函数
	public MyPanel(){
		hero=new Hero(10,10);
	}
	
	
	
	//重写paint
	public void paint(Graphics g){
		super.paint(g);
		//先用默认颜色把活动区域画出来
		g.fillRect(0, 0, 400, 300);
		this.drawTank(hero.getX(), hero.getY(), g, 0, 0);
		
	}
	public void drawTank(int x,int y,Graphics g,int direct ,int type){//封装的画坦克函数,包括坦克类型(颜色),坦克方向
		switch(type){
		case 0:
			g.setColor(Color.CYAN);break;
		case 1:
			g.setColor(Color.yellow);break;
		}
		switch(direct){
		case 0:
			//画出坦克,到时再封装成函数
			//1 左轮
			g.fill3DRect(x, y, 5, 30,true);
			//2 右轮
			g.fill3DRect(x+15, y, 5, 30,true);
			//3 中间矩形
			g.fillRect(x+5, y+5, 10, 20);
			//4 圆形
			g.fillOval(x+5, y+10, 10, 10);
			//5 画炮筒
			g.drawLine(x+10, y, x+10,y+15);
			break;
		}
	}
}

//坦克类
class Tank{
	//表示坦克横纵坐标
	int x=0;
	int y=0;
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
}
