package Test;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * �¼��������
 * @author wsx
 *
 */
public class EventProcess extends JFrame implements ActionListener{

	JPanel mp=null;
	JButton jb1=null;
	JButton jb2=null;
	public static void main(String []args){
		EventProcess ep=new EventProcess();
	}
	public EventProcess(){
		mp=new JPanel();
		Cat cat=new Cat();
		mp.setBackground(Color.black);
		jb1=new JButton("��ɫ");
		jb2=new JButton("��ɫ");
		
		this.add(mp);
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		
		
		//ע�����
		jb1.addActionListener(cat);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//ָ��action����
		jb1.setActionCommand("��ɫ");
		jb2.setActionCommand("��ɫ");
		this.setVisible(true);
		this.setSize(200,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	//���¼�����ķ���
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equals("��ɫ"))
		{mp.setBackground(Color.BLACK);}
		else if(ae.getActionCommand().equals("��ɫ"))
		{mp.setBackground(Color.red);}
		System.out.println("���");
	}
	
}
class Cat implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equals("��ɫ")){
			System.out.println("èҲ֪���㰴�º�ɫ��ť.");
		}
	}
	
}

//class MyPanel extends JPanel{
	//public void paint(Graphics g){
		
	//}
//}