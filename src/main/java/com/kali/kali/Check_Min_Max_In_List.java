package com.kali.kali;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mahan.k.palavelli
 *
 */
public class Check_Min_Max_In_List {
	public static void main(String[] args) {
		List<Integer> list = new CopyOnWriteArrayList<>();
		list.add(10);
		list.add(82);
		list.add(17);
		list.add(96);
		list.add(3948);
		list.add(32475);
		System.out.println(list);
		Iterator it = list.iterator();
		while (it.hasNext()){
			Integer i = (Integer) it.next();
			if(Collections.min(list) == i){
				list.remove(i);
			}
		}
		for(Integer itr : list) {
			if(Collections.min(list) == itr) {
				list.remove(itr);

			}
		}

		System.out.println(list);
	}

}
//asklfkdsyioahdshflksdhafk;dsjfjdksljafkldksjfaldjksjfa