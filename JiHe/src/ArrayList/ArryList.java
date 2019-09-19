package ArrayList;
import java.util.*;
/**
 * 
 * @author wsx
 *
 */
public class ArryList {
	public static void main(String [] args)
	{
		ArrayList al=new ArrayList();
		Clerk clerk1=new Clerk("SongJiang",50,1000);
		Clerk clerk2=new Clerk("WuYong",45,2500);
		Clerk clerk3=new Clerk("WuYong",45,2500);
		al.add(clerk1);
		al.add(clerk2);
		al.add(clerk2);
		al.add(clerk3);
		//��ʾ��С
		System.out.println("al size:"+al.size());
		//��ʾ����
		for (int i=0;i<al.size();i++)
		{
			Clerk temp=(Clerk)al.get(i);//����get()���ص�����ΪOBJECT����Ҫǿ��ת������
			System.out.println("��"+i+"���˵������ǣ�"+temp.getName());
		}
		//ɾ��һ������
		al.remove(2);
		al.remove(1);
		//��ʾ����
		for (int i=0;i<al.size();i++)
		{
			Clerk temp=(Clerk)al.get(i);//����get()���ص�����ΪOBJECT����Ҫǿ��ת������
			System.out.println("��"+i+"���˵������ǣ�"+temp.getName());
		}
	}

} 
/**
 * ����һ��Ա����
 * @author wsx
 *
 */
class Clerk{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	private String name;
	private int age;
	private float sal;
	public Clerk(String name,int age,float sal)
	{
		this.age=age;
		this.name=name;
		this.sal=sal;
	}
}

