package Test3;

public class Test3_1 {

	public static void main(String[] args) {
		//����������̳в�ͬ
		Dog dog =new Dog();
		//����Thread����
		Thread th=new Thread(dog);
		th.start();
	}

}

//����java�������̳�,�����ṩ��һ��Runnable�ӿ�
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