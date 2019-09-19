package com.wsx.TankGame10;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.*;

//��̬��������ֱ������.����������
class Recorder{
	
	//��¼�ж��ٵ���
	private static int enNum=20;
	//ɱ����
	private static int killEnNum=0;
	//�Լ�������
	private static int myLife=3;
	//������������̹����Ϣ
	private static Vector<EnemyTank> ets =new Vector<EnemyTank>();
	//���ļ��лָ���¼�ĵ���̹��λ��
	static Vector<Node> nodes =new Vector<Node>();
	public static void getNodesAndEnNum(){
		try {
			fr=new FileReader("f:\\tankGameRecorder.txt");
			br=new BufferedReader(fr);
			//�ȶ�ȡ��һ��
			String s=br.readLine();
			killEnNum=Integer.parseInt(s);	
			System.out.println(s);
			while((s=br.readLine())!=null){
				String []xyz=s.split(" ");//�Կո�Ϊ��־,����ȡ���зֳ��ַ�������
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
	//�ļ�
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
	//���ٵ�����
	public static void reduceEnemy(){
		enNum--;
		killEnNum++;
	}
	//�Լ���������
	public static void reduceHero(){
		if(myLife>0){
			myLife--;
		}else{
			
		}	
	}
	//��ȡ��һ��ܵо���
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
	//�����˳�
	public static void saveExit(Vector<EnemyTank> ets){
		try {
			fw=new FileWriter("f:\\tankGameRecorder.txt");
			bw=new BufferedWriter(fw);
			//���������
			bw.write(killEnNum+"\r\n");
			//�������̹��λ��
			for (int i=0;i<ets.size();i++){
				EnemyTank et=ets.get(i);
				if(et.isLive){
					//������
					String locate=et.x+" "+et.y+" "+et.direct;
					bw.write(locate+"\r\n");
					System.out.println("���ڱ���");
					
				}
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ر���
			//���ȹ�
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



//������
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
		System.out.println("����");
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