package com.kali.kali.multithreding;

import java.util.HashSet;

import com.kali.STSBean;
import com.kali.multithreding.Consumer;
import com.kali.multithreding.Item;
import com.kali.multithreding.Producer;

public class MainClass {
	public static void main(String[] args) {
		com.kali.multithreding.Item item = new Item();
		new Consumer(item);
		new Producer(item);

		/*new Thread_1(item);
		new Thread_2(item);*/
		
		/*STSBean s1 =new STSBean(10,"kali","123");
		STSBean s2 = new STSBean(10,"kali1","123");
		System.out.println(s1.hashCode()+" , "+s2.hashCode());
		HashSet set =new HashSet<>();
		set.addAtEnd(s1);
		set.addAtEnd(s2);
		System.out.println(set.size());*/
	}
}
