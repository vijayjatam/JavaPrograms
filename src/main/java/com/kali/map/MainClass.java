package com.kali.map;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MainClass {
	public static void main(String[] args) {
		Map<String,String> map = new ConcurrentHashMap<String,String>();
		map.put("1","a");
		map.put("2","b");
		map.put("3","c");
		map.containsValue("4");

		for (Map.Entry<String,String> entry:map.entrySet()) {

		}

		MyHashMap mymap =new MyHashMap();
		mymap.put(1, "kali");
		mymap.put(1, "mahan");
		mymap.put(2,"Raja");
		mymap.put(3,"mahankali");

		mymap.put(null,"mahankali");
		System.out.println(mymap.put(1, "xyz"));
		mymap.print();
	}
}
