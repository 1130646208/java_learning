package com.wsx.TankGame10;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.*;

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



//控制类
class KeyBoardListener1 implements KeyListener{

	Hero hero=null;
	
	public void setHero(Hero hero){
		this.hero=hero;
		//System.out.println("GotHero"+hero.x+" "+hero.y);	
	}
	public Hero getHero(){
		return this.hero;
	}
	public void keyPressed(KeyEvent arg0) {
		System.out.println("按下");
		Thread t=new Thread(hero);
		t.start();
		switch(arg0.getKeyCode()){
		case (KeyEvent.VK_W):
			if(hero.y>15){
			hero.setDirect(0);
			}
			break;
		case (KeyEvent.VK_D):
			if(hero.x<385){
			hero.setDirect(1);

			}
			break;
		case (KeyEvent.VK_S):
			if(hero.y<385){
			hero.setDirect(2);	
			}
			break;
		case (KeyEvent.VK_A):
			if(hero.x>15){
				hero.setDirect(3);
			}
			break;
		}	
	}
	public void keyReleased(KeyEvent arg0) {
		
	}
	public void keyTyped(KeyEvent arg0) {
	}
}