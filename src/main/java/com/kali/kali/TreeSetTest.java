package com.kali.kali;

import com.kali.STSBean;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		/*SortedSet<STSBean> list = new TreeSet<>(new Comparator<STSBean>() {

			@Override
			public int compare(STSBean o1, STSBean o2) {
				// TODO Auto-generated method stub
				return (o1.getNumber().compareTo(o2.getNumber()));
			}
		});*/
		SortedSet<com.kali.STSBean> list = new TreeSet<>();
		
		com.kali.STSBean b1 = new com.kali.STSBean();
		b1.setNumber(15);
		b1.setName("kali");
		b1.setAccount("34");
		
		com.kali.STSBean b2 = new com.kali.STSBean();
		b2.setNumber(13);
		b2.setName("Mahan");
		b2.setAccount("84");
		
		list.add(b1);
		list.add(b2);
		
		com.kali.STSBean b3 = new STSBean();
		b3.setNumber(00);
		b3.setName("Cpu");
		b3.setAccount("93");
		
		list.add(b3);
		System.out.println(list.first().getName());
		System.out.println(list.last().getName());
		/*Collections.sort(new LinkedList<>(list));
		System.out.println(list.first().getNumber());*/
	}
}
