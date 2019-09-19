package com.wsx.TankGame2;
import java.awt.*;//绘图
import javax.swing.*;//绘图
import java.awt.event.*;//事件

import java.util.*;//Vector
/**
 * 坦克1.1
 * 坦克会动
 * @author wsx
 *
 */
public class TankToMove extends JFrame{
	MyPanel mp =null;
	public static void main(String[]args){
		TankToMove tg=new TankToMove();
	}
	
	//构造函数
	public TankToMove(){
		mp=new MyPanel(); 
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
//我的面板
class MyPanel extends JPanel implements KeyListener{
	//定义一个我的坦克
	Hero hero=null;
	//定义敌人坦克组
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	//敌人数量
	int enSize=3;
	//构造函数
	public MyPanel(){
		hero=new Hero(100,100);
		//初始化
		for (int i=0;i<enSize;i++){
			//创建敌人坦克对象
			EnemyTank et=new EnemyTank((i+1)*50,15);
			et.setColor(1);
			et.setDirect(2);
			ets.add(et);
		}
	}
	
	//重写paint
	public void paint(Graphics g){
		super.paint(g);
		//先用默认颜色把活动区域画出来
		g.fillRect(0, 0, 400, 300);
		//画自己坦克
		this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 0);
		//画敌人坦克
		for(int i=0;i<ets.size();i++){
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
		}
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
			//1 左轮
			g.fill3DRect(x-10, y-15, 5, 30,false);
			//2 右轮
			g.fill3DRect(x+5, y-15, 5, 30,false);
			//3 中间矩形
			g.fill3DRect(x-5, y-10, 10, 20,false);
			//4 圆形
			g.fillOval(x-5, y-5, 10, 10);
			//5 画炮筒
			g.drawLine(x, y-15, x,y);
			break;
		case 1://右
			//1 左轮
			g.fill3DRect(x-15, y-10, 30, 5,false);
			//2 右轮
			g.fill3DRect(x-15, y+5, 30, 5,false);
			//3 中间矩形
			g.fill3DRect(x-10, y-5, 20, 10,false);
			//4 圆形
			g.fillOval(x-5, y-5, 10, 10);
			//5 画炮筒
			g.drawLine(x, y, x+15,y);
			break;
		case 2://下
			//1 左轮
			g.fill3DRect(x-10, y-15, 5, 30,false);
			//2 右轮
			g.fill3DRect(x+5, y-15, 5, 30,false);
			//3 中间矩形
			g.fill3DRect(x-5, y-10, 10, 20,false);
			//4 圆形
			g.fillOval(x-5, y-5, 10, 10);
			//5 画炮筒
			g.drawLine(x, y, x,y+15);
			break;
		case 3://左
			//1 左轮
			g.fill3DRect(x-15, y-10, 30, 5,false);
			//2 右轮
			g.fill3DRect(x-15, y+5, 30, 5,false);
			//3 中间矩形
			g.fill3DRect(x-10, y-5, 20, 10,false);
			//4 圆形
			g.fillOval(x-5, y-5, 10, 10);
			//5 画炮筒
			g.drawLine(x, y, x-15,y);
			break;
			
	
			
		}
	}



	//
	public void keyPressed(KeyEvent arg0) {
		// 设置(改变)我的坦克方向
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
		//重绘Panel
		this.repaint();
	}

	public void keyReleased(KeyEvent arg0) {
	
	}

	public void keyTyped(KeyEvent arg0) {
	
	}
}
