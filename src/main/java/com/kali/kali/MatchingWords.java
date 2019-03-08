package com.kali.kali;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
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
		String source = scan.nextLine();
		List<String> list = Stream.of(source.split("")).collect(Collectors.toList());
		Map<String, Integer> sourceMap = list.stream().distinct().collect(Collectors.toMap(s->s,s->Collections.frequency(list,s)));//getMapValue(source.toLowerCase())
		System.out.println(sourceMap);
		System.out.println("Enter size of Options");
		int optSize = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Option values");
		for (int i = 1; i <= optSize; i++) {
			System.out.println("Enter Option "+i+" value....!");
			String option = scan.nextLine();
			List<String> list_1 = Stream.of(option.split("")).collect(Collectors.toList());
			Map<String, Integer> optionMap = list_1.stream().distinct().collect(Collectors.toMap(s->s,s->Collections.frequency(list_1,s)));//getMapValue(option);
//			System.out.println(optionMap);
			if (!comparision(sourceMap, optionMap)) {
				System.out.println(option + " is not match with " + source);
			} else
				System.out.println(option + " is match with " + source);
		}

	}

	public static Map<String, Integer> getMapValue(String source) {
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		Map<String, Integer> sourceMap = new TreeMap<String, Integer>();
		for (int i = 0; i < source.length(); i++) {
			/*list.addAtEnd((new Character(source.charAt(i)).toString()));
			set.addAtEnd((new Character(source.charAt(i)).toString()));*/
			list.add(source.substring(i, i+1).toLowerCase());
			set.add(source.substring(i, i+1).toLowerCase());
		}
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String str =  itr.next();
			sourceMap.put(str, Collections.frequency(list, str));
		}
		return sourceMap;
	}

	public static boolean comparision(Map<String, Integer> sourceMap,
			Map<String, Integer> optionMap) {
		boolean flage = true;
		if (sourceMap.size() != optionMap.size()) {
			System.out.println("Size is not Match");
			flage = false;
			return flage;
		} else {
			Set<String> key_set = sourceMap.keySet();
			Iterator<String> itr = key_set.iterator();
			while (itr.hasNext()) {
				String key = (String) itr.next();
				// System.out.println(key);
				if (sourceMap.get(key) != optionMap.get(key)) {
					flage = false;
					break;
				}
			}
			return flage;
		}
	}
}
