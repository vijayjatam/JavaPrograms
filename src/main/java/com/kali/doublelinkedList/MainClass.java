package com.kali.doublelinkedList;

public class MainClass {
	public static void main(String[] args) {
		doubleLinkedList();
	}
	public static void doubleLinkedList(){
		OwnDouble_LinkedList D_list = new OwnDouble_LinkedList();
		for(int i =1;i<10;i++){
			D_list.addAtEnd(i);
		}
		for(int i =11;i<20;i++){
			D_list.addAtFirst(i);
		}
//		D_list.circlerDoubleLinkedList();
		D_list.printNodes("Y");
		System.out.println("-----------------------------------------------------------------------------------");
		D_list.deleteBasedOnValue(2);
		D_list.printNodes("D");
	}
}
