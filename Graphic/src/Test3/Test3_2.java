package Test3;
/**
 * �����߳�ͬʱ����
 * @author wsx
 *
 */
public class Test3_2 {

	public static void main(String[] args) {
	
		Pig pig=new Pig(10);
		Bird bird=new Bird(10);
		Thread th1=new Thread(pig);
		Thread th2=new Thread(bird);
		th1.start();
		th2.start();

	}

}

class Pig implements Runnable{

	int n=0;
	int times=0;
	public Pig(int n){
		this.n=n;
	}
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			times++;
			System.out.println("�����߳�,���������"+times+"��HelloWorld");
			if(times==n){
				break;
			}
		}
		
		
	}
	
}

class Bird implements Runnable{
	int n=0; 
	int res=0;
	int times=0;
	public void run(){
		
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			res+=(++times);
			System.out.println("��ǰ�����"+res);
			if(times==n){
				System.out.println("�������"+res);
				break;
			}
		} 
	 }
	 public Bird(int n){
		 this.n=n;
	 }
}