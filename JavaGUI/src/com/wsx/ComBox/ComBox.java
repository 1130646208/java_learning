package com.wsx.ComBox;
import java.awt.*;
import javax.swing.*;
/**
 * JComboBox(下拉框) JList(列表) JScrollPane(滚动条)
 * @author wsx
 *
 */
public class ComBox extends JFrame{
	//定义组件
	JPanel jp1,jp2;
	JLabel jl1,jl2;
	JComboBox jcb1;
	JList jlist;
	JScrollPane jsp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComBox c=new ComBox();
		
	}
	public ComBox(){
		//生成组件
		jp1=new JPanel();
		jp2=new JPanel();
		
		jl1=new JLabel("籍贯");
		jl2=new JLabel("旅游地点");
		
		String []jg={"北京","天津","上海","火星"};
		jcb1=new JComboBox(jg);
		
		String []dd={"九寨沟","天安门","故宫","长城","华山"};
		jlist =new JList(dd);
		jlist.setVisibleRowCount(2);
		//将list添加到scrollpane
		jsp=new JScrollPane(jlist);
		
		
		//设置布局
		this.setLayout(new GridLayout(2,1));
		//添加组件
		
		jp1.add(jl1);
		jp1.add(jcb1);
		
		jp2.add(jl2);
		jp2.add(jsp);
		
		this.add(jp1);
		this.add(jp2);
		//设置窗口属性
		this.setSize(300,250);
		this.setTitle("调查");
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setResizable(false);
		
	}
	

}
