package com.FileTest;
/**
 * FileOutPutStream
 * @author wsx
 *
 */
import java.io.*;
public class Test2 {

	
	public static void main(String[] args) {
 
		FileOutputStream fos=null;
		File f=new File("f:\\a.txt");
		try {
			fos=new FileOutputStream(f);
			String s=new String("HelloWorld!!\r\n");//�س�
			String s2="���,����!!";
			//�����ֽ�����
			//byte []bytes =new byte[1024];
			fos.write(s.getBytes());
			fos.write(s2.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

}
