package Test3;
/**
 * �̲߳��� �̰߳�ȫ����
 * @author wsx
 *
 */
public class Test3_4 {

	public static void main(String[] args) {
		//����������Ʊ����
		TicketWindow tw1=new TicketWindow();
		TicketWindow tw2=new TicketWindow();
		TicketWindow tw3=new TicketWindow();
		
		//�߳���������
//		Thread th1=new Thread(tw1);
//		Thread th2=new Thread(tw2);
//		Thread th3=new Thread(tw3);
		//�̲߳���
		//�̰߳�ȫ����
		Thread th1=new Thread(tw1);
		Thread th2=new Thread(tw1);
		Thread th3=new Thread(tw1);
		
		th1.start();
		th2.start();
		th3.start();
	}

}

//��Ʊ������
class TicketWindow implements Runnable{
	//һ����ǧ��Ʊ
	private int nums=20;
	//private Dogg dogg=new Dogg();
	
	public void run(){
		
		while(true){
			//��Ϊ if else Ҫ��֤��ԭ����[ͬ�������]
			//this ������
			//������ʱ�������߳��ȱ������̵߳ȴ���
			//�ȴ��������̵߳�ʱ��,������ֱ�ӽ���ȴ���
			//doggҲ������Ϊ������
			synchronized(this){
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (nums>0){
					//Thread.currentThread().getName()�߳�����
					System.out.println(Thread.currentThread().getName());
					System.out.println("���۳��� "+nums+"��Ʊ");
					nums--;
				}
				else break;
			}
		}
	}
}

class Dogg{
	//Ҳ������Ϊ������
}