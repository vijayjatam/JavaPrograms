package com.kali.kali.multithreding;

import com.kali.multithreding.Item;

public class Producer implements Runnable{
	com.kali.multithreding.Item item;
	public Producer(Item item) {
		this.item = item;
		new Thread(this,"Odd").start();
	}
	@Override
	public void run() {
		while (item.commonValue<10) {
			item.oddPrint();
		}
	}
	/*@Override
	public void run() {
		int i =0;
		while(i<=5){
			item.prod(i++);
		}
//		System.exit(0);
	}*/
}
