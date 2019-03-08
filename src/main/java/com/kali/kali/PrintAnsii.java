package com.kali.kali;

public class PrintAnsii {
	public static void main(String[] args) {
		for(int i=32;i<256;i++){
			System.out.println(i+" -> "+(char)i);
			
		}
		/**
		 * 402 -> �
		 * 381 -> �
		 * 382 -> �
		 * 376 -> �
		 * 352 -> �
		 * 353 -> �
		 * 338 -> �
		 * 339 -> �
		 * 
		 * 
		 * 
		 * */
		//onString();
	}
	public static void onString(){
		String s1 ="SWA";
		String s2 ="Kali";
		String s3 ="Kali";
		String s4 ="Kali";
		String s5 ="Kali";
		String s6 ="Kali";
		System.out.println(s1.hashCode()+","+s2.hashCode()+","+s3.hashCode());
	}
}
