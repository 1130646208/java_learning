/**
 * GUI������ʾ
 * @author wsx
 *
 */

import java.awt.*;
import javax.swing.*;
//JFrame��һ�����������࣬�����������swing�������
public class JavaGUI extends JFrame{
	//����Ҫ��swing�����Ӻ�
	JButton jb1=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaGUI gui=new JavaGUI();
		 
	}
	//���캯��
	public JavaGUI()
	{
		
				//���ɰ�ť
				JButton jb1=new JButton("��ť");
				//��Ӱ�ť������
				this.add(jb1);
				//���ñ���
				this.setTitle("Hello World");
				//���ô�С��������
				this.setSize(200,200);
				//���ó�ʼλ��
				this.setLocation(1000,800);
				//��ʾ����
				this.setVisible(true);
				//����Ĭ�Ϲر�,�رմ��ں��Ƴ������
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

