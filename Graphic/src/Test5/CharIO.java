package Test5;
import java.io.*;
/**
 * �ַ���
 * @author wsx
 *
 */
public class CharIO {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			//��ȡ���ڴ�
			FileReader fr=null;
			//д�����ļ�
			FileWriter fw=null;
		try {
				//����һ��fr����
				fr=new FileReader("f:\\a.txt");
				fw=new FileWriter("f:\\copyed.txt");
				//��ȡ�����ַ���
				int n=0;
				char c[]=new char[512];
				while((n=fr.read(c))!=-1){
					fw.write(c,0,n);
					String s=new String(c,0,n);
					System.out.println(s);
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally{
			try {
				fr.close();
				fw.close();//���رյĻ�����ɹ�			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
