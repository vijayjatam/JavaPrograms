package com.kali.map;

public class MyHashMap {
	int defaultCapacity = 4;
	OwnNode[] bucketsArray;//= new OwnNode[defaultCapacity];
	
	public Object put(Object key, Object value){
		int index = 0;
		if(key!=null)
			index = key.hashCode()%defaultCapacity;
		
		if(bucketsArray ==null|| bucketsArray.length==0){
			bucketsArray = new OwnNode[defaultCapacity];
			OwnNode newNode = getNewNode(key, value);
			bucketsArray[index] = newNode;
			return null;
		}
		else if(bucketsArray[index]==null){
			OwnNode newNode = getNewNode(key, value);
			bucketsArray[index] = newNode;
			return null;
		}
		return searchKey(key, value);
	}
	private OwnNode getNewNode(Object key, Object value){
		OwnNode tempNode = new OwnNode();
		tempNode.key = key;
		tempNode.value = value;
		if(key==null)
			tempNode.hash = 0;
		else
		    tempNode.hash = key.hashCode();
		return tempNode;
	}
	private Object searchKey(Object key,Object value){
		int index = key.hashCode()%defaultCapacity;
		OwnNode existedHeadNode = bucketsArray[index];
		while(existedHeadNode!=null){
			if((existedHeadNode.key.hashCode()==key.hashCode()) && (existedHeadNode.key.equals(key))){
				Object tempValue = existedHeadNode.value;
				existedHeadNode.value = value;
				return tempValue;
			}
			else if(existedHeadNode.nextNode==null){
				OwnNode tempNode = getNewNode(key, value);
				existedHeadNode.nextNode = tempNode;
				return null;
			}
			existedHeadNode = existedHeadNode.nextNode;
		}
		return null;
	}
	/*public void setKeyValuesToArray(Object key, Object value, int index){

		if(bucketsArray[index] !=null){
			OwnNode existedNode = bucketsArray[index];
			while(existedNode!=null){
				if(existedNode.nextNode==null){
					OwnNode tempNode = getNewNode(key,value);
					existedNode.nextNode = tempNode;
					break;
				}else{
					existedNode = existedNode.nextNode;
				}
			}
		}else{
			bucketsArray[index] = getNewNode(key, value);
		}
	
	}*/
	
	public void print(){
		StringBuffer strBuffer = new StringBuffer();
		System.out.print("[");
		for(int index = 0; index< bucketsArray.length; index++){
			OwnNode existedNode = bucketsArray[index];
			if(existedNode!=null && strBuffer.length()!=0)
				strBuffer.append(" , ");
			while(existedNode!=null){
				strBuffer.append("{"+(Object)existedNode.key+" "+existedNode.value.toString()+"}");
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
