package com.wsx.SplitPane;
import java.awt.*;
import javax.swing.*;
/**
 * 金山词霸界面制作
 * @author wsx
 *
 */
public class JSplitPaneDemo extends JFrame{

	JSplitPane jsp;
	JList jlist;
	JLabel jlb;//可以放图片
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSplitPaneDemo jspd=new JSplitPaneDemo();
	}
	
	public JSplitPaneDemo(){
		//创建组件
		String lst[]={"boy","girl","men","women","bird","shit"};
		jlist = new JList(lst);
		jlb=new JLabel(new ImageIcon("Images\\IMG_20120923_135712.jpg"));//可以放置图片
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jlb);
		//可以收起
		jsp.setOneTouchExpandable(true);
		//不用设置布局管理器,默认Border
		this.setLayout(new GridLayout(1,2,50,50));
		//添加组件
		this.add(jsp);
		//设置窗口属性
		this.setSize(500,500);
		this.setTitle("查词");
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
