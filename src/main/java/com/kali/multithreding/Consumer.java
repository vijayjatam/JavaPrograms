package com.kali.multithreding;

public class Consumer implements Runnable{
	Item item;
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
