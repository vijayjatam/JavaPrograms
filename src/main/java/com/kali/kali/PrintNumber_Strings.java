package com.kali.kali;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author mahan.k.palavelli
 *
 */
public class PrintNumber_Strings {
	static Scanner scan = new Scanner(System.in);
	public static void alterNative(String sourceStr) {
		String numbers = sourceStr.replaceAll("[^0-9]", "");
		String chars = sourceStr.replaceAll("[^a-zA-Z]", "");
		String specialChars= new String();
		int specialIncr =0;
		for(int i =0; i< sourceStr.length();i++) {
			if(!((int)sourceStr.charAt(i)>=48 && (int) sourceStr.charAt(i) <=57) 
					&& !((int)sourceStr.charAt(i)>=65 && (int) sourceStr.charAt(i) <=90) 
					&& !((int)sourceStr.charAt(i)>=97 && (int) sourceStr.charAt(i) <=122)){
				specialChars = specialChars+sourceStr.substring(i, i+1);
			}
//			spelis = spelis+sourceStr.substring(beginIndex)
		}
		System.out.println("Special Chars: "+specialChars);
		
		boolean flag = true;
		StringBuilder stBuilder = new StringBuilder();
		while(flag) {
			System.out.println("Which do you want print first\n N: Numbers  C: Alpha");
			String priority = scan.next();
			if(priority.equalsIgnoreCase("n")){
				flag = false;
				for(int i=0; i<(numbers.length() > chars.length() ? numbers.length() : chars.length()); i++) {
					if(numbers.length() > i)
						stBuilder.append(numbers.charAt(i));
					else 
						if(numbers.length()<=i && chars.length() > i) {
							if(specialIncr < specialChars.length())
								stBuilder.append(specialChars.charAt(specialIncr));
							else
								stBuilder.append("*");
							specialIncr++;
						}
					if(chars.length() > i) 
						stBuilder.append(chars.charAt(i));
					else
						if(chars.length() <= i && numbers.length() > (i+1)) {
							if(specialIncr < specialChars.length())
								stBuilder.append(specialChars.charAt(specialIncr));
							else
								stBuilder.append("*");
							specialIncr++;
						}
						
				}
			}
			else if(priority.equalsIgnoreCase("c")) {
				flag=false;
				for(int i=0; i<(numbers.length() > chars.length() ? numbers.length() : chars.length()); i++) {
					if(chars.length() > i) 
						stBuilder.append(chars.charAt(i));
					else
						if(chars.length() <= i && numbers.length() > i) {
							if(specialIncr < specialChars.length())
								stBuilder.append(specialChars.charAt(specialIncr));
							else
								stBuilder.append("*");
							specialIncr++;
						}
					if(numbers.length() > i)
						stBuilder.append(numbers.charAt(i));
					else 
						if(numbers.length()<=i && chars.length() > (i+1)) {
							if(specialIncr < specialChars.length())
								stBuilder.append(specialChars.charAt(specialIncr));
							else
								stBuilder.append("*");
							specialIncr++;
						}
				}
			}
		}
		if(specialIncr < specialChars.length()) {
			for(int i =specialIncr; i< specialChars.length(); i++) 
				stBuilder.append(specialChars.charAt(i));
		}
		System.out.println(stBuilder);
	}
	public static void main(String[] args) {
		System.out.println("Enter AlphaNumaric + Symbals String");
		String sourceStr = scan.next();
		alterNative(sourceStr);
		//74103905  82525
//		onString();
	}
	
	
	public static void onString(){
		String s1 = new String("Kali");
		String s2 =new String("Kali");
		String str1=new String("nataraz");
		String str2=new String("nataraz");
		     
		Hashtable table=new Hashtable();
		Object obj1=table.put(str1, "Spring");//addAtEnd key,value returns null as its a new entry
		Object obj2=table.put(str2,"Hibernate");//replaces old value with new Value and returns old value
		     
		System.out.println(table);
		System.out.println(obj1+" "+obj2); //null Spring(old value that was removed) 
		     
		System.out.println(table); //returns {nataraz=Hibernate}

		/*String s3 ="Kali";
		String s4 ="Kali";
		String s5 ="Kali";
		String s6 ="Kali";*/
//		System.out.println(s1.hashCode()+","+s2.hashCode()+","+s3.hashCode());
//		System.out.println(s1.hashCode()+" : "+s2.hashCode());
//		System.out.println(s1==s2);
//		System.out.println(s1.equalsIgnoreCase(s2));
	}
	
	
	/*public void printAnsi() {
		
		for(int i=0; i< 200; i++) {
			
		}
	}*/
}
