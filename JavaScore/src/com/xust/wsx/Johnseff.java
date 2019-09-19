package com.xust.wsx;
/**
 * 
 * @author 王双星
 * @TODO 解决约瑟夫问题
 */

class Child{
	int num;
	Child nextChild=null;
	//构造函数自动编号
	public Child(int num){
		this.num=num;
	}
}
class CycLink{
	//链表头和链表长度
	Child firstChild=null;
	int len=0;
	//构造函数确定链表长度
	public CycLink(int len){
		this.len=len;
	}
	public void createLink(){
		//创建第一个孩子
		Child temp=null;
		for(int i=1;i<=this.len;i++){
			if (i==1){
				this.firstChild=new Child(i);
				temp=this.firstChild;
			}//创建其他孩子
			else{
				//最后一个孩子时
				if (i==this.len){
					temp.nextChild=new Child(i);
					temp=temp.nextChild;
					temp.nextChild=this.firstChild;
					temp=null;
				}else{
				temp.nextChild=new Child(i);
				temp=temp.nextChild;
				}
			}
		}	
	}
	//打印链表中孩子编号
	public void print(){
		Child temp=this.firstChild;
		do{
			System.out.println(temp.num);
			temp=temp.nextChild;
		}while(temp!=firstChild);
	}
}
public class Johnseff{
	public static void main(String[] args) {
		CycLink link1= new CycLink(5);
		link1.createLink();
		link1.print();
	}

}
