package com.kali.kali.multithreding;

import com.kali.multithreding.Item;

public class Thread_2 implements Runnable{
	com.kali.multithreding.Item item;
	public Thread_2(Item item) {
		this.item = item;
		new Thread(this," 2nd: ").start();
	}
	@Override
	public void run() {
		/*int i =item.commonValue;
		while(item.commonValue <10){
			i = item.commonMethod(++i);
		}*/
		printPrim();
		System.exit(0);
	}
	public void printPrim(){
		while(item.commonValue <=10){
			item.printPrim();
		}
	}
	
}
