package com.kali.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Map_Test {
	static int statVar1;
	 int statVar2;
	public static void main(String[] args) {
		Map<String, String> map = new ConcurrentHashMap<String, String>();
		map.put("bcd","11");
		map.put("abc", "10");
		System.out.println(map);
		map = process(map, "bcd");
		System.out.println(map);
		Object[] obj = map.keySet().toArray(); 
		Arrays.sort(obj);
		System.out.println(obj[0]);
	}
	public static Map<String, String> process(Map<String, String> oldMap, String str){
		
		if(oldMap.containsKey(str)){
			Integer val = Integer.parseInt(oldMap.get(str));
			val = val+1;
			oldMap.remove(str);
			oldMap.put(str, val.toString());
		}
		return oldMap;
	}
	public void f() {
		 statVar1 = 10;
		 this.statVar2 = 11;
		 this.statVar1 = 12;
		 statVar2 = statVar1;
	}
}
