package com.wsx.TankGame8;
import java.awt.*;//绘图
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;//绘图
import java.awt.event.*;//事件

import java.util.*;//Vector
/**
 * 坦克1.7
 * 坦克会动基础上会发射子弹 
 * 实现连发(限制最多5颗)
 * 实现杀死坦克(敌人坦克消失)
 * 实现爆炸效果
 * 敌人自由移动
 * 自己会被打到并死亡
 * 防止敌人重叠 * 放到enemyTank中
 * 可以分关 * 1关
 */
public class TankGameAlmostFinish extends JFrame implements ActionListener{
	MyPanel mp=null;
	//关卡提示
	MyStart ms=null;
	//游戏菜单
	JMenuBar jmb=null;
	JMenu jm1=null;
	JMenuItem jmi1=null;
	
	public static void main(String[]args){
		TankGameAlmostFinish tg=new TankGameAlmostFinish();
	}
	//构造函数 
	public TankGameAlmostFinish(){
		
		//创建菜单及选项
		jmb=new JMenuBar();
		jm1=new JMenu("游戏(G)");
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("开始游戏(N)");
		jmi1.setVisible(true);
		jmi1.setMnemonic('N');
		jm1.add(jmi1);
		jmb.add(jm1);
		this.setJMenuBar(jmb);
		//注册监听
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		//关卡提示面板
		ms=new MyStart();
		this.add(ms);
		Thread t2=new Thread(ms);
		t2.start();
		//主窗口
		this.setSize(500,550);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("newgame")){
			mp=new MyPanel();
			System.out.println("点击开始");
			//启动mp线程
			Thread t=new Thread(mp);
			t.start();
			//先删除旧的关卡提示面板
			this.remove(ms);
			this.add(mp);
			this.addKeyListener(mp);
			//刷新JFrame
			//this.setVisible(false);
			this.setVisible(true);
		}
		
	}
}
//提示开始
class MyStart extends JPanel implements Runnable{
	boolean drawStage=true;
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 400, 400);
		if(this.drawStage){//闪烁效果
			//提示信息
			g.setColor(Color.yellow);
			Font myFont=new Font("微软雅黑",Font.BOLD,30);
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




//我的面板
class MyPanel extends JPanel implements KeyListener,Runnable{
	


	//定义一个我的坦克
	Hero hero=null;
	//定义敌人坦克组
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	//敌人数量
	int enSize=3;
	//定义三张图片,三张图片组成一颗炸弹
	Image image1=null;
	Image image2=null;
	Image image3=null;
	//定义一颗炸弹集合向量
	Vector<Bomb> bombs=new Vector<Bomb>();
	//构造函数
	public MyPanel(){
		
		//初始化我的坦克
		hero=new Hero(100,300);
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
			//传递到enemyTank
			et.setEts(ets);
		}
		
		//初始化图片,会出现第一个图片加载不明显的问题
//		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
//		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
//		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
		//新的加载图片方法 速度更快
		try {
			//加载图片
			System.out.println("加载图片");
			image1=ImageIO.read(new File("bomb_1.gif"));
			image2=ImageIO.read(new File("bomb_2.gif"));
			image3=ImageIO.read(new File("bomb_3.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
	//画出提示信息
	public void showInfo(Graphics g){
		//画出提示信息的指示器坦克
		this.drawTank(80, 440, g, 0, 1);
		this.drawTank(150, 440, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Recorder.getEnNum()+"", 110, 450);
		g.drawString(Recorder.getMyLife()+"", 180, 450);
		//玩家成绩
		g.setColor(Color.black);
		Font f=new Font("微软雅黑",Font.BOLD,20);
		g.setFont(f);
		g.drawString("分数:",415,50);
		this.drawTank(420, 80, g, 0, 1);
		g.setColor(Color.black);
		g.drawString(Recorder.getKillEnNum()+"", 440, 85);
	}
	//重写paint
	//画坦克和子弹
	public void paint(Graphics g){
		super.paint(g);
		//先用默认颜色把活动区域画出来
		
		g.fillRect(0, 0, 400, 400);
		this.showInfo(g);
		//画自己坦克
		if(this.hero.isLive){
		
			this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 0);
		}
		//画出炸弹
		for (int i=0;i<bombs.size();i++){
			//取出炸弹
			Bomb b=bombs.get(i);
			//System.out.println("炸弹数量"+bombs.size());
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
			if(et.isLive){
				
				this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
			}
			//画敌人坦克的坦克时顺便将子弹画出
			for(int j=0;j<et.ss.size();j++){
				Shot enemyShot=et.ss.get(j);
				if(enemyShot.isLive){
					g.setColor(Color.WHITE);
					g.fill3DRect(enemyShot.x-2, enemyShot.y-2, 4, 4,true);
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
				g.setColor(Color.WHITE);
				g.fill3DRect(myShot.x-2, myShot.y-2, 4, 4,true);
			}
			//限制子弹数量
			if(myShot.isLive==false){
				hero.ss.remove(myShot);
			}
		}
		
	}
	
	//判断子弹是否击中坦克
	public boolean hitTank(Shot s,Tank t){
		boolean hit=false;
		//判断该坦克的方向
		switch(t.direct){
		//上或下
		case 0:
		case 2:
			if (s.x>t.x-15&&s.x<t.x+15&&s.y>t.y-15&&s.y<t.y+15){
				t.isLive=false;
				s.isLive=false;
				//创建一颗炸弹,放入向量
				Bomb b=new Bomb(t.x-15,t.y-15);
				bombs.add(b);
				return true;
			}else return false;

		case 1:
		case 3:
			if (s.y>t.y-15&&s.y<t.y+15&&s.x>t.x-15&&s.x<t.x+15){
				t.isLive=false;
				s.isLive=false;
				//创建一颗炸弹,放入向量
				Bomb b=new Bomb(t.x-15,t.y-15);
				bombs.add(b);
				return true;
			}else return false;
		}
		return hit;
		
	}
	//敌人是否打到我
	public void hitMe(){
		//取出每个坦克	
		for (int i=0;i<this.ets.size();i++){
			EnemyTank et=ets.get(i);
			for (int j=0;j<et.ss.size();j++){
				//取出子弹
				Shot enemyShot=et.ss.get(j);
				if(this.hero.isLive){
					if(this.hitTank(enemyShot, hero))
					{
						Recorder.reduceHero();
					}
				}
			}	
		}
	}
	
	//判断所有子弹是否有击中敌人坦克的
	public void hitEnemyTank(){
		//判断是否击中敌人坦克
		for(int i=0;i<hero.ss.size();i++){
			//取出子弹
			Shot myShot=hero.ss.get(i);
			//判断子弹是否有效
			if(myShot.isLive==true){
				//取出每个敌人坦克判断
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
	//画坦克形状
 	public void drawTank(int x,int y,Graphics g,int direct ,int type){//封装的画坦克函数,包括坦克类型(颜色),坦克方向
		switch(type){
		case 0:
			g.setColor(Color.red);break;//我的
		case 1:
			g.setColor(Color.yellow);break;//敌人
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
		
		Thread t=new Thread(this.hero);
		
		// 设置(改变)我的坦克方向
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
		}
		if(arg0.getKeyCode()==KeyEvent.VK_J){
			//开火
			//限制5颗子弹
			if (this.hero.ss.size()<=3){
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
		//判断是否有敌人坦克被击中
		this.hitEnemyTank();
		//击中我了没
		this.hitMe();
		//判断是否有坦克需要加新的子弹
		for(int i=0;i<ets.size();i++){
			EnemyTank et=ets.get(i);
			if(et.isLive==true){
				if(et.ss.size()<1){//这里可以限制子弹数量
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
		
		//重绘 
		this.repaint();
		}
		
	}
}
