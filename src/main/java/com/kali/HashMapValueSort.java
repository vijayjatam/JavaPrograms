package com.kali;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author mahan.k.palavelli
 * 
 */
class HashMapValueSort {
	public static void main(String... k) {
		Map<Integer, String> unSortedMap = new HashMap<Integer, String>();
		unSortedMap.put(1, "three");
		unSortedMap.put(2, "nine");
		unSortedMap.put(3, "eight");
		unSortedMap.put(4, "seven");
		unSortedMap.put(5, "two");
		
		unSortedMap.put(6, "ten");
		unSortedMap.put(7, "one");
		unSortedMap.put(8, "five");
		unSortedMap.put(9, "six");
		unSortedMap.put(10, "ten");
		unSortedMap.put(11, "four");
		sortByValues(unSortedMap);
		
		unSortedMap.put(1, "one");
		unSortedMap.put(2, "two");
		unSortedMap.put(3, "three");
		unSortedMap.put(4, "four");
		unSortedMap.put(5, "five");
		unSortedMap.put(6, "six");
		unSortedMap.put(7, "seven");
		unSortedMap.put(8, "eight");
		unSortedMap.put(9, "nine");
		unSortedMap.put(10, "ten");
//		sortByValues(unSortedMap);
		
		
		unSortedMap.put(1, "10");
		unSortedMap.put(2, "2");
		unSortedMap.put(3, "11");
		unSortedMap.put(4, "15");
		unSortedMap.put(5, "24");
		unSortedMap.put(6, "36");
		unSortedMap.put(7, "7");
		unSortedMap.put(8, "2");
		unSortedMap.put(9, "99");
		unSortedMap.put(10, "1");
//		sortByValues(unSortedMap);
		
		// 8,5,4,9,1,7,6,10,3,2
		/* System.out.println(sortByComparator(unSortedMap)); */
		// 3,8,11,2,7,9,6,10,1,5
		
		Map<Object, String> map =new HashMap<Object, String>();
		map.put("kali", "Hashing");
		System.out.println(map.put("kali", "java"));
		
	}

	public static void sortByValues(Map<Integer, String> unSortedMap) {
		
		List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(unSortedMap.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
			
			public int compare(Map.Entry<Integer, String> o1,
					Map.Entry<Integer, String> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		Map<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();
		sortedMap = list.stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue) -> oldValue,LinkedHashMap::new));
		/*for (Iterator<Map.Entry<Integer, String>> it = list.iterator(); it
				.hasNext();) {
			Map.Entry<Integer, String> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}*/
		System.out.println(sortedMap);
	}
	
	public static Map<Object, Object> sortByValuesFromOutSideSource(Map<Object,Object> unSortedMap) {
		List<Map.Entry<Object, Object>> list = new LinkedList<Map.Entry<Object, Object>>(unSortedMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Object, Object>>() {
			public int compare(Map.Entry<Object, Object> o1,
					Map.Entry<Object, Object> o2) {
				return ((Integer) o2.getValue()).compareTo((Integer) o1.getValue());
			}
		});
		Map<Object, Object> sortedMap = new LinkedHashMap<Object, Object>();
		for (Iterator<Map.Entry<Object, Object>> it = list.iterator(); it
				.hasNext();) {
			Map.Entry<Object, Object> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}