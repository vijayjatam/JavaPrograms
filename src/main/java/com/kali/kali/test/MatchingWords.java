package com.kali.kali.test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mahan.k.palavelli
 * 
 */
class MatchingWords {
	
	public static void main(String[] k) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Give Source Entry");
		String source = scan.next();
		Map<String, Integer> sourceMap = getMapValue(source.toLowerCase());
		System.out.println(sourceMap);
		System.out.println("Enter size of Options");
		int optSize = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Option values");
		for (int i = 1; i <= optSize; i++) {
			String option = scan.nextLine();
			Map<String, Integer> optionMap = getMapValue(option.toLowerCase());
//			System.out.println(optionMap);
			//comparision(sourceMap,optionMap) ? System.out.println(option + " is not match with " + source): System.out.println(option + " is match with " + source);

			if (comparision(sourceMap, optionMap)) {
				System.out.println(option + " is not match with " + source);
			} else
				System.out.println(option + " is match with " + source);
		}

	}

	public static Map<String, Integer> getMapValue(String source) {
		//List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		Map<String, Integer> sourceMap = new TreeMap<String, Integer>();
		//List<String> list = Stream.of(source.split("")).collect(Collectors.toList());
		List<String> list = Arrays.asList(source.split(""));
		//set.addAll(list);
		/*for (int i = 0; i < source.length(); i++) {
			*//*list.addAtEnd((new Character(source.charAt(i)).toString()));
			set.addAtEnd((new Character(source.charAt(i)).toString()));*//*
			list.add(source.substring(i, i+1).toLowerCase());
			set.add(source.substring(i, i+1).toLowerCase());
		}*/
		/*sourceMap = list.stream().distinct().collect(Collectors.toMap(str->str,str->Collections.frequency(list,str)));
		list.add("1");*/
		for (String str : set){
			sourceMap.put(str, Collections.frequency(list, str));
		}
		/*Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String str = (String) itr.next();
			sourceMap.put(str, Collections.frequency(list, str));
		}*/
		return sourceMap;
	}

	public static boolean comparision(Map<String, Integer> sourceMap,
			Map<String, Integer> optionMap) {
		boolean flage = false;
		if (sourceMap.size() != optionMap.size()) {
			System.out.println("Size is not Match");
			flage = true;
			return flage;
		} else {
			Set<String> key_set = sourceMap.keySet();
			Iterator<String> itr = key_set.iterator();
			while (itr.hasNext()) {
				String key = (String) itr.next();
				// System.out.println(key);
				if (sourceMap.get(key) != optionMap.get(key)) {
					flage = true;
					break;
				}
			}
			return flage;
		}
	}
}
