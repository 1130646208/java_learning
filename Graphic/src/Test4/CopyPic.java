package Test4;
/**
 * ͼƬ����
 * @author wsx
 *
 *˼· �Ȱ�ͼƬ�����ڴ�
 *��д��ĳ���ļ�
 */
import java.io.*;
public class CopyPic {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fis=null;
		FileOutputStream fos=null;
		//��Ϊ�Ƕ������ļ�,���ֻ�����ֽ������
		//�򵥷���:������ File f=new File("123.jpg"); ֱ��д
		try {
			fis=new FileInputStream("bomb_1.gif");
			fos=new FileOutputStream("F:\\Copyed.gif");
			System.out.println("�������");
			byte buf[]=new byte[512];
			int n=0;//��¼��ȡ�����ֽ���
			while((n=fis.read(buf))!=-1){
				//�����ָ���ļ�
				fos.write(buf);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//�ر��ļ�
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
