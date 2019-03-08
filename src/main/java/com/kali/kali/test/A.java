package com.kali.kali.test;

import com.kali.STSBean;
import com.kali.test.test.ParentClass;

public class A extends STSBean{
	protected void m1(){
		System.out.println("from child");
	}
	public static void main(String[] args) {

		long l = 1234_4568;
		long hexBytes = 0xFFECDE5E;//0xFF_EC_DE_5E;//0xFFECDE5E
		long hexWords = 0xCAFE_BABE;
		long maxLong = 0x7fff_ffff_ffff_ffffL;
		System.out.println(0x7A);
		System.out.println(l);
		System.out.println(hexBytes);
		System.out.println(hexWords);
		System.out.println(maxLong);
	}
}
