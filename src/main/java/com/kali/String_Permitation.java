package com.kali;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author mahan.k.palavelli
 *
 */
public class String_Permitation {


    public static long permuTime=0;
	public static long stringLength=0;
	public static String finalStringValue;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String");
		String s =  scan.next();
		stringLength = s.length();
		Set<String> finalResult = permitationOnString(s);
		System.out.println();
		int defaultSize = 0;
		for(String string : finalResult) {
			defaultSize++;
			System.out.print(string+", ");
			if(defaultSize == 30) {
				System.out.println("\n-----------------------------------------------------------");
				defaultSize = 0;
			}
		}
	}
 
	public static LinkedHashSet<String> permitationOnString(String str) {
		LinkedHashSet<String> permiResult = new LinkedHashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			permiResult.add("");
			return permiResult;
		}
 
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		LinkedHashSet<String> words = permitationOnString(rem);
		//System.out.println(firstChar+" :: "+words);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				finalStringValue = charAdd(newString, firstChar, i);
				//System.out.print("\n"+finalStringValue+";");
				permiResult.add(finalStringValue);
				/*if(stringLength == finalStringValue.length())
				{
					permuTime++;
					System.out.println(permuTime+" -----------------"+crunchifyResult);
				}*/
			}
		}
		return permiResult;
	}
 
	public static String charAdd(String str, char c, int i) {
		String first = str.substring(0, i);
		String last = str.substring(i);
		return first + c + last;
	}
 
}
/*
*kwolaclcl, cbeofoka, gilencafin, cemrsenlboei, rlrgsmaorsi, etdbehes, hpastawp, hulgisnt.
*
*
*/
