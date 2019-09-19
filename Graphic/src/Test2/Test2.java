package Test2;
import javax.swing.*;
/**
 * 事件监听 窗口状态 鼠标状态
 */
import java.awt.*;
import java.awt.event.*;
public class Test2 extends JFrame{
	
	MyPanel mp= null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test2 t2=new Test2();
	}
	public Test2(){
		mp=new MyPanel();
		this.add(mp);
		//注册监听
		this.addMouseMotionListener(mp);
		this.addWindowListener(mp);
		this.addMouseListener(mp);//t2发生事件,传递给mp
		this.setVisible(true);
		this.setSize(200,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	

}



//得到点击的位置
//和哪个键按下
//让Panel知道鼠标移动,拖拽
//让Panel知道窗口变化,最大化,最小化等
class MyPanel extends JPanel implements WindowListener,MouseListener,KeyListener,MouseMotionListener{
	public void paint(Graphics g){
		super.paint(g);
	}

	@Override
	//鼠标点击
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("x="+arg0.getX()+",y="+arg0.getY());
	}

	@Override
	//鼠标进入Panel
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("鼠标进入");
	}

	@Override
	//离开Panel
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("鼠标离开");
	}

	@Override
	//按下不松开
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("鼠标按下"+arg0.getButton());
	}

	@Override
	//松开
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("鼠标松开");
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//鼠标当前坐标
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("坐标"+arg0.getX());
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated");
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowClosed");
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing");
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated");
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified");
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened");
	}
}