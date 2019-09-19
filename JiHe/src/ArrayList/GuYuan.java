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
			System.out.println("选择操作:");
			System.out.println("1:添加雇员");
			System.out.println("2:查找雇员");
			System.out.println("3:修改工资");
			System.out.println("4:删除雇员");
			String operType=br.readLine();
			if(operType.equals("1"))
			{
				
				System.out.println("输入信息 编号 姓名 工资");
				String empNo =br.readLine();
				String name=br.readLine();
				float sal=Float.parseFloat(br.readLine());
				Emp emp = new Emp(empNo,name,sal);
				em.addEmp(emp);
				System.out.println("完成");
			}
			else if(operType.equals("2"))
			{
				System.out.println("输入编号");
				String empNo=br.readLine();
				em.showInfo(empNo);
			}
			else if (operType.equals("3"))
			{
				System.out.println("输入编号");
				String empNo=br.readLine();
				System.out.println("输入新工资");
				float newSal=Float.parseFloat(br.readLine());
				em.updateSal(empNo, newSal);
				
			}
			else
			{
				System.out.println("输入要删除的编号：");
				String empNo=br.readLine();
				em.delEmp(empNo);
				
			}
		}
	}

}

class EmpManage{
	private ArrayList al=null;
	//构造
	public EmpManage()
	{
		al=new ArrayList();
		
	}
	//加入员工
	public void addEmp(Emp emp)
	{
		al.add(emp);
	}
	//显示员工的相关信息
	public void showInfo(String empNo)
	{
		//遍历整个ArrayList
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			
			
			//比较
			if(emp.getEmpNo().equals(empNo))
			{
				System.out.print("员工信息"+emp.getEmpNo()+" "+emp.getName()+" "+emp.getSal());
				
			}
		}
		
	}
	//修改员工薪水
	public void updateSal(String empNo,float newSal)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			//比较
			if(emp.getEmpNo().equals(empNo))
			{
				System.out.print("员工信息"+emp.getEmpNo()+" "+emp.getName()+" "+emp.getSal());
				emp.setSal(newSal);
			}
		}
	}
	//删除员工
	public void delEmp(String empNo)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			
			
			//比较
			if(emp.getEmpNo().equals(empNo))
			{
				al.remove(emp);
			}
		}
	}
}


/**
 * 雇员类
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