package com.kali;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class TestOnList {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(2);
		for(Integer itr: list){
		    if(itr.intValue()==3){
		        list.add(10);
            }
        }



		removeCommonValuesFromTwoList();
		//deleteDublecates(list);
		//listToString();
	}
	public static void deleteDublecates(List<Integer> list){
		/*System.out.println(list);
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()){
			int val = itr.next();
			if(Collections.frequency(list, val)>1){
				itr.remove();
			}
		}
		System.out.println(list);*/
		System.out.println(list.stream().distinct().collect(Collectors.toList()));
		
	}
	
	public void removeUsingItr(){

		ArrayList<String> list = new ArrayList<String>();
		list.add("kali");
		list.add("");
		list.add("mahan");
		list.add("");
		list.add("cell");
		
		
		
		/*Object[] obj = list.toArray();
		String[] str = new String[obj.length];
		for(int i = 0;i<obj.length;i++){
			str[i] = (String) obj[i];
		}
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}*/
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			String str1 = (String) itr.next();
			if(str1.equalsIgnoreCase("kali")){
				itr.remove();
			}
		}
		System.out.println(list);
	
	}
	
	public static void listToString(){
		HashSet set = new HashSet();
		set.add(1);
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4,1);
		 String commaSeparatedNumbers = numbers.stream()
		     .map(i -> i.toString())
		     .collect(Collectors.joining(""));
		 System.out.println(commaSeparatedNumbers);
		 Integer.parseInt(commaSeparatedNumbers);
	}

	public static void removeCommonValuesFromTwoList() {
		int[] a = new int[]{1, 2, 3};
		int[] b = new int[]{1, 2};
		Collection col = new ArrayList();

		/*List<String> a1 = Arrays.asList("2009-05-18", "2009-05-19", "2009-05-21");
		List<String> a2 = Arrays.asList("2009-05-18", "2009-05-18", "2009-05-19", "2009-05-19", "2009-05-20", "2009-05-21","2009-05-21", "2009-05-22");*/
		List<Integer> a1 = Arrays.stream(b).boxed().collect(Collectors.toList());
		List<Integer> a2 = Arrays.stream(a).boxed().collect(Collectors.toList());

		List<Integer> result = a2.stream().filter(elem -> !a1.contains(elem)).collect(Collectors.toList());


		System.out.println(result);
	}
}
