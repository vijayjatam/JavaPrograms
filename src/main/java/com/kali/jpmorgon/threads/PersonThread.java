package com.kali.jpmorgon.threads;

public class PersonThread implements Runnable{
	int val1,val2;
	public PersonThread(int a, int b) {
		this.val1=a;
		this.val2=b;
	}
	@Override
	public void run() {
		val1 = this.val1+this.val2;
		System.out.println(val1);
	}
}
