package ExceptionDemo;
import java.io.*;
import java.net.Socket;
public class ExceptionDemo {
	public static void main(String args[]){
		try{
			FileReader fr1=new FileReader("d:\\a.txt");
			//�ڳ����쳣�ĵط���ִֹ�У�����catch��䣬
			//����ж��catch ������ƥ���쳣���Ǹ����
			Socket s1=new Socket("192.168.1.1",78);//����ִ�д˾�
		    }catch(FileNotFoundException e){
		    	e.printStackTrace();
			}catch(Exception e1){
				e1.printStackTrace();
			}finally{
				//���������쳣������ִ��
				//�ر���Դ�ȣ��������
				//try ֮��û��catch��ֻ��finallyҲ��
				System.out.println("����finally");
			}
	}
}

