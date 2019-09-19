package com.wsx.NotePad;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.*;

public class NotePad extends JFrame implements ActionListener{

	JTextArea jta=null;
	//菜单条
	JMenuBar jmb=null;
	//菜单一级项目
	JMenu jm1=null;
	//菜单二级项目
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NotePad np=new NotePad();
	}

	
	
	//构造函数
	public NotePad(){
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm1=new JMenu("文件(F)");
		jm1.setMnemonic('F');//按Alt+F自动展开
		ImageIcon im1=new ImageIcon("game.ico");
		
		jmi1=new JMenuItem("打开",im1);
		System.out.println("图像读取成功"+im1.getDescription()+"高度"+im1.getIconHeight());
		jmi2=new JMenuItem("保存");
		//把jm1放入jmb
		jmb.add(jm1);
		//把jmi1放入jm1
		jm1.add(jmi1);
		jm1.add(jmi2);
		//注册监听
		//打开
		jmi1.addActionListener(this);
		jmi1.setActionCommand("OPEN");
		//保存
		jmi2.addActionListener(this);
		jmi2.setActionCommand("SAVE");
		
		
		
		
		//放入JFrame
		this.add(jta);
		//加入菜单条
		this.setJMenuBar(jmb);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
		
		
	}



	//
	public void actionPerformed(ActionEvent arg0) {
		//判断是那个菜单被选中
		if(arg0.getActionCommand().equals("OPEN")){
			System.out.println("open");
			//文件选择器
			JFileChooser jfc1=new JFileChooser();
			//设置名字
			jfc1.setDialogTitle("选择文件");
			//使用默认方式
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			//得到所选文件路径
			String fileName=jfc1.getSelectedFile().getAbsolutePath();
		
			
			FileReader fr=null;
			BufferedReader br=null;
			//读取文件并显示到Panel
			try {
				fr=new FileReader(fileName);
				br=new BufferedReader(fr);
				String s="";
				String allString="";//最好不要初始化成null
				

				while((s=br.readLine())!=null){
					//System.out.println(s);
					System.out.println(allString);
					allString+=(s+"\r\n");
				}
				jta.setText(allString);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
				try {
					fr.close();
					br.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			System.out.println(fileName);
		}else if(arg0.getActionCommand().equals("SAVE")){
			//出现保存对话框
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("另存为");
			jfc.showSaveDialog(null);//默认方式
			jfc.setVisible(true);
			//保存到哪?
			String fileName2=jfc.getSelectedFile().getAbsolutePath();
			
			//准备写入到指定文件
			FileWriter fw=null;
			BufferedWriter bw=null;
			try {
				fw=new FileWriter(fileName2);
				bw=new BufferedWriter(fw);
				
				//此处可以优化下
				bw.write(this.jta.getText());

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					bw.close();
					fw.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		}		
	}
}
