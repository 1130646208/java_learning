package com.FileTest;
import java.io.*;
/**
 * �ֽ���
 * @author wsx
 *
 */
public class Test1 {

	public static void main(String[] args) {
		File f=new File("f:\\a.txt");
		FileInputStream fis=null;
		//��Ϊfû�ж�ȡ����,����
		try {
			fis=new FileInputStream(f);
			//����һ���ֽ�����(���ʴ�С),�൱�ڻ���
			byte []bytes=new byte[1024];
			//ѭ����ȡ
			int n=0;//ʵ�ʶ�ȡ�����ֽ�
			while((n=fis.read(bytes))!=-1){//�Ӵ��������н���� b.length ���ֽڵ����ݶ���һ�� byte �����С�
				//�ֽ�ת��String         ���뻺�������ֽ������������Ϊ�Ѿ������ļ�ĩβ��û�и�������ݣ��򷵻� -1
				String s=new String(bytes,0,n);
				System.out.println("/**/");
				System.out.println(s);
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//�ر��ļ���,���ڴ˴�,ִ������
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
