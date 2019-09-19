package com.wsx.TankGame9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

//同包访问机制
//静态方法可以直接用类.函数名访问
class Recorder{
	
	//记录有多少敌人
	private static int enNum=20;
	//杀敌数
	private static int killEnNum=0;
	//自己多少命
	private static int myLife=3;
	//存放外面世界的坦克信息
	private static Vector<EnemyTank> ets =new Vector<EnemyTank>();
	//从文件中恢复记录的敌人坦克位置
	static Vector<Node> nodes =new Vector<Node>();
	public static void getNodesAndEnNum(){
		try {
			fr=new FileReader("f:\\tankGameRecorder.txt");
			br=new BufferedReader(fr);
			//先读取第一行
			String s=br.readLine();
			killEnNum=Integer.parseInt(s);	
			System.out.println(s);
			while((s=br.readLine())!=null){
				String []xyz=s.split(" ");//以空格为标志,将读取的行分成字符串数组
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
	//文件
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
	//减少敌人数
	public static void reduceEnemy(){
		enNum--;
		killEnNum++;
	}
	//自己减少生命
	public static void reduceHero(){
		if(myLife>0){
			myLife--;
		}else{
			
		}	
	}
	//读取玩家击败敌军数
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
	//存盘退出
	public static void saveExit(Vector<EnemyTank> ets){
		try {
			fw=new FileWriter("f:\\tankGameRecorder.txt");
			bw=new BufferedWriter(fw);
			//保存击毁数
			bw.write(killEnNum+"\r\n");
			//保存敌人坦克位置
			for (int i=0;i<ets.size();i++){
				EnemyTank et=ets.get(i);
				if(et.isLive){
					//保存活的
					String locate=et.x+" "+et.y+" "+et.direct;
					bw.write(locate+"\r\n");
					System.out.println("正在保存");
					
				}
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭流
			//后开先关
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

//保存敌人坦克位置的点
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

	
//坦克类
class Tank{
	//表示坦克横纵坐标
	int x=0;
	int y=0;
	//坦克方向 0 上 1右 2 下 3 左
	int direct=0;
	//坦克速度
	int speed=1;
	//颜色
	int color=0;
	//是否生存
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
	//构造函数
	public Tank(int x,int y) {
		this.x=x;
		this.y=y;	
	}
	//移动改进,可以实时监控direct,防止坦克横着走
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
//我的坦克
class Hero extends Tank implements Runnable{

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

//敌人坦克 ,为实现移动,做成线程
class EnemyTank extends Tank implements Runnable{
	//boolean isLive=true;//已经移到父类,不能再定义,否则会覆盖父类的,导致敌人坦克死不了
	//敌人子弹向量
	//敌人坦克添加子弹,在创建之后和子弹死亡之后
	Vector<Shot> ss=new Vector<Shot>();
	//定义一个向量,可以访问到panel 上所有的坦克
	Vector<EnemyTank> ets=new Vector<EnemyTank>();	
	public EnemyTank(int x, int y) {
		super(x, y);
	}

	//得到MyPanel上所有坦克,此函数在Mypanel敌人坦克初始化之后调用
	public void setEts(Vector<EnemyTank> vv){
		this.ets=vv;
	}
	
	
	//判断是否撞到别的敌人坦克
	public boolean isTouchOther(){
		boolean b=false;
		switch(this.direct){
		case 0:
		case 2:
			//取出所有敌人坦克
			for(int i=0;i<this.ets.size();i++){
				EnemyTank et=ets.get(i);
				//如果不是自己
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
							//System.out.println("撞到");
							b=true;
						}		
					}else if(et.direct==1||et.direct==3){
						if(Math.abs(this.x-et.x)<=25&&Math.abs(this.y-et.y)<=25){
							//System.out.println("撞到");
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
						System.out.println("意外");
					}			
				}
			}
			break;
		case 1:
		case 3:
			//取出所有敌人坦克
			for(int i=0;i<this.ets.size();i++){
				EnemyTank et=ets.get(i);
				//如果不是自己
				if(et!=this){
					if(et.direct==0||et.direct==2){
						if(Math.abs(this.x-et.x)<=25&&Math.abs(this.y-et.y)<=25){
							//System.out.println("撞到");
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
							//System.out.println("撞到");
							if(et.x>=this.x){
								
								this.move(3);
							}else{
								
								this.move(1);
							}
							b=true;					
						}	
					}else {	
						System.out.println("意外");
					}			
				}
			}
			break;
		}
		return b;		
	}
	
	//
	public void run() {
		//设置敌人速度
		this.speed*=1;
		long sleepTime=30;
		
		while(true){
			switch(this.direct){//限制行动范围
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
	//子弹速度=1000/sleepTime*speed
	int direct;
	int speed=3;
	long sleepTime=50;
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