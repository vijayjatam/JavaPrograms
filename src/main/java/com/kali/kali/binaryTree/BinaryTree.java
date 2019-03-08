package com.kali.kali.binaryTree;

import com.kali.binaryTree.BTreePrinter;
import com.kali.binaryTree.Node;

public class BinaryTree {
	private com.kali.binaryTree.Node rootNode = null;
	public void addToTree(com.kali.binaryTree.Node node){
		if(rootNode==null){
			rootNode = node;
		}
		else{
			addNode(rootNode, node);
		}
	}
	@SuppressWarnings("unchecked")
	private void addNode(com.kali.binaryTree.Node rootNode, Node checkNode){
		if(checkNode!=null ){
			if(rootNode.value.compareTo(checkNode.value)>0){
				if(rootNode.left!=null){
					addNode(rootNode.left,checkNode);
				}
				else{
					rootNode.left = checkNode;
				}
			}
			else{ // checkNode bigger than rootNode
				if(rootNode.right!=null){
					addNode(rootNode.right,checkNode);
				}
				else{
					rootNode.right = checkNode;
				}
			}

		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public String toString(){
		BTreePrinter.printNode(rootNode);
	return "";
	}
}
