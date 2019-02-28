package com.kali.linkedList;

public class OwnLinkedList {
	private  OwnNode head = null;
	private  OwnNode rare = null;
	private  int size = 0;
	
	/**
	 * @param intVal
	 */
	public void addNodeAtEnd(int intVal){
		if(head==null){
			OwnNode newNode = new OwnNode();
			newNode.VALUE = intVal;
			head = newNode;
			rare = newNode;
			size++;
		}
		else{
			OwnNode newNode = new OwnNode();
			newNode.VALUE = intVal;
			rare.NEXT_NODE = newNode;
			rare =newNode;
			size++;
		}
	}
	/**
	 * @param intVal
	 */
	public void addNodeAtFirst(int intVal){
		if(head==null){
			OwnNode newNode = new OwnNode();
			newNode.VALUE = intVal;
			head = newNode;
			rare = newNode;
			size++;
		}
		else{
			OwnNode newNode = new OwnNode();
			newNode.VALUE = intVal;
			newNode.NEXT_NODE = head;
			head = newNode;
			size++;
		}
	}
	/**
	 * 
	 */
	public void printNodes(){
		while(head!=null){
			System.out.println(head.VALUE+" : "+head.hashCode());
			head = head.NEXT_NODE;
		}
	}
	/**
	 * @return
	 */
	public OwnNode getLinkedList(){
		return head;
	}
	public int size(){
		return size;
	}
	/**
	 * @return
	 */
	public OwnNode middleNode(){
		int count = 0;
		OwnNode middleNode = head;
		if(size%2==0){
			while(count!=(size/2)){
				count++;
				middleNode = middleNode.NEXT_NODE;
			}
		}else{
			while(count!=Math.floor(size/2)){
				count++;
				middleNode = middleNode.NEXT_NODE;
			}
		}
		return middleNode;
		
	}
	/**
	 * @param index
	 * @return
	 */
	public OwnNode getNodeAt(int index){
		int count = 1;
		OwnNode nodeAtIndex = head;
		if(index<=size){
			while(count!=index){
				count++;
				nodeAtIndex = nodeAtIndex.NEXT_NODE;
			}
			return nodeAtIndex;
		}
		else{
			return null;
		}
	}
	public boolean addAll(OwnLinkedList destiList){
		boolean flage = false;
		if(head!=null && destiList!=null){
			rare.NEXT_NODE = destiList.head;
			rare = destiList.rare;
			size+=destiList.size;
			flage=true;
		}
		else if(head!=null){
			rare.NEXT_NODE = null;
		}
		else if(destiList!=null){
			head = destiList.head;
			rare = destiList.rare;
			size+=destiList.size;
			flage=true;
		}
		return flage;
	}

	public boolean addListAt(int index, OwnLinkedList destiList){
		boolean flage = false;
		if(size!=0 && destiList!=null){
			OwnNode nodeAtIndex = getNodeAt(index);
			destiList.rare.NEXT_NODE = nodeAtIndex.NEXT_NODE;
			nodeAtIndex.NEXT_NODE = destiList.head;
			size+=destiList.size();
			flage = true;
		}
	
		return flage;
	}
	
	public boolean delete(int index){
		boolean flage = false;
		if(size!=0){
			OwnNode beforNode = getNodeAt(index-1);
			OwnNode nodeAtIndex = getNodeAt(index);
			if(beforNode==null){
				head = nodeAtIndex.NEXT_NODE;
			}
			else{
				beforNode.NEXT_NODE = nodeAtIndex.NEXT_NODE;
			}
			System.gc();
			flage = true;
			
		}
		return flage;
	}
	public OwnNode middleNodeWithEff(){
		OwnNode runner = head;
		OwnNode middle = head;
		while(runner.NEXT_NODE!=null&&runner.NEXT_NODE.NEXT_NODE!=null){
			middle = middle.NEXT_NODE;
			runner = runner.NEXT_NODE.NEXT_NODE;
		}
		if(runner.NEXT_NODE==null)
			return middle;
		else
			return middle.NEXT_NODE;
	}
	public OwnNode searchNodeFromEnd(int kthElement){
		OwnNode tempNode = head;
		int count = 1;
		while(tempNode!=null && count <=size-(kthElement+1)){
			tempNode = tempNode.NEXT_NODE;
			count++;
		}
		return tempNode;
	}

	@Override
	public String toString(){
		OwnNode tempNode = head;
		
		while(tempNode != null){
			System.out.println("Node "+tempNode.VALUE+", hash "+tempNode.hashCode());
			tempNode = tempNode.NEXT_NODE;
		}
		return null;
	}
	public OwnNode revers(){
		OwnNode tempNode = head;
		OwnNode returNode = null;
		while(tempNode!=null){
			if(returNode==null){
				returNode = tempNode;
				tempNode = tempNode.NEXT_NODE;
				returNode.NEXT_NODE = null;
			}
			else{
				OwnNode nNode = tempNode;
				tempNode = tempNode.NEXT_NODE;
				nNode.NEXT_NODE = returNode;
				returNode = nNode;
			}
		}
		return returNode;
	}
}
