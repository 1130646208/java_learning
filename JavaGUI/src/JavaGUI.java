/**
 * GUI开发演示
 * @author wsx
 *
 */

import java.awt.*;
import javax.swing.*;
//JFrame是一个顶层容器类，可以添加其他swing组件的类
public class JavaGUI extends JFrame{
	//把需要的swing组件添加好
	JButton jb1=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaGUI gui=new JavaGUI();
		 
	}
	//构造函数
	public JavaGUI()
	{
		
				//生成按钮
				JButton jb1=new JButton("按钮");
				//添加按钮到窗口
				this.add(jb1);
				//设置标题
				this.setTitle("Hello World");
				//设置大小，按像素
				this.setSize(200,200);
				//设置初始位置
				this.setLocation(1000,800);
				//显示出来
				this.setVisible(true);
				//设置默认关闭,关闭窗口后推出虚拟机
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

