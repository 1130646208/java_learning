package com.GridLayoutDemo;
import java.awt.*;
import javax.swing.*;
/**
 * GridLayout��ʾ
 * @author wsx
 *
 */
public class GridLayoutDemo extends JFrame {
	int size = 9;
	JButton jbs[]=new JButton[size];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GridLayoutDemo gld= new GridLayoutDemo();
	}
	
	public GridLayoutDemo(){
		
		//�������
		for(int i=0;i<size;i++){
			jbs[i]= new JButton(String.valueOf(i));
		}
		
		
		
		//�������񲼾ֹ�����
		
		this.setLayout(new GridLayout(3,3,10,10));//�� �� ˮƽ��϶ ��ֱ��϶
		
		//������
		for(int i=0;i<size;i++){
			this.add(jbs[i]);
		}
		
		//���ô�������
		
		this.setTitle("��ʾ��ʽ���ֹ�����");
		this.setSize(200,200);
		this.setResizable(false);//��ֹ�޸Ĵ��ڴ�С
		this.setLocation(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
