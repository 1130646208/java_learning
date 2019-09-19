package Test1;
/**
 * Java绘图原理讲解
 * @author wsx
 *
 */
import java.awt.*;
import javax.swing.*;

public class Test1 extends JFrame{
	MyPanel mp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test1 t=new Test1();
		
	}
	public Test1(){
		mp=new MyPanel();
		this.add(mp);
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
class MyPanel extends JPanel{
	//覆盖JPanel的paint方法
	//Graphics是绘图的重要类 相当于一支画笔
	int i=0;
	public void paint(Graphics g){
		//调用父类函数完成初始化
		super.paint(g);
//		g.setColor(Color.CYAN);
//		System.out.println("调用"+i++);
//		//画圆
//		g.drawOval(10, 10, 30, 30);
//		//画出直线
//		g.drawLine(50, 50, 100, 100);
//		//画矩形边框
//		g.draw3DRect(70, 70, 90, 90, false);
		//画出一张图片
//		Image im=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1.jpg"));
//		g.drawImage(im, 10, 10, 500, 500, this);
		g.setColor(Color.red);
		g.setFont(new Font("微软雅黑",Font.BOLD,100));
		g.drawString("祖国万岁", 200, 200);
		g.drawArc(100, 100, 100, 100, 500, 50);
		g.drawRect(100, 100, 100, 100);
		
	}
}