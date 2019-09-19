package Test3;

public class Test3_1 {

	public static void main(String[] args) {
		//启动方法与继承不同
		Dog dog =new Dog();
		//创建Thread对象
		Thread th=new Thread(dog);
		th.start();
	}

}

//由于java不允许多继承,所以提供了一个Runnable接口
class Dog implements Runnable{
	int times=0;
	public void run(){
		while(true){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("HelloWorld "+times++);
		}
	}
}