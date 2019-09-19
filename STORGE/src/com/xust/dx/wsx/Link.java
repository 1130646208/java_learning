package com.xust.dx.wsx;
import java.util.*;
//货物链表类
public class Link {
	Goods firstGood;
	int counter;//总货物种类数
	Scanner s=new Scanner(System.in);
	/**
	 * 增加货物
	 */
	Link(){
		this.firstGood=null;
		this.counter=0;
	}
	public Goods addGoods(){
		Input in=new Input();
		if(this.counter==0){
			//没有货物时	
			in.input();
			this.firstGood=new Goods(in._name,in._quantity,in._price,counter);
			this.firstGood.nextGood=null;
			counter++;
		}else{
			Goods temp=null;
			temp=this.firstGood;
			//找到最后一个货物
			while(temp.nextGood!=null){
				temp=temp.nextGood;
			}
			in.input();
			temp.nextGood=new Goods(in._name,in._quantity,in._price,counter);
			counter++;
			temp=temp.nextGood;
			temp=null;
		}	
		return this.firstGood;
	}
	/**
	 * 显示所有货物
	 */
	public void display(){
		Goods temp=this.firstGood;
		float sum=0f;
		while(temp!=null){
			System.out.print("货物编号:"+temp.num);
			System.out.print("\t货物名称:"+temp.name);
			System.out.print("\t货物数量:"+temp.quantity);
			System.out.println("\t货物单价:"+temp.price+"\t价值:"+temp.price*temp.quantity);
			sum+=temp.price*temp.quantity;
			temp=temp.nextGood;
		}
		if(this.counter==0){
			System.out.println("还没有进货.");
		}else{
			System.out.println("\t\t\t\t\t\t\t\t总值:"+sum);
			System.out.println("货物共:"+this.counter+"种.");
		}
	}	
	/**
	 * 显示某个货物
	 */
	public void showInfo(Goods _goods){
		System.out.println("*货物信息:");
		System.out.print("  货物编号:"+_goods.num+"货物名称:"+_goods.name+" 现有库存:"+_goods.quantity);
		System.out.println();
	}	
	/**
	 * 搜索货物
	 */
	public Goods search(String _name){
		Goods temp=this.firstGood;
		Goods wanted=null;
		byte found='n';
		while(temp!=null){
			if(temp.name ==_name){
				wanted=temp;
				System.out.print("*货物已经找到:");
				showInfo(temp);	
				found='f';
			}
			temp=temp.nextGood;
		}if(found!='f'){
			System.out.println("*没有找到货物.");
		}
		return wanted;
	}
	public Goods search(int _num){
		Goods temp=this.firstGood;
		Goods wanted=null;
		byte found='n';
		while(temp!=null){
			if(temp.num ==_num){
				wanted=temp;
				System.out.print("*货物已经找到:");
				showInfo(temp);
				found='f';
			}
			temp=temp.nextGood;
		}if(found!='f'){
			System.out.println("*没有找到货物.");
		}
		return wanted;
	}
	/**
	 * 删除货物
	 */
	public Goods delete(Goods _goods){
		Goods temp=null;
		//没有货物
		if(_goods==null){
			System.out.println("*没有找到货物,无法删除 .");
			return this.firstGood;
		}//只有一个货物
		else if(this.counter==1){
			this.firstGood=null;
			this.counter--;
		}//最后一个货物
		else if(_goods.nextGood==null){
			temp=this.firstGood;
			while(temp.nextGood!=_goods)
			{temp=temp.nextGood;}
			temp.nextGood=null;
			temp=null;
			this.counter--;
		}else if(_goods==this.firstGood){//第一个货物
			this.firstGood=this.firstGood.nextGood;
			_goods=null;
			this.counter--;
		}else{
			temp=this.firstGood;
			while(temp.nextGood!=_goods)
				{temp=temp.nextGood;}
			temp.nextGood=_goods.nextGood;
			_goods.nextGood=null;
			this.counter--;
			temp=null;
		}
		System.out.println("  此种货物已经删除.");
		return this.firstGood;
	}
	/**
	 * 检查货物库存
	 */
	public void check(){
		if(this.firstGood==null){
			System.out.println("还没有进货.");
		}else{
			Goods temp=this.firstGood;
			//Scanner s= new Scanner(System.in);
			System.out.println("+请输入货物库存量下限:");
			int underLim=0;
			underLim=s.nextInt();
			System.out.println("*以下货物库存不足"+underLim);
			while(temp!=null){			
				if(temp.quantity<=underLim){				
					showInfo(temp);
				}temp=temp.nextGood;
			}
		}
	}
}










