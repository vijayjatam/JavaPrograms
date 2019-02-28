package com.kali;

import java.util.Scanner;

/**
 * @author mahan.k.palavelli
 *
 */
public class NumberPlateSum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number");
		String stringNumber = scan.next();
		System.out.println(sumOfNumber(stringNumber));
	}
	public static int sumOfNumber(String stringNumber) {
		int finalSum =0;
		for(int i =0;i<stringNumber.length(); i++) {
			finalSum = finalSum+(new Integer(stringNumber.substring(i,i+1)));
		}
		if(finalSum >= 10){
			finalSum = sumOfNumber((new Integer(finalSum)).toString());
		}
		return finalSum;
	}
	public static int sumOfIntegers(String stringNumber){
		int finalSum =0;
		for(int i =0;i<stringNumber.length(); i++) {
			finalSum = finalSum+(new Integer(stringNumber.substring(i,i+1)));
		}
		return finalSum;
	}
}
