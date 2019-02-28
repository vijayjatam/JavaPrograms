package com.kali;

import java.util.Scanner;

public class NthRoot {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("This program for finding nth root of value.\n Enter Root value?");
		double ROOT_VALUE = scan.nextDouble();
		System.out.println("Enter Base value?");
		double BASE_VALUE = scan.nextDouble();
		if(BASE_VALUE > 1) {
			System.out.println("Value is: "+findRoot(BASE_VALUE, ROOT_VALUE));
		}
		else
			System.out.println("Wrong root value");
	}

	private static double findRoot(double BASE_VALUE, double ROOT_VALUE) {
	    double k = 1;
	    double incre = 0.0078125;
	    for(double i=1; i<=BASE_VALUE; i = i+incre){
	        for(int j=0;j<ROOT_VALUE;j++){
	            k=k*i;
	        }
	        if(BASE_VALUE<k){
	        	if(0.95 <= (i-incre) - (int) (i-incre)) {
	        		System.out.println("0.95 <= "+i);
	        		return(Math.round(i-incre));
	        	}
	        	else{
	        		System.out.println(i);
	        		return (i-incre);
	        	}
	        }
	        else
	            k=1;
	    }
		return 1;
	}
}
