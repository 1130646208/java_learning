package Test3;
/**
 * �̳�Thread�����߳�
 */

public class Test3_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat=new Cat();
		cat.start();
	}

}


class Cat extends Thread{
	//��дRun()
	int times=0;
	public void run(){
		while(true)
		{
			//����һ��
			//sleep���ø��߳̽���Block״̬,�ͷ���Դ
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