package com.kali.test;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
//
//import com.swabunga.spell.engine.SpellDictionary;
//import com.swabunga.spell.engine.SpellDictionaryHashMap;
//import com.swabunga.spell.event.SpellCheckEvent;
//import com.swabunga.spell.event.SpellCheckListener;
//import com.swabunga.spell.event.SpellChecker;
//import com.swabunga.spell.event.StringWordTokenizer;
//
//public class String_Permitation implements SpellCheckListener {
//
//	public static long permuTime = 0;
//	public static long stringLength = 0;
//	public static String finalStringValue;
//	private static String dictFile = "C:\\Users\\mahan.k.palavelli\\Downloads\\english.0";
//	int result = 0;
//	// private static String phonetFile =
//	// "C:\\Users\\mahan.k.palavelli\\Desktop\\SamplePr\\executedFiles\\b.txt";
//
//	private SpellChecker spellCheck = null;
//
//	public boolean spellingCheck_JustPass_Input(String word) {
//		try {
//			SpellDictionary dictionary = new SpellDictionaryHashMap(new File(
//					dictFile));
//
//			spellCheck = new SpellChecker(dictionary);
//			spellCheck.addSpellCheckListener(this);
//
//			if (word.length() <= 0)
//				return false;
//			result = spellCheck.checkSpelling(new StringWordTokenizer(word));
//			if (result == -1) {
//				System.out.println("Correct Value");
//				return true;
//			} else
//				return false;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return true;
//	}
//
//	public void spellingError(SpellCheckEvent event) {
//		/*List suggestions = event.getSuggestions();
//		if (suggestions.size() > 0) {
//			System.out.println("MISSPELT WORD: " + event.getInvalidWord());
//			for (Iterator suggestedWord = suggestions.iterator(); suggestedWord
//					.hasNext();) {
//				System.out.println("\tSuggested Word: " + suggestedWord.next());
//			}
//		} else {
//			System.out.println("MISSPELT WORD: " + event.getInvalidWord());
//			System.out.println("\tNo suggestions");
//		}*/
//		// Null actions
//	}
//
//	public static void main(String[] args) {
//
//		Scanner scan = new Scanner(System.in);
//		String_Permitation currentClassObj = new String_Permitation();
//		System.out.println("Enter String");
//		String s = scan.next();
//		stringLength = s.length();
//		// crunchifyPermutation(s);
//		// currentClassObj.spellingCheck_JustPass_Input(s);
//		Set<String> finalResult = stringPermitation(s);
//		currentClassObj.checkSpelling(finalResult);
//
//		// System.out.println("\nString " + s + ":\nPermutations: " +
//		// crunchifyPermutation(s));
//		// System.out.println("Total Permutations: "+permuTime);
//		/*
//		 * String s = "ABC"; String s1 = "EBAY"; String s2 = "Yahoo";
//		 * System.out.println("\nString " + s + ":\nPermutations: " +
//		 * crunchifyPermutation(s)); System.out.println("\nString " + s1 +
//		 * ":\nPermutations: " + crunchifyPermutation(s1));
//		 * System.out.println("\nString " + s2 + ":\nPermutations: " +
//		 * crunchifyPermutation(s2));
//		 */
//	}
//
//	public static Set<String> stringPermitation(String str) {
//		Set<String> crunchifyResult = new HashSet<String>();
//		if (str == null) {
//			return null;
//		} else if (str.length() == 0) {
//			crunchifyResult.addAtEnd("");
//			return crunchifyResult;
//		}
//
//		char firstChar = str.charAt(0);
//		String rem = str.substring(1);
//		Set<String> words = stringPermitation(rem);
//		// System.out.println(firstChar+" :: "+words);
//		for (String newString : words) {
//			for (int i = 0; i <= newString.length(); i++) {
//				finalStringValue = crunchifyCharAdd(newString, firstChar, i);
//				// System.out.print("\n"+finalStringValue+";");
//				crunchifyResult.addAtEnd(finalStringValue);
//				/*
//				 * if(stringLength == finalStringValue.length()) { permuTime++;
//				 * System
//				 * .out.println(permuTime+" -----------------"+crunchifyResult);
//				 * }
//				 */
//			}
//		}
//		return crunchifyResult;
//	}
//
//	public static String crunchifyCharAdd(String str, char c, int j) {
//		String first = str.substring(0, j);
//		String last = str.substring(j);
//		return first + c + last;
//	}
//
//	public void checkSpelling(Set<String> finalResult) {
//		boolean status = false;
//		for (String string : finalResult) {
//			if (spellingCheck_JustPass_Input(string)) {
//				System.out
//						.println("Correct word for given shaffiled letters : "
//								+ string);
//				status = true;
////				break; // keep enable If we need at first correct value only.
//			}
//		}
//		if (!status) {
//			System.out.println("Given shaffiled letters are not correct");
//		}
//	}
//
//}
/*
 * kwolaclcl, cbeofoka, gilencafin, cemrsenlboei, rlrgsmaorsi, etdbehes,
 * hpastawp, hulgisnt.
 */
