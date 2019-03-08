package com.kali.kali.binaryTree;

import com.kali.binaryTree.BinaryTree;
import com.kali.binaryTree.Node;

import java.util.Random;

public class BinaryMainClass {
	public static void main(String[] args) {
		com.kali.binaryTree.BinaryTree bt = new BinaryTree();
		com.kali.binaryTree.Node<Integer> n1 = new com.kali.binaryTree.Node<Integer>(9);
		com.kali.binaryTree.Node<Integer> n2 = new com.kali.binaryTree.Node<Integer>(13);
		com.kali.binaryTree.Node<Integer> n3 = new com.kali.binaryTree.Node<Integer>(15);
		com.kali.binaryTree.Node<Integer> n4 = new com.kali.binaryTree.Node<Integer>(7);
		com.kali.binaryTree.Node<Integer> n5 = new com.kali.binaryTree.Node<Integer>(8);
		com.kali.binaryTree.Node<Integer> n6 = new com.kali.binaryTree.Node<Integer>(0);
		com.kali.binaryTree.Node<Integer> n7 = new Node<Integer>(16);
		
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
