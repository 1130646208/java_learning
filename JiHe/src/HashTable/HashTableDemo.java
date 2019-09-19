package HashTable;
import java.util.*;
public class HashTableDemo {
	public static void main (String args[])
	{
			//����һ��HashMap
			Hashtable ht=new Hashtable();
			Emp emp1=new Emp("123","Wang",456.4f);
			Emp emp2=new Emp("345","Li",456.8f);
			Emp emp3=new Emp("234","Zhang",456.9f);
			ht.put("123",emp1);
			ht.put("234",emp2);
			ht.put("456",emp3);
			//hm.put("123",emp3);//HashMap Key�����ظ���ֱ�Ӹ���
		if(ht.containsKey("123"))
		{
			Emp emp=(Emp)ht.get("123");
			//System.out.println(emp.getName());
		}
		else{
			//do nothing 
			}
			
		//��ô����Hashtable��
		//HashMap��
			//toString() ��Objectת��ΪString
			//Iterator�� ������
		Iterator it=ht.keySet().iterator();
		while (it.hasNext())
		{
			//ȡ��Key
			String key=it.next().toString();
			//ͨ��Keyȡ��value
			Emp emp =(Emp)ht.get(key);
			System.out.println(emp.getEmpNo());
			System.out.println(emp.getName());
			System.out.println(emp.getSal());
		}
	}
}
/**
 * ��Ա��
 * @author wsx
 *
 */
class Emp{
	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getSal() {
		return sal;
	}


	public void setSal(float sal) {
		this.sal = sal;
	}


	private String empNo;
	private String name;
	private float sal;
	
	
	public Emp(String emNo,String name,float sal)
	{
		this.empNo=emNo;
		this.name=name;
		this.sal=sal;
	}
	
}