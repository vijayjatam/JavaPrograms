package com.kali;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class PellFinal {
    static TreeMap<BigInteger, BigInteger> tm;

    public static void main(String[] args) {
        BigInteger scan = new BigInteger("0");
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int cases = 0;
        System.out.println("Enter how many values do you want");
        try {
            cases = sc2.nextInt();
            System.out.println();
            if (cases < 1) {
                System.out.println("PLEASE ENTER ATLEAST ONE CASE");
            } else {
                System.out.println("Enter " + cases + " values");
                int i = 0;
                BigInteger[] array = new BigInteger[cases];
                tm = new TreeMap<BigInteger, BigInteger>();
                while (i < cases) {
                    scan = sc.nextBigInteger();
                    array[i] = scan;
                    i++;
                }

                i = 0;
                System.out.println();
                // System.out.println("OUTPUT\n");
                System.out.println("The Pell values are below\n");
                while (i < cases) {
                    BigInteger res = pell(array[i]);
                    System.out.println("Pell value of '" + array[i] + "' is '" + res + "'");
                    System.out.println();
                    i++;
                }


            }
        } catch (IllegalArgumentException e) {
            System.out.println("PLEASE ENTER  INTEGERS IN THE RANGE 10 TO 10000");
        } catch (InputMismatchException e) {
            System.out.println("PLEASE ENTER ONLY INTEGERS");
        } catch (Throwable e) {
            System.out.println("PLEASE TRY A LOWER VALUE");
        }


    }


    public static BigInteger pell(BigInteger num) {


        if ((num.compareTo(BigInteger.ZERO)) == 0) {
            return BigInteger.ZERO;
        }
        if ((num.compareTo(BigInteger.ONE)) == 0) {
            return BigInteger.ONE;
        }


        if ((tm.get(num)) == null) {
            //tm.put(num,( 2*pell(num-1)+pell(num-2) ) );     

            //BigInteger one = new BigInteger(Integer.toString(1));
            //BigInteger two = new BigInteger(Integer.toString(2));

            BigInteger value1 = num.subtract(BigInteger.ONE);
            BigInteger value2 = num.subtract(BigInteger.valueOf(2));


            tm.put(num, ((pell(value1)).multiply(BigInteger.valueOf(2))).add(pell(value2)));
            return tm.get(num);


        }

        return tm.get(num);


    }
}  
