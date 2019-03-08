package com.kali.kali.doublelinkedList;

import com.kali.doublelinkedList.OwnDNode;

public class OwnDouble_LinkedList {
	com.kali.doublelinkedList.OwnDNode previousDNode = null;
	com.kali.doublelinkedList.OwnDNode nextDNode = null;
	public void addAtEnd(int intValue){
		if(previousDNode==null){
			com.kali.doublelinkedList.OwnDNode newDNode = new com.kali.doublelinkedList.OwnDNode();
			newDNode.value = intValue;
			previousDNode = newDNode;
			nextDNode = newDNode;
		}
		else{
			com.kali.doublelinkedList.OwnDNode newDNode = new com.kali.doublelinkedList.OwnDNode();
			newDNode.value = intValue;
			newDNode.previousNode = nextDNode;
			nextDNode.nextNode = newDNode;
			nextDNode = newDNode;
		}
	}
	public void addAtFirst(int intValue){
		if(previousDNode==null){
			com.kali.doublelinkedList.OwnDNode newDNode = new com.kali.doublelinkedList.OwnDNode();
			newDNode.value = intValue;
			previousDNode = newDNode;
			nextDNode = newDNode;
		}
		else{
			com.kali.doublelinkedList.OwnDNode newDNode = new com.kali.doublelinkedList.OwnDNode();
			newDNode.value = intValue;
			newDNode.nextNode = previousDNode;
			previousDNode.previousNode = newDNode;
			previousDNode = newDNode;
		}
	}
	public void printNodes(String type){
		if(type!=null && type.equalsIgnoreCase("D")){
			
			// Circle Happened Here
			circlerDoubleLinkedList();
			
			com.kali.doublelinkedList.OwnDNode tempNode = previousDNode.previousNode;
			/*while(tempNode!=null){
				if(tempNode.previousNode!=null &&  tempNode.nextNode!=null){
					System.out.println(tempNode.previousNode.hashCode()+" : "+tempNode.value+" : "+tempNode.nextNode.hashCode()+" => "+tempNode.hashCode());
				}
				else if( tempNode.previousNode!=null){
					System.out.println(tempNode.previousNode.hashCode()+" : "+tempNode.value+" : -----  => "+tempNode.hashCode());
				}
				else{
					System.out.println("-----  : "+tempNode.value+" : "+tempNode.nextNode.hashCode()+" => "+tempNode.hashCode());
				}
				if(tempNode == previousDNode){
					break;
				}
				tempNode = tempNode.nextNode;
			}*/
			while(previousDNode!=null){
				if(previousDNode.previousNode!=null &&  previousDNode.nextNode!=null){
					System.out.println(previousDNode.previousNode.hashCode()+" : "+previousDNode.value+" : "+previousDNode.nextNode.hashCode()+" => "+previousDNode.hashCode());
				}
				else if( previousDNode.previousNode!=null){
					System.out.println(previousDNode.previousNode.hashCode()+" : "+previousDNode.value+" : -----  => "+previousDNode.hashCode());
				}
				else{
					System.out.println("-----  : "+previousDNode.value+" : "+previousDNode.nextNode.hashCode()+" => "+previousDNode.hashCode());
				}
				if(tempNode == previousDNode){
					break;
				}
				previousDNode = previousDNode.nextNode;
			}
		}
		else{
			com.kali.doublelinkedList.OwnDNode tempNode = previousDNode;
			while(tempNode!=null){
				if(tempNode.previousNode!=null &&  tempNode.nextNode!=null){
					System.out.println(tempNode.previousNode.hashCode()+" : "+tempNode.value+" : "+tempNode.nextNode.hashCode()+" => "+tempNode.hashCode());
				}
				else if( tempNode.previousNode!=null){
					System.out.println(tempNode.previousNode.hashCode()+" : "+tempNode.value+" : -----  => "+tempNode.hashCode());
				}
				else{
					System.out.println("-----  : "+tempNode.value+" : "+tempNode.nextNode.hashCode()+" => "+tempNode.hashCode());
				}
				tempNode = tempNode.nextNode;
			}
		}
	}
	public void circlerDoubleLinkedList(){
		previousDNode.previousNode = nextDNode;
		nextDNode.nextNode = previousDNode;
	}
	public void deleteBasedOnValue(int intValue){
		boolean flage = true;
		OwnDNode tempNode = previousDNode;
		while(tempNode!=null){
			if(tempNode.value==intValue){
				tempNode.previousNode.nextNode = tempNode.nextNode;
				tempNode.nextNode.previousNode = tempNode.previousNode;
				flage = false;
				break;
				
			}
			/*if(tempNode == previousDNode){
				break;
			}*/
			tempNode = tempNode.nextNode;
		}
		if(flage){
			System.out.println(intValue+" value not found");
		}
	}
}
