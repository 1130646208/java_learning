package com.xust.dx.wsx;
//货物类
public class Goods {
	String name;//货物名称
	float price;//货物单价
	int quantity;//货物库存
	int num;//货物编号
	Goods nextGood=null;//下一个货物
	/**
	 * 构造函数
	 */
	public Goods(String _name,int _quantity,float _price,int _num){
		this.quantity=_quantity;
		this.price=_price;
		this.name=_name;
		this.num=_num;
	}
}
