package com.kali;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class Factorial {
	public BigInteger finalValue = new BigInteger("1");
	public long finalVal = 1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number for finding factorial for that\n");
		BigInteger sourceInteger = scan.nextBigInteger();

		System.out.println(sourceInteger + "! = \nBig Integer: " + new Factorial().findBigFact(sourceInteger,0));
//		System.out.println("Our Integer: "+findIntFact(sourceInteger.intValue()));
		//System.out.println(findIntFactBySame(sourceInteger.intValue()));
	}

	/* n! = n x n-1 x n-2 x......x 2 x 1 */
	public BigInteger findBigFact(BigInteger sourceInteger,long uptorange) {
		if (sourceInteger.intValue() != uptorange) {
			finalValue = finalValue.multiply(sourceInteger);
			findBigFact(sourceInteger.subtract(new BigInteger("1")), uptorange);
		}
		return finalValue;
	}
	
	public long findIntFact(long sourceInt,long uptorange) {
		if(sourceInt != uptorange) {
			finalVal= finalVal*sourceInt;
			findIntFact(sourceInt-1, uptorange);
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
