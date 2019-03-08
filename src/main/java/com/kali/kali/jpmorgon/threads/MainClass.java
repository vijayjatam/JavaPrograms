package com.kali.kali.jpmorgon.threads;

import com.kali.jpmorgon.threads.PersonThread;

public class MainClass{
	public static void main(String[] args) {
		PersonThread p1 = new PersonThread(10,20);
		PersonThread p2 = new PersonThread(30, 40);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);

		t2.start();
		t1.start();
		try {
			t1.join();
			t2.join();
			System.out.println(p1.val1 * p2.val1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
