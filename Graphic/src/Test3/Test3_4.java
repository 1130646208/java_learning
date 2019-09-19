package Test3;
/**
 * 线程并发 线程安全问题
 * @author wsx
 *
 */
public class Test3_4 {

	public static void main(String[] args) {
		//定义三个售票窗口
		TicketWindow tw1=new TicketWindow();
		TicketWindow tw2=new TicketWindow();
		TicketWindow tw3=new TicketWindow();
		
		//线程正常启动
//		Thread th1=new Thread(tw1);
//		Thread th2=new Thread(tw2);
//		Thread th3=new Thread(tw3);
		//线程并发
		//线程安全问题
		Thread th1=new Thread(tw1);
		Thread th2=new Thread(tw1);
		Thread th3=new Thread(tw1);
		
		th1.start();
		th2.start();
		th3.start();
	}

}

//售票窗口类
class TicketWindow implements Runnable{
	//一共两千张票
	private int nums=20;
	//private Dogg dogg=new Dogg();
	
	public void run(){
		
		while(true){
			//认为 if else 要保证其原子性[同步代码块]
			//this 对象锁
			//上锁的时候其他线程先被放入线程等待池
			//等待池里有线程的时候,后来的直接进入等待池
			//dogg也可以作为对象锁
			synchronized(this){
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (nums>0){
					//Thread.currentThread().getName()线程名字
					System.out.println(Thread.currentThread().getName());
					System.out.println("在售出第 "+nums+"张票");
					nums--;
				}
				else break;
			}
		}
	}
}

class Dogg{
	//也可以作为对象锁
}