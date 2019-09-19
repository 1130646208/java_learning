package com.xust.wsx;
/**
 * @time 2016_11_8
 * @author 王双星
 * @to do 解决约瑟夫问题
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
	//打印链表中孩子出列编号
	public void play(int count){
		System.out.println("出列顺序:");
		for (int i=0;i<this.len;i++){
			Child temp1=null;
			Child temp2=null;
			temp1=this.firstChild;
			for (int c=1;c<count;c++){
				temp1=temp1.nextChild;
			}//找到出列孩子temp1
			System.out.println(temp1.num);
			temp2=this.firstChild;
			while(temp2.nextChild!=temp1){
				temp2=temp2.nextChild;
			}
			//出列
			if(temp1==this.firstChild){//如果第一个孩子出列,第二个孩子变成第一个孩子
				this.firstChild=this.firstChild.nextChild;
				temp2.nextChild=temp1.nextChild;
			}else{//其他情况
				this.firstChild=temp1.nextChild;
				temp2.nextChild=temp1.nextChild;
			}temp1=temp2=null;
		}
	}
}
public class Johnseff{
	public static void main(String[] args) {
		CycLink link1= new CycLink(5);//创建5个孩子的环队列
		link1.createLink();
		link1.play(2);//数两下之后出列
	}

}
