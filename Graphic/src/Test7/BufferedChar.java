package Test7;
import java.io.*;
public class BufferedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		FileWriter fw=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try {
			
			//br=BufferedReader("f:\\a.txt");不允许这样写
			fr=new FileReader("f:\\a.txt");//先生成文件缓冲
			fw=new FileWriter("f:\\co.txt");
			br=new BufferedReader(fr);//再装入缓冲
			bw=new BufferedWriter(fw);
			String s="";
			//readline不会读取换行符
			while((s=br.readLine())!=null){
				//System.out.print(s);
				bw.write(s+"\r\n");//手动换行
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				
				br.close();
				
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
