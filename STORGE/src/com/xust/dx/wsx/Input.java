package com.xust.dx.wsx;
import java.util.*;
//������
public class Input {
	int _quantity;
	String _name;	
	float _price;
	Scanner s=new Scanner(System.in);
	/**
	 * ���캯��
	 */
	Input (){
		this._quantity=0;
		this._name=null;
		this._price=0;
	}
	/**
	 * ���뺯��
	 */
	public void input(){
			System.out.println("+�������������(����Ӣ������):");
			_name=s.next();
			System.out.println("+��������ﵥ��:");
			_price=s.nextFloat();
			System.out.println("+�������������:");
			_quantity=s.nextInt();	
	}
}
