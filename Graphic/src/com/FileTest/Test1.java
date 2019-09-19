package com.FileTest;
import java.io.*;
/**
 * 字节流
 * @author wsx
 *
 */
public class Test1 {

	public static void main(String[] args) {
		File f=new File("f:\\a.txt");
		FileInputStream fis=null;
		//因为f没有读取功能,所以
		try {
			fis=new FileInputStream(f);
			//定义一个字节数组(合适大小),相当于缓存
			byte []bytes=new byte[1024];
			//循环读取
			int n=0;//实际读取到的字节
			while((n=fis.read(bytes))!=-1){//从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
				//字节转成String         读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1
				String s=new String(bytes,0,n);
				System.out.println("/**/");
				System.out.println(s);
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//关闭文件流,放在此处,执行力高
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
