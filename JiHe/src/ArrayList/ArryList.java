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
		//显示大小
		System.out.println("al size:"+al.size());
		//显示内容
		for (int i=0;i<al.size();i++)
		{
			Clerk temp=(Clerk)al.get(i);//由于get()返回的类型为OBJECT，需要强制转换类型
			System.out.println("第"+i+"个人的名字是："+temp.getName());
		}
		//删除一个对象
		al.remove(2);
		al.remove(1);
		//显示内容
		for (int i=0;i<al.size();i++)
		{
			Clerk temp=(Clerk)al.get(i);//由于get()返回的类型为OBJECT，需要强制转换类型
			System.out.println("第"+i+"个人的名字是："+temp.getName());
		}
	}

} 
/**
 * 定义一个员工类
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

