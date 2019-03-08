package com.kali.kali.binaryTree;

/**
 * @author mahan.k.palavelli
 *
 */
public class Node<T extends Comparable<?>> {
	T value;
	Node<T> left;
	Node<T> right;
	Node(T value){
		this.value = value;
	}
}
