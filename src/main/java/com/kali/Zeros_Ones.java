package com.kali;

import java.util.Scanner;

public class Zeros_Ones {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter String(only in zeros and ones)");
		String sourceString = scan.next();
		/*int RANGE = scan.nextInt();
		String sourceString[] = new String[RANGE];
		System.out.println("Enter String(only in zeros and ones)");
		for(int i=0; i<RANGE; i++) {
			sourceString[i] = scan.next();
		}*/
		alterNative(sourceString );
//		sortingString();
		
	}

	private static void alterNative(String sourceString) {
		// TODO Auto-generated method stub
		String ones = sourceString.replaceAll("0", "");
		String zeros = sourceString.replaceAll("1", "");
		StringBuilder sBuild =  new StringBuilder();
		for(int i=0; i<(ones.length() > zeros.length() ? ones.length() : zeros.length()); i++) {
			if(zeros.length() > i)
				sBuild.append(zeros.charAt(i));
			if(ones.length() > i)
				sBuild.append(ones.charAt(i));
		}
		System.out.println(sBuild);
	}
	private static void sortingString() {
		System.out.println("Enter Range");
		int RANGE = scan.nextInt();
		String sourceString[] = new String[RANGE];
		System.out.println("Enter String(only in zeros and ones)");
		for(int i=0; i<RANGE; i++) {
			sourceString[i] = scan.next();
		}
		int stringLength = sourceString.length;
		for(int i=0; i< sourceString.length/2; i++)  {
			if(sourceString[i].equalsIgnoreCase("0"))
			stringLength = stringLength-1;
			sourceString[stringLength-1] = "0";
			sourceString[i]="1";
			/*if(sourceString[i].equalsIgnoreCase("1")) {
				sourceString[i]="1";
			}
			else if(sourceString[i].equalsIgnoreCase("0")) {
				stringLength = stringLength-1;
				sourceString[stringLength-1] = "0";
				sourceString[i]="1";
			}*/
		}
		System.out.println("\n Final answer:    \n");
		for(int i =0 ;i < sourceString.length; i++)
			System.out.print(sourceString[i]+",");
	}
}
