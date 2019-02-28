package com.kali;

import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author mahan.k.palavelli
 */
public class Eff_Prime {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        String input = "13415681"; //935649839983
        //primeOrNot(Integer.parseInt(input));
        bigPrim(new BigInteger(input)); //600851475143
        //System.out.println(isPrime(121,2));
        //System.out.println(isBigPrime(new BigInteger(input),BigInteger.valueOf(2)));
    }

    private static void eff_Prime() {
        TreeMap<Object, Object> values = new TreeMap<Object, Object>();
        System.out.println("Enter starting and ending range");
        Scanner scan = new Scanner(System.in);
        int startRange = scan.nextInt();
        int endRange = scan.nextInt();
        int timeTakeingForEach = 0;
        boolean flage = false;
        int primeCount = 1, compositeCount = 0;
        for (int j = 2; j <= endRange; j++) {
            flage = false;
            for (int i = 2; i <= Math.sqrt(j); i++) {
                if (j == 2)
                    break;
                ++timeTakeingForEach;
                if (j % i == 0) {
                    flage = true;
                    break;
                }
            }
            // System.out.println("Totla Loops for "+j+": "+timeTakeingForEach);
            values.put(j, timeTakeingForEach);
            timeTakeingForEach = 0;
            if (!flage) {
                // System.out.println("Prime: "+j+"\n-------------------------------------");
                ++primeCount;
            } else {
                ++compositeCount;
            }
        }
        System.out.println("Primes count: " + primeCount
                + " , Composite count: " + compositeCount
                + "\n--------------------------------");
        int just3 = 0;
        int uniqueValue = 1;
        for (Map.Entry<Object, Object> entryObj : new HashMapValueSort()
                .sortByValuesFromOutSideSource(values).entrySet()) {
            if (just3 >= 3 && uniqueValue != (Integer) entryObj.getValue())
                break;
            System.out.println(entryObj.getKey() + " : " + entryObj.getValue());
            if (uniqueValue != (Integer) entryObj.getValue())
                just3 = just3 + 1;
            uniqueValue = (Integer) entryObj.getValue();
        }
    }

    private static void primeOrNot(int value) {
        boolean flage = false;
        for (int val = 2; val <= Math.sqrt(value); val++) {
            if (value % val == 0) {
                System.out.println(" Not Prime, factor is " + val + " and quotient is " + (value / val));
                flage = true;
                break;
            }
        }
        if (!flage)
            System.out.println("Prime");
    }

    private static void bigPrim(BigInteger bigInteger) {
		/*for (BigInteger intialValue =  bigInteger.subtract(BigInteger.ONE); intialValue.compareTo(BigInteger.valueOf(1))==1 ;){
			if(bigInteger.divideAndRemainder(intialValue)[1].compareTo(BigInteger.ZERO) == 0){
				System.out.println(intialValue);
				break;
			}
			intialValue = intialValue.subtract(BigInteger.ONE);
		}*/
        BigInteger twoBigInteger = BigInteger.valueOf(2);
        if (!isBigPrime(bigInteger, twoBigInteger)) {
            BigInteger largestPrime = BigInteger.ZERO;
            BigInteger quotient = BigInteger.ZERO;
            for (BigInteger divisor = BigInteger.valueOf(2); bigInteger.compareTo(divisor) == 1; ) {
                BigInteger divideValue[] = bigInteger.divideAndRemainder(divisor);
                quotient = divideValue[0];
                if (quotient.compareTo(divisor) == 0) {
                    break;
                }
                if (divideValue[1].compareTo(BigInteger.ZERO) == 0) {
                    System.out.println("Factor is " + divisor + " and quotient is " + quotient);
                    if (isBigPrime(quotient, twoBigInteger)) {
                        largestPrime = quotient;
                        break;
                    } else if (isBigPrime(divisor, twoBigInteger)) {
                        largestPrime = divisor;
                    }

                }
                divisor = divisor.add(BigInteger.ONE);
            }
            System.out.println("Largest prime factor is " + largestPrime);
        } else {
            System.out.println("The given value is prime, so largest prime factor is " + bigInteger);
        }
    }

    private static boolean isPrime(int value, int divir) {
        if (value == 2) {
            return true;
        } else if (value % divir == 0) {
            return false;
        }
        if (divir > Math.sqrt(value))
            return true;
        else
            return isPrime(value, divir + 1);
    }

    private static boolean isBigPrime(BigInteger value, BigInteger divir) {
        if (value.compareTo(BigInteger.valueOf(2)) == 0) {
            return true;
        } /*else if (value.divideAndRemainder(divir)[1].compareTo(BigInteger.ZERO) == 0) {
            return false;
        }*/
        /*if ((value.divide(BigInteger.valueOf(2))).compareTo(divir) == -1) {
            return true;
        } else if(value.compareTo(divir.add(BigInteger.ONE)) == 1) {
            return isBigPrime(value, divir.add(BigInteger.ONE));
        } else{
            return true;
        }*/
        boolean flag = true;
        for (; (value.divide(BigInteger.valueOf(2))).compareTo(divir) == 1 || (value.divide(BigInteger.valueOf(2))).compareTo(divir) == 0; ) {
            if (value.divideAndRemainder(divir)[1].compareTo(BigInteger.ZERO) == 0) {
                flag = false;
                break;
            }
            divir = divir.add(BigInteger.ONE);
        }
        return flag;
    }
}
