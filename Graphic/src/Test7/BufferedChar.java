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
			
			//br=BufferedReader("f:\\a.txt");����������д
			fr=new FileReader("f:\\a.txt");//�������ļ�����
			fw=new FileWriter("f:\\co.txt");
			br=new BufferedReader(fr);//��װ�뻺��
			bw=new BufferedWriter(fw);
			String s="";
			//readline�����ȡ���з�
			while((s=br.readLine())!=null){
				//System.out.print(s);
				bw.write(s+"\r\n");//�ֶ�����
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
