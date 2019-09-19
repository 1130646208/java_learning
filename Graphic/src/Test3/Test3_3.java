package Test3;
/**
 * 演示线程注意事项
 * 1 一个线程只能启动一次
 * 2 
 * @author wsx
 *
 */
public class Test3_3 {

	public static void main(String[] args) {
		Cat2 cat1=new Cat2();
		Dog2 dog1=new Dog2();
		Thread t1=new Thread(dog1);
		cat1.start();
		//cat1.start();
		t1.start();
		//t1.start();

	}

}



class Cat2 extends Thread{
	public void run(){
		System.out.println("Cat");
	}
}

class Dog2 implements Runnable{

	public void run() {
		System.out.println("Dog");
		
	}
	
}