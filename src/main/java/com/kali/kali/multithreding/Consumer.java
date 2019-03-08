package com.kali.kali.multithreding;

import com.kali.multithreding.Item;

public class Consumer implements Runnable{
	com.kali.multithreding.Item item;
	public Consumer(Item item) {
		this.item = item;
		new Thread(this,"Even").start();
	}
	@Override
	public void run() {
		while (item.commonValue<10) {
			item.evenPrint();
		}
	}
	/*@Override
	public void run() {
		int i = 0;
		while(i<5){
			i = item.consum();
		}
		
	}*/
}
