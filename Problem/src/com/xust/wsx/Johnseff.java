package com.xust.wsx;
/**
 * @time 2016_11_8
 * @author ��˫��
 * @to do ���Լɪ������
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
	//��ӡ�����к��ӳ��б��
	public void play(int count){
		System.out.println("����˳��:");
		for (int i=0;i<this.len;i++){
			Child temp1=null;
			Child temp2=null;
			temp1=this.firstChild;
			for (int c=1;c<count;c++){
				temp1=temp1.nextChild;
			}//�ҵ����к���temp1
			System.out.println(temp1.num);
			temp2=this.firstChild;
			while(temp2.nextChild!=temp1){
				temp2=temp2.nextChild;
			}
			//����
			if(temp1==this.firstChild){//�����һ�����ӳ���,�ڶ������ӱ�ɵ�һ������
				this.firstChild=this.firstChild.nextChild;
				temp2.nextChild=temp1.nextChild;
			}else{//�������
				this.firstChild=temp1.nextChild;
				temp2.nextChild=temp1.nextChild;
			}temp1=temp2=null;
		}
	}
}
public class Johnseff{
	public static void main(String[] args) {
		CycLink link1= new CycLink(5);//����5�����ӵĻ�����
		link1.createLink();
		link1.play(2);//������֮�����
	}

}
