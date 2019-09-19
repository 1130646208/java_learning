package com.wsx.NotePad;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.*;

public class NotePad extends JFrame implements ActionListener{

	JTextArea jta=null;
	//�˵���
	JMenuBar jmb=null;
	//�˵�һ����Ŀ
	JMenu jm1=null;
	//�˵�������Ŀ
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NotePad np=new NotePad();
	}

	
	
	//���캯��
	public NotePad(){
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm1=new JMenu("�ļ�(F)");
		jm1.setMnemonic('F');//��Alt+F�Զ�չ��
		ImageIcon im1=new ImageIcon("game.ico");
		
		jmi1=new JMenuItem("��",im1);
		System.out.println("ͼ���ȡ�ɹ�"+im1.getDescription()+"�߶�"+im1.getIconHeight());
		jmi2=new JMenuItem("����");
		//��jm1����jmb
		jmb.add(jm1);
		//��jmi1����jm1
		jm1.add(jmi1);
		jm1.add(jmi2);
		//ע�����
		//��
		jmi1.addActionListener(this);
		jmi1.setActionCommand("OPEN");
		//����
		jmi2.addActionListener(this);
		jmi2.setActionCommand("SAVE");
		
		
		
		
		//����JFrame
		this.add(jta);
		//����˵���
		this.setJMenuBar(jmb);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
		
		
	}



	//
	public void actionPerformed(ActionEvent arg0) {
		//�ж����Ǹ��˵���ѡ��
		if(arg0.getActionCommand().equals("OPEN")){
			System.out.println("open");
			//�ļ�ѡ����
			JFileChooser jfc1=new JFileChooser();
			//��������
			jfc1.setDialogTitle("ѡ���ļ�");
			//ʹ��Ĭ�Ϸ�ʽ
			jfc1.showOpenDialog(null);
			//��ʾ
			jfc1.setVisible(true);
			//�õ���ѡ�ļ�·��
			String fileName=jfc1.getSelectedFile().getAbsolutePath();
		
			
			FileReader fr=null;
			BufferedReader br=null;
			//��ȡ�ļ�����ʾ��Panel
			try {
				fr=new FileReader(fileName);
				br=new BufferedReader(fr);
				String s="";
				String allString="";//��ò�Ҫ��ʼ����null
				

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
			//���ֱ���Ի���
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("���Ϊ");
			jfc.showSaveDialog(null);//Ĭ�Ϸ�ʽ
			jfc.setVisible(true);
			//���浽��?
			String fileName2=jfc.getSelectedFile().getAbsolutePath();
			
			//׼��д�뵽ָ���ļ�
			FileWriter fw=null;
			BufferedWriter bw=null;
			try {
				fw=new FileWriter(fileName2);
				bw=new BufferedWriter(fw);
				
				//�˴������Ż���
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
