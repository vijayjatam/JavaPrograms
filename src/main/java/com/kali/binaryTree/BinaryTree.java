package com.kali.binaryTree;

public class BinaryTree {
	private Node rootNode = null;
	public void addToTree(Node node){
		if(rootNode==null){
			rootNode = node;
		}
		else{
			addNode(rootNode, node);
		}
	}
	@SuppressWarnings("unchecked")
	private void addNode(Node rootNode, Node checkNode){
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
