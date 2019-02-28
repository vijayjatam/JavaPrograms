package com.kali;


import java.util.Scanner;

/**
 * @author mahan.k.palavelli
 *
 */
public class ArrayListAdd {
	private Object addObjArray[];
	private int indexIncre = 0;
	private static int defaultIncrementSize = 2;

	
	
	/**
	 * Adding Object Values to Global Array
	 * @param obj
	 */
	private void addToArray(Object obj) {
		if(indexIncre <= addObjArray.length) {
			addObjArray[indexIncre] = obj;
			indexIncre = indexIncre+1;
		}
	}
	private void add(Object obj, boolean falge) {
		if(addObjArray == null) {
			incrementDefaultSize(defaultIncrementSize);
			addToArray(obj);
		}
		else {
			try {
				if( null != addObjArray[addObjArray.length-1]) {
					incrementDefaultSize(defaultIncrementSize+indexIncre);
					addToArray(obj);
				}
				else {
					addToArray(obj);
				}
			} catch(Exception e) {
				addToArray(obj);
			}
		}
	}
	/**
	 * 
	 * @param obj
	 */
	public void add(Object obj) {
		add(obj, true);
	}
	
	/**
	 * Get the Index based value
	 * @param properIndex
	 */
	public void get(int properIndex) {
		if(properIndex >= indexIncre) {
			System.out.println("No value at given index");
			return;
		}
		try {
			if(null!=addObjArray[properIndex])
				System.out.println(addObjArray[properIndex]);
			else
				throw new IndexOutOfBoundsException("Index: "+properIndex+", Size: "+this.size());
		}catch(Exception e) {
			throw new IndexOutOfBoundsException("Index: "+properIndex+", Size: "+this.size());
		}
	}
	
	/**
	 * Increment the Default size of Array Dynamically
	 * @param size
	 */
	private void incrementDefaultSize(int size) {
		Object localArray[] = null;
		
		if(null != addObjArray) {
			localArray = addObjArray;
		}
		addObjArray = new Object[size];
		if(null != localArray && localArray.length>0)
			transforData(localArray, addObjArray);
	}
	
	/**
	 * return the Size of Global Array
	 * @return
	 */
	public int size() {
		return indexIncre;
	}
	
	/**
	 * capacity of the Global array
	 * @return
	 */
	public int capacity() {
		if(indexIncre > 0)
			return addObjArray.length;
		else
			return defaultIncrementSize;
	}
	
	/**
	 * Print All values in Global Array
	 */
	public void printAll() {
		/*** Old Code **/
		/*System.out.print("[");
		for(int i =0; i<this.size(); i++) {
			if(null != addObjArray[i]) 
				System.out.print(addObjArray[i]);
			if((i+1) < this.size() && null != addObjArray[i+1])
				System.out.print(", ");
			else
				break;
		}
		System.out.print("]");
		System.out.println();*/
		toString();
	}
	
	/**
	 * Transform old data to Global Array
	 * @param source
	 * @param destination
	 * @return
	 */
	private Object[] transforData(Object[] source, Object[] destination) {
		//destination = Stream.of(source).collect(Collectors.toList()).toArray();
		for(int i =0; i<source.length; i++) {
			destination[i] = source[i];
		}
		return destination;
	}
	
	/**
	 * Main 
	 * @param args
	 */
	public static void main(String[] args) {

		boolean flage = true;
		ArrayListAdd addList = new ArrayListAdd();
		while(flage) {
			System.out.println("1. Add\n2. Get\n3. Print All\n4. Size\n5. Exit\n6. Capacity");
			Scanner scan = new Scanner(System.in);
			int option = scan.nextInt();
			System.out.println("------------------------------------------------");
			switch(option) {
			case 1:
				System.out.println("Enter element to addAtEnd");
				addList.add(scan.next());
				break;
			case 2:
				System.out.println("Enter index");
				addList.get(scan.nextInt());
				break;
			case 3:
				addList.printAll();
				break;
			case 4:
				System.out.println(addList.size());
				break;
			case 5:
				flage = false;
				break;
			case 6:
				System.out.println(addList.capacity());
				
			}
			System.out.println("------------------------------------------------");
		}
	
	}
	/*@Override
	public String toString() {
		return Arrays.toString(addObjArray);
	}*/
}
