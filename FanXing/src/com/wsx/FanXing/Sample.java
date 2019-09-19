package com.wsx.FanXing;
import java.util.*;

/**
 * 泛型
 * @author wsx
 *
 */
public class Sample {

	public static void main(String []args)
	{
		ArrayList a1=new ArrayList();
		
		Gen<String> gen1=new Gen<String>("AAA");
		Gen<Integer> gen2=new Gen<Integer>(123);
		gen1.showTypeName();
		gen2.showTypeName();
		a1.add(gen1);
		a1.add(gen2);
	}
}

class Gen<T>{
	private T o;
	public Gen(T a)
	{
		o=a;
	}
	//显示T的类型名
	public void showTypeName(){
		System.out.println("类型是："+o.getClass().getName());
	}
}

