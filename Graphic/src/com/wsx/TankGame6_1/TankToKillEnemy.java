package com.wsx.TankGame6_1;
import java.awt.*;//绘图
import javax.swing.*;//绘图
import java.awt.event.*;//事件

import java.util.*;//Vector
/**
 * 坦克1.6 (独立改进)
 * 坦克会动基础上会发射子弹 
 * 实现连发(限制最多5颗)
 * 实现杀死坦克(敌人坦克消失)
 * 实现爆炸效果
 * 敌人自由移动
 * 独立改进实现坦克不能互相覆盖
 * @author wsx
 *
 */
public class TankToKillEnemy extends JFrame{
	MyPanel mp =null;
	public static void main(String[]args){
		TankToKillEnemy tg=new TankToKillEnemy();
	}
	
	//构造函数 
	public TankToKillEnemy(){
		mp=new MyPanel(); 
		//启动mp线程
		Thread t=new Thread(mp);
		t.start();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(420,440);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
//我的面板
class MyPanel extends JPanel implements KeyListener,Runnable{
	//定义一个我的坦克
	Hero hero=null;
	//定义敌人坦克组
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	//敌人数量
	int enSize=4;
	//定义三张图片,三张图片组成一颗炸弹
	Image image1=null;
	Image image2=null;
	Image image3=null;
	//定义一颗炸弹集合向量
	Vector<Bomb> bombs=new Vector<Bomb>();
	//构造函数
	public MyPanel(){
		//初始化我的坦克
		hero=new Hero(100,100);
		//初始化敌人坦克
		for (int i=0;i<enSize;i++){
			//创建敌人坦克对象
			EnemyTank et=new EnemyTank((i+1)*50,15);
			et.setColor(1);
			et.setDirect(2);
			//启动敌人坦克
			Thread t=new Thread(et);
			t.start();
			//给敌人坦克添加一颗子弹
			Shot s=new Shot(et.x,et.y+15,2);
			//给敌人坦克添加子弹
			et.ss.add(s);
			Thread t2=new Thread(s);
			t2.start();
			ets.add(et);
		}
		//初始化图片
		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
	}
	
	//重写paint
	//画坦克和子弹
	public void paint(Graphics g){
		super.paint(g);
		//先用默认颜色把活动区域画出来
		g.fillRect(0, 0, 400, 400);
		//画自己坦克
		this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 0);
		//画出炸弹
		for (int i=0;i<bombs.size();i++){
			//取出炸弹
			Bomb b=bombs.get(i);
			System.out.println(""+bombs.size());
			if(b.life>6){
				g.drawImage(image1, b.x, b.y, 30, 30,this);
			}else if(b.life>3){
				g.drawImage(image2, b.x, b.y, 30, 30,this);
			}else{
				g.drawImage(image3, b.x, b.y, 30, 30,this);
			}
			//让b的生命值减少
			b.lifeDown();
			//炸弹生命为零
			if(b.isLive==false){
				bombs.remove(b);
			}
		}
		
		//画敌人坦克
		for(int i=0;i<ets.size();i++){
			//只画活的
			EnemyTank et=ets.get(i);
			if(et.isLive==true){//画敌人坦克
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
			}
			for (int j=0;j<et.ss.size();j++){
				Shot s=et.ss.get(j);
				if(s.isLive){
					g.fill3DRect(s.x-2, s.y-2, 4, 4,true);
				}else{
					//如果子弹死亡 从Vector中移除
					et.ss.remove(j);
				}
			}
			
		}
		
		//从ss中遍历所有子弹 (我的子弹) 
		for(int i=0;i<this.hero.ss.size();i++){
			//取出一颗子弹
			Shot myShot=hero.ss.get(i);
			//画出一颗子弹
			if(myShot!=null && myShot.isLive==true){
				g.fill3DRect(myShot.x-2, myShot.y-2, 4, 4,true);
			}
			//限制子弹数量
			if(myShot.isLive==false){
				hero.ss.remove(myShot);
			}
		}	
	}
	
	
	//判断是否击中
	public void hitTank(Shot s,EnemyTank et){
		
		//判断该坦克的方向
		switch(et.direct){
		//上或下
		case 0:
		case 2:
			if (s.x>et.x-10&&s.x<et.x+10&&s.y>et.y-15&&s.y<et.y+15){
				et.isLive=false;
				s.isLive=false;
				//创建一颗炸弹,放入向量
				Bomb b=new Bomb(et.x-15,et.y-15);
				bombs.add(b);
				}
			break;
		case 1:
		case 3:
			if (s.y>et.y-10&&s.y<et.y+10&&s.x>et.x-15&&s.x<et.x+15){
				et.isLive=false;
				s.isLive=false;
				//创建一颗炸弹,放入向量
				Bomb b=new Bomb(et.x-15,et.y-15);
				bombs.add(b);
				}
			break;
		}
		
	}
	
	
	
	
	//画坦克形状
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

	//按键
	public void keyPressed(KeyEvent arg0) {
		// 设置(改变)我的坦克方向
		if(arg0.getKeyCode()==KeyEvent.VK_W){
			this.hero.setDirect(0);
			this.hero.move(0);
		}else if(arg0.getKeyCode()==KeyEvent.VK_D){
			this.hero.setDirect(1);
			this.hero.move(1);
		}else if(arg0.getKeyCode()==KeyEvent.VK_S){
			this.hero.setDirect(2);
			this.hero.move(2);
		}else if(arg0.getKeyCode()==KeyEvent.VK_A){
			this.hero.setDirect(3);
			this.hero.move(3);}
		if(arg0.getKeyCode()==KeyEvent.VK_J){
			//开火
			//限制5颗子弹
			if (this.hero.ss.size()<=5){
			this.hero.shotEnemy();
			}
		}
		
		//重绘Panel
		
		this.repaint();
	}

	public void keyReleased(KeyEvent arg0) {
	
	}

	public void keyTyped(KeyEvent arg0) {
	
	}


	public void run() {
		System.out.println("PanelRunning");
		//每隔 ms重画
		while(true){
		try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		for(int i=0;i<hero.ss.size();i++){
			//取出子弹
			Shot myShot=hero.ss.get(i);
			//判断子弹是否有效
			if(myShot.isLive==true){
				//取出每个敌人坦克判断
				for(int j=0;j<ets.size();j++){
					EnemyTank et=ets.get(j);
					if(et.isLive==true){
						this.hitTank(myShot, et);
					}
				}
			}
			
		}
		
		//判断是否有坦克需要加新的子弹
		for(int i=0;i<ets.size();i++){
			EnemyTank et=ets.get(i);
			if(et.isLive==true){
				if(et.ss.size()<1){//这里可以限制子弹数量,但是现在发射速度太快,都重叠到一起了
					//没有子弹 添加
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
					//启动子弹
					Thread t=new Thread(s);
					t.start();
				}
			}
		}
		//判断是否撞到
		for (int i=0;i<this.ets.size()-1;i++){
			EnemyTank et=this.ets.get(i);
			for (int j=i+1;j<this.ets.size();j++){
				EnemyTank et2=this.ets.get(j);
				if(Math.abs(et.getX()-et2.getX())<30&&Math.abs(et.getY()-et2.getY())<30){
					//System.out.println("距离"+Math.abs(et.getX()-et2.getX()));
					System.out.println("撞到了");
					if(et.getX()>et2.getX()){
						
						et.setDirect(1);
						et2.setDirect(3);
					
					}else{
						et.setDirect(3);
						et2.setDirect(1);
					}
				}
			}
		}
		
		
		//重绘 
		this.repaint();
		}
		
	}
}
