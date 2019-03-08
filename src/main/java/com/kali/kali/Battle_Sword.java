package com.kali.kali;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Battle_Sword {
	static List<Integer> globalList = new CopyOnWriteArrayList<Integer>();
	static int count = 0;

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter No.of people?");
		int numberOfPPL = scan.nextInt();
		System.out.println("Which person you wanna give sword..?");
		int whichPerson = scan.nextInt();
		List<Integer> totalPPL = new CopyOnWriteArrayList<Integer>();
		for (int i = 1; i <= numberOfPPL; i++) {
			totalPPL.add(i);
			globalList.add(i);
		}
		//whichPerson = 1;
		cutHeades(totalPPL, totalPPL.size(), whichPerson);
		scan.close();
	}

	public static void cutHeades(List<Integer> values, int size, int nextPersonPossition) {
		System.out.println(values);
		count++;
		int i = 0, lastValue = (int) values.get(values.size()-1);
		for (i = nextPersonPossition; i < size; i = i + 2) 
			values.remove(globalList.get(i));
		
		
		if (values.size() > 1) {
			globalList.clear();
			globalList.addAll(values);
			
			if (lastValue != (int) values.get(values.size()-1))
				cutHeades(values, values.size(), 1);
			else
				cutHeades(values, values.size(), 0);
		}
		else 
			System.out.println(values.get(0)+" position would be safe(alive) and No.of rounds: "+count);
	}
}

/**
 * Formula: 2(x-2^n) + 1
 * Example: 45 ppl then 2(45-32) + 1 = 27
 *
 *
 *
 * */