package Test;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * 事件处理机制
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
		jb1=new JButton("黑色");
		jb2=new JButton("红色");
		
		this.add(mp);
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		
		
		//注册监听
		jb1.addActionListener(cat);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//指定action命令
		jb1.setActionCommand("黑色");
		jb2.setActionCommand("红色");
		this.setVisible(true);
		this.setSize(200,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	//对事件处理的方法
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equals("黑色"))
		{mp.setBackground(Color.BLACK);}
		else if(ae.getActionCommand().equals("红色"))
		{mp.setBackground(Color.red);}
		System.out.println("点击");
	}
	
}
class Cat implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equals("黑色")){
			System.out.println("猫也知道你按下黑色按钮.");
		}
	}
	
}

//class MyPanel extends JPanel{
	//public void paint(Graphics g){
		
	//}
//}