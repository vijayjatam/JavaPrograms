package com.kali.kali.jug;

import com.kali.jug.JugSolve;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JugSolve_AI {
	public static int smallJugSize = 0, largeJugSize = 0, setSize = 0;
	public static int COUNT_ON_START_WITH_SMALL = 0,  COUNT_ON_START_WITH_LARGE = 0;
	public static Map<String, Map<String,Map<String,List<String>>>> ABOUT_NUMBERS = new HashMap<String, Map<String,Map<String,List<String>>>>();

	public static void main(String[] args) {
		puzzleStatus();
	}

	public static void puzzleStatus() {
		
		for(int i=2;i<=30;i++) {
			for(int j=i+1;j<=30;j++) {
				for(int k=1;k<j;k++) {
					if(k!=i) {
						smallJugSize = com.kali.jug.JugSolve.smallJugSize = i;
						largeJugSize = com.kali.jug.JugSolve.largeJugSize = j;
						setSize = com.kali.jug.JugSolve.setSize = k;
						validate();
					}
				}
			}
		}
		
		/*Scanner scan = new Scanner(System.in);
		System.out.println("Enter Small jug size.......! ");
		smallJugSize = JugSolve.smallJugSize = scan.nextInt();
		System.out.println("Enter Large jug size.......! ");
		largeJugSize = JugSolve.largeJugSize = scan.nextInt();
		System.out.println("Enter how much measuring need ........! ");
		setSize = JugSolve.setSize = scan.nextInt();*/
		
		
	}
	public static void validate() {
		if(smallJugSize > largeJugSize) {
			smallJugSize = smallJugSize + largeJugSize; // 11+9
			largeJugSize = smallJugSize - largeJugSize; // 20-9=11
			smallJugSize = smallJugSize - largeJugSize; // 20-11=9
		}
		com.kali.jug.JugSolve.smallJugSize = smallJugSize;
		com.kali.jug.JugSolve.largeJugSize = largeJugSize;
		if((setSize % com.kali.jug.JugSolve.GCD(smallJugSize,largeJugSize) != 0)) {
			//System.out.println("Given measuring "+setSize+" not possible with "+smallJugSize+","+largeJugSize+" jugs.  GCD = "+JugSolve.GCD(smallJugSize,largeJugSize));
		}
		else if (setSize <= largeJugSize) {
			if (smallJugSize != largeJugSize) {
				
				COUNT_ON_START_WITH_SMALL= com.kali.jug.JugSolve.fillSmallFirst();
				COUNT_ON_START_WITH_LARGE = com.kali.jug.JugSolve.fillLargeFirst();
				
				compareAndConclude();
				
			} else
				System.out.println("Both Numbers need not to be equal...!");
		} else {
			System.out.println("Measuring value need to < "+largeJugSize);
		}
	}
	
	public static boolean isEven(double number){
		if(number % 2 == 0)
			return true;
		return false;
	}
	public static int statusOfMeasure() {
		if(setSize > smallJugSize)
			return 1;
		return 0;
	}
	public static void compareAndConclude() {
		if (isEven(smallJugSize) && isEven(largeJugSize)) {
			if (isEven(setSize)) {
				if(statusOfMeasure() == 0) {
					if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
						/*System.out.println("("+evenOrOdd(smallJugSize/setSize)+","+smallJugSize%setSize+"), " +
								"("+evenOrOdd(largeJugSize/setSize)+","+largeJugSize%setSize+"), " +
								"("+evenOrOdd((largeJugSize-smallJugSize)/setSize)+", " +
								"["+(largeJugSize-smallJugSize)/setSize+" , "+(largeJugSize-smallJugSize)%setSize+"]),---> "+JugSolve.GCD(smallJugSize,largeJugSize));*/
						System.out.println("Both evens, Measure value even and below both then start with large ("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
					else {
						System.out.println("("+evenOrOdd(smallJugSize/setSize)+","+smallJugSize%setSize+"), " +
								"("+evenOrOdd(largeJugSize/setSize)+","+largeJugSize%setSize+"), " +
								"("+evenOrOdd((largeJugSize-smallJugSize)/setSize)+", " +
								"["+(largeJugSize-smallJugSize)/setSize+" , "+(largeJugSize-smallJugSize)%setSize+"]),---> "+ JugSolve.GCD(smallJugSize,largeJugSize));
						System.out.println("Both evens, Measure value even and below both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
				} /*else {
					if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
						System.out.println("Both evens, Measure value even and middle of both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
					else {
						System.out.println("Both evens, Measure value even and middle of both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
				}*/
			} /*else {
				if(statusOfMeasure() == 0) {
					if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
						System.out.println("Both evens, Measure value odd and below both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
					else {
						System.out.println("Both evens, Measure value odd and below both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
				} else {
					if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
						System.out.println("Both evens, Measure value odd and middle of both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
					else {
						System.out.println("Both evens, Measure value odd and middle of both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
				}
			}*/
		}
		/*else if(!isEven(smallJugSize) && !isEven(largeJugSize)) {
			if (isEven(setSize)) {
				if(statusOfMeasure() == 0) {
					if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
						System.out.println("Both odds, Measure value even and below both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
					else {
						System.out.println("Both odds, Measure value even and below both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
				} else {
					if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
						System.out.println("Both odds, Measure value even and middle of both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
					else {
						System.out.println("Both odds, Measure value even and middle of both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
				}
			} else {
				if(statusOfMeasure() == 0) {
					if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
						System.out.println("Both odds, Measure value odd and below both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
					else {
						System.out.println("Both odds, Measure value odd and below both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
				} else {
					if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
						System.out.println("Both odds, Measure value odd and middle of both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
					else {
						System.out.println("Both odds, Measure value odd and middle of both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
					}
				}
			}
		}
		else {
			if(isEven(largeJugSize)){
				// Small Odd here (Odd - Even)
				if (isEven(setSize)) {
					if(statusOfMeasure() == 0) {
						if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
							System.out.println("Small odd and Large even, Measure value even and below both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
						else {
							System.out.println("Small odd and Large even, Measure value even and below both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
					} else {
						if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
							System.out.println("Small odd and Large even, Measure value even and middle of both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
						else {
							System.out.println("Small odd and Large even, Measure value even and middle of both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
					}
				} else {
					if(statusOfMeasure() == 0) {
						if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
							System.out.println("Small odd and Large even, Measure value odd and below both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
						else {
							System.out.println("Small odd and Large even, Measure value odd and below both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
					} else {
						if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
							System.out.println("Small odd and Large even, Measure value odd and middle of both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
						else {
							System.out.println("Small odd and Large even, Measure value odd and middle of both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
					}
				}
			} else {
				// Large Odd here (Even - Odd)
				if (isEven(setSize)) {
					if(statusOfMeasure() == 0) {
						if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
							System.out.println("Small even and Large odd, Measure value even and below both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
						else {
							System.out.println("Small even and Large odd, Measure value even and below both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
					} else {
						if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
							System.out.println("Small even and Large odd, Measure value even and middle of both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
						else {
							System.out.println("Small even and Large odd, Measure value even and middle of both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
					}
				} else {
					if(statusOfMeasure() == 0) {
						if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
							System.out.println("Small even and Large odd, Measure value odd and below both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
						else {
							System.out.println("Small even and Large odd, Measure value odd and below both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
					} else {
						if(COUNT_ON_START_WITH_SMALL > COUNT_ON_START_WITH_LARGE) {
							System.out.println("Small even and Large odd, Measure value odd and middle of both then start with large("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
						else {
							System.out.println("Small even and Large odd, Measure value odd and middle of both then start with small("+smallJugSize+","+largeJugSize+","+setSize+")");
						}
					}
				}
			}
		}*/
	}
	public static String evenOrOdd(double value){
		return isEven(value)?"Even":"Odd";
	}
}
