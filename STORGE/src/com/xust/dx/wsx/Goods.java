package com.xust.dx.wsx;
//������
public class Goods {
	String name;//��������
	float price;//���ﵥ��
	int quantity;//������
	int num;//������
	Goods nextGood=null;//��һ������
	/**
	 * ���캯��
	 */
	public Goods(String _name,int _quantity,float _price,int _num){
		this.quantity=_quantity;
		this.price=_price;
		this.name=_name;
		this.num=_num;
	}
}
