package com.kali.multithreding;

public class Item {
	boolean notifyFlag = false;
	int commonValue = 0;
	int prim = 2;
	public synchronized void prod(int value){
		if(!notifyFlag){
			try{
				System.out.println(Thread.currentThread().getName()+" , Waiting");
				wait(1000);

			}catch(InterruptedException IE){
				
			}
		}
		this.commonValue = value;
		this.notifyFlag = false;
		System.out.println(Thread.currentThread().getName()+" , "+ commonValue);
		notify();
		
	}
	public synchronized int consum(){
		if(notifyFlag){
			try {
				System.out.println(Thread.currentThread().getName()+" , Waiting");
				wait(1000);
			} catch (InterruptedException e) {
			}
		}
		this.notifyFlag = true;
		System.out.println(Thread.currentThread().getName()+" , "+ commonValue);
		notify();
		return commonValue;
		
	}
	public synchronized int commonMethod(int value){
		this.commonValue = value;
		System.out.println(Thread.currentThread().getName()+" "+this.commonValue);
		notify();
		try {
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonValue;
	}
	public synchronized int printPrim(){
		if(!findPrim(prim)){
			commonValue++;
			System.out.println(Thread.currentThread().getName()+" : "+prim);
			++prim;
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			++prim;
			printPrim();
		}
		return prim;
	}
	private boolean findPrim(int value){
		boolean flage = false;
		if(value==2)
			return flage;
		for(int index =2;index<=Math.sqrt(value);index++){
			if(value%index == 0){
				flage = true;
				break;
			}
		}
		return flage;
		/*if(flage)
			return 0;
		return 1;*/
	}
	public synchronized void  evenPrint(){
		if (!notifyFlag) {
			try {
				wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(this.commonValue <10) {
			this.commonValue = ++commonValue;
			System.out.println(Thread.currentThread().getName() + " , " + this.commonValue);
			notifyFlag = false;
			notify();
		}
	}
	public synchronized void  oddPrint(){
		if (notifyFlag) {
			try {
				wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(this.commonValue <10) {
			this.commonValue = ++commonValue;
			System.out.println(Thread.currentThread().getName() + " , " + this.commonValue);
			notifyFlag = true;
			notify();
		}
	}
	public void printValues(){
		synchronized (this){
			for (int i =1;i<=10;i++){
				System.out.println(Thread.currentThread().getName()+" , "+i);
				notify();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
