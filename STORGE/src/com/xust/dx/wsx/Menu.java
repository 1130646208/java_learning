package com.xust.dx.wsx;
import java.util.*;
public class Menu {
	static Scanner s=new Scanner(System.in);
	public static void main (String args[]){
		Link goodsStorge=new Link();
		System.out.println("-------------------------------------------------");
		System.out.println("-----------------�������ϵͳV1.0-----------------");
		System.out.println("��������ȷѡ��------------------------------------");
		System.out.println("-----1:��ӻ���-------2:�����嵥------------------");
		System.out.println("-----3:���һ���-------4:ɾ������------------------");
		System.out.println("-----5:�����-------6:�˳�����------------------");
		System.out.println("-----7:�����ļ�-------8:��ȡ�ļ�------------------");
		System.out.println("-------------------------------------------------");
		while(true)
			action(goodsStorge);
	}
	public static void action(Link _link){
		System.out.println("+������Ҫִ�еĲ���:");
		byte choice;
		choice=s.nextByte();
		switch(choice){
			case 1:
			{
				System.out.println("�밴����ʾ����:");
				_link.addGoods();
				break;
			}
			
			case 2:
			{
				System.out.println("*���������еĻ�����Ϣ:");
				_link.display();
				break;
			}
			
			case 3:
			{
				int _num;
				System.out.println("+������Ҫ���ҵĻ�����:");
				_num=s.nextInt();
				_link.search(_num);
				break;
			}
			case 4:
			{
				int _num;
				System.out.println("+������Ҫɾ���Ļ�����:");
				_num=s.nextInt();
				_link.delete(_link.search(_num));
				break;
			}
			case 5:
			{
				System.out.println("*�������:");
				_link.check();
				break;
			}
			case 6:
				System.out.println("�����˳�...");
				System.out.println("�����Ѿ��˳�,�ر��ն˼���.");
				System.exit(-1);
			case 7:
				System.out.println("�����ڴ�...");
			case 8:
				System.out.println("�����ڴ�...");
			default:
				System.out.println("��������ȷѡ��.");
				break;
		}
	}
}