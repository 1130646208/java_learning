package ArrayList;
import java.util.*;
import java.io.*;
/**
 * 
 * @author wsx
 *
 */
public class GuYuan {

	public static void main(String[] args) throws IOException {
		EmpManage em=new EmpManage();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("ѡ�����:");
			System.out.println("1:��ӹ�Ա");
			System.out.println("2:���ҹ�Ա");
			System.out.println("3:�޸Ĺ���");
			System.out.println("4:ɾ����Ա");
			String operType=br.readLine();
			if(operType.equals("1"))
			{
				
				System.out.println("������Ϣ ��� ���� ����");
				String empNo =br.readLine();
				String name=br.readLine();
				float sal=Float.parseFloat(br.readLine());
				Emp emp = new Emp(empNo,name,sal);
				em.addEmp(emp);
				System.out.println("���");
			}
			else if(operType.equals("2"))
			{
				System.out.println("������");
				String empNo=br.readLine();
				em.showInfo(empNo);
			}
			else if (operType.equals("3"))
			{
				System.out.println("������");
				String empNo=br.readLine();
				System.out.println("�����¹���");
				float newSal=Float.parseFloat(br.readLine());
				em.updateSal(empNo, newSal);
				
			}
			else
			{
				System.out.println("����Ҫɾ���ı�ţ�");
				String empNo=br.readLine();
				em.delEmp(empNo);
				
			}
		}
	}

}

class EmpManage{
	private ArrayList al=null;
	//����
	public EmpManage()
	{
		al=new ArrayList();
		
	}
	//����Ա��
	public void addEmp(Emp emp)
	{
		al.add(emp);
	}
	//��ʾԱ���������Ϣ
	public void showInfo(String empNo)
	{
		//��������ArrayList
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			
			
			//�Ƚ�
			if(emp.getEmpNo().equals(empNo))
			{
				System.out.print("Ա����Ϣ"+emp.getEmpNo()+" "+emp.getName()+" "+emp.getSal());
				
			}
		}
		
	}
	//�޸�Ա��нˮ
	public void updateSal(String empNo,float newSal)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			//�Ƚ�
			if(emp.getEmpNo().equals(empNo))
			{
				System.out.print("Ա����Ϣ"+emp.getEmpNo()+" "+emp.getName()+" "+emp.getSal());
				emp.setSal(newSal);
			}
		}
	}
	//ɾ��Ա��
	public void delEmp(String empNo)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			
			
			//�Ƚ�
			if(emp.getEmpNo().equals(empNo))
			{
				al.remove(emp);
			}
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