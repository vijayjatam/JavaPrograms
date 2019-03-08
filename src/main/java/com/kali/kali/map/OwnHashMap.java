package com.kali.kali.map;

import com.kali.map.OwnNode;

public class OwnHashMap {
	int defaultCapacity = 4;
	com.kali.map.OwnNode[] nodesArray = new com.kali.map.OwnNode[defaultCapacity];
	com.kali.map.OwnNode head;
	com.kali.map.OwnNode rare;
	public Object put(Object key, Object value){
		if(key!=null){
			int tempHash = key.hashCode();
			if(head==null){
				com.kali.map.OwnNode tempNode = getNewNode(key,value);
				int index = tempHash%defaultCapacity;
				if(index<nodesArray.length){
					nodesArray[index] = tempNode;
				}
				else{
					nodesArray[0] = tempNode;
				}
				head = tempNode;
			}
			else{
				int index = tempHash%defaultCapacity;
				Object objValue =  searchKey(key,value);
				if(objValue==null){
					if(index<nodesArray.length){
						setKeyValuesToArray(key,value,index);
					}else{
						setKeyValuesToArray(key, value, 0);
					}
				}
				else{
					return objValue;
				}
			}
			
		}
		return null;
	}
	private com.kali.map.OwnNode getNewNode(Object key, Object value){
		com.kali.map.OwnNode tempNode = new com.kali.map.OwnNode();
		tempNode.key = key;
		tempNode.value = value;
		tempNode.hash = key.hashCode();
		return tempNode;
	}
	public Object searchKey(Object key,Object value){
		Object tempValue = null;
		if(nodesArray!=null && nodesArray.length!=0){
			for(int index=0;index<nodesArray.length;index++){
				com.kali.map.OwnNode existedNode = nodesArray[index];
				while(existedNode!=null){
					if((existedNode.key.hashCode()==key.hashCode()) && (existedNode.key.equals(key))){
						tempValue = existedNode.value;
						existedNode.value = value;
						return tempValue;
					}
					existedNode = existedNode.nextNode;
				}
			}
		}
		return tempValue;
	}
	public void setKeyValuesToArray(Object key, Object value, int index){

		if(nodesArray[index] !=null){
			com.kali.map.OwnNode existedNode = nodesArray[index];
			while(existedNode!=null){
				if(existedNode.nextNode==null){
					com.kali.map.OwnNode tempNode = getNewNode(key,value);
					existedNode.nextNode = tempNode;
					break;
				}else{
					existedNode = existedNode.nextNode;
				}
			}
		}else{
			nodesArray[index] = getNewNode(key, value);
		}
	
	}
	public void print(){
		StringBuffer strBuffer = new StringBuffer();
		System.out.print("[");
		for(int index =0;index<nodesArray.length;index++){
			OwnNode existedNode = nodesArray[index];
			if(existedNode!=null && strBuffer.length()!=0)
				strBuffer.append(" , ");
			while(existedNode!=null){
				strBuffer.append("{"+existedNode.key.toString()+" "+existedNode.value.toString()+"}");
//				System.out.print("{"+existedNode.key.toString()+" "+existedNode.value.toString()+"}");
				existedNode = existedNode.nextNode;
				if(existedNode!=null)
					strBuffer.append(" , ");
			}
			
		}
		System.out.print(strBuffer.toString());
		System.out.print("]");
	}
}
