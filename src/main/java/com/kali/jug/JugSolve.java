package com.kali.jug;

import java.util.Scanner;


public class JugSolve {
	public static int smallJugSize = 0, largeJugSize = 0, setSize = 0;
	public static void main(String[] args) {
		//solveWaterJugPuzzle();
		System.out.println(GCD(4,6));
	}
	public static  void solveWaterJugPuzzle() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Small jug size.......! ");
		JugSolve.smallJugSize = scan.nextInt();
		System.out.println("Enter Large jug size.......! ");
		JugSolve.largeJugSize = scan.nextInt();
		System.out.println("Enter how much measuring need ........! ");
		JugSolve.setSize = scan.nextInt();
		if(smallJugSize > largeJugSize) {
			smallJugSize = smallJugSize + largeJugSize; // 11+9
			largeJugSize = smallJugSize - largeJugSize; // 20-9=11
			smallJugSize = smallJugSize - largeJugSize; // 20-11=9
		}
		if((setSize % GCD(smallJugSize,largeJugSize) != 0)){
			System.out.println("Given measuring "+setSize+" not possible with "+smallJugSize+","+largeJugSize+" jugs.  " +
					"GCD = "+GCD(smallJugSize,largeJugSize));
		}
		else if(setSize <= largeJugSize) {
			/*if(smallJugSize%2==0 && largeJugSize%2==0) {
				if(setSize>smallJugSize){
					
				}
			}*/
			if(fillSmallFirst() > fillLargeFirst())
				System.out.println("Start with Large Jug would be Accurate ");
			else
				System.out.println("Start with Small Jug would be Accurate");
			
			
		} else
			System.out.println("SetSize need to be <= "+largeJugSize);
	}
	public static int fillLargeFirst() {
		int smallJug = 0;
		int bigJug = largeJugSize;
		
		int count = 0;
		while(true) {
//			System.out.print("("+smallJug+","+bigJug+")");
			count++;
			if(smallJug == setSize || bigJug == setSize) {
				break;
			}else
//				System.out.print("->");
			if(smallJug == smallJugSize) {
				smallJug = 0;
			}
			else if(bigJug == 0) {
				bigJug = largeJugSize;
			}
			else if((smallJug+bigJug) <= smallJugSize){
				smallJug = (smallJug+bigJug);
				bigJug = 0;
			} else {
				bigJug = bigJug - (smallJugSize - smallJug);
				smallJug = smallJugSize;
			}
			
		}
//		System.out.println();
//		System.out.println("Big start first == : "+count);
		return count;
	}
	
	public static int fillSmallFirst() {
		int smallJug = smallJugSize;
		int bigJug = 0;
		
		int count = 0;
		while(true) {
//			System.out.print("("+smallJug+","+bigJug+")");
			count++;
			if(smallJug == setSize || bigJug == setSize) {
				break;
			}else
//				System.out.print("->");
			if(smallJug == 0){
				smallJug = smallJugSize;
			}
			else if(bigJug == largeJugSize)
				bigJug = 0;
			else if((bigJug+smallJug) <= largeJugSize){
				bigJug = bigJug+smallJug;
				smallJug = 0;
			} else {
				smallJug = smallJug-(largeJugSize-bigJug);
				bigJug = largeJugSize;
			}
			
		}
//		System.out.println();
//		System.out.println("small Start first == : "+count);
		return count;
	}
	
	public static int GCD(int number1, int number2) {
		if(number2 == 0)
			return number1;
		return GCD(number2, number1%number2);
	}
}
