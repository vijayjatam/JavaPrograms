package com.kali.linkedList;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		LinkedList list =new LinkedList();
		list.addAll(list);
	//	list();
//		setValueInDynamic();
		//showRandom();
		list();
	}
	public static void list(){
		OwnLinkedList linkedList = new OwnLinkedList();
		for(int i =10;i>=1;i--){
			linkedList.addNodeAtFirst(i);
		}
		//linkedList.delete(6);
		for(int i =31;i<=40;i++){
			linkedList.addNodeAtEnd(i);
		}
		OwnNode kthPlaceNode = linkedList.searchNodeFromEnd(23);
		System.out.println("Value : "+kthPlaceNode.VALUE+" : "+kthPlaceNode.hashCode());
	//	System.out.println(linkedList);
		OwnNode listOfNodes = linkedList.revers();
		while(listOfNodes!=null){
			System.out.println(listOfNodes.VALUE+" : "+listOfNodes.hashCode());
			listOfNodes = listOfNodes.NEXT_NODE;
		}
		//System.out.println(linkedList.size());
		
		
		/*OwnNode listOfNodes = linkedList.getLinkedList();
		while(listOfNodes!=null){
			System.out.println(listOfNodes.VALUE+" : "+listOfNodes.hashCode());
			listOfNodes = listOfNodes.NEXT_NODE;
		}
		System.out.println(linkedList.size());*/
		
//		System.out.println(linkedList.middleNode().VALUE+" : "+linkedList.middleNode().hashCode());
		OwnLinkedList linkedList_1 = new OwnLinkedList();
		for(int i =20;i>=11;i--){
			linkedList_1.addNodeAtFirst(i);
		}
		for(int i =21;i<=30;i++){
			linkedList_1.addNodeAtEnd(i);
		}
		/*OwnNode listOfNodes_1 = linkedList_1.getLinkedList();
		while(listOfNodes_1!=null){
			System.out.println(listOfNodes_1.VALUE+" : "+listOfNodes_1.hashCode());
			listOfNodes_1 = listOfNodes_1.NEXT_NODE;
		}*/
		//System.out.println(linkedList_1.size());
		
//		linkedList.addAll(linkedList_1);
		//linkedList.addListAt(10, linkedList_1);
		/*System.out.println(linkedList.size());
		listOfNodes = linkedList.getLinkedList();
		while(listOfNodes!=null){
			System.out.print(listOfNodes.VALUE+" : "+listOfNodes.hashCode());
			listOfNodes = listOfNodes.NEXT_NODE;
			if(listOfNodes!=null)
				System.out.println(" : "+listOfNodes.hashCode());
		}*/
		
		
	}
	
	public static void setValueInDynamic(){
		OwnLinkedList linkedList = new OwnLinkedList();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter how many values you need..?");
		int range = scan.nextInt();
		for(int index = 1;index<=range;index++){
			linkedList.addNodeAtFirst(scan.nextInt());
		}
		System.out.println(linkedList.middleNodeWithEff().VALUE);
	}
	public static void showRandom(){
		Random r = new Random();
		for(int i =1;i<=11;i++){
			System.out.print(r.nextInt(50)+1+" , ");
		}
	}
}
