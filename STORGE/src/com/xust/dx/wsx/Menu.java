package com.xust.dx.wsx;
import java.util.*;
public class Menu {
	static Scanner s=new Scanner(System.in);
	public static void main (String args[]){
		Link goodsStorge=new Link();
		System.out.println("-------------------------------------------------");
		System.out.println("-----------------货物管理系统V1.0-----------------");
		System.out.println("请输入正确选择------------------------------------");
		System.out.println("-----1:添加货物-------2:货物清单------------------");
		System.out.println("-----3:查找货物-------4:删除货物------------------");
		System.out.println("-----5:检查库存-------6:退出程序------------------");
		System.out.println("-----7:保存文件-------8:读取文件------------------");
		System.out.println("-------------------------------------------------");
		while(true)
			action(goodsStorge);
	}
	public static void action(Link _link){
		System.out.println("+请输入要执行的操作:");
		byte choice;
		choice=s.nextByte();
		switch(choice){
			case 1:
			{
				System.out.println("请按照提示输入:");
				_link.addGoods();
				break;
			}
			
			case 2:
			{
				System.out.println("*以下是所有的货物信息:");
				_link.display();
				break;
			}
			
			case 3:
			{
				int _num;
				System.out.println("+请输入要查找的货物编号:");
				_num=s.nextInt();
				_link.search(_num);
				break;
			}
			case 4:
			{
				int _num;
				System.out.println("+请输入要删除的货物编号:");
				_num=s.nextInt();
				_link.delete(_link.search(_num));
				break;
			}
			case 5:
			{
				System.out.println("*库存检查结果:");
				_link.check();
				break;
			}
			case 6:
				System.out.println("正在退出...");
				System.out.println("程序已经退出,关闭终端即可.");
				System.exit(-1);
			case 7:
				System.out.println("敬请期待...");
			case 8:
				System.out.println("敬请期待...");
			default:
				System.out.println("请输入正确选择.");
				break;
		}
	}
}