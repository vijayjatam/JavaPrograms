package com.kali.test;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class OnlineTest {
	public static void main(String[] args) throws FileNotFoundException{
		
		double total = 99.35;
		total = total+1.10;
		System.out.println(total);
		String str = String.format("%.2f\n", total);
		System.out.println(Double.parseDouble(str));
		int[] ints = {-9, 14, 37, 102};
		System.out.println(Arrays.binarySearch(ints, -10));
//		throw new FileNotFoundException();
		
	}
}
