package com.wsx.SplitPane;
import java.awt.*;
import javax.swing.*;
/**
 * ��ɽ�ʰԽ�������
 * @author wsx
 *
 */
public class JSplitPaneDemo extends JFrame{

	JSplitPane jsp;
	JList jlist;
	JLabel jlb;//���Է�ͼƬ
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSplitPaneDemo jspd=new JSplitPaneDemo();
	}
	
	public JSplitPaneDemo(){
		//�������
		String lst[]={"boy","girl","men","women","bird","shit"};
		jlist = new JList(lst);
		jlb=new JLabel(new ImageIcon("Images\\IMG_20120923_135712.jpg"));//���Է���ͼƬ
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jlb);
		//��������
		jsp.setOneTouchExpandable(true);
		//�������ò��ֹ�����,Ĭ��Border
		this.setLayout(new GridLayout(1,2,50,50));
		//������
		this.add(jsp);
		//���ô�������
		this.setSize(500,500);
		this.setTitle("���");
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
