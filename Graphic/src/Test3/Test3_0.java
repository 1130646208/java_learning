package Test3;
/**
 * 继承Thread开发线程
 */

public class Test3_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat=new Cat();
		cat.start();
	}

}


class Cat extends Thread{
	//重写Run()
	int times=0;
	public void run(){
		while(true)
		{
			//休眠一秒
			//sleep会让该线程进入Block状态,释放资源
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("HelloWorld"+times++);
			if(times==10){
				break;
			}
		}
	}
}