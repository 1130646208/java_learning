package Test5;
import java.io.*;
/**
 * 字符流
 * @author wsx
 *
 */
public class CharIO {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			//读取到内存
			FileReader fr=null;
			//写出到文件
			FileWriter fw=null;
		try {
				//创建一个fr对象
				fr=new FileReader("f:\\a.txt");
				fw=new FileWriter("f:\\copyed.txt");
				//读取到的字符数
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
				fw.close();//不关闭的话不会成功			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
