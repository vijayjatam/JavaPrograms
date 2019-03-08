package com.kali.kali;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NthHighest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter array size..!");
		int size = scan.nextInt();
		int intArray[] = new int[size];
		System.out.println("Enter Values....!");
		for(int index=0;index<intArray.length;index++){
			intArray[index] = scan.nextInt();
		}
		int tempArray[] = intArray;
		IntStream.of(tempArray).boxed().collect(Collectors.toList()).stream().sorted(/*(o1,o2) -> o1.compareTo(o2)*/).forEach(System.out::println);
		System.out.println("Enter Nth largest....!");
		int nth = scan.nextInt();

			int max = 0;
			for (int i = 1; i <= nth; i++) {
				max = 0;
				for (int j = 1; j < tempArray.length; j++) {
					if (tempArray[max] < tempArray[j]) {
						max = j;
					}
				}
				tempArray = new int[intArray.length];
				for (int index = 0; index < intArray.length; index++) {
					if (index != max) {
						tempArray[index] = intArray[index];
					}
				}
				if (i != nth)
					intArray = tempArray;
			}
			System.out.println(nth + " largest value -> " + intArray[max]);
		}
}
