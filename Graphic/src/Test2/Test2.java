package Test2;
import javax.swing.*;
/**
 * �¼����� ����״̬ ���״̬
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
		//ע�����
		this.addMouseMotionListener(mp);
		this.addWindowListener(mp);
		this.addMouseListener(mp);//t2�����¼�,���ݸ�mp
		this.setVisible(true);
		this.setSize(200,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	

}



//�õ������λ��
//���ĸ�������
//��Panel֪������ƶ�,��ק
//��Panel֪�����ڱ仯,���,��С����
class MyPanel extends JPanel implements WindowListener,MouseListener,KeyListener,MouseMotionListener{
	public void paint(Graphics g){
		super.paint(g);
	}

	@Override
	//�����
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("x="+arg0.getX()+",y="+arg0.getY());
	}

	@Override
	//������Panel
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("������");
	}

	@Override
	//�뿪Panel
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("����뿪");
	}

	@Override
	//���²��ɿ�
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("��갴��"+arg0.getButton());
	}

	@Override
	//�ɿ�
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("����ɿ�");
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
	//��굱ǰ����
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("����"+arg0.getX());
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