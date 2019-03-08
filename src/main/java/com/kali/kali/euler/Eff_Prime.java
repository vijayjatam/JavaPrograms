package com.kali.kali.euler;


import java.math.BigInteger;
import java.util.*;

/**
 * @author mahan.k.palavelli
 */
public class Eff_Prime {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        System.out.println(nthPrime(10001));
        String input = "600851475143"; //935649839983
        //primeOrNot(Integer.parseInt(input));
        bigPrim(new BigInteger(input)); //600851475143
        //System.out.println(isPrime(121,2));
        //System.out.println(isBigPrime(new BigInteger(input),BigInteger.valueOf(2)));
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
        for (; (value.divide(BigInteger.valueOf(2))).compareTo(divir) == 1
                || (value.divide(BigInteger.valueOf(2))).compareTo(divir) == 0; ) {
            if (value.divideAndRemainder(divir)[1].compareTo(BigInteger.ZERO) == 0) {
                flag = false;
                break;
            }
            divir = divir.add(BigInteger.ONE);
        }
        return flag;
    }

    private static int nthPrime(int range) {
        int nthPrimeValue = 0;
        int naturalNumber = 2;
        while (range > 0) {
            if (isPrime(naturalNumber++, 2)) {
                range--;
                nthPrimeValue = naturalNumber - 1;
            }
        }
        return nthPrimeValue;
    }

    private static BigInteger largestPrime(long range) {
        List<BigInteger> primesBelowRange = new ArrayList<>();

        return null;
    }
   /* private static BigInteger funtionForLargestPrime(){

    }*/
}
