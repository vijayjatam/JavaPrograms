package com.kali;

import java.util.Random;
import java.util.Scanner;

public class RandomCube {
	public static void main(String[] args) {
		Random r = new Random();
		int Low = 10;
		int High = 100;
		int R = r.nextInt(High - Low) + Low;
		long cubeOf_R =  (long) Math.pow(R, 3);
//		System.out.println(R);
		System.out.println(cubeOf_R);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Cube root value for this?");
		int cubeRootValue = scan.nextInt();
		if(R == cubeRootValue)
			System.out.println("Yes, "+R+" is Right Answer. ");
		else
			System.out.println("No, Wrong Answer. Correct: "+R);
		scan.close();
	}
}
//   