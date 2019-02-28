package com.kali;

import java.util.Scanner;

/**
 * @author mahan.k.palavelli
 *
 */
public class Partition { 
public static int inc =0,real=0;
    public static void partition(int n) {
        partition(n, n, "");
    }
    private static void partition(int n, int max, String prefix) {
        if (n == 0) {
            inc++;
            System.out.println(inc+" -> "+prefix);
            return;
        }
        for (int minValue = Math.min(max, n); minValue >= 1; minValue--) {
            partition(n-minValue, minValue, prefix + " " + minValue);
        }
    }
    public static void main(String[] args) { 
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Number");
        int N = s.nextInt(); //Integer.parseInt(args[0]);
        partition(N);
		//System.out.println("Total: "+inc);
		System.out.println("------------------------------------------------");
    }
}
