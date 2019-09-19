package com.xust.dx.wsx;
import java.util.*;
//输入类
public class Input {
	int _quantity;
	String _name;	
	float _price;
	Scanner s=new Scanner(System.in);
	/**
	 * 构造函数
	 */
	Input (){
		this._quantity=0;
		this._name=null;
		this._price=0;
	}
	/**
	 * 输入函数
	 */
	public void input(){
			System.out.println("+请输入货物名称(仅限英文名称):");
			_name=s.next();
			System.out.println("+请输入货物单价:");
			_price=s.nextFloat();
			System.out.println("+请输入货物数量:");
			_quantity=s.nextInt();	
	}
}
