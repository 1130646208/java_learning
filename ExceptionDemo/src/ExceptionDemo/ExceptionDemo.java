package ExceptionDemo;
import java.io.*;
import java.net.Socket;
public class ExceptionDemo {
	public static void main(String args[]){
		try{
			FileReader fr1=new FileReader("d:\\a.txt");
			//在出现异常的地方终止执行，进入catch语句，
			//如果有多个catch ，进入匹配异常的那个语句
			Socket s1=new Socket("192.168.1.1",78);//不会执行此句
		    }catch(FileNotFoundException e){
		    	e.printStackTrace();
			}catch(Exception e1){
				e1.printStackTrace();
			}finally{
				//不管有无异常，都会执行
				//关闭资源等，保险起见
				//try 之后没有catch，只有finally也行
				System.out.println("进入finally");
			}
	}
}

