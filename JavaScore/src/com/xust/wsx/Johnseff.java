package com.xust.wsx;
/**
 * 
 * @author ��˫��
 * @TODO ���Լɪ������
 */

class Child{
	int num;
	Child nextChild=null;
	//���캯���Զ����
	public Child(int num){
		this.num=num;
	}
}
class CycLink{
	//����ͷ��������
	Child firstChild=null;
	int len=0;
	//���캯��ȷ��������
	public CycLink(int len){
		this.len=len;
	}
	public void createLink(){
		//������һ������
		Child temp=null;
		for(int i=1;i<=this.len;i++){
			if (i==1){
				this.firstChild=new Child(i);
				temp=this.firstChild;
			}//������������
			else{
				//���һ������ʱ
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
	//��ӡ�����к��ӱ��
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
