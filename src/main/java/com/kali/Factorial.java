package com.kali;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class Factorial {
	static BigInteger finalValue = new BigInteger("1");
	static int finalVal = 1;
	static Object obj =new Object();

	public static void main(String[] args) {
//		obj.notify();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number for finding factorial for that\n");
		BigInteger sourceInteger = scan.nextBigInteger();

		System.out.println(sourceInteger + "! = \nBig Integer: " + findBigFact(sourceInteger));
//		System.out.println("Our Integer: "+findIntFact(sourceInteger.intValue()));
		//System.out.println(findIntFactBySame(sourceInteger.intValue()));
	}

	private static BigInteger findBigFact(BigInteger sourceInteger) {
		if (sourceInteger.intValue() != 0) {
			finalValue = finalValue.multiply(sourceInteger);
			findBigFact(sourceInteger.subtract(new BigInteger("1")));
		}
		return finalValue;
	}
	
	public static int findIntFact(int sourceInt) {
		if(sourceInt != 0) {
			finalVal= finalVal*sourceInt;
			findIntFact(sourceInt-1);
		}
		return finalVal;
	}
	private static int findIntFactBySame(int sourceInt) {
		if(sourceInt > 1) {
			sourceInt= sourceInt*findIntFactBySame(sourceInt-1);
			return sourceInt;
		}
		else{
			return 1;
		}
		
	}

}
