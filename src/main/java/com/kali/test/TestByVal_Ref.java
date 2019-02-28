package com.kali.test;

import com.kali.STSBean;

public class TestByVal_Ref {
	int _value = 10;
	int $value = 10;
	int value = 100;
	public static void main(String[] args) {
		STSBean s1 = new STSBean();
		s1.setAccount("10121");
		STSBean s2 = new STSBean();
		s2.setAccount("0000");
		swap(s1,s2);
		System.out.println(s1.getAccount()+"  ,  "+s2.getAccount());
		String st1 = "kali";
		String st2 = "mahan";
		System.out.println(swaping("kali",st2));
		System.out.println(st1+"  "+st2);
		
	}
	public static void swap(STSBean s1 , STSBean s2){
		STSBean temp = s1;

		s1 = s2;
		s2 = temp;
		//s1.setAccount("25435");
	}
	public static String swaping(String s1, String s2){
		s1.concat(" java");
		//s2 = s1;
		s1 = s1.intern();
		
		return s1+s2;
	}
}
