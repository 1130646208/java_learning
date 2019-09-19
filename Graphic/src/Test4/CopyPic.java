package Test4;
/**
 * 图片拷贝
 * @author wsx
 *
 *思路 先把图片读入内存
 *再写入某个文件
 */
import java.io.*;
public class CopyPic {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fis=null;
		FileOutputStream fos=null;
		//因为是二进制文件,因此只能用字节流完成
		//简单方法:不用先 File f=new File("123.jpg"); 直接写
		try {
			fis=new FileInputStream("bomb_1.gif");
			fos=new FileOutputStream("F:\\Copyed.gif");
			System.out.println("拷贝完成");
			byte buf[]=new byte[512];
			int n=0;//记录读取到的字节数
			while((n=fis.read(buf))!=-1){
				//输出到指定文件
				fos.write(buf);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭文件
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
