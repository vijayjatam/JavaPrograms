package com.kali;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class StringOperation_Test {

	public static void main(String[] args) {
		Object obj = new Object();
		//test();
		removeLast();
		//--------------------------------------------
		String abc = "Mahan";
		String def = new String();
		int lenght = abc.length();
		for (int i = lenght; i >0 ; i--) {
			def = def.concat(abc.substring(i-1,i));
		}
		System.out.println(def);
		char a = abc.charAt(lenght-1);
		System.out.println(a);
		System.out.println(abc.concat(" sis"));
		System.out.println(abc.concat(def));
		//System.out.println(abc.concat(null));
		char[] charArry = new char[abc.length()];
		charArry= Arrays.copyOf(abc.toCharArray(), charArry.length);
		System.out.println(charArry[charArry.length-1]);
		//------------------------------------------
		StringBuffer str =new StringBuffer(2);
		System.out.println(str+" Capacity: "+str.capacity());
		str.append("abcdefgh");
		System.out.println(str+" Capacity: "+str.capacity());
		//----------------------------------------

		String str1 = new String("java");
		String str2 = new String("java");
		String str3 = "java";
		str2 = str2.intern();
		System.out.println(str1.toString().hashCode()+" : "+str2.toString().hashCode());
		System.out.println(str1.hashCode()+" : "+str2.hashCode()+" : "+str3.hashCode());
		
		System.out.println("0".codePointAt(0));
		System.out.println("java".hashCode()=="java".hashCode());
		System.out.println(str3==str2);
		new Object().equals(new Object());
		//---------------------------------------
		String sourceStr = "abcaba";
		String numbers = sourceStr.replaceAll("[^0-9]", "");
		String chars = sourceStr.replaceAll("[a-zA-Z]", "a-zA-Z ");
		System.out.println(chars);
		//-----------------------------------------
		String str23 = "[]";
		for(int i =0;i<str23.length();i++){
			if(String.valueOf(str23.charAt(i)).equals("[")){
				System.out.println(true);
			}
		}
	}
	
	
	public static void test(){
		HashMap<Integer,TestingBean> map =new HashMap();
		TestingBean t1 = new TestingBean();
		Byte b = (byte) -129;
		TestingBean t2 = new TestingBean();
		t2.setIntr(4);
		TestingBean t3 = new TestingBean();
		t3.setDoubl(10.23);
		TestingBean t4 = new TestingBean();
		t4.setStr("54");
		map.put(1, t1);
		map.put(2, t2);
		map.put(3, t3);
		map.put(4, t4);
		System.out.println(map);
		for(Map.Entry<Integer,TestingBean> tb : map.entrySet()){
			TestingBean t = tb.getValue();
			t.setIntr(12);
		}
		System.out.println(map);
	}
	public static void removeLast(){
		StringBuffer sb = new StringBuffer();
		sb.append("ajfldksjafk,saklfjdsafkds,,,ajdskjfksd,ksajfdsa,,safkdjafjdsakfdjs,,,,,,,");
		String st = sb.toString();
		String[] strarr = st.split(",");
		System.out.println(strarr[2]);
		System.out.println(st.replaceAll("(,)*$", ""));


	}
}
