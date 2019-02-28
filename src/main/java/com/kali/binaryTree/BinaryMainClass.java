package com.kali.binaryTree;

import java.util.Random;

public class BinaryMainClass {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Node<Integer> n1 = new Node<Integer>(9);
		Node<Integer> n2 = new Node<Integer>(13);
		Node<Integer> n3 = new Node<Integer>(15);
		Node<Integer> n4 = new Node<Integer>(7);
		Node<Integer> n5 = new Node<Integer>(8);
		Node<Integer> n6 = new Node<Integer>(0);
		Node<Integer> n7 = new Node<Integer>(16);
		
		bt.addToTree(n1);
		bt.addToTree(n3);
		bt.addToTree(n2);
		bt.addToTree(n4);
		bt.addToTree(n5);
		bt.addToTree(n6);
		bt.addToTree(n7);
		
		/*Random r = new Random();
		for(int i =1;i<=5;i++){
			Node<Integer> n = new Node<Integer>(r.nextInt(10)+1);
			bt.addToTree(n);
		}*/
		System.out.print(bt.toString());
	}
}
